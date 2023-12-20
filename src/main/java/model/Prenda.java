package model;



/**
 *
 * @author cocodrelo
 */
public class Prenda {
    
    
    private int idPrenda;
    private String  color;
    private int cantidad;
    private String talla;
    private String descripcion;
    private String tipoTela; 
    private String precioVenta;
    private String sexo;
    private int numPedido;
    
    public Prenda(int idPrenda, String color, int cantidad, String talla,String descripcion, 
            String tipoTela, String precioVenta, String sexo,int numPedido) {
        this.idPrenda = idPrenda;
        this.color = color;
        this.cantidad = cantidad;
        this.numPedido = numPedido;
        this.talla = talla;
        this.descripcion = descripcion;
        this.tipoTela = tipoTela;
        this.precioVenta = precioVenta;
        this.sexo = sexo;
    }
    public Prenda( String color, int cantidad, String talla, String descripcion, String tipoTela,
            String precioVenta, String sexo,int numPedido){
        
        this.color = color;
        this.cantidad = cantidad;
        this.numPedido = numPedido;
        this.talla = talla;
        this.descripcion = descripcion;
        this.tipoTela = tipoTela;
        this.precioVenta = precioVenta;
        this.sexo = sexo;
        
    }
    
    
    public int getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
