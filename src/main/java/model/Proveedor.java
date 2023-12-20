package model;

public class Proveedor {
    private String NIT; // Llave primaria
    private String nombre;
    private String nombreContacto;
    private String productoSuministra;

    // Constructor que recibe todos los atributos
    public Proveedor(String NIT, String nombre, String nombreContacto, String productoSuministra) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.nombreContacto = nombreContacto;
        this.productoSuministra = productoSuministra;
    }

    // Constructor que recibe todos los atributos excepto la llave primaria
    public Proveedor(String nombre, String nombreContacto, String productoSuministra) {
        this.nombre = nombre;
        this.nombreContacto = nombreContacto;
        this.productoSuministra = productoSuministra;
    }

    // Métodos set y get para nit
    public void setNIT(String nit) {
        this.NIT = nit;
    }

    public String getNIT() {
        return NIT;
    }

    // Métodos set y get para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Métodos set y get para nombreContacto
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    // Métodos set y get para productoSuministra
    public void setProductoSuministra(String productoSuministra) {
        this.productoSuministra = productoSuministra;
    }

    public String getProductoSuministra() {
        return productoSuministra;
    }
}
