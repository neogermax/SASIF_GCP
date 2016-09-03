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
import jpa.controlador.MbdFormulasLocal;
import jpa.valores.Formulas;

/**
 *
 * @author analista02
 */
public class PtdFormulas {
    MbdFormulasLocal mbdFormulas = lookupMbdFormulasLocal();

    private MbdFormulasLocal lookupMbdFormulasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdFormulasLocal) c.lookup("java:comp/env/MbdFormulas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Formulas> encontrarTodos() {
        return mbdFormulas.encontrarTodos();
    }

    public Formulas encontrar(Integer forCodPk) {
        return mbdFormulas.encontrar(forCodPk);
    }

    public void actualizar(Formulas formulas) {
        mbdFormulas.actualizar(formulas);
    }

    public void insertar(Formulas formulas) throws Exception {
        mbdFormulas.insertar(formulas);
    }

    public void eliminar(Integer forCodPk) {
        mbdFormulas.eliminar(forCodPk);
    }
}
