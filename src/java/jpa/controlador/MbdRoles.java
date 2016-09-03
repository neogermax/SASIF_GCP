/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Roles;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdRoles implements MbdRolesLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public void insertar(Roles rol) throws Exception {
        Roles e = em.find(Roles.class, rol.getRolRolPk());
        if(e != null)
            throw new Exception();
        em.persist(rol);
    }

    @Override
    public void actualizar(Roles rol) {
        em.merge(rol);
    }

    @Override
    public Roles encontrar(String rolRolPk) {
        return em.find(Roles.class, rolRolPk);
    }

    @Override
    public List<Roles> encontrarTodos() {
        return em.createNamedQuery("Roles.findAll", Roles.class)
                .getResultList();
    }

    @Override
    public void eliminar(String rolRolPk) {
        Roles e = em.find(Roles.class, rolRolPk);
        em.remove(e);
    }
    
}
