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
import jpa.controlador.MbdErroresLocal;
import jpa.valores.Errores;

/**
 *
 * @author analista02
 */
public class PtdErrores {
    MbdErroresLocal mbdErrores = lookupMbdErroresLocal();

    private MbdErroresLocal lookupMbdErroresLocal() {
        try {
            Context c = new InitialContext();
            return (MbdErroresLocal) c.lookup("java:comp/env/MbdErrores");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Errores> encontrarTodos() {
        return mbdErrores.encontrarTodos();
    }
    
    public Errores encontrar(Integer errCodPk) {
        return mbdErrores.encontrar(errCodPk);
    }

    public void insertar(Errores errores) throws Exception {
        mbdErrores.insertar(errores);
    }

    public void actualizar(Errores errores) {
        mbdErrores.actualizar(errores);
    }

    public void eliminar(Integer errCodPk) {
        mbdErrores.eliminar(errCodPk);
    }
}
