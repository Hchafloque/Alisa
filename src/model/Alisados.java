package model;

public class Alisados {
	 private String codAlisado;
	 private int codTipo;
	 private int stock;
	 private double precio;
	 private String fechaVenc;
	 private double preciVenta;
	 private String nomAli;
	 
	 public String getNomAli() {
		return nomAli;
	}
	public void setNomAli(String nomAli) {
		this.nomAli = nomAli;
	} 
	public String getCodAlisado() {
		return codAlisado;
	}
	public void setCodAlisado(String codAlisado) {
		this.codAlisado = codAlisado;
	}
	public int getCodTipo() {
		return codTipo;
	}
	public void setCodTipo(int codTipo) {
		this.codTipo = codTipo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFechaVenc() {
		return fechaVenc;
	}
	public void setFechaVenc(String fechaVenc) {
		this.fechaVenc = fechaVenc;
	}
	public double getPreciVenta() {
		return preciVenta;
	}
	public void setPreciVenta(double preciVenta) {
		this.preciVenta = preciVenta;
	}	 
	 
}
