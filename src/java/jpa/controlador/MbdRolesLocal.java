/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Roles;

/**
 *
 * @author analista02
 */
@Local
public interface MbdRolesLocal {
    
    Roles encontrar(String rolRolPk);

    List<Roles> encontrarTodos();

    void insertar(Roles rol) throws Exception;

    void actualizar(Roles rol);

    void eliminar(String rolRolPk);
    
}
