package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexion {
	
	public static Connection getConexion() {
		Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/alisabrilloextremo?useSSL=false&useTimezone=true&serverTimezone=UTC";
            //Class.forName("com.mysql.jdbc.Driver");
            //String url = "jdbc:mysql://localhost:3306/alisabrilloextremo"; 
            String usr = "root";
            String psw = "dayhana03";
            con = DriverManager.getConnection(url, usr, psw);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error >> Driver no Instalado!!");
        } catch (SQLException ex) {
            System.out.println("Error >> de conexión con la BD");
        } catch (Exception ex) {
            System.out.println("Error >> general : " + ex.getMessage());
        }
        return con;
	}

}
