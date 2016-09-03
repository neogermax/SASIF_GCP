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
import jpa.controlador.MbdRolesLocal;
import jpa.valores.Roles;

/**
 *
 * @author analista02
 */
public class PtdRoles {
    MbdRolesLocal mbdRoles = lookupMenuLocal();

    private MbdRolesLocal lookupMenuLocal() {
        try {
            Context c = new InitialContext();
            return (MbdRolesLocal) c.lookup("java:comp/env/MbdRoles");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    public void insertar(Roles rol) throws Exception {
        mbdRoles.insertar(rol);
    }

    public void actualizar(Roles rol) {
        mbdRoles.actualizar(rol);
    }

    public Roles encontrar(String rolRolPk) {
        return mbdRoles.encontrar(rolRolPk);
    }

    public List<Roles> encontrarTodos() {
        return mbdRoles.encontrarTodos();
    }

    public void eliminar(String rolRolPk) {
        mbdRoles.eliminar(rolRolPk);
    }
    
}
