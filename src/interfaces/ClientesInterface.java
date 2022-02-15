package interfaces;

import java.util.ArrayList;
import model.Clientes;

import model.TipoRedSocial;

public interface ClientesInterface {
	 public int registrar(Clientes c);
	    
	 public int generarCodigio();
	    
	 public int modificar(Clientes c);
	    
	 public int eliminar(int codigo);
	    
	 public ArrayList<Clientes> listarClientes();
	    
	 public ArrayList<Clientes> ReportePorFecha(String fecha);
	    
	 public ArrayList<TipoRedSocial> listarRedSocial();
	    
	 public ArrayList<Clientes>buscarPorNombre(String nombre);
	    
	 public ArrayList<Clientes>buscarPorApellido(String Apellido);
	 
	 public int ActualizarFechaYHoraCliente(Clientes c);

	 
}
