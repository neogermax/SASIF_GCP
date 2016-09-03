/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.OpcionRoles;
import jpa.valores.OpcionRolesPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdOpcionRoles implements MbdOpcionRolesLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<OpcionRoles> encontrarOpcion() {
        return em.createNamedQuery("OpcionRoles.findAll", OpcionRoles.class)
                .getResultList();
    }

    @Override
    public void insertar(OpcionRoles opcionroles) throws Exception {
        OpcionRoles e = em.find(OpcionRoles.class, opcionroles.getOpcionRolesPK());
        if(e != null)
            throw new Exception();
        em.persist(opcionroles);
    }

    @Override
    public void actualizar(OpcionRoles opcionroles) {
        em.merge(opcionroles);
    }

    @Override
    public void eliminar(OpcionRolesPK opcionRolesPK) {
        OpcionRoles e = em.find(OpcionRoles.class, opcionRolesPK);
        em.remove(e);
    }
    
}
