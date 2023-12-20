package model;

public class MateriasPrimas {
    //Atributos
    private int codPri; //llave primaria
    private String tipo;
    private String cantPri;
    private String unidadMedida;
    private String descripcionPri;

    //Primer constructor
    public MateriasPrimas(int codPri, String tipo, String cantPri, String unidadMedida, String descripcionPri){
        this.codPri = codPri;
        this.tipo = tipo;
        this.cantPri = cantPri;
        this.unidadMedida = unidadMedida;
        this.descripcionPri = descripcionPri;
    }

    //Segundo constructor
    public MateriasPrimas(String tipo, String cantPri, String unidadMedida, String descripcionPri){
        this.tipo = tipo;
        this.cantPri = cantPri;
        this.unidadMedida = unidadMedida;
        this.descripcionPri = descripcionPri;
    }

    public void setCodPri(int codPri) {
        this.codPri = codPri;
    }

    // Método get para codPri
    public int getCodPri() {
        return codPri;
    }

    // Método set para tipo
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Método get para tipo
    public String getTipo() {
        return tipo;
    }

    // Método set para cantPri
    public void setCantPri(String cantPri) {
        this.cantPri = cantPri;
    }

    // Método get para cantPri
    public String getCantPri() {
        return cantPri;
    }

    // Método set para unidadMedida
    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    // Método get para unidadMedida
    public String getUnidadMedida() {
        return unidadMedida;
    }

    // Método set para descripcionPri
    public void setDescripcionPri(String descripcionPri) {
        this.descripcionPri = descripcionPri;
    }

    // Método get para descripcionPri
    public String getDescripcionPri() {
        return descripcionPri;
    }
}
