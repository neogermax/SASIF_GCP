/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Areas;
import jpa.valores.AreasPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdAreasLocal {

    List<Areas> encontrarTodos();

    void insertar(Areas areas) throws Exception;

    void actualizar(Areas areas);

    void eliminar(AreasPK areasPk);
    
}
