/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Constantes;

/**
 *
 * @author analista02
 */
@Local
public interface MbdConstantesLocal {

    List<Constantes> encontrarTodos();

    Constantes encontrar(Integer consCodPk);

    void actualizar(Constantes constantes);

    void insertar(Constantes constantes) throws Exception;

    void eliminar(Integer consCodPk);
    
}
