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
import jpa.controlador.MbdPdocumentosLocal;
import jpa.valores.Pdocumentos;

public class PtdPdocumentos {
    MbdPdocumentosLocal mbdPdocumentos = lookupMbdPdocumentosLocal();

    private MbdPdocumentosLocal lookupMbdPdocumentosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdPdocumentosLocal) c.lookup("java:comp/env/MbdPdocumentos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Pdocumentos> encontrarTodos() {
        return mbdPdocumentos.encontrarTodos();
    }

    public Pdocumentos encontrar(String pdoDocumentoPk) {
        return mbdPdocumentos.encontrar(pdoDocumentoPk);
    }

    public void insertar(Pdocumentos pdocumento) throws Exception {
        mbdPdocumentos.insertar(pdocumento);
    }

    public void actualizar(Pdocumentos pdocumentos) {
        mbdPdocumentos.actualizar(pdocumentos);
    }

    public void eliminar(String pdoDocumentoPk) {
        mbdPdocumentos.eliminar(pdoDocumentoPk);
    }
}
