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
import jpa.controlador.MbdDocExistentesLocal;
import jpa.valores.DocExistentes;
import jpa.valores.DocExistentesPK;

/**
 *
 * @author analista02
 */
public class PtdDocExistentes {
    MbdDocExistentesLocal mbdDocExistentes = lookupMbdDocExistentesLocal();

    private MbdDocExistentesLocal lookupMbdDocExistentesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdDocExistentesLocal) c.lookup("java:comp/env/MbdDocExistentes");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<DocExistentes> encontrarTodos() {
        return mbdDocExistentes.encontrarTodos();
    }

    public void insertar(DocExistentes docExistentes) throws Exception {
        mbdDocExistentes.insertar(docExistentes);
    }

    public void actualizar(DocExistentes docExistentes) {
        mbdDocExistentes.actualizar(docExistentes);
    }

    public void eliminar(DocExistentesPK docExistentesPk) {
        mbdDocExistentes.eliminar(docExistentesPk);
    }
    
    public DocExistentes encontrar(DocExistentesPK docExistentesPK) {
        return mbdDocExistentes.encontrar(docExistentesPK);
    }
    
    public Long secuencia(String codAplOr, String tipoDoc, Long ideApli, String nomDoc) {
        return mbdDocExistentes.secuencia(codAplOr, tipoDoc, ideApli, nomDoc);
    }
}
