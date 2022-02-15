package model;

public class TipoAlisado {
	private int codigo;
	private String nomTipoAlisado;	
	
	public TipoAlisado() {
	}
	
	public TipoAlisado(int codigo, String nomTipoAlisado) {
		this.codigo = codigo;
		this.nomTipoAlisado = nomTipoAlisado;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomTipoAlisado() {
		return nomTipoAlisado;
	}
	public void setNomTipoAlisado(String nomTipoAlisado) {
		this.nomTipoAlisado = nomTipoAlisado;
	}
	@Override
	public String toString() {
		return nomTipoAlisado;
	}
	
}
