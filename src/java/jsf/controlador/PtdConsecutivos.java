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
import jpa.controlador.MbdConsecutivosLocal;
import jpa.valores.Consecutivos;

/**
 *
 * @author analista02
 */
public class PtdConsecutivos {
    MbdConsecutivosLocal mbdConsecutivos = lookupMbdConsecutivosLocal();

    private MbdConsecutivosLocal lookupMbdConsecutivosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdConsecutivosLocal) c.lookup("java:comp/env/MbdConsecutivos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Consecutivos encontrar(Integer consecCodPk) {
        return mbdConsecutivos.encontrar(consecCodPk);
    }

    public List<Consecutivos> encontrarTodos() {
        return mbdConsecutivos.encontrarTodos();
    }

    public void insertar(Consecutivos consecutivos) throws Exception {
        mbdConsecutivos.insertar(consecutivos);
    }
    
    public void actualizar(Consecutivos consecutivos) {
        mbdConsecutivos.actualizar(consecutivos);
    }

    public void eliminar(Integer consecCodPk) {
        mbdConsecutivos.eliminar(consecCodPk);
    }
}
