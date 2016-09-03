/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.ActItems;
import jpa.valores.ActItemsPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdActItems implements MbdActItemsLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
    
    @Override
    public ActItems encontrar(ActItemsPK actItemsPK) {
        return em.find(ActItems.class, actItemsPK);
    }

    @Override
    public List<ActItems> encontrarTodos() {
        return em.createNamedQuery("ActItems.findAll", ActItems.class).getResultList();
    }

    @Override
    public void insertar(ActItems actItem) throws Exception {
        ActItems a = em.find(ActItems.class, actItem.getActItemsPK());
        if(a != null)
            throw new Exception();
        em.persist(actItem);
    }

    @Override
    public void actualizar(ActItems actItem) {
        em.merge(actItem);
    }

    @Override
    public void eliminar(ActItemsPK actItemsPK) {
        ActItems a = em.find(ActItems.class, actItemsPK);
        em.remove(a);
    }

    @Override
    public void insertar(List<ActItems> actItems) {
        em.createNamedQuery("ActItems.deleteAll", ActItems.class).executeUpdate();
        for(ActItems a : actItems) {
            em.persist(a);
        }
    }

}
