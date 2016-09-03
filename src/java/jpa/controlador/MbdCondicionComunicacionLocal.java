/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.CondicionComunicacion;

/**
 *
 * @author analista02
 */
@Local
public interface MbdCondicionComunicacionLocal {

    List<CondicionComunicacion> encontrarTodos();
    
    CondicionComunicacion encontrar(Integer concomCodigoPk);

    void actualizar(CondicionComunicacion condicionComunicacion);
    
    void insertar(CondicionComunicacion condicionComunicacion) throws Exception;

    void eliminar(Integer concomCodigoPk);
    
}
