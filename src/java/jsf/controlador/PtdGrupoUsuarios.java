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
import jpa.controlador.MbdGrupoUsuariosLocal;
import jpa.valores.GrupoUsuarios;
import jpa.valores.GrupoUsuariosPK;

/**
 *
 * @author analista02
 */
public class PtdGrupoUsuarios {
    MbdGrupoUsuariosLocal mbdGrupoUsuarios = lookupMbdGrupoUsuariosLocal();

    private MbdGrupoUsuariosLocal lookupMbdGrupoUsuariosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdGrupoUsuariosLocal) c.lookup("java:comp/env/MbdGrupoUsuarios");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public GrupoUsuarios encontrar(GrupoUsuariosPK grupoUsuariosPK) {
        return mbdGrupoUsuarios.encontrar(grupoUsuariosPK);
    }

    public List<GrupoUsuarios> encontrarTodos() {
        return mbdGrupoUsuarios.encontrarTodos();
    }

    public void insertar(GrupoUsuarios grupoUsuario) throws Exception {
        mbdGrupoUsuarios.insertar(grupoUsuario);
    }

    public void actualizar(GrupoUsuarios grupoUsuario) {
        mbdGrupoUsuarios.actualizar(grupoUsuario);
    }

    public void eliminar(GrupoUsuariosPK grupoUsuariosPK) {
        mbdGrupoUsuarios.eliminar(grupoUsuariosPK);
    }
    
}
