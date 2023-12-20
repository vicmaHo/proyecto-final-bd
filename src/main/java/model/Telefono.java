package model;


/**
 *
 * @author cocodrelo
 */
public class Telefono {
    

   
    private String Documento;
    private String telefono;

    
   
    public Telefono(String Documento, String telefono) {
        this.Documento = Documento;
        this.telefono = telefono;
    }
    
    
    public Telefono(String telefono, int Documentof) {
        this.telefono = telefono;
    }


   

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

  
}