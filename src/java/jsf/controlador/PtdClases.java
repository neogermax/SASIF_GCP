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
import jpa.controlador.MbdClasesLocal;
import jpa.valores.Clases;

/**
 *
 * @author analista02
 */
public class PtdClases {
    MbdClasesLocal mbdClases = lookupMbdClasesLocal();

    private MbdClasesLocal lookupMbdClasesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdClasesLocal) c.lookup("java:comp/env/MbdClases");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Clases encontrar(Integer clsCodPk) {
        return mbdClases.encontrar(clsCodPk);
    }

    public List<Clases> encontrarTodos() {
        return mbdClases.encontrarTodos();
    }

    public void insertar(Clases clases) throws Exception {
        mbdClases.insertar(clases);
    }
    
    public void actualizar(Clases clases) {
        mbdClases.actualizar(clases);
    }

    public void eliminar(Integer clsCodPk) {
        mbdClases.eliminar(clsCodPk);
    }
    
    public void actualizar(List<Clases> clases) {
        mbdClases.actualizar(clases);
    }
}
