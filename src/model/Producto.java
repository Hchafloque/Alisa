package model;

public class Producto {
	 private String codigoPro;
	 private int codCatePro;
	 private int stock;
	 private double precio;
	 private String fechaVenc;
	 private double preciVenta;
	 
	 public int getCod_cate() {
		return cod_cate;
	}
	public void setCod_cate(int cod_cate) {
		this.cod_cate = cod_cate;
	}
	private int cod_cate;
	 
	 public int getCodCatePro() {
		return codCatePro;
	}
	public void setCodCatePro(int codCatePro) {
		this.codCatePro = codCatePro;
	}
	//
	 private String nomPro;
	 
	public String getCodigoPro() {
		return codigoPro;
	}
	public void setCodigoPro(String codigoPro) {
		this.codigoPro = codigoPro;
	}
	public String getNomPro() {
		return nomPro;
	}
	public void setNomPro(String nomPro) {
		this.nomPro = nomPro;
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
