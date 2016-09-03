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
import jpa.controlador.MbdAreasLocal;
import jpa.valores.Areas;
import jpa.valores.AreasPK;

/**
 *
 * @author analista02
 */
public class PtdAreas {
    MbdAreasLocal mbdAreas = lookupMbdAreasLocal();

    private MbdAreasLocal lookupMbdAreasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdAreasLocal) c.lookup("java:comp/env/MbdAreas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Areas> encontrarTodos() {
        return mbdAreas.encontrarTodos();
    }

    public void insertar(Areas areas) throws Exception {
        mbdAreas.insertar(areas);
    }

    public void actualizar(Areas areas) {
        mbdAreas.actualizar(areas);
    }

    public void eliminar(AreasPK areasPk) {
        mbdAreas.eliminar(areasPk);
    }
}
