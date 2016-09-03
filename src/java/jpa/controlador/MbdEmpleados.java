/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Empleados;
import jpa.valores.EmpleadosPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdEmpleados implements MbdEmpleadosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public void insertar(Empleados empleado) throws Exception {
        Empleados e = em.find(Empleados.class, empleado.getEmpleadosPK());
        if(e != null)
            throw new Exception();
        em.persist(empleado);
    }

    @Override
    public void actualizar(Empleados empleado) {
        em.merge(empleado);
    }

    @Override
    public Empleados encontrar(EmpleadosPK empleadosPK) {
        return em.find(Empleados.class, empleadosPK);
    }

    @Override
    public List<Empleados> encontrarTodos() {
        return em.createNamedQuery("Empleados.findAll", Empleados.class)
                .getResultList();
    }
    
    @Override
    public List<Empleados> encontrarNoUsuarios() {
        return em.createNamedQuery("Empleados.findNoUsuarios", Empleados.class)
                .getResultList();
    }

    @Override
    public void eliminar(EmpleadosPK empleadosPK) {
        Empleados e = em.find(Empleados.class, empleadosPK);
        em.remove(e);
    }
    
}
