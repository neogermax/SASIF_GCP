/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Actividades;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdActividades implements MbdActividadesLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public Actividades encontrar(Integer actCodPk) {
        return em.find(Actividades.class, actCodPk);
    }

    @Override
    public List<Actividades> encontrarTodos() {
        return em.createNamedQuery("Actividades.findAll", Actividades.class).getResultList();
    }

    @Override
    public void insertar(Actividades actividades) throws Exception {
        Actividades a = em.find(Actividades.class, actividades.getActCodPk());
        if(a != null)
            throw new Exception();
        em.persist(actividades);
    }

    @Override
    public void actualizar(Actividades actividades) {
        em.merge(actividades);
    }

    @Override
    public void eliminar(Integer actCodPk) {
        Actividades a = em.find(Actividades.class, actCodPk);
        em.remove(a);
    }

    @Override
    public void actualizar() {
        em.getEntityManagerFactory().getCache().evictAll();
    }
}
