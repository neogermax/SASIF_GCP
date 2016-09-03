/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Ayudas;

/**
 *
 * @author analista02
 */
@Local
public interface MbdAyudasLocal {

    List<Ayudas> encontrarTodos();

    Ayudas encontrar(Integer aydCodPk);

    void actualizar(Ayudas ayudas);

    void insertar(Ayudas ayudas) throws Exception;

    void eliminar(Integer aydCodPk);
    
}
