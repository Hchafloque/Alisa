package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Tratamiento;
import utils.MySqlConexion;

public class GestionTratamiento {

	public ArrayList<Tratamiento> listarTratamientos() {
        ArrayList<Tratamiento>lista=new ArrayList<Tratamiento>();
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        
        try {
            con=MySqlConexion.getConexion();
            String sql="select * from tb_tratamiento";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while (rs.next()) {
                Tratamiento t = new Tratamiento();
                t.setCodTratamiento(rs.getString(1));
                t.setNomTratami(rs.getString(2));
                t.setPrecio(rs.getDouble(3));
                lista.add(t);
            }
        } catch (Exception e) {
            System.out.println("Error en GestionTratamiento<<listarTratamientos>> "+e.getMessage());
        }finally{
            try {
                if(pst!=null)pst.close();
                if(con!=null)con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return lista;
    }
}
