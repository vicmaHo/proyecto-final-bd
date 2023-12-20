package model;

/**
 *
 * @author cocodrelo
 */
public class Uniforme {
    
    
    private int idprenda;
    private int idcolegio;
    private String tipo;
    private String caracteristicasPropias;


   

    public Uniforme(int idprenda, String tipo, int idcolegio, String caracteristicasPropias) {
        this.idprenda = idprenda;
        this.tipo = tipo;
        this.idcolegio = idcolegio;
        this.caracteristicasPropias = caracteristicasPropias;
    }
    
    public Uniforme(String tipo, int idcolegio, String caracteristicasPropias) {
        this.tipo = tipo;
        this.idcolegio = idcolegio;
        this.caracteristicasPropias = caracteristicasPropias;
    }


    public int getIdprenda() {
        return idprenda;
    }

    public void setIdprenda(int idprenda) {
        this.idprenda = idprenda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdcolegio() {
        return idcolegio;
    }

    public void setIdcolegio(int idcolegio) {
        this.idcolegio = idcolegio;
    }

    public String getCaracteristicasPropias() {
        return caracteristicasPropias;
    }

    public void setCaracteristicasPropias(String caracteristicasPropias) {
        this.caracteristicasPropias = caracteristicasPropias;
    }

    @Override
    public String toString() {
        return "Uniforme{" + "idprenda=" + idprenda + ", tipo=" + tipo + ", idcolegio=" + idcolegio + ", caracteristicasPropias=" + caracteristicasPropias + '}';
    }
    
    
    
}
