/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Alfanumericas;
import jpa.valores.AlfanumericasPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdAlfanumericas implements MbdAlfanumericasLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
    
    @Override
    public List<Alfanumericas> encontrarTodos() {
        return em.createNamedQuery("Alfanumericas.findAll").getResultList();
    }

    @Override
    public List<Alfanumericas> encontrarPorCodigo(Integer alfCodPk) {
        return em.createNamedQuery("Alfanumericas.findByCode")
                .setParameter("alfCodPk", alfCodPk).getResultList();
    }

    @Override
    public void insetar(Alfanumericas alfanumericas) throws Exception {
        Alfanumericas a = em.find(Alfanumericas.class, alfanumericas.getAlfanumericasPK());
        if(a != null)
            throw new Exception();
        em.persist(alfanumericas);
    }

    @Override
    public void actualizar(Alfanumericas alfanumericas) {
        em.merge(alfanumericas);
    }

    @Override
    public void eliminar(AlfanumericasPK alfanumericasPK) {
        Alfanumericas a = em.find(Alfanumericas.class, alfanumericasPK);
        em.remove(a);
    }

    @Override
        public Alfanumericas encontrar(AlfanumericasPK alfanumericasPk) {
        return em.find(Alfanumericas.class, alfanumericasPk);
    }

    @Override
    public List<Integer> encontrarCodigos() {
        return em.createNamedQuery("Alfanumericas.findCodes", Integer.class).getResultList();
    }
    
}
