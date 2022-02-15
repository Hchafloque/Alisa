package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.PersonalInterface;
import model.Personal;
import utils.MySqlConexion;

public class GestionPersonal implements PersonalInterface{
	@Override
    public int registrar(Personal p) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "insert into tb_personal values (?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            
            pst.setInt(1, p.getCodEmpleado());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getApelido());
            pst.setString(4, p.getDireccion());
            pst.setString(5, p.getTelefono());
            pst.setString(6, p.getCorreo());
            pst.setString(7, p.getDni());
            pst.setString(8, p.getFecha());

            rs = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionPersonal<<registrar>> " + e.getMessage());
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
            String sql = "select cod_empleado from tb_personal order by cod_empleado desc limit 1";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                codigo = (Integer.parseInt(rs.getString(1)) + 1);
            }

        } catch (Exception e) {
            System.out.println("Error en GestionPersonal<<generarCodigio>> " + e.getMessage());
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
    public int modificar(Personal p) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "update tb_personal set nombre=?,apellido=?,direccion=?,telefono=?,correo=?,dni=?,fecha=? where cod_empleado=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, p.getNombre());
            pst.setString(2, p.getApelido());
            pst.setString(3, p.getDireccion());
            pst.setString(4, p.getTelefono());
            pst.setString(5, p.getCorreo());
            pst.setString(6, p.getDni());
            pst.setString(7, p.getFecha());
            pst.setInt(8, p.getCodEmpleado());           

            rs = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionPersonal<<modificar>> " + e.getMessage());
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
            String sql = "delete from tb_personal where cod_empleado=?";
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            rs = pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en sentencia  GestionPersonal<<eliminar>> " + e.getMessage());
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
    public ArrayList<Personal> listarPersonal() {
        ArrayList<Personal> lista = new ArrayList<Personal>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "select * from tb_personal";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Personal p = new Personal();
                p.setCodEmpleado(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApelido(rs.getString(3));
                p.setDireccion(rs.getString(4));
                p.setTelefono(rs.getString(5));
                p.setCorreo(rs.getString(6));
                p.setDni(rs.getString(7));
                p.setFecha(rs.getString(8));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error en GestionPersonal<<listarPersonal>> " + e.getMessage());
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

}
