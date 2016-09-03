/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Numericas;
import jpa.valores.NumericasPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdNumericas implements MbdNumericasLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Numericas> encontrarTodos() {
        return em.createNamedQuery("Numericas.findAll", Numericas.class).getResultList();
    }

    @Override
    public List<Numericas> encontrarPorCodigo(Integer numCodPk) {
        return em.createNamedQuery("Numericas.findByCode", Numericas.class)
                .setParameter("numCodPk", numCodPk).getResultList();
    }

    @Override
    public void insertar(Numericas numericas) throws Exception {
        Numericas n = em.find(Numericas.class, numericas.getNumericasPK());
        if(n != null)
            throw new Exception();
        em.persist(numericas);
    }

    @Override
    public void actualizar(Numericas numericas) {
        em.merge(numericas);
    }

    @Override
    public void eliminar(NumericasPK numericasPK) {
        Numericas n = em.find(Numericas.class, numericasPK);
        em.remove(n);
    }

    @Override
    public Numericas encontrar(NumericasPK numericasPk) {
        return em.find(Numericas.class, numericasPk);
    }

    @Override
    public List<Integer> encontrarCodigos() {
        return em.createNamedQuery("Numericas.findCodes", Integer.class).getResultList();
    }

}
