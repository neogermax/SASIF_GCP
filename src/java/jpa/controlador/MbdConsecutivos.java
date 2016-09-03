/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Consecutivos;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdConsecutivos implements MbdConsecutivosLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public Consecutivos encontrar(Integer consecCodPk) {
        return em.find(Consecutivos.class, consecCodPk);
    }

    @Override
    public List<Consecutivos> encontrarTodos() {
        return em.createNamedQuery("Consecutivos.findAll", Consecutivos.class).getResultList();
    }

    @Override
    public void insertar(Consecutivos consecutivos) throws Exception {
        Consecutivos c = em.find(Consecutivos.class, consecutivos.getConsecCodPk());
        if(c != null)
            throw new Exception();
        em.persist(consecutivos);
    }

    @Override
    public void actualizar(Consecutivos consecutivos) {
        em.merge(consecutivos);
    }

    @Override
    public void eliminar(Integer consecCodPk) {
        Consecutivos c = em.find(Consecutivos.class, consecCodPk);
        em.remove(c);
    }

}