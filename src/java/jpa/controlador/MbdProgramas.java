/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Programas;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdProgramas implements MbdProgramasLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Programas> encontrarTodos() {
        return em.createNamedQuery("Programas.findAll", Programas.class).getResultList();
    }

    @Override
    public Programas encontrar(String progNomPk) {
        return em.find(Programas.class, progNomPk);
    }

    @Override
    public void actualizar(Programas programas) {
        em.merge(programas);
    }

    @Override
    public void insertar(Programas programas) throws Exception {
        Programas a = em.find(Programas.class, programas.getProgNomPk());
        if(a != null)
            throw new Exception();
        em.persist(programas);
    }

    @Override
    public void eliminar(String progNomPk) {
        Programas a = em.find(Programas.class, progNomPk);
        em.remove(a);
    }

}
