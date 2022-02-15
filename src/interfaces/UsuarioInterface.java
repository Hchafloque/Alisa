package interfaces;

import java.util.ArrayList;

import model.Tipo;
import model.Usuarios;

public interface UsuarioInterface {
	public int registrar(Usuarios u);
    
    public int generarCodigio();
    
    public int modificar(Usuarios u);
    
    public int eliminar(String codigo);
    
    public ArrayList<Usuarios> listarUsuarios();
    
    public Usuarios loginUsuario(String usuario,String pass);
    
    public ArrayList<Tipo>listarTipo();
}
