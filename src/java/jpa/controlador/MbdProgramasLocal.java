/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Programas;

/**
 *
 * @author analista02
 */
@Local
public interface MbdProgramasLocal {

    List<Programas> encontrarTodos();

    Programas encontrar(String ProgNomPk);

    void actualizar(Programas programas);

    void insertar(Programas programas) throws Exception;

    void eliminar(String ProgNomPk);
    
}
