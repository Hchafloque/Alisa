package model;

public class CitasCCR {
	private int codigo;
	private int codCliente;
	private int Cantidad;
	
	//
	private String fechaPosAlisado;
	private String hora;
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFechaPosAlisado() {
		return fechaPosAlisado;
	}
	public void setFechaPosAlisado(String fechaPosAlisado) {
		this.fechaPosAlisado = fechaPosAlisado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	
}
