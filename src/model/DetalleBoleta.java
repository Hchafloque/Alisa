package model;

public class DetalleBoleta {
	private String numBol;
    private String codProducto;
    private String codAlisado;
    private int cantidad;
    private double precioVenta;
    private double importe;
    
	public String getNumBol() {
		return numBol;
	}
	public void setNumBol(String numBol) {
		this.numBol = numBol;
	}
	public String getCodProducto() {
		return codProducto;
	}
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}
	public String getCodAlisado() {
		return codAlisado;
	}
	public void setCodAlisado(String codAlisado) {
		this.codAlisado = codAlisado;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
    
}
