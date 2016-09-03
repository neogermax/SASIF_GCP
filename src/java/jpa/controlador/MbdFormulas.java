/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Formulas;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdFormulas implements MbdFormulasLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Formulas> encontrarTodos() {
        return em.createNamedQuery("Formulas.findAll", Formulas.class).getResultList();
    }

    @Override
    public Formulas encontrar(Integer forCodPk) {
        return em.find(Formulas.class, forCodPk);
    }

    @Override
    public void actualizar(Formulas formulas) {
        em.merge(formulas);
    }

    @Override
    public void insertar(Formulas formulas) throws Exception {
        Formulas a = em.find(Formulas.class, formulas.getForCodPk());
        if(a != null)
            throw new Exception();
        em.persist(formulas);
    }

    @Override
    public void eliminar(Integer forCodPk) {
        Formulas a = em.find(Formulas.class, forCodPk);
        em.remove(a);
    }

}
