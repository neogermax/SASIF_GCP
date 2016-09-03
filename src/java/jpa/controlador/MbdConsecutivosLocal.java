
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Consecutivos;

/**
 *
 * @author analista02
 */
@Local
public interface MbdConsecutivosLocal {

    Consecutivos encontrar(Integer consecCodPk);

    List<Consecutivos> encontrarTodos();

    void insertar(Consecutivos consecutivos) throws Exception;

    void actualizar(Consecutivos consecutivos);

    void eliminar(Integer consecCodPk);
    
}

