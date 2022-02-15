package model;

public class Usuarios {
	private int codUsuario;
    private String nombreUsu;
    private String ApellidoUsu;
    private String Usuario;
    private String pass;
    private String fecha;
    private String nomTipoUsu;
    private int codTipoUsu;
    
	public String getNomTipoUsu() {
		return nomTipoUsu;
	}
	public void setNomTipoUsu(String nomTipoUsu) {
		this.nomTipoUsu = nomTipoUsu;
	}
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNombreUsu() {
		return nombreUsu;
	}
	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}
	public String getApellidoUsu() {
		return ApellidoUsu;
	}
	public void setApellidoUsu(String apellidoUsu) {
		ApellidoUsu = apellidoUsu;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCodTipoUsu() {
		return codTipoUsu;
	}
	public void setCodTipoUsu(int codTipoUsu) {
		this.codTipoUsu = codTipoUsu;
	}
    
    
}
