/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Rutas;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdRutas implements MbdRutasLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Rutas> encontrarTodos() {
        return em.createNamedQuery("Rutas.findAll", Rutas.class).getResultList();
    }

    @Override
    public Rutas encontrar(Integer rutCodigoPk) {
        return em.find(Rutas.class, rutCodigoPk);
    }

    @Override
    public void actualizar(Rutas rutas) {
        em.merge(rutas);
    }

    @Override
    public void insertar(Rutas rutas) throws Exception {
        Rutas a = em.find(Rutas.class, rutas.getRutCodigoPk());
        if(a != null)
            throw new Exception();
        em.persist(rutas);
    }

    @Override
    public void eliminar(Integer rutCodigoPk) {
        Rutas a = em.find(Rutas.class, rutCodigoPk);
        em.remove(a);
    }

}
