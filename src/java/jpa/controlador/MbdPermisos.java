/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Permisos;
import jpa.valores.PermisosPK;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Actividades;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdPermisos implements MbdPermisosLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<Permisos> encontrarOpcion() {
        return em.createNamedQuery("Permisos.findAll", Permisos.class).getResultList();
                
    }
    
    

    @Override
    public void insertar(Permisos permiso) throws Exception {
        Permisos e = em.find(Permisos.class, permiso.getPermisosPK());
        if(e != null)
            throw new Exception();
        em.persist(permiso);
    }

    @Override
    public void actualizar(Permisos permisos) {
        em.merge(permisos);
    }

    @Override
    public void eliminar(PermisosPK permisosPK) {
        Permisos e = em.find(Permisos.class, permisosPK);
        em.remove(e);
    }

    @Override
    public List<Permisos> encontrarPorActividad(Clases clase, Etapas etapa, Actividades actividad) {
        return em.createNamedQuery("Permisos.findByAct", Permisos.class)
                .setParameter("clase", clase)
                .setParameter("etapa", etapa)
                .setParameter("actividad", actividad).getResultList();
    }

    @Override
    public Permisos encontrar(PermisosPK permisosPK) {
        return em.find(Permisos.class, permisosPK);
    }
    
}
