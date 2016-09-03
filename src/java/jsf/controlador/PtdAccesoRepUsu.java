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
import jpa.controlador.MbdAccesoRepUsuLocal;
import jpa.valores.AccesoRepUsu;
import jpa.valores.AccesoRepUsuPK;

/**
 *
 * @author analista02
 */
public class PtdAccesoRepUsu {
 MbdAccesoRepUsuLocal mbdAccesoRepUsu = lookupMbdAccesoRepUsuLocal();

    private MbdAccesoRepUsuLocal lookupMbdAccesoRepUsuLocal() {
        try {
            Context c = new InitialContext();
            return (MbdAccesoRepUsuLocal) c.lookup("java:comp/env/MbdAccesoRepUsu");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<AccesoRepUsu> encontrarTodos() {
        return mbdAccesoRepUsu.encontrarTodos();
    }

    public void insertar(AccesoRepUsu accesoRepUsu) throws Exception {
        mbdAccesoRepUsu.insertar(accesoRepUsu);
    }

    public void actualizar(AccesoRepUsu accesoRepUsu) {
        mbdAccesoRepUsu.actualizar(accesoRepUsu);
    }

    public void eliminar(AccesoRepUsuPK accesoRepUsuPk) {
        mbdAccesoRepUsu.eliminar(accesoRepUsuPk);
    }
    
    public List<AccesoRepUsu> encontrarPorUsuario(String usuario) {
        return mbdAccesoRepUsu.encontrarPorUsuario(usuario);
    }
}
