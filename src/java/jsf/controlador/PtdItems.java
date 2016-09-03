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
import jpa.controlador.MbdItemsLocal;
import jpa.valores.Items;

/**
 *
 * @author Analista02
 */
public class PtdItems {
    MbdItemsLocal mbdItems = lookupMbdItemsLocal();

    private MbdItemsLocal lookupMbdItemsLocal() {
        try {
            Context c = new InitialContext();
            return (MbdItemsLocal) c.lookup("java:comp/env/MbdItems");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Items> encontrarTodos() {
        return mbdItems.encontrarTodos();
    }

    public Items encontrar(Integer itmCodPk) {
        return mbdItems.encontrar(itmCodPk);
    }

    public void insertar(Items item) throws Exception {
        mbdItems.insertar(item);
    }

    public void actualizar(Items item) {
        mbdItems.actualizar(item);
    }

    public void eliminar(Integer itmCodPk) {
        mbdItems.eliminar(itmCodPk);
    }
}
