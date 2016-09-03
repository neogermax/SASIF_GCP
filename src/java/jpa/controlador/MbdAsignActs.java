/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.AsignActs;
import jpa.valores.AsignActsPK;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Actividades;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdAsignActs implements MbdAsignActsLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<AsignActs> encontrarOpcion() {
        return em.createNamedQuery("AsignActs.findAll", AsignActs.class).getResultList();
                
    }
    
    

    @Override
    public void insertar(AsignActs asignact) throws Exception {
        AsignActs e = em.find(AsignActs.class, asignact.getAsignActsPK());
        if(e != null)
            throw new Exception();
        em.persist(asignact);
    }

    @Override
    public void actualizar(AsignActs asignacts) {
        em.merge(asignacts);
    }

    @Override
    public void eliminar(AsignActsPK asignactsPK) {
        AsignActs e = em.find(AsignActs.class, asignactsPK);
        em.remove(e);
    }

    @Override
    public List<AsignActs> encontrarAsignaciones(Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("AsignActs.findAsign", AsignActs.class)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }

    @Override
    public List<AsignActs> encontrarCronograma(Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("AsignActs.findCronog", AsignActs.class)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }
    
}
