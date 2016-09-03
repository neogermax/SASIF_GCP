/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Alfanumericas;
import jpa.valores.AlfanumericasPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdAlfanumericasLocal {

    List<Alfanumericas> encontrarTodos();

    List<Alfanumericas> encontrarPorCodigo(Integer alfCodPk);

    void insetar(Alfanumericas alfanumericas) throws Exception;

    void actualizar(Alfanumericas alfanumericas);

    void eliminar(AlfanumericasPK alfanumericasPK);

    Alfanumericas encontrar(AlfanumericasPK alfanumericasPk);

    List<Integer> encontrarCodigos();
    
}
