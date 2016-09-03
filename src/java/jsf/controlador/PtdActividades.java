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
import jpa.controlador.MbdActividadesLocal;
import jpa.valores.Actividades;

/**
 *
 * @author analista02
 */
public class PtdActividades {
    MbdActividadesLocal mbdActividades = lookupMbdActividadesLocal();

    private MbdActividadesLocal lookupMbdActividadesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdActividadesLocal) c.lookup("java:comp/env/MbdActividades");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Actividades encontrar(Integer actCodPk) {
        return mbdActividades.encontrar(actCodPk);
    }

    public List<Actividades> encontrarTodos() {
        return mbdActividades.encontrarTodos();
    }

    public void insertar(Actividades actividades) throws Exception {
        mbdActividades.insertar(actividades);
    }

    public void actualizar(Actividades actividades) {
        mbdActividades.actualizar(actividades);
    }
    
    public void actualizar() {
        mbdActividades.actualizar();
    }

    public void eliminar(Integer actCodPk) {
        mbdActividades.eliminar(actCodPk);
    }
}
