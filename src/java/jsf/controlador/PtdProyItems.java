/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.controlador.MbdProyItemsLocal;
import jpa.valores.Actividades;
import jpa.valores.ProyItems;
import jpa.valores.ProyItemsPK;
import jpa.valores.Proyectos;

/**
 *
 * @author analista02
 */
public class PtdProyItems {


    MbdProyItemsLocal mbdProyItems = lookupMbdProyItemsLocal();

    private MbdProyItemsLocal lookupMbdProyItemsLocal() {
        try {
            Context c = new InitialContext();
            return (MbdProyItemsLocal) c.lookup("java:comp/env/MbdProyItems");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public ProyItems encontrar(ProyItemsPK proyItemsPK) {
        return mbdProyItems.encontrar(proyItemsPK);
    }
    
    public void actualizar(ProyItems proyItems) {
        mbdProyItems.actualizar(proyItems);
    }

    public void eliminar(ProyItemsPK proyItemsPK) {
        mbdProyItems.eliminar(proyItemsPK);
    }
    
    public void actualizar(List<ProyItems> proyItems) {
        mbdProyItems.actualizar(proyItems);
    }
    
    public List<ProyItems> encontrarPorActItems(Integer act, Proyectos proy) {
        return mbdProyItems.encontrarPorActItems(act, proy);
    }
}
