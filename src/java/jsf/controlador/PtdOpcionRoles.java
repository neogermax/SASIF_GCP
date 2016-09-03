/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.controlador.MbdOpcionRolesLocal;

import jpa.valores.OpcionRoles;
import jpa.valores.OpcionRolesPK;


/**
 *
 * @author analista02
 */
public class PtdOpcionRoles {
    MbdOpcionRolesLocal mbdOpcionRoles = lookupOpcionRolesLocal();

    private MbdOpcionRolesLocal lookupOpcionRolesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdOpcionRolesLocal) c.lookup("java:comp/env/MbdOpcionRoles");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    
    public List<OpcionRoles> encontrarOpcion() {
        return mbdOpcionRoles.encontrarOpcion();
    }
    
    public void insertar(OpcionRoles opcionrol) throws Exception {
        this.mbdOpcionRoles.insertar(opcionrol);
    }

    public void actualizar(OpcionRoles opcionrol) {
        this.mbdOpcionRoles.actualizar(opcionrol);
    }

    public void eliminar(OpcionRolesPK opcionRolesPK) {
        mbdOpcionRoles.eliminar(opcionRolesPK);
    }
    
}
