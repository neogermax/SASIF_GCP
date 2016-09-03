/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Contactos;
import jpa.valores.ContactosPK;
import jpa.valores.EmpleadosPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdContactos implements MbdContactosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Contactos> encontrarTodos() {
        return em.createNamedQuery("Contactos.findAll", Contactos.class)
                .getResultList();
    }

    @Override
    public void insertar(Contactos contacto) throws Exception {
        Contactos e = em.find(Contactos.class, contacto.getContactosPK());
        if(e != null)
            throw new Exception();
        em.persist(contacto);
    }

    @Override
    public void actualizar(Contactos contacto) {
        em.merge(contacto);
    }

    @Override
    public void eliminar(ContactosPK contactosPk) {
        Contactos e = em.find(Contactos.class, contactosPk );
        em.remove(e);
    }
    
    @Override
    public List<Contactos> encontrarUno(EmpleadosPK empleadosPK) {
        return em.createNamedQuery("Contactos.findByEmpleadoPK", Contactos.class)
                .setParameter("empleadoId", empleadosPK.getEmplId())
                .setParameter("empleadoTipoId", empleadosPK.getEmplTipoId()).getResultList();
    }
}
