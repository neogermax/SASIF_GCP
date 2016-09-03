/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.ProyItems;
import jpa.valores.ProyItemsPK;
import jpa.valores.Proyectos;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdProyItems implements MbdProyItemsLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
    
    @Override
    public ProyItems encontrar(ProyItemsPK proyItemsPK) {
        return em.find(ProyItems.class, proyItemsPK);
    }

    @Override
    public void actualizar(ProyItems proyItems) {
        ProyItems p = em.find(ProyItems.class, proyItems.getProyItemsPK());
        if(p == null) {
            em.persist(proyItems);
        } else {
            em.merge(proyItems);
        }
    }

    @Override
    public void eliminar(ProyItemsPK proyItemsPK) {
        ProyItems p = em.find(ProyItems.class, proyItemsPK);
        em.remove(p);
    }

    @Override
    public void actualizar(List<ProyItems> proyItems) {
        for(ProyItems proyItem : proyItems) {
            actualizar(proyItem);
        }
    }
    
    @Override
    public List<ProyItems> encontrarPorActItems(Integer act, Proyectos proy) {
        return (List<ProyItems>) em.createNamedQuery("ProyItems.actItems", ProyItems.class)
                .setParameter("proy", proy)
                .setParameter("act", act).getResultList();
    }
    
}
