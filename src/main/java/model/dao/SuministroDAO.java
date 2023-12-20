package model.dao;

import model.Suministro;


/**
 *
 * @author cocodrelo
 */
public interface SuministroDAO extends DAO<Suministro> {
    
    public Suministro getByIdCompuesto(String NIT, int codPri);
    public void modificar(Suministro suministroNuevo, Suministro suministroViejo);
    
}
