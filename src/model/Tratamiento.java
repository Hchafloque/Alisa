package model;

public class Tratamiento {

	private String codTratamiento;
    private String nomTratami;
    private double precio;
    private int codCli;

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }
    private int codigoCli;

    public String getCodTratamiento() {
        return codTratamiento;
    }

    public void setCodTratamiento(String codTratamiento) {
        this.codTratamiento = codTratamiento;
    }

    public String getNomTratami() {
        return nomTratami;
    }

    public void setNomTratami(String nomTratami) {
        this.nomTratami = nomTratami;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigoCli() {
        return codigoCli;
    }

    public void setCodigoCli(int codigoCli) {
        this.codigoCli = codigoCli;
    }
}
