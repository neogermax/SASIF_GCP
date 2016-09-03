/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Areas;
import jpa.valores.AreasPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdAreas implements MbdAreasLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Areas> encontrarTodos() {
        return em.createNamedQuery("Areas.findAll", Areas.class).getResultList();
    }

    @Override
    public void insertar(Areas areas) throws Exception {
        Areas a = em.find(Areas.class, areas.getAreasPK());
        if(a != null)
            throw new Exception();
        em.persist(areas);
    }

    @Override
    public void actualizar(Areas areas) {
        em.merge(areas);
    }

    @Override
    public void eliminar(AreasPK areasPk) {
        Areas a = em.find(Areas.class, areasPk);
        em.remove(a);
    }
    
}
