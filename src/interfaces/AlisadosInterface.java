package interfaces;

import java.util.ArrayList;

import model.Alisados;
import model.TipoAlisado;

public interface AlisadosInterface {
	public int agregar (Alisados a);
	public int modificar (Alisados a);
	public int eliminar (int cod);
	public ArrayList<Alisados>listarAlisados();
	public String generarCodigo();
	public ArrayList<TipoAlisado>listarTipoAlisados();
}
