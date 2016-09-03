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
import jpa.controlador.MbdUsuariosLocal;
import jpa.valores.Areas;
import jpa.valores.Empresas;
import jpa.valores.HistoricoClaves;
import jpa.valores.Usuarios;

/**
 *
 * @author saflap
 */
public class PtdUsuarios {
    private MbdUsuariosLocal mbdUsuarios = lookupLoginLocal();

    
    
    public Usuarios validarUsuario(String usuario) {
        return mbdUsuarios.validarUsuario(usuario);
        
    }
    
    public void actualizarUsuario(Usuarios usuario) {
        mbdUsuarios.actualizarUsuario(usuario);
    }
    
    public List<HistoricoClaves> encontrarHistoricos(String usuario) {
        return mbdUsuarios.encontrarHistoricos(usuario);
    }
    
    public void cambiarContraseña(Usuarios usuario) {
        mbdUsuarios.cambiarContraseña(usuario);
    }

    private MbdUsuariosLocal lookupLoginLocal() {
        try {
            Context c = new InitialContext();
            return (MbdUsuariosLocal) c.lookup("java:comp/env/MbdUsuarios");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Usuarios> encontrarTodos() {
        return mbdUsuarios.encontrarTodos();
    }

    public void insertar(Usuarios usuarios) throws Exception {
        mbdUsuarios.insertar(usuarios);
    }

    public void eliminar(String usuCodPk) {
        mbdUsuarios.eliminar(usuCodPk);
    }
    
    public List<Usuarios> encontrarPorEmpresa(Empresas empresa) {
        return mbdUsuarios.encontrarPorEmpresa(empresa);
    }

    public List<Usuarios> encontrarPorArea(Areas area) {
        return mbdUsuarios.encontrarPorArea(area);
    }
    
    public Usuarios encontrarPorCod(String cod) {
        return mbdUsuarios.encontrarPorCod(cod);
    }
}
