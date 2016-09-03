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
import jpa.controlador.MbdPermisosDocUsuLocal;
import jpa.valores.PermisosDocUsu;
import jpa.valores.PermisosDocUsuPK;

/**
 *
 * @author analista02
 */
public class PtdPermisosDocUsu {
    MbdPermisosDocUsuLocal mbdPermisosDocUsu = lookupMbdPermisosDocUsuLocal();

    private MbdPermisosDocUsuLocal lookupMbdPermisosDocUsuLocal() {
        try {
            Context c = new InitialContext();
            return (MbdPermisosDocUsuLocal) c.lookup("java:comp/env/MbdPermisosDocUsu");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<PermisosDocUsu> encontrarTodos() {
        return mbdPermisosDocUsu.encontrarTodos();
    }

    public void insertar(PermisosDocUsu permisosDocUsu) throws Exception {
        mbdPermisosDocUsu.insertar(permisosDocUsu);
    }

    public void actualizar(PermisosDocUsu permisosDocUsu) {
        mbdPermisosDocUsu.actualizar(permisosDocUsu);
    }

    public void eliminar(PermisosDocUsuPK permisosDocUsuPk) {
        mbdPermisosDocUsu.eliminar(permisosDocUsuPk);
    }
}
