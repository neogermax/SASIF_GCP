/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.documentos;

import documentos.DocumentosLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author analista02
 */
public class DocumentosDelegate {
    DocumentosLocal documentos = lookupDocumentosLocal();

    private DocumentosLocal lookupDocumentosLocal() {
        try {
            Context c = new InitialContext();
            return (DocumentosLocal) c.lookup("java:comp/env/Documentos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void processDigitalizado(String trama) {
        documentos.processDigitalizado(trama);
    }
    
    public void processDocument(String trama) {
        documentos.processDocument(trama);
    }
}
