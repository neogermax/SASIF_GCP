/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Numericas;
import jpa.valores.NumericasPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdNumericasLocal {

    List<Numericas> encontrarTodos();

    List<Numericas> encontrarPorCodigo(Integer numCodPk);

    void insertar(Numericas numericas) throws Exception;

    void actualizar(Numericas numericas);

    void eliminar(NumericasPK numericasPK);

    Numericas encontrar(NumericasPK numericasPk);

    List<Integer> encontrarCodigos();
    
}
