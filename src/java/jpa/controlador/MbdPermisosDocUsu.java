/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.PermisosDocUsu;
import jpa.valores.PermisosDocUsuPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdPermisosDocUsu implements MbdPermisosDocUsuLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<PermisosDocUsu> encontrarTodos() {
        return em.createNamedQuery("PermisosDocUsu.findAll", PermisosDocUsu.class).getResultList();
    }

    @Override
    public void insertar(PermisosDocUsu permisosDocUsu) throws Exception {
        PermisosDocUsu a = em.find(PermisosDocUsu.class, permisosDocUsu.getPermisosDocUsuPK());
        if(a != null)
            throw new Exception();
        em.persist(permisosDocUsu);
    }

    @Override
    public void actualizar(PermisosDocUsu permisosDocUsu) {
        em.merge(permisosDocUsu);
    }

    @Override
    public void eliminar(PermisosDocUsuPK permisosDocUsuPk) {
        PermisosDocUsu a = em.find(PermisosDocUsu.class, permisosDocUsuPk);
        em.remove(a);
    }
    
}
