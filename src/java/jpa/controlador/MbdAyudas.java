/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Ayudas;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdAyudas implements MbdAyudasLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Ayudas> encontrarTodos() {
        return em.createNamedQuery("Ayudas.findAll", Ayudas.class).getResultList();
    }

    @Override
    public Ayudas encontrar(Integer aydCodPk) {
        return em.find(Ayudas.class, aydCodPk);
    }

    @Override
    public void actualizar(Ayudas ayudas) {
        em.merge(ayudas);
    }

    @Override
    public void insertar(Ayudas ayudas) throws Exception {
        Ayudas a = em.find(Ayudas.class, ayudas.getAydCodPk());
        if(a != null)
            throw new Exception();
        em.persist(ayudas);
    }

    @Override
    public void eliminar(Integer aydCodPk) {
        Ayudas a = em.find(Ayudas.class, aydCodPk);
        em.remove(a);
    }

}
