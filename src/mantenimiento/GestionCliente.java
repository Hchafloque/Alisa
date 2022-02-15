package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import interfaces.ClientesInterface;
import model.Clientes;
import model.TipoRedSocial;
import utils.MySqlConexion;

public class GestionCliente implements ClientesInterface{

    @Override
    public int registrar(Clientes c) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "insert into tb_clientes values(?,?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);

            pst.setInt(1, c.getCodCli());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getApellido());
            pst.setString(4, c.getDni());
            pst.setString(5, c.getFecha());
            pst.setString(6, c.getTelefono());
            pst.setString(7, c.getHora());
            pst.setString(8, c.getCorreo());
            pst.setInt(9, c.getTipo());

            rs = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionClientes<<registrar>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return rs;
    }

    @Override
    public int generarCodigio() {
        int codigo = 1;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "select cod_cli from tb_clientes order by cod_cli desc limit 1";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                //DecimalFormat df = new DecimalFormat("00000");
                codigo = Integer.parseInt(rs.getString(1)) + 1;
            }

        } catch (Exception e) {
            System.out.println("Error en GestionClientes<<generarCodigio>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return codigo;
    }

    @Override
    public int modificar(Clientes c) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "update tb_clientes SET nombre=?,apellido=?,dni=?,fecha_cita=?,telefono=?,hora=?,correo=?,red_social=? where cod_cli=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, c.getNombre());
            pst.setString(2, c.getApellido());
            pst.setString(3, c.getDni());
            pst.setString(4, c.getFecha());
            pst.setString(5, c.getTelefono());
            pst.setString(6, c.getHora());
            pst.setString(7, c.getCorreo());
            pst.setInt(8, c.getTipo());
            pst.setInt(9, c.getCodCli());

            rs = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionClientes<<modificar>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return rs;
    }

    @Override
    public int eliminar(int codigo) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "delete from tb_clientes where cod_cli=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            rs = pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en sentencia  GestionClientes<<eliminar>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return rs;
    }

    @Override
    public ArrayList<Clientes> listarClientes() {
        ArrayList<Clientes> lista = new ArrayList<Clientes>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "select c.cod_cli,c.nombre,c.apellido,c.dni,c.fecha_cita,c.telefono,c.hora,c.correo,r.nombre,c.Red_social from tb_clientes c \r\n"
            		+ "inner join tb_red_social r on c.red_social=r.red_social";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();              
                c.setCodCli(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setFecha(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setHora(rs.getString(7));
                c.setCorreo(rs.getString(8));
                c.setNomRedSocial(rs.getString(9));
                c.setTipo(rs.getInt(10));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error en GestionClientes<<listarClientes>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return lista;
    }
   
    @Override
    public ArrayList<Clientes> ReportePorFecha(String fecha) {
        ArrayList<Clientes> lista = new ArrayList<Clientes>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "select * from tb_clientes where fecha_cita=?";
            pst = con.prepareStatement(sql);
            pst.setDate(1, java.sql.Date.valueOf(fecha));
            rs = pst.executeQuery();
            while (rs.next()) {
                Clientes c = new Clientes();
                c.setCodCli(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setFecha(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setHora(rs.getString(7));
                c.setCorreo(rs.getString(8));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error en GestionClientes <<ReportePorFecha>>" + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerra conexiones");
            }
        }
        return lista;
    }

  /*  @Override
   public ArrayList<ListarCitasRedSocial> listarCitasRedSocial() {
        ArrayList<ListarCitasRedSocial> listar = new ArrayList<ListarCitasRedSocial>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = MSQLConexion.getConexion();
            String sql = "select c.cod_cli, c.nombre,c.apellido,c.dni,c.fecha_cita,c.telefono,c.hora,c.correo, r.nom_redSocial from tb_clientes c inner join tb_RedSocial r on c.tipo=r.doc_redSocial order by c.cod_cli desc";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                ListarCitasRedSocial s = new ListarCitasRedSocial();
                s.setCodCli(rs.getInt(1));
                s.setNombre(rs.getString(2));
                s.setApellido(rs.getString(3));
                s.setDni(rs.getString(4));
                s.setFecha(rs.getString(5));
                s.setTelefono(rs.getString(6));
                s.setHora(rs.getString(7));
                s.setCorreo(rs.getString(8));
                s.setNomRedSocial(rs.getString(9));
                listar.add(s);
            }
        } catch (Exception e) {
            System.out.println("Error en sentecias GestionClientes<<listarCitasRedSocial>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return listar;
    }
*/
  
    @Override
    public ArrayList<Clientes> buscarPorNombre(String nombre) {
        ArrayList<Clientes> lista = new ArrayList<Clientes>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = MySqlConexion.getConexion();
            String sql = "select * from tb_clientes where nombre=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, nombre);
            rs = pst.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();
                c.setCodCli(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setFecha(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setHora(rs.getString(7));
                c.setCorreo(rs.getString(8));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error en sentencias GestionClientes<<buscarPorNombre>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones ");
            }
        }
        return lista;
    }

    @Override
    public ArrayList<Clientes> buscarPorApellido(String Apellido) {
        ArrayList<Clientes> lista = new ArrayList<Clientes>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = MySqlConexion.getConexion();
            String sql = "select * from tb_clientes where apellido=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, Apellido);
            rs = pst.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();
                c.setCodCli(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setApellido(rs.getString(3));
                c.setDni(rs.getString(4));
                c.setFecha(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setHora(rs.getString(7));
                c.setCorreo(rs.getString(8));
                lista.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error en sentencias GestionClientes<<buscarPorApellido>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones ");
            }
        }
        return lista;
    }

	@Override
	public ArrayList<TipoRedSocial> listarRedSocial() {
		ArrayList<TipoRedSocial> lista = new ArrayList<TipoRedSocial>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = MySqlConexion.getConexion();
            String sql = "select * from tb_red_social";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
            	TipoRedSocial r = new TipoRedSocial();
                r.setCodRedSocial(rs.getInt(1));
                r.setRedSocial(rs.getString(2));
                lista.add(r);
            }

        } catch (Exception e) {
            System.out.println("Error en sentencias GestionClientes<<listarRedSocial>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones ");
            }
        }
        return lista;
	}

	@Override
	public int ActualizarFechaYHoraCliente(Clientes c) {
		int salida = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "update tb_clientes SET fecha_cita=?,hora=? where cod_cli=?";
            pst = con.prepareStatement(sql);            
            pst.setString(1, c.getFecha());
            pst.setString(2, c.getHora());
            pst.setInt(3, c.getCodCli());

            salida = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionClientes<<modificar>> " + e.getMessage());
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return salida;
	}

	

	
	
}
