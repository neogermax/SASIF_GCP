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
import jpa.controlador.MbdRutasLocal;
import jpa.valores.Rutas;

/**
 *
 * @author analista02
 */
public class PtdRutas {
    MbdRutasLocal mbdRutas = lookupMbdRutasLocal();

    private MbdRutasLocal lookupMbdRutasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdRutasLocal) c.lookup("java:comp/env/MbdRutas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Rutas> encontrarTodos() {
        return mbdRutas.encontrarTodos();
    }

    public Rutas encontrar(Integer rutCodigoPk) {
        return mbdRutas.encontrar(rutCodigoPk);
    }

    public void actualizar(Rutas rutas) {
        mbdRutas.actualizar(rutas);
    }

    public void insertar(Rutas rutas) throws Exception {
        mbdRutas.insertar(rutas);
    }

    public void eliminar(Integer rutCodigoPk) {
        mbdRutas.eliminar(rutCodigoPk);
    }
}
