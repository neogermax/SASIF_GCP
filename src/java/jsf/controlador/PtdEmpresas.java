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
import jpa.controlador.MbdEmpresasLocal;
import jpa.valores.Empresas;

/**
 *
 * @author analista02
 */
public class PtdEmpresas {
    MbdEmpresasLocal mbdEmpresas = lookupEmpresaLocal();

    private MbdEmpresasLocal lookupEmpresaLocal() {
        try {
            Context c = new InitialContext();
            return (MbdEmpresasLocal) c.lookup("java:comp/env/MbdEmpresas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Empresas> encontrarTodos() {
        return mbdEmpresas.encontrarTodos();
    }
    
    public void insertar(Empresas empresa) throws Exception {
        this.mbdEmpresas.insertar(empresa);
    }

    public void actualizar(Empresas empresa) {
        this.mbdEmpresas.actualizar(empresa);
    }

    public void eliminar(Integer emprCodigoPk) {
        mbdEmpresas.eliminar(emprCodigoPk);
    }
    
}
