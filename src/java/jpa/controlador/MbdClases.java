/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Clases;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdClases implements MbdClasesLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public Clases encontrar(Integer clsCodPk) {
        return em.find(Clases.class, clsCodPk);
    }

    @Override
    public List<Clases> encontrarTodos() {
        return em.createNamedQuery("Clases.findAll", Clases.class).getResultList();
    }

    @Override
    public void insertar(Clases clases) throws Exception {
        Clases c = em.find(Clases.class, clases.getClsCodPk());
        if(c != null)
            throw new Exception();
        em.persist(clases);
    }

    @Override
    public void actualizar(Clases clases) {
        em.merge(clases);
    }

    @Override
    public void eliminar(Integer clsCodPk) {
        Clases c = em.find(Clases.class, clsCodPk);
        em.remove(c);
    }

    @Override
    public void actualizar(List<Clases> clases) {
        for(Clases c : clases) {
            em.merge(c);
        }
    }

}
