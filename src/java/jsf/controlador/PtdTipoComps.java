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
import jpa.controlador.MbdTipoCompsLocal;
import jpa.valores.TipoComps;

/**
 *
 * @author Analista02
 */
public class PtdTipoComps {
    MbdTipoCompsLocal mbdTipoComps = lookupMbdTipoCompsLocal();

    private MbdTipoCompsLocal lookupMbdTipoCompsLocal() {
        try {
            Context c = new InitialContext();
            return (MbdTipoCompsLocal) c.lookup("java:comp/env/MbdTipoComps");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<TipoComps> encontrarTodos() {
        return mbdTipoComps.encontrarTodos();
    }

    public void insertar(TipoComps tipoComps) throws Exception {
        mbdTipoComps.insertar(tipoComps);
    }

    public void actualizar(TipoComps tipoComps) {
        mbdTipoComps.actualizar(tipoComps);
    }

    public void eliminar(Integer tipCodPk) {
        mbdTipoComps.eliminar(tipCodPk);
    }
}
