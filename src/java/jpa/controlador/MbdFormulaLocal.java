/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Formulas;

/**
 *
 * @author analista02
 */
@Local
public interface MbdFormulaLocal {

    List<Formulas> encontrarTodos();

    Formulas encontrar(Integer forCodPk);

    void actualizar(Formulas formulas);

    void insertar(Formulas formulas) throws Exception;

    void eliminar(Integer forCodPk);
    
}
