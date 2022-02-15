package interfaces;

import java.util.ArrayList;

import model.Boleta;
import model.DetalleBoleta;

public interface VentaInterface {
	public String generarCodigo();
    
    public int generarVenta(Boleta bol ,ArrayList<DetalleBoleta>det);
}
