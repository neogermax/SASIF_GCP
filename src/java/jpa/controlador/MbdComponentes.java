/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Componentes;
import jpa.valores.ComponentesPK;
import jpa.valores.Proyectos;

/**
 *
 * @author Analista02
 */
@Stateless
public class MbdComponentes implements MbdComponentesLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
    
    @Override
    public Componentes encontrar(ComponentesPK componentesPK) {
        return em.find(Componentes.class, componentesPK);
    }

    @Override
    public List<Componentes> encontrarTodos() {
        return em.createNamedQuery("Componentes.findAll").getResultList();
    }

    @Override
    public void insertar(Componentes componentes) throws Exception {
        Componentes c = em.find(Componentes.class, componentes.getComponentesPK());
        if(c != null)
            throw new Exception();
        em.persist(componentes);
    }

    @Override
    public void actualizar(Componentes componentes) {
        em.merge(componentes);
    }

    @Override
    public void eliminar(ComponentesPK componentesPK) {
        Componentes c = em.find(Componentes.class, componentesPK);
        em.remove(c);
    }

    @Override
    public List<Componentes> encontrarPorProyecto(Proyectos proyecto) {
        return em.createNamedQuery("Componentes.findByProy")
                .setParameter("proyecto", proyecto).getResultList();
    }

    @Override
    public void insertar(List<Componentes> componentes) {
        for(Componentes componente : componentes) {
            Componentes c = em.find(Componentes.class, componente.getComponentesPK());
            if(c == null) {
                em.persist(componente);
            }
        }
    }

}
