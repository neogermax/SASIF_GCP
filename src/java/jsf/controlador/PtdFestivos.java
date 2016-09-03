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
import jpa.controlador.MbdFestivosLocal;
import jpa.valores.Festivos;
import jpa.valores.FestivosPK;

/**
 *
 * @author analista02
 */
public class PtdFestivos {
    MbdFestivosLocal mbdFestivos = lookupFestivoLocal();

    private MbdFestivosLocal lookupFestivoLocal() {
        try {
            Context c = new InitialContext();
            return (MbdFestivosLocal) c.lookup("java:comp/env/MbdFestivos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Festivos> encontrarTodos() {
        return mbdFestivos.encontrarTodos();
    }
    
    public void insertar(Festivos festivo) throws Exception {
        this.mbdFestivos.insertar(festivo);
    }

    public void eliminar(FestivosPK festivosPK) {
        mbdFestivos.eliminar(festivosPK);
    }
    
}
