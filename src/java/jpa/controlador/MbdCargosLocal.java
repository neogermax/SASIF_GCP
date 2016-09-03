/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Cargos;

/**
 *
 * @author analista02
 */
@Local
public interface MbdCargosLocal {

    List<Cargos> encontrarTodos();
    
    Cargos encontrar(Integer carCodigoPk);

    void actualizar(Cargos cargos);
    
    void insertar(Cargos cargos) throws Exception;

    void eliminar(Integer carCodigoPk);
    
}
