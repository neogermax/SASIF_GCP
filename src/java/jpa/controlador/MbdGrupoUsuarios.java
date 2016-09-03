/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.GrupoUsuarios;
import jpa.valores.GrupoUsuariosPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdGrupoUsuarios implements MbdGrupoUsuariosLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public GrupoUsuarios encontrar(GrupoUsuariosPK grupoUsuariosPK) {
        return em.find(GrupoUsuarios.class, grupoUsuariosPK);
    }

    @Override
    public List<GrupoUsuarios> encontrarTodos() {
        return em.createNamedQuery("GrupoUsuarios.findAll", GrupoUsuarios.class).getResultList();
    }

    @Override
    public void insertar(GrupoUsuarios grupoUsuario) throws Exception {
        GrupoUsuarios gu = em.find(GrupoUsuarios.class, grupoUsuario.getGrupoUsuariosPK());
        if(gu != null)
            throw new Exception();
        em.persist(grupoUsuario);
    }

    @Override
    public void actualizar(GrupoUsuarios grupoUsuario) {
        em.persist(grupoUsuario);
    }

    @Override
    public void eliminar(GrupoUsuariosPK grupoUsuariosPK) {
        GrupoUsuarios gu = em.find(GrupoUsuarios.class, grupoUsuariosPK);
        em.remove(gu);
    }

}
