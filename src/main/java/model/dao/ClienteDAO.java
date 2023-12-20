package model.dao;


import model.Cliente;

public interface ClienteDAO extends DAO<Cliente>{

    public Cliente getByIdDocumento(String documento);
    
    
}
