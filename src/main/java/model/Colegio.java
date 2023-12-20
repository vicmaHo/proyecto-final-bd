package model;

public class Colegio {
    //ATRIBUTOS DE LA CLASE
    private int idColegio; //llave primaria
    private String direccion;
    private String nombre;


    // Primer constructor de la clase
    public Colegio(int idColegio, String direccion, String nombre) {
        this.idColegio = idColegio;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    //Segundo constructor de la clase
    public Colegio(String direccion, String nombre) {
        this.direccion = direccion;
        this.nombre = nombre;
    }

    //Metodos set

    public int getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(int idColegio) {
        this.idColegio = idColegio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
