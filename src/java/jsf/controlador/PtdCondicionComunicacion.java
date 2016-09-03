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
import jpa.controlador.MbdCondicionComunicacionLocal;
import jpa.valores.CondicionComunicacion;

/**
 *
 * @author analista02
 */
public class PtdCondicionComunicacion {
    MbdCondicionComunicacionLocal mbdCondicionComunicacion = lookupMbdCondicionComunicacionLocal();

    private MbdCondicionComunicacionLocal lookupMbdCondicionComunicacionLocal() {
        try {
            Context c = new InitialContext();
            return (MbdCondicionComunicacionLocal) c.lookup("java:comp/env/MbdCondicionComunicacion");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<CondicionComunicacion> encontrarTodos() {
        return mbdCondicionComunicacion.encontrarTodos();
    }

     public CondicionComunicacion encontrar(Integer concomCodigoPk) {
        return mbdCondicionComunicacion.encontrar(concomCodigoPk);
    }
     
    public void actualizar(CondicionComunicacion condicionComunicacion) {
        mbdCondicionComunicacion.actualizar(condicionComunicacion);
    }

    public void insertar(CondicionComunicacion condicionComunicacion) throws Exception {
        mbdCondicionComunicacion.insertar(condicionComunicacion);
    }
    
    public void eliminar(Integer concomCodigoPk) {
        mbdCondicionComunicacion.eliminar(concomCodigoPk);
    }
    
}
