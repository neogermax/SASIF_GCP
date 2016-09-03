/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Links;

/**
 *
 * @author analista02
 */
@Local
public interface MbdLinksLocal {

    List<Links> encontrarTodos();

    void insertar(Links link) throws Exception;

    void actualizar(Links link);

    void eliminar(String linkCodPk);
    
}
