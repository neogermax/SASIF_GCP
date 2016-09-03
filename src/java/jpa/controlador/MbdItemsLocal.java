/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Items;

/**
 *
 * @author Analista02
 */
@Local
public interface MbdItemsLocal {

    List<Items> encontrarTodos();

    Items encontrar(Integer itmCodPk);

    void insertar(Items item) throws Exception;

    void actualizar(Items item);

    void eliminar(Integer itmCodPk);
    
}
