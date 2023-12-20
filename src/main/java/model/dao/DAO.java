/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.dao;

import java.util.List;

/**
 *
 * @author Victor
 * @param <T>
 */
public interface DAO<T> {
        
    public void insertar(T t);
    public void modificar(T t);
    public void eliminar(T t);
    public List<T> obtenerTodos(); 
    public T getById(int id);
}
