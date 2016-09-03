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
import jpa.controlador.MbdInfoDocumentosLocal;
import jpa.valores.InfoDocumentos;
import jpa.valores.InfoDocumentosPK;

/**
 *
 * @author analista02
 */
public class PtdInfoDocumentos {
    MbdInfoDocumentosLocal mbdInfoDocumentos = lookupMbdInfoDocumentosLocal();

    private MbdInfoDocumentosLocal lookupMbdInfoDocumentosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdInfoDocumentosLocal) c.lookup("java:comp/env/MbdInfoDocumentos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<InfoDocumentos> encontrarTodos() {
        return mbdInfoDocumentos.encontrarTodos();
    }

    public void insertar(InfoDocumentos infoDocumentos) throws Exception {
        mbdInfoDocumentos.insertar(infoDocumentos);
    }

    public void actualizar(InfoDocumentos infoDocumentos) {
        mbdInfoDocumentos.actualizar(infoDocumentos);
    }

    public void eliminar(InfoDocumentosPK infoDocumentosPk) {
        mbdInfoDocumentos.eliminar(infoDocumentosPk);
    }
}
