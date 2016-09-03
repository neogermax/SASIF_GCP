/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.GrupoReportes;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdGrupoReportes implements MbdGrupoReportesLocal {
    @PersistenceContext(unitName = "CGPLUISPU3")
    private EntityManager em;

    @Override
    public List<GrupoReportes> encontrarTodos() {
        return em.createNamedQuery("GrupoReportes.findAll", GrupoReportes.class).getResultList();
    }

    @Override
    public GrupoReportes encontrar(Integer grpCodPk) {
        return em.find(GrupoReportes.class, grpCodPk);
    }

    @Override
    public void actualizar(GrupoReportes grupoReportes) {
        em.merge(grupoReportes);
    }

    @Override
    public void insertar(GrupoReportes grupoReportes) throws Exception {
        GrupoReportes a = em.find(GrupoReportes.class, grupoReportes.getGrpCodPk());
        if(a != null)
            throw new Exception();
        em.persist(grupoReportes);
    }

    @Override
    public void eliminar(Integer grpCodPk) {
        GrupoReportes a = em.find(GrupoReportes.class, grpCodPk);
        em.remove(a);
    }

}
