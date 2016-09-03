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
import jpa.controlador.MbdEtapasLocal;
import jpa.valores.Etapas;

/**
 *
 * @author analista02
 */
public class PtdEtapas {
    MbdEtapasLocal mbdEtapas = lookupMbdEtapasLocal();

    private MbdEtapasLocal lookupMbdEtapasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdEtapasLocal) c.lookup("java:comp/env/MbdEtapas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Etapas> encontrarTodos() {
        return mbdEtapas.encontrarTodos();
    }

    public Etapas encontrar(Integer etpCodPk) {
        return mbdEtapas.encontrar(etpCodPk);
    }

    public void actualizar(Etapas etapas) {
        mbdEtapas.actualizar(etapas);
    }

    public void insertar(Etapas etapas) throws Exception {
        mbdEtapas.insertar(etapas);
    }

    public void eliminar(Integer etpCodPk) {
        mbdEtapas.eliminar(etpCodPk);
    }
}
