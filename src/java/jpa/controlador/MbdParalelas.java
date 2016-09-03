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
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Paralelas;
import jpa.valores.ParalelasPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdParalelas implements MbdParalelasLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
    
    @Override
    public List<Paralelas> encontrarTodos() {
        return em.createNamedQuery("Paralelas.findAll").getResultList();
    }

    @Override
    public List<Paralelas> encontrarPorCodigo(Integer parClsCodFk) {
        return em.createNamedQuery("Paralelas.findByCode")
                .setParameter("parClsCodFk", parClsCodFk).getResultList();
    }

    @Override
    public void insetar(Paralelas paralelas) throws Exception {
        Paralelas a = em.find(Paralelas.class, paralelas.getParalelasPK());
        if(a != null)
            throw new Exception();
        em.persist(paralelas);
    }

    @Override
    public void actualizar(Paralelas paralelas) {
        em.merge(paralelas);
    }

    @Override
    public void eliminar(ParalelasPK paralelasPK) {
        Paralelas a = em.find(Paralelas.class, paralelasPK);
        em.remove(a);
    }

    @Override
        public Paralelas encontrar(ParalelasPK paralelasPk) {
        return em.find(Paralelas.class, paralelasPk);
    }

    @Override
    public void insertar(List<Paralelas> paralelas) {
        em.createNamedQuery("Paralelas.deleteAll", Paralelas.class).executeUpdate();
        for(Paralelas p : paralelas) {
            em.persist(p);
        }
    }

    @Override
    public List<Paralelas> encontrar(Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("Paralelas.findByCls", Paralelas.class)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }
    
}
