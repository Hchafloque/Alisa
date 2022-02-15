package model;

public class Tipo {
	private int codTipo;
	private String nomTipo;
	public Tipo() {
		super();
	}
	public Tipo(int codTipo, String nomTipo) {
		super();
		this.codTipo = codTipo;
		this.nomTipo = nomTipo;
	}
	public int getCodTipo() {
		return codTipo;
	}
	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}
	public String getNomTipo() {
		return nomTipo;
	}
	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}
	@Override
	public String toString() {
		return nomTipo;
	}
	
}
