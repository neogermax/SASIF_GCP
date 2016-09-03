/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Clases;
import jpa.valores.Relaciones;
import jpa.valores.RelacionesPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdRelaciones implements MbdRelacionesLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Relaciones> encontrarTodos() {
        return em.createNamedQuery("Relaciones.findAll", Relaciones.class).getResultList();
    }

    @Override
    public List<Relaciones> encontrarPorClase(Clases clases) {
        return em.createNamedQuery("Relaciones.findByClass", Relaciones.class)
                .setParameter("clases", clases).getResultList();
    }

    @Override
    public void insertar(Relaciones relaciones) throws Exception {
        Relaciones r = em.find(Relaciones.class, relaciones.getRelacionesPK());
        if(r != null)
            throw new Exception();
        em.persist(relaciones);
    }

    @Override
    public void actualizar(Relaciones relaciones) {
        em.merge(relaciones);
    }

    @Override
    public void eliminar(RelacionesPK relacionesPk) {
        Relaciones r = em.find(Relaciones.class, relacionesPk);
        em.remove(r);
    }

    @Override
    public void insertar(List<Relaciones> relaciones) {
        em.createNamedQuery("Relaciones.deleteAll", Relaciones.class).executeUpdate();
        for(Relaciones r : relaciones) {
            em.persist(r);
        }
    }

}
