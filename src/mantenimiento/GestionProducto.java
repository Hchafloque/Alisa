package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.CategoriaProducto;
import model.Producto;
import utils.MySqlConexion;

public class GestionProducto implements ProductoInterface{
	
	@Override
    public int registrar(Producto p) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion(); 
            String sql = "insert into tb_productos values(?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getCodigoPro());
            pst.setInt(2, p.getStock());
            pst.setDouble(3, p.getPrecio());
            pst.setString(4, p.getFechaVenc());
            pst.setInt(5, p.getCodCatePro());
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
    public String generarCodigio() {
        String codigo = "P0001";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "select substring(cod_pro,2)  from tb_productos order by cod_pro desc limit 1";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                DecimalFormat df = new DecimalFormat("0000");
                codigo = "P" + df.format(Integer.parseInt(rs.getString(1)) + 1);
            }

        } catch (Exception e) {
            System.out.println("Error en GestionProducto<<generarCodigio>> " + e.getMessage());
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
    public int modificar(Producto p) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "update tb_productos set stock=?,precio=?,fecha_venci=?,cod_cat=?,precio_venta=? where cod_pro=?";
            pst = con.prepareStatement(sql);

            pst.setInt(1, p.getStock());
            pst.setDouble(2, p.getPrecio());
            pst.setString(3, p.getFechaVenc());          
            pst.setInt(4, p.getCodCatePro());
            pst.setDouble(5, p.getPreciVenta());
            pst.setString(6, p.getCodigoPro());
            
            rs = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionProducto<<modificar>> " + e.getMessage());
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
    public int eliminar(String codigo) {
        int rs = 0;
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "delete from tb_productos where cod_pro=?";
            pst = con.prepareStatement(sql);
            pst.setString(1, codigo);
            rs = pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en sentencia  GestionProducto<<eliminar>> " + e.getMessage());
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
    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            con = MySqlConexion.getConexion();
            String sql = "select p.cod_pro,p.stock,p.precio,p.fecha_venci,c.descripcion,p.precio_venta,c.cod_cate from tb_productos p \r\n"
            		+ "inner join tb_categoriaproducto c on p.cod_cat=c.cod_Cate";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigoPro(rs.getString(1));
                p.setStock(rs.getInt(2));                           
                p.setPrecio(rs.getDouble(3));
                p.setFechaVenc(rs.getString(4));
                p.setNomPro(rs.getString(5));
                p.setPreciVenta(rs.getDouble(6));
                p.setCod_cate(rs.getInt(7));
                lista.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error en GestionProducto<<listarClientes>> " + e.getMessage());
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
	public ArrayList<CategoriaProducto> ListarCategoria() {
		 ArrayList<CategoriaProducto> lista = new ArrayList<CategoriaProducto>();
	        Connection con = null;
	        PreparedStatement pst = null;
	        ResultSet rs = null;
	        try {
	            con = MySqlConexion.getConexion();
	            String sql = "select * from tb_categoriaproducto";
	            pst = con.prepareStatement(sql);
	            rs = pst.executeQuery();

	            while (rs.next()) {
	            	CategoriaProducto p = new CategoriaProducto();
	                p.setCodCategoria(rs.getInt(1));
	                p.setNomCategoria(rs.getString(2));	              
	                lista.add(p);
	            }
	        } catch (Exception e) {
	            System.out.println("Error en GestionProducto<<ListarCategoria>> " + e.getMessage());
	            e.printStackTrace();
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
	                e.printStackTrace();
	            }
	        }
	        return lista;
	}

}
