package model;



/**
 *
 * @author cocodrelo
 */
public class Suministro {
    
   
   private String NIT;
   private int codPri;

    public Suministro(String NIT, int codPri) {
        this.NIT = NIT;
        this.codPri = codPri;
    }
    
    public Suministro() {
        
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public int getCodPri() {
        return codPri;
    }

    public void setCodPri(int CodPri) {
        this.codPri = CodPri;
    }

   
}
