package model;



public class Cliente {
    private String documento; // Llave primaria
    private String nombreCompleto;

    // Constructor que recibe todos los atributos
    public Cliente(String documento, String nombreCompleto) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
    }

    // Constructor que recibe todos los atributos excepto la llave primaria
    public Cliente(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    // Métodos set y get para documento
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    // Métodos set y get para nombreCompleto
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
