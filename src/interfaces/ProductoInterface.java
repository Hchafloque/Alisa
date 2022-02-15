package interfaces;

import java.util.ArrayList;

import model.CategoriaProducto;
import model.Producto;

public interface ProductoInterface {
	
	public int registrar(Producto p);
    
    public String generarCodigio();
    
    public int modificar(Producto p);
    
    public int eliminar(String codigo);
    
    public ArrayList<Producto> listarProductos();
    
    public ArrayList<CategoriaProducto> ListarCategoria();

}
