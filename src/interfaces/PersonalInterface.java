package interfaces;

import java.util.ArrayList;

import model.Personal;

public interface PersonalInterface {
	
public int registrar(Personal p);
    
    public int generarCodigio();
    
    public int modificar(Personal p);
    
    public int eliminar(int codigo);
    
    public ArrayList<Personal> listarPersonal();
}
