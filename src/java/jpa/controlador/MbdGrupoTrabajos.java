/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.GrupoTrabajos;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdGrupoTrabajos implements MbdGrupoTrabajosLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public GrupoTrabajos encontrar(Integer grpCodPk) {
        return em.find(GrupoTrabajos.class, grpCodPk);
    }

    @Override
    public List<GrupoTrabajos> encontrarTodos() {
        return em.createNamedQuery("GrupoTrabajos.findAll", GrupoTrabajos.class).getResultList();
    }

    @Override
    public void insertar(GrupoTrabajos grupoTrabajo) throws Exception {
        GrupoTrabajos gt = em.find(GrupoTrabajos.class, grupoTrabajo.getGrpCodPk());
        if(gt != null)
            throw new Exception();
        em.persist(grupoTrabajo);
    }

    @Override
    public void actualizar(GrupoTrabajos grupoTrabajo) {
        em.merge(grupoTrabajo);
    }

    @Override
    public void eliminar(Integer grpCodPk) {
        GrupoTrabajos gt = em.find(GrupoTrabajos.class, grpCodPk);
        em.remove(gt);
    }
}
