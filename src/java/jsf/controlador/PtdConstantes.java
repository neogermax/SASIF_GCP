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
import jpa.controlador.MbdConstantesLocal;
import jpa.valores.Constantes;

/**
 *
 * @author analista02
 */
public class PtdConstantes {
    MbdConstantesLocal mbdConstantes = lookupMbdConstantesLocal();

    private MbdConstantesLocal lookupMbdConstantesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdConstantesLocal) c.lookup("java:comp/env/MbdConstantes");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Constantes> encontrarTodos() {
        return mbdConstantes.encontrarTodos();
    }

    public Constantes encontrar(Integer consCodPk) {
        return mbdConstantes.encontrar(consCodPk);
    }

    public void actualizar(Constantes constantes) {
        mbdConstantes.actualizar(constantes);
    }

    public void insertar(Constantes constantes) throws Exception {
        mbdConstantes.insertar(constantes);
    }

    public void eliminar(Integer consCodPk) {
        mbdConstantes.eliminar(consCodPk);
    }
}
