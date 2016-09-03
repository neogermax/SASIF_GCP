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
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;
import jpa.valores.Responsables;
import jpa.valores.ResponsablesPK;

/**
 *
 * @author Analista02
 */
@Stateless
public class MbdResponsables implements MbdResponsablesLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
    
    @Override
    public List<Responsables> encontrarTodos() {
        return em.createNamedQuery("Responsables.findAll", Responsables.class).getResultList();
    }

    @Override
    public void insertar(Responsables responsables) throws Exception {
        Responsables r = em.find(Responsables.class, responsables.getResponsablesPK());
        if(r != null)
            throw new Exception();
        em.persist(responsables);
    }

    @Override
    public void actualizar(Responsables responsables) {
        em.merge(responsables);
    }
    
    @Override
    public void actualizar(Proyectos proyecto) {
        em.createNamedQuery("Responsables.updateActivos")
                .setParameter("proyecto", proyecto).executeUpdate();
    }
    
    @Override
    public void actualizar(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad, String comp, Integer tipComp) {
        em.createNamedQuery("Responsables.updateActivos2")
                    .setParameter("proyecto", proyecto)
                    .setParameter("clase", clase)
                    .setParameter("etapa", etapa)
                    .setParameter("actividad", actividad)
                    .setParameter("comp", comp)
                    .setParameter("tipComp", tipComp).executeUpdate();
    }

    @Override
    public void eliminar(ResponsablesPK responsablesPk) {
        Responsables r = em.find(Responsables.class, responsablesPk);
        em.remove(r);
    }

    @Override
    public void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<Responsables> responsables) {
        for(Relaciones r : relaciones) {
            em.createNamedQuery("Responsables.deleteByAct", Responsables.class)
                    .setParameter("proyecto", proyecto)
                    .setParameter("clase", r.getClases())
                    .setParameter("etapa", r.getRelEtpCodFk())
                    .setParameter("actividad", r.getRelActCodFk()).executeUpdate();
        }
        for(Responsables r : responsables) {
            em.persist(r);
        }
    }

    @Override
    public List<Responsables> encontrarPorClase(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("Responsables.findByCls", Responsables.class)
                .setParameter("proyecto", proyecto)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }

    @Override
    public Responsables encontrar(ResponsablesPK responsablesPk) {
        return em.find(Responsables.class, responsablesPk);
    }

    @Override
    public Long encontrarCantidadAutoriz(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("Responsables.findCountAut", Long.class)
                .setParameter("proyecto", proyecto)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getSingleResult();
    }

    @Override
    public Long encontrarCantidadNoAutoriz(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("Responsables.findCountNoAut", Long.class)
                .setParameter("proyecto", proyecto)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getSingleResult();
    }

    @Override
    public List<Responsables> encontrarActivos() {
        return em.createNamedQuery("Responsables.findActivos", Responsables.class).getResultList();
    }
    
    @Override
    public List<Responsables> encontrarActivos(Proyectos proyecto) {
        return em.createNamedQuery("Responsables.findActivos2", Responsables.class)
                .setParameter("proyecto", proyecto).getResultList();
    }

}
