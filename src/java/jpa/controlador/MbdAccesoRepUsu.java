/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.AccesoRepUsu;
import jpa.valores.AccesoRepUsuPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdAccesoRepUsu implements MbdAccesoRepUsuLocal {
    @PersistenceContext(unitName = "CGPLUISPU3")
    private EntityManager em;

    @Override
    public List<AccesoRepUsu> encontrarTodos() {
        return em.createNamedQuery("AccesoRepUsu.findAll", AccesoRepUsu.class).getResultList();
    }

    @Override
    public void insertar(AccesoRepUsu accesoRepUsu) throws Exception {
        AccesoRepUsu a = em.find(AccesoRepUsu.class, accesoRepUsu.getAccesoRepUsuPK());
        if(a != null)
            throw new Exception();
        em.persist(accesoRepUsu);
    }

    @Override
    public void actualizar(AccesoRepUsu accesoRepUsu) {
        em.merge(accesoRepUsu);
    }

    @Override
    public void eliminar(AccesoRepUsuPK accesoRepUsuPk) {
        AccesoRepUsu a = em.find(AccesoRepUsu.class, accesoRepUsuPk);
        em.remove(a);
    }

    @Override
    public List<AccesoRepUsu> encontrarPorUsuario(String usuario) {
        return em.createNamedQuery("AccesoRepUsu.findByUser", AccesoRepUsu.class)
                .setParameter("usucod", usuario).getResultList();
    }
    
}
