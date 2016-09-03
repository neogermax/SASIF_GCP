/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Rutas;

/**
 *
 * @author analista02
 */
@Local
public interface MbdRutasLocal {

    List<Rutas> encontrarTodos();

    Rutas encontrar(Integer rutCodigoPk);

    void actualizar(Rutas rutas);

    void insertar(Rutas rutas) throws Exception;

    void eliminar(Integer rutCodigoPk);
    
}
