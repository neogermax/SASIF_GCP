/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Constantes;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdConstantes implements MbdConstantesLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Constantes> encontrarTodos() {
        return em.createNamedQuery("Constantes.findAll", Constantes.class).getResultList();
    }

    @Override
    public Constantes encontrar(Integer consCodPk) {
        return em.find(Constantes.class, consCodPk);
    }

    @Override
    public void actualizar(Constantes constantes) {
        em.merge(constantes);
    }

    @Override
    public void insertar(Constantes constantes) throws Exception {
        Constantes a = em.find(Constantes.class, constantes.getConsCodPk());
        if(a != null)
            throw new Exception();
        em.persist(constantes);
    }

    @Override
    public void eliminar(Integer consCodPk) {
        Constantes a = em.find(Constantes.class, consCodPk);
        em.remove(a);
    }

}
