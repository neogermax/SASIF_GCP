/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Errores;

/**
 *
 * @author analista02
 */
@Local
public interface MbdErroresLocal {

    List<Errores> encontrarTodos();

    Errores encontrar(Integer errCodPk);

    void insertar(Errores errores) throws Exception;

    void actualizar(Errores errores);

    void eliminar(Integer errCodPk);
    
}
