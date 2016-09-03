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
import jpa.controlador.MbdLinksLocal;
import jpa.valores.Links;

/**
 *
 * @author analista02
 */
public class PtdLinks {
    MbdLinksLocal mbdLinks = lookupLinkLocal();

    private MbdLinksLocal lookupLinkLocal() {
        try {
            Context c = new InitialContext();
            return (MbdLinksLocal) c.lookup("java:comp/env/MbdLinks");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

        
    public List<Links> encontrarTodos() {
        return mbdLinks.encontrarTodos();
    }
    
    public void insertar(Links link) throws Exception {
        this.mbdLinks.insertar(link);
    }

    public void actualizar(Links link) {
        this.mbdLinks.actualizar(link);
    }

    public void eliminar(String linkCodPk) {
        mbdLinks.eliminar(linkCodPk);
    }
    
}
