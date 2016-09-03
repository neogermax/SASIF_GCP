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
import jpa.controlador.MbdDocmActvLocal;

import jpa.valores.DocmActv;
import jpa.valores.DocmActvPK;


/**
 *
 * @author analista02
 */
public class PtdDocmActv {
    MbdDocmActvLocal mbdDocmActv = lookupDocmActvLocal();

    private MbdDocmActvLocal lookupDocmActvLocal() {
        try {
            Context c = new InitialContext();
            return (MbdDocmActvLocal) c.lookup("java:comp/env/MbdDocmActv");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    
    public List<DocmActv> encontrarOpcion() {
        return mbdDocmActv.encontrarOpcion();
    }
    
    public void insertar(DocmActv docmactv) throws Exception {
        this.mbdDocmActv.insertar(docmactv);
    }

    public void actualizar(DocmActv docmactv) {
        this.mbdDocmActv.actualizar(docmactv);
    }

    public void eliminar(DocmActvPK docmactvPK) {
        mbdDocmActv.eliminar(docmactvPK);
    }
    
}
