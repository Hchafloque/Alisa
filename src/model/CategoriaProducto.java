package model;

public class CategoriaProducto {
	private int codCategoria;
	private String nomCategoria;
	
	public CategoriaProducto(int codCategoria, String nomCategoria) {
		super();
		this.codCategoria = codCategoria;
		this.nomCategoria = nomCategoria;
	}

	public CategoriaProducto() {
		super();
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	@Override
	public String toString() {
		return nomCategoria;
	}
	
	
}
