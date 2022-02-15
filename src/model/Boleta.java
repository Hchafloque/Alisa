package model;

public class Boleta {
	private String numBoleta;
    private String fecBoleta;
    private int CodCliente;
    private int codUsuario;
    private double totalBoleta;
    
	public String getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(String numBoleta) {
		this.numBoleta = numBoleta;
	}
	public String getFecBoleta() {
		return fecBoleta;
	}
	public void setFecBoleta(String fecBoleta) {
		this.fecBoleta = fecBoleta;
	}
	public int getCodCliente() {
		return CodCliente;
	}
	public void setCodCliente(int codCliente) {
		CodCliente = codCliente;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public double getTotalBoleta() {
		return totalBoleta;
	}
	public void setTotalBoleta(double totalBoleta) {
		this.totalBoleta = totalBoleta;
	}
}
