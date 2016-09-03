/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Errores;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdErrores implements MbdErroresLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Errores> encontrarTodos() {
        return em.createNamedQuery("Errores.findAll", Errores.class).getResultList();
    }

    @Override
    public Errores encontrar(Integer errCodPk) {
        return em.find(Errores.class, errCodPk);
    }

    @Override
    public void insertar(Errores errores) throws Exception {
        Errores e = em.find(Errores.class, errores.getErrCodPk());
        if(e != null)
            throw new Exception();
        em.persist(errores);
    }

    @Override
    public void actualizar(Errores errores) {
        em.merge(errores);
    }

    @Override
    public void eliminar(Integer errCodPk) {
        Errores e = em.find(Errores.class, errCodPk);
        em.remove(e);
    }
    
}
