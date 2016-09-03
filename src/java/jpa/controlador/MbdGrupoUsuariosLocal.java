/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.GrupoUsuarios;
import jpa.valores.GrupoUsuariosPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdGrupoUsuariosLocal {

    GrupoUsuarios encontrar(GrupoUsuariosPK grupoUsuariosPK);

    List<GrupoUsuarios> encontrarTodos();

    void insertar(GrupoUsuarios grupoUsuario) throws Exception;

    void actualizar(GrupoUsuarios grupoUsuario);

    void eliminar(GrupoUsuariosPK grupoUsuariosPK);
    
}
