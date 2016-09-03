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
import jpa.controlador.MbdActItemsLocal;
import jpa.valores.ActItems;
import jpa.valores.ActItemsPK;

/**
 *
 * @author analista02
 */
public class PtdActItems {
    MbdActItemsLocal mbdActItems = lookupMbdActItemsLocal();

    private MbdActItemsLocal lookupMbdActItemsLocal() {
        try {
            Context c = new InitialContext();
            return (MbdActItemsLocal) c.lookup("java:comp/env/MbdActItems");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public ActItems encontrar(ActItemsPK actItemsPK) {
        return mbdActItems.encontrar(actItemsPK);
    }

    public List<ActItems> encontrarTodos() {
        return mbdActItems.encontrarTodos();
    }

    public void insertar(ActItems actItem) throws Exception {
        mbdActItems.insertar(actItem);
    }

    public void actualizar(ActItems actItem) {
        mbdActItems.actualizar(actItem);
    }

    public void eliminar(ActItemsPK actItemsPK) {
        mbdActItems.eliminar(actItemsPK);
    }
    
    public void insertar(List<ActItems> actItems) {
        mbdActItems.insertar(actItems);
    }
    
}
