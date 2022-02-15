package model;

public class TipoRedSocial {	 
	private int codRedSocial;
	private String redSocial;
	
	public TipoRedSocial() {
	}
	
	public TipoRedSocial(int codRedSocial, String redSocial) {
		this.codRedSocial = codRedSocial;
		this.redSocial = redSocial;
	}
	
	public int getCodRedSocial() {
		return codRedSocial;
	}
	public void setCodRedSocial(int codRedSocial) {
		this.codRedSocial = codRedSocial;
	}
	public String getRedSocial() {
		return redSocial;
	}
	public void setRedSocial(String redSocial) {
		this.redSocial = redSocial;
	}
	@Override
	public String toString() {
		return redSocial;
	}
	

}
