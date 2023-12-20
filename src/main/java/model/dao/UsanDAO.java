package model.dao;

import model.Usan;


/**
 *
 * @author cocodrelo
 */
public interface UsanDAO extends DAO<Usan>{
    
    public Usan getByIdCompuesto(int idPrenda, int codPri);
    public void modificar(Usan usanNuevo, Usan usanViejo);
    
}
