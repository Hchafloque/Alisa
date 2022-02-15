package interfaces;

import java.util.ArrayList;

import model.Boleta;
import model.DetalleBoleta;

public interface BoletaInterface {
	public String generarCodigo();
    
    public int generarVenta(Boleta bol ,ArrayList<DetalleBoleta>det);
}
