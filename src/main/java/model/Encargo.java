package model;

import java.sql.Date;

import org.postgresql.shaded.com.ongres.stringprep.StringPrep;
public class Encargo {
    private int numPedido; // Llave primaria
    private Date fechaEncargo;
    private Date fechaEntrega;
    private String anotacion;
    private String estado;
    private double abono;
    private double valorTotal;
    private String documento; // Llave foránea

    // Constructor que recibe todos los atributos
    public Encargo(int numPedido, Date fechaEncargo, Date fechaEntrega, String anotacion,
                   String estado, double abono, double valorTotal, String documento) {
        this.numPedido = numPedido;
        this.fechaEncargo = fechaEncargo;
        this.fechaEntrega = fechaEntrega;
        this.anotacion = anotacion;
        this.estado = estado;
        this.abono = abono;
        this.valorTotal = valorTotal;
        this.documento = documento;
    }

    public Encargo(Date fechaEncargo, Date fechaEntrega, String anotacion,
                   String estado, double abono, double valorTotal, String documento) {
        this.fechaEncargo = fechaEncargo;
        this.fechaEntrega = fechaEntrega;
        this.anotacion = anotacion;
        this.estado = estado;
        this.abono = abono;
        this.valorTotal = valorTotal;
        this.documento = documento;
    }

    // Métodos set y get para numPedido
    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getNumPedido() {
        return numPedido;
    }

    // Métodos set y get para fechaEncargo
    public void setFechaEncargo(Date fechaEncargo) {
        this.fechaEncargo = fechaEncargo;
    }

    public Date getFechaEncargo() {
        return fechaEncargo;
    }

    // Métodos set y get para fechaEntrega
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    // Métodos set y get para anotacion
    public void setAnotacion(String anotacion) {
        this.anotacion = anotacion;
    }

    public String getAnotacion() {
        return anotacion;
    }

    // Métodos set y get para estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    // Métodos set y get para abono
    public void setAbono(double abono) {
        this.abono = abono;
    }

    public double getAbono() {
        return abono;
    }

    // Métodos set y get para valorTotal
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    // Métodos set y get para documento
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

}
