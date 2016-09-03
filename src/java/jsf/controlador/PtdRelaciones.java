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
import jpa.controlador.MbdRelacionesLocal;
import jpa.valores.Clases;
import jpa.valores.Relaciones;
import jpa.valores.RelacionesPK;

/**
 *
 * @author analista02
 */
public class PtdRelaciones {
    MbdRelacionesLocal mbdRelaciones = lookupMbdRelacionesLocal();

    private MbdRelacionesLocal lookupMbdRelacionesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdRelacionesLocal) c.lookup("java:comp/env/MbdRelaciones");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Relaciones> encontrarTodos() {
        return mbdRelaciones.encontrarTodos();
    }

    public List<Relaciones> encontrarPorClase(Clases clases) {
        return mbdRelaciones.encontrarPorClase(clases);
    }

    public void insertar(Relaciones relaciones) throws Exception {
        mbdRelaciones.insertar(relaciones);
    }

    public void actualizar(Relaciones relaciones) {
        mbdRelaciones.actualizar(relaciones);
    }

    public void eliminar(RelacionesPK relacionesPk) {
        mbdRelaciones.eliminar(relacionesPk);
    }
    
    public void insertar(List<Relaciones> relaciones) {
        mbdRelaciones.insertar(relaciones);
    }
}
