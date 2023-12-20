package model.dao;


import model.Proveedor;

public interface ProveedorDAO extends DAO<Proveedor>{
    
    public Proveedor getByNit(String nit);
}
