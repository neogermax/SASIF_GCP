/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.OpcionRoles;
import jpa.valores.OpcionRolesPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdOpcionRolesLocal {

    List<OpcionRoles> encontrarOpcion();

    void insertar(OpcionRoles opcionrol) throws Exception;

    void actualizar(OpcionRoles opcionro);

    void eliminar(OpcionRolesPK opcionRolesPK);
    
}
