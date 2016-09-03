/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Contactos;
import jpa.valores.ContactosPK;
import jpa.valores.EmpleadosPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdContactosLocal {

    List<Contactos> encontrarTodos();

    void insertar(Contactos contacto) throws Exception;

    void actualizar(Contactos contacto);

    void eliminar(ContactosPK contactosPk);

    List<Contactos> encontrarUno(EmpleadosPK EmpleadosPK);
    
}