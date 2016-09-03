/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.ActItems;
import jpa.valores.ActItemsPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdActItemsLocal {

    ActItems encontrar(ActItemsPK actItemsPK);

    List<ActItems> encontrarTodos();

    void insertar(ActItems actItem) throws Exception;

    void actualizar(ActItems actItem);

    void eliminar(ActItemsPK actItemsPK);

    void insertar(List<ActItems> actItems);
    
}
