package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import interfaces.VentaInterface;
import model.Boleta;
import model.DetalleBoleta;
import utils.MySqlConexion;

public class GestionVenta implements VentaInterface {
	@Override
    public String generarCodigo() {
        String codigo = "B0001";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            con = MySqlConexion.getConexion();
            String sql = "select substring(num_bol,2)  from tb_boleta order by num_bol desc limit 1";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                DecimalFormat df = new DecimalFormat("0000"); 
                codigo = "B" + df.format(Integer.parseInt(rs.getString(1)) + 1);
            }

        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error en GestionVenta<<generarCodigo>> " + e.getMessage());
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
    public int generarVenta(Boleta bol, ArrayList<DetalleBoleta> det) {
        int ok = -1;
        Connection con = null;
        PreparedStatement pstBol = null;
        PreparedStatement pstDet = null;
        PreparedStatement pstPro = null;
        PreparedStatement pstAli = null;

        try {
            con = MySqlConexion.getConexion();
            //anular el autocomit
            con.setAutoCommit(false);

            //1. Registrar Boleta
            String sql = "insert into tb_boleta values(?,?,?,?,?)";
            pstBol = con.prepareStatement(sql);
            pstBol.setString(1, bol.getNumBoleta());
            pstBol.setString(2, bol.getFecBoleta());
            pstBol.setInt(3, bol.getCodCliente());
            pstBol.setInt(4, bol.getCodUsuario());
            pstBol.setDouble(5, bol.getTotalBoleta());
            ok = pstBol.executeUpdate();

            //Registrar detalle boleta
            String sql2 = "insert into tb_det_boleta values(?,?,?,?,?)";
            for (DetalleBoleta d : det) {
                pstDet = con.prepareStatement(sql2);
                pstDet.setString(1, bol.getNumBoleta());
                pstDet.setString(2, d.getCodProducto());
                //pstDet.setString(3, d.getCodAlisado());
                pstDet.setInt(3, d.getCantidad());
                pstDet.setDouble(4, d.getPrecioVenta());
                pstDet.setDouble(5, d.getImporte());

                ok = pstDet.executeUpdate();
            }
            //Actualizar producto
            String sql3 = "update tb_productos set stock=stock-? where cod_pro=?";
            for (DetalleBoleta d : det) {
                pstPro = con.prepareStatement(sql3);
                pstPro.setInt(1, d.getCantidad());
                pstPro.setString(2, d.getCodProducto());
                ok = pstPro.executeUpdate();
            }
            
            /*String sql4="update tb_tratamientos set stock=stock-? where cod_tratamiento = ?";
            for (DetalleBoleta d : det) {
                pstAli =con.prepareStatement(sql4);
                pstAli.setInt(1, d.getCantidad());
                pstAli.setString(2, d.getCodProducto());               
                ok =pstAli.executeUpdate();
                
            }*/                        
            //confirmar la transaccion              
            con.commit();

        } catch (Exception e) {
            System.out.println("Error en sentencias generarVenta "+e.getMessage());
            ok=-1;
          
            try {
                con.rollback();
            } catch (SQLException ex) {
            	ex.printStackTrace();
                //Logge.getLogger(GestionVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }finally{
            try {
                if(pstBol!=null)pstBol.close();
                if(pstDet!=null)pstDet.close();
                if(pstPro!=null)pstPro.close();
                if(con!=null) con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return ok;
    }
}
