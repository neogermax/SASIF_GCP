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
import jpa.valores.ProyActs;
import jpa.valores.ProyActsPK;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdProyActs implements MbdProyActsLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<ProyActs> encontrarTodos() {
        return em.createNamedQuery("ProyActs.findAll", ProyActs.class).getResultList();
    }

    @Override
    public ProyActs encontrar(ProyActsPK proyActsPk) {
        return em.find(ProyActs.class, proyActsPk);
    }

    @Override
    public void insertar(ProyActs proyActs) {
        em.persist(proyActs);
    }

    @Override
    public void actualizar(ProyActs proyActs) {
        em.merge(proyActs);
    }
    
    @Override
    public void actualizar(Proyectos proyecto) {
        em.createNamedQuery("ProyActs.updateProy")
                .setParameter("proyecto", proyecto).executeUpdate();
    }
    
    @Override
    public void actualizar(List<ProyActs> proyActs) {
        for(ProyActs p : proyActs) {
            em.merge(p);
        }
    }

    @Override
    public void eliminar(ProyActsPK proyActsPk) {
        ProyActs p = em.find(ProyActs.class, proyActsPk);
        em.remove(p);
    }

    @Override
    public List<ProyActs> encontrarNoTerminadas(Proyectos proyecto) {
        return em.createNamedQuery("ProyActs.findNoTerm", ProyActs.class)
                .setParameter("proyecto", proyecto)
                .getResultList();
    }
    
    @Override
    public List<ProyActs> encontrarActDisp() {
        return em.createNamedQuery("ProyActs.findActDisp3", ProyActs.class).getResultList();
    }

    @Override
    public List<ProyActs> encontrarActDisp(Proyectos proyecto) {
        return em.createNamedQuery("ProyActs.findActDisp", ProyActs.class)
                .setParameter("proyecto", proyecto).getResultList();
    }

    @Override
    public List<ProyActs> encontrarActDisp(Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("ProyActs.findActDisp2", ProyActs.class)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }

    @Override
    public Long encontrarCountAct(Proyectos proyecto, Actividades actividad) {
        return em.createNamedQuery("ProyActs.countAct", Long.class)
                .setParameter("proyecto", proyecto)
                .setParameter("act", actividad)
                .getSingleResult();
    }

    @Override
    public List<ProyActs> encontrarActsComp(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("ProyActs.findActComp", ProyActs.class)
                .setParameter("proyecto", proyecto)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }

    @Override
    public void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<ProyActs> proyActs) {
        for(Relaciones r : relaciones) {
            em.createNamedQuery("ProyActs.deleteComp", ProyActs.class)
                .setParameter("proyecto", proyecto)
                .setParameter("clase", r.getClases())
                .setParameter("etapa", r.getRelEtpCodFk())
                .setParameter("actividad", r.getRelActCodFk())
                .executeUpdate();
        }
        for(ProyActs proyAct : proyActs) {
            em.persist(proyAct);
        }
    }

    @Override
    public List<ProyActs> encontrarProyComp(Proyectos proyecto) {
        return em.createNamedQuery("ProyActs.findProyComp", ProyActs.class)
                .setParameter("proyecto", proyecto).getResultList();
    }
    
    @Override
    public List<ProyActs> encontrarProyComp(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("ProyActs.findProyComp2", ProyActs.class)
                .setParameter("proyecto", proyecto)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }

    @Override
    public List<ProyActs> encontrarCompPar() {
        return em.createNamedQuery("ProyActs.findCompPar", ProyActs.class).getResultList();
    }

    @Override
    public List<ProyActs> encontrarPorProyCod(Integer proCodFk) {
        return em.createNamedQuery("ProyActs.findProy1", ProyActs.class)
                .setParameter("proCodFk", proCodFk).getResultList();
    }

    @Override
    public List<ProyActs> encontrarPorProyDescrip(String proDescrip) {
        return em.createNamedQuery("ProyActs.findProy2", ProyActs.class)
                .setParameter("proDescrip", proDescrip).getResultList();
    }

    @Override
    public List<ProyActs> encontrarPorProyCodDes(Integer proCodFk, String proDescrip) {
        return em.createNamedQuery("ProyActs.findProy3", ProyActs.class)
                .setParameter("proCodFk", proCodFk)
                .setParameter("proDescrip", proDescrip).getResultList();
    }
    
    @Override
    public List<ProyActs> encontrarPorProy(Integer proCodFk) {
        return em.createNamedQuery("ProyActs.findByProy", ProyActs.class)
                .setParameter("proCodFk", proCodFk).getResultList();
    }

    @Override
    public List<ProyActs> encontrarPorRelacion(Integer proCodFk) {
        return em.createNamedQuery("ProyActs.findRel", ProyActs.class)
                .setParameter("proCodFk", proCodFk).getResultList();
    }
    
    @Override
    public List<ProyActs> encontrarUno(Integer proCodFk) {
        return  em.createNamedQuery("ProyActs.findone", ProyActs.class)
                .setParameter("proCodFk", proCodFk).getResultList();
    }
}
