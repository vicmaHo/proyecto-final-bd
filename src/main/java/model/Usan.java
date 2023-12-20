package model;


/**
 *
 * @author cocodrelo
 */
public class Usan {
    
    private int idprenda;
    private int codPri;

    public Usan(int idprenda, int codPri) {
        this.idprenda = idprenda;
        this.codPri = codPri;
    }
    
    public Usan() {
    }

    public int getIdprenda() {
        return idprenda;
    }

    public void setIdprenda(int idprenda) {
        this.idprenda = idprenda;
    }

    public int getCodPri() {
        return codPri;
    }

    public void setCodPri(int codPri) {
        this.codPri = codPri;
    }

}
