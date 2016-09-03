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
import jpa.controlador.MbdPoliticaGruposLocal;

import jpa.valores.PoliticaGrupos;

/**
 *
 * @author analista02
 */
public class PtdPoliticaGrupos {
    MbdPoliticaGruposLocal mbdPoliticaGrupos = lookupPoliticaGrupoLocal();
    
    private MbdPoliticaGruposLocal lookupPoliticaGrupoLocal() {
        try {
            Context c = new InitialContext();
            return (MbdPoliticaGruposLocal) c.lookup("java:comp/env/MbdPoliticaGrupos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<PoliticaGrupos> encontrarPoliticaGrupos() {
        return mbdPoliticaGrupos.encontrarTodos();
    }
    
     public void insertar(PoliticaGrupos politicagrupo) throws Exception {
        this.mbdPoliticaGrupos.insertar(politicagrupo);
    }

    public void actualizar(PoliticaGrupos politicagrupo) {
        this.mbdPoliticaGrupos.actualizar(politicagrupo);
    }

    public void eliminar(Integer polCodPk) {
        mbdPoliticaGrupos.eliminar(polCodPk);
    }
        
}
