package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import interfaces.AlisadosInterface;
import model.Alisados;
import model.TipoAlisado;
import utils.MySqlConexion;

public class GestionAlisados implements AlisadosInterface{

	@Override
	public int agregar(Alisados p) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "insert into tb_tratamientos values(?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getCodAlisado());
            pst.setInt(2, p.getStock());
            pst.setDouble(3, p.getPrecio());
            pst.setString(4, p.getFechaVenc());
            pst.setInt(5, p.getCodTipo());
            pst.setDouble(6, p.getPreciVenta());
            rs = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionProducto<<registrar>> " + e.getMessage());
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
	public String generarCodigo() {
		String codigo = "A0001";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con= MySqlConexion.getConexion();
            String sql="select substring(cod_tratamiento,2)  from tb_tratamientos order by cod_tratamiento desc limit 1";

            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
             
            if(rs.next()){              
                DecimalFormat df = new DecimalFormat("0000");
                codigo = "A" + df.format(Integer.parseInt(rs.getString(1)) + 1);
            }
                    
        } catch (Exception e) {
            System.out.println("Error en GestionUsuario<<generarCodigio>> "+e.getMessage());
        }finally{
            try {
                if(pst!=null)pst.close();
                if(con!=null)con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return codigo;        
	}
	
	@Override
	public int modificar(Alisados p) {
		int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "update tb_productos set stock=?,precio=?,fecha_venci=?,cod_tipo=?,precio_venta=? where cod_tratamiento=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getCodAlisado());
            pst.setInt(2, p.getStock());
            pst.setDouble(3, p.getPrecio());
            pst.setString(4, p.getFechaVenc());
            pst.setInt(5, p.getCodTipo());
            pst.setDouble(6, p.getPreciVenta());
            rs = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionProducto<<registrar>> " + e.getMessage());
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
	public int eliminar(int cod) {
		int salida=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			con=MySqlConexion.getConexion();
			String sql="delete from tb_tratamientos where cod_tratamiento=?";
			pst=con.prepareStatement(sql);
			pst.setInt(1, cod);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	
		return salida;
	}

	@Override
	public ArrayList<Alisados> listarAlisados() {
		ArrayList<Alisados>lista=new ArrayList<Alisados>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=MySqlConexion.getConexion();
            String sql = "SELECT t.cod_tratamiento,t.stock,t.precio,t.fecha_venci,ta.nom_tipo,t.precio_venta,t.cod_tipo FROM tb_tratamientos t inner join tipo_alisado ta on t.cod_tipo=ta.cod_tipo";
			pst=con.prepareStatement(sql);			
			rs=pst.executeQuery();
			while(rs.next()) {
				Alisados p = new Alisados();
                p.setCodAlisado(rs.getString(1));
                p.setStock(rs.getInt(2));                           
                p.setPrecio(rs.getDouble(3));
                p.setFechaVenc(rs.getString(4));
                p.setNomAli(rs.getString(5));
                p.setPreciVenta(rs.getDouble(6));
                p.setCodTipo(rs.getInt(7));
                lista.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public ArrayList<TipoAlisado> listarTipoAlisados() {
		ArrayList<TipoAlisado>lista=new ArrayList<TipoAlisado>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			con=MySqlConexion.getConexion();
			String sql="select * from tipo_alisado";
			pst=con.prepareStatement(sql);			
			rs=pst.executeQuery();
			while(rs.next()) {
				TipoAlisado t=new TipoAlisado();
				t.setCodigo(rs.getInt(1));
				t.setNomTipoAlisado(rs.getString(2));
				lista.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}


	 
}
