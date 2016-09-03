/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Etapas;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdEtapas implements MbdEtapasLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Etapas> encontrarTodos() {
        return em.createNamedQuery("Etapas.findAll", Etapas.class).getResultList();
    }

    @Override
    public Etapas encontrar(Integer etpCodPk) {
        return em.find(Etapas.class, etpCodPk);
    }

    @Override
    public void actualizar(Etapas etapas) {
        em.merge(etapas);
    }

    @Override
    public void insertar(Etapas etapas) throws Exception {
        Etapas a = em.find(Etapas.class, etapas.getEtpCodPk());
        if(a != null)
            throw new Exception();
        em.persist(etapas);
    }

    @Override
    public void eliminar(Integer etpCodPk) {
        Etapas a = em.find(Etapas.class, etpCodPk);
        em.remove(a);
    }

}
