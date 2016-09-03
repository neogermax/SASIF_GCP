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
import jpa.controlador.MbdGdocumentosLocal;
import jpa.valores.Gdocumentos;

public class PtdGdocumentos {
    MbdGdocumentosLocal mbdGdocumentos = lookupMbdGdocumentosLocal();

    private MbdGdocumentosLocal lookupMbdGdocumentosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdGdocumentosLocal) c.lookup("java:comp/env/MbdGdocumentos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Gdocumentos> encontrarTodos() {
        return mbdGdocumentos.encontrarTodos();
    }

    public Gdocumentos encontrar(Integer gdoGrupoPk) {
        return mbdGdocumentos.encontrar(gdoGrupoPk);
    }

    public void insertar(Gdocumentos gdocumento) throws Exception {
        mbdGdocumentos.insertar(gdocumento);
    }

    public void actualizar(Gdocumentos gdocumento) {
        mbdGdocumentos.actualizar(gdocumento);
    }

    public void eliminar(Integer gdoGrupoPk) {
        mbdGdocumentos.eliminar(gdoGrupoPk);
    }
}
