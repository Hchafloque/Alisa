package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import interfaces.CitasCCRInterface;
import model.CitasCCR;
import utils.MySqlConexion;

public class GestionCitasCCR implements CitasCCRInterface{
	@Override
	public int agregarCitaCanceladas(CitasCCR c) {
		int salida=0;
		Connection con=null; 
		PreparedStatement pst=null;
		 try {
	            con = MySqlConexion.getConexion();
	            String sql = "insert into tb_citacancelada values (null,?,+1)";
	            pst = con.prepareStatement(sql);
	            //pst.setInt(1,c.getCodigo());
	            pst.setInt(1, c.getCodCliente());	           
	            salida = pst.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error en GestionClientes<<clientasCitasCanceladas>> " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pst != null) {
	                    pst.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e2) {
	                System.out.println("Error al cerrar conexiones");
	                e2.printStackTrace();
	            }
	        }
	        return salida;
	}

	@Override
	public int agergarrCitaConfirmada(CitasCCR c) {
		int salida=0;
		Connection con=null;
		PreparedStatement pst=null;
		 try {
	            con = MySqlConexion.getConexion();
	            String sql = "insert into tb_citaconfirmada values (null,?,+1)";
	            pst = con.prepareStatement(sql);
	            //pst.setInt(1,c.getCodigo());
	            pst.setInt(1, c.getCodCliente());	           
	            salida = pst.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error en GestionClientes<<clientasCitasCanceladas>> " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pst != null) {
	                    pst.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e2) {
	                System.out.println("Error al cerrar conexiones");
	                e2.printStackTrace();
	            }
	        }
	        return salida;
	}

	@Override
	public int ActualizarCitaReagendada(CitasCCR c) {
		int salida=0;
		Connection con=null;
		PreparedStatement pst=null;
		 try {
	            con = MySqlConexion.getConexion();
	            String sql = "insert into tb_citareagendada values (null,?,+1)";
	            pst = con.prepareStatement(sql);
	            //pst.setInt(1,c.getCodigo());
	            pst.setInt(1, c.getCodCliente());	           
	            salida = pst.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error en GestionClientes<<clientasCitasCanceladas>> " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pst != null) {
	                    pst.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e2) {
	                System.out.println("Error al cerrar conexiones");
	                e2.printStackTrace();
	            }
	        }
	        return salida;
	}

	@Override
	public int AgregarPosAlisado(CitasCCR c) {
		int salida=0;
		Connection con=null;
		PreparedStatement pst=null;
		 try {
	            con = MySqlConexion.getConexion();
	            String sql = "insert into tb_PosAlisado values (null,?,?,?)";
	            pst = con.prepareStatement(sql);
	            
	            pst.setInt(1, c.getCodCliente());	
	            pst.setString(2,c.getFechaPosAlisado());
	            pst.setString(3, c.getHora());
	            salida = pst.executeUpdate();
	        } catch (SQLException e) {
	            System.out.println("Error en GestionClientes<<clientasCitasCanceladas>> " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            try {
	                if (pst != null) {
	                    pst.close();
	                }
	                if (con != null) {
	                    con.close();
	                }
	            } catch (SQLException e2) {
	                System.out.println("Error al cerrar conexiones");
	                e2.printStackTrace();
	            }
	        }
	        return salida;
	}



}
