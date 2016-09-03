/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.CronoProye;
import jpa.valores.CronoProyePK;
import jpa.valores.Etapas;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;


/**
 *
 * @author Analista02
 */
@Stateless
public class MbdCronoProye implements MbdCronoProyeLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
    
    @Override
    public List<CronoProye> encontrarTodos() {
        return em.createNamedQuery("CronoProye.findAll", CronoProye.class).getResultList();
    }

    @Override
    public CronoProye encontrar(CronoProyePK cronoProyePK) {
        return em.find(CronoProye.class, cronoProyePK);
    }
    
    @Override
    public List<CronoProye> encontrarProy(Integer CronoProyPK) {
       return em.createNamedQuery("CronoProye.findByFil", CronoProye.class)
                .setParameter("proyectosPK", CronoProyPK).getResultList();
    }
    
    @Override
    public List<CronoProye> encontrarProyecto(Integer CronoProyPK) {
       return em.createNamedQuery("CronoProye.findByProy", CronoProye.class)
                .setParameter("proyectoPK", CronoProyPK).getResultList();
    }
    
    @Override
    public List<CronoProye> encontrarProyCron(Integer CronoProyPK) {
       return em.createNamedQuery("CronoProye.findByProyCron", CronoProye.class)
                .setParameter("proyectoPK", CronoProyPK).getResultList();
    }
    
    @Override
    public List<CronoProyePK> encontrarProyect(Integer CronoProyPK) {
       return em.createNamedQuery("CronoProyePK.findByProy", CronoProyePK.class)
                .setParameter("proyectoPK", CronoProyPK).getResultList();
    }

    @Override
    public void insertar(CronoProye cronoProy) throws Exception {
        CronoProye gd = em.find(CronoProye.class, cronoProy.getCronoProyePK());
        if(gd != null)
            throw new Exception();
        em.persist(cronoProy);
    }

    @Override
    public void actualizar(CronoProye cronoProy) {
        em.merge(cronoProy);
    }

    @Override
   public void eliminar(CronoProyePK cronoProyePK) {
        CronoProye e = em.find(CronoProye.class, cronoProyePK);
        em.remove(e);
    }
    
     @Override
    public void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<CronoProye> cronoProye) {
        for(Relaciones r : relaciones) {
            em.createNamedQuery("CronoProye.deleteByAct", CronoProye.class)
                    .setParameter("proyecto", proyecto)
                    .setParameter("clase", r.getClases())
                    .setParameter("etapa", r.getRelEtpCodFk())
                    .setParameter("actividad", r.getRelActCodFk()).executeUpdate();
        }
        for(CronoProye r : cronoProye) {
            
            em.persist(r);
        }
    }
     
    @Override
    public List<CronoProye> encontrarPorClase(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("CronoProye.findByCls", CronoProye.class)
                .setParameter("proyecto", proyecto)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }
    
    @Override
    public List<CronoProye> encontrarDisp() {
        return em.createNamedQuery("CronoProye.findByDisp", CronoProye.class).getResultList();
    }
    
    @Override
    public List<Object[]> fechMinMax(Integer proyecto) {
        return em.createNamedQuery("CronoProye.findFecMinMax", Object[].class)
                .setParameter("proyecto", proyecto).getResultList();
    }
    
    @Override
    public List<Object[]> fechMinMax() {
        return em.createNamedQuery("CronoProye.findFecMinMax2", Object[].class).getResultList();
    }
    
    @Override
    public List<CronoProye> encontrarProyecto(Object[] parametros) {
        StringBuilder query = new StringBuilder("SELECT c FROM CronoProye c");
        /*if(parametros != null || parametros.length != 0) {
            query.append(" WHERE ");
            if(parametros[0] != null) {
                query.append("c.proyectos.proEstado := estado");
            }
        }*/
        
        Query q = em.createQuery(query.toString(), CronoProye.class);
        /*if(parametros != null || parametros.length != 0) {
            if(parametros[0] != null) {
                q.setParameter("estado", (String)parametros[0]);
            }
        }*/
        return q.getResultList();
    }
}
