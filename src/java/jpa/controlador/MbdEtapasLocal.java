/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Etapas;

/**
 *
 * @author analista02
 */
@Local
public interface MbdEtapasLocal {

    List<Etapas> encontrarTodos();

    Etapas encontrar(Integer etpCodPk);

    void actualizar(Etapas etapas);

    void insertar(Etapas etapas) throws Exception;

    void eliminar(Integer etpCodPk);
    
}
