/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Clases;

/**
 *
 * @author analista02
 */
@Local
public interface MbdClasesLocal {

    Clases encontrar(Integer clsCodPk);

    List<Clases> encontrarTodos();

    void insertar(Clases clases) throws Exception;

    void actualizar(Clases clases);

    void eliminar(Integer clsCodPk);

    void actualizar(List<Clases> clases);
    
}
