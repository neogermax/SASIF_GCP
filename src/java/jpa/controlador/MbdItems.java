/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Items;

/**
 *
 * @author Analista02
 */
@Stateless
public class MbdItems implements MbdItemsLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Items> encontrarTodos() {
        return em.createNamedQuery("Items.findAll", Items.class).getResultList();
    }

    @Override
    public Items encontrar(Integer itmCodPk) {
        return em.find(Items.class, itmCodPk);
    }

    @Override
    public void insertar(Items item) throws Exception {
        Items i = em.find(Items.class, item.getItmCodPk());
        if(i != null)
            throw new Exception();
        em.persist(item);
    }

    @Override
    public void actualizar(Items item) {
        em.merge(item);
    }

    @Override
    public void eliminar(Integer itmCodPk) {
        Items i = em.find(Items.class, itmCodPk);
        em.remove(i);
    }

}
