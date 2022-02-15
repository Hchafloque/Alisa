package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.UsuarioInterface;
import model.Tipo;
import model.Usuarios;
import utils.MySqlConexion;

public class GestionUsuario implements UsuarioInterface{


    @Override
    public int registrar(Usuarios u) {
        int rs=0;
        Connection con=  null;
        PreparedStatement pst=null;
        try {
            con=MySqlConexion.getConexion();
            String sql="insert into tb_usuarios values (?,?,?,?,?,?,?)";
            pst=con.prepareStatement(sql);
            
            pst.setInt(1, u.getCodUsuario());
            pst.setString(2, u.getNombreUsu());
            pst.setString(3, u.getApellidoUsu());
            pst.setString(4, u.getUsuario());
            pst.setString(5, u.getPass());
            pst.setString(6, u.getFecha());
            pst.setInt(7, u.getCodTipoUsu());
            
            rs=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionUsuario<<registrar>> "+e.getMessage());
        }finally{
            try {
                if(pst!=null)pst.close();
                if(con!=null)con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return rs;
    }

    @Override
    public int generarCodigio() {
        int codigo=1;
        Connection con=null;
        PreparedStatement pst = null;
        ResultSet rs=null;
        try {
            con= MySqlConexion.getConexion();
            String sql="select cod_usuario from tb_usuarios order by cod_usuario desc limit 1";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next()){              
                codigo=Integer.parseInt(rs.getString(1))+1;
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
    public int modificar(Usuarios u) {
        int rs=0;
        Connection con=  null;
        PreparedStatement pst=null;
        try {
            con=MySqlConexion.getConexion();
            String sql="update tb_usuarios set nombre=?,apellido=?,usuario=?,clave=?,fec_session=?,cod_tipoUsu=? where cod_usuario=?";
            pst=con.prepareStatement(sql);
            
            pst.setString(1, u.getNombreUsu());
            pst.setString(2, u.getApellidoUsu());
            pst.setString(3, u.getUsuario());
            pst.setString(4, u.getPass());
            pst.setString(5, u.getFecha());
            pst.setInt(6, u.getCodTipoUsu());
            pst.setInt(7, u.getCodUsuario());
            
            rs=pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en GestionUsuario<<modificar>> "+e.getMessage());
        }finally{
            try {
                if(pst!=null)pst.close();
                if(con!=null)con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return rs;
    }

    @Override
    public int eliminar(String codigo) {
       int rs=0;
       Connection con= null;
       PreparedStatement pst=null;
        try {
            con= MySqlConexion.getConexion();
            String sql="delete from tb_usuarios where cod_usuario=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, codigo);
            rs=pst.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error en sentencia  GestionUsuario<<eliminar>> "+e.getMessage());
        }finally{
            try {
                if(pst!=null)pst.close();
                if(con!=null)con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexiones");
            }
        }
        return rs;
    }

    @Override
    public ArrayList<Usuarios> listarUsuarios() {
        ArrayList<Usuarios> lista =new ArrayList<Usuarios>();
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            con= MySqlConexion.getConexion();
            String sql="select u.cod_usuario,u.nombre,u.apellido,u.usuario,u.clave,u.fec_session,tu.descripcion_tipoUsu,u.cod_tipoUsu from tb_usuarios u inner join tb_tipousuario tu on u.cod_tipoUsu=tu.cod_tipoUsu";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                Usuarios u = new Usuarios();
                u.setCodUsuario(rs.getInt(1));
                u.setNombreUsu(rs.getString(2));
                u.setApellidoUsu(rs.getString(3));
                u.setUsuario(rs.getString(4));
                u.setPass(rs.getString(5));
                u.setFecha(rs.getString(6));
                u.setNomTipoUsu(rs.getString(7));
                u.setCodTipoUsu(rs.getInt(8));
                lista.add(u);
            }
     } catch (Exception e) {
            System.out.println("Error en GestionUsuario<<listarUsuarios>> "+e.getMessage());
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

    @Override
    public Usuarios loginUsuario(String usuario, String pass) {
        Usuarios lista = new Usuarios();
        Connection con= null;
        PreparedStatement pst= null;
        ResultSet rs=null;        
        try {
            con=MySqlConexion.getConexion();
            String sql="select cod_usuario,nombre,apellido,usuario,clave from tb_usuarios where usuario=? and clave=?";
            pst=con.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2,pass);

            rs=pst.executeQuery();
            if (rs.next()) {   
                Usuarios u=new Usuarios();
                u.setCodUsuario(rs.getInt(1));
                u.setNombreUsu(rs.getString(2));
                u.setApellidoUsu(rs.getString(3));
                u.setUsuario(rs.getString(4));
                u.setPass(rs.getString(5));
                lista=u;
            }                  
        } catch (Exception e) {
            System.out.println("Error en sentencia GestionUsuario <<loginUsuario>> "+e.getMessage());
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

	@Override
	public ArrayList<Tipo> listarTipo() {
		ArrayList<Tipo> lista =new ArrayList<Tipo>();
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        try {
            con= MySqlConexion.getConexion();
            String sql="select * from tb_tipousuario";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
            	Tipo t = new Tipo();
                t.setCodTipo(rs.getInt(1));
                t.setNomTipo(rs.getString(2));
                lista.add(t);
            }
     } catch (SQLException e) {
            System.out.println("Error en GestionUsuario<<listarTipo>> "+e.getMessage());
            e.printStackTrace();
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
