/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.valores.Parametrias;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdParametrias implements MbdParametriasLocal {
    @PersistenceContext(unitName = "CGPLUISPU3")
    private EntityManager em;

    private String query(String inicial, List<Integer> reportes, List<Integer> grupos) {
        StringBuilder q = new StringBuilder(inicial);
        for(int i=0; i<reportes.size(); i++) {
            q.append("p.parCodRepPk = :rep").append(i);
            if(i<reportes.size()-1) {
                q.append(" OR ");
            }
        }
        if(!(reportes.isEmpty() && grupos.isEmpty())) {
            q.append(" OR ");
        }
        for(int i=0; i<grupos.size(); i++) {
            q.append("p.parCodGrpRepFk = :grp").append(i);
            if(i<grupos.size()-1) {
                q.append(" OR ");
            }
        }
        q.append(" ORDER BY p.parCodRepPk");
        return q.toString();
    }
    
    @Override
    public List<Parametrias> encontrarTodos() {
        return em.createNamedQuery("Parametrias.findAll", Parametrias.class).getResultList();
    }
    
    @Override
    public List<Parametrias> encontrarSint() {
        return em.createNamedQuery("Parametrias.findBySint", Parametrias.class).getResultList();
    }

    @Override
    public Parametrias encontrar(Integer parCodRepPk) {
        return em.find(Parametrias.class, parCodRepPk);
    }

    @Override
    public void actualizar(Parametrias parametrias) {
        em.merge(parametrias);
    }

    @Override
    public void insertar(Parametrias parametrias) throws Exception {
        Parametrias a = em.find(Parametrias.class, parametrias.getParCodRepPk());
        if(a != null)
            throw new Exception();
        em.persist(parametrias);
    }

    @Override
    public void eliminar(Integer parCodRepPk) {
        Parametrias a = em.find(Parametrias.class, parCodRepPk);
        em.remove(a);
    }

    @Override
    public List<Parametrias> encontrarPorTipo(String tipo) {
        return em.createNamedQuery("Parametrias.findByTipo", Parametrias.class)
                .setParameter("tipo", tipo).getResultList();
    }

    @Override
    public List<Parametrias> encontrarPorGrupo(String tipo, Integer grupo) {
        return em.createNamedQuery("Parametrias.findByGrupo", Parametrias.class)
                .setParameter("tipo", tipo)
                .setParameter(tipo, grupo).getResultList();
    }

    @Override
    public List<Parametrias> encontrarPorAcceso(String tipo, List<Integer> reportes, List<Integer> grupos) {
        String query = query("SELECT p FROM Parametrias p WHERE p.parTipoRep = :tipo AND ", reportes, grupos);
        Query q = em.createQuery(query, Parametrias.class);
        q.setParameter("tipo", tipo);
        for(int i=0; i<reportes.size(); i++) {
            q.setParameter("rep" + i, reportes.get(i));
        }
        for(int i=0; i<grupos.size(); i++) {
            q.setParameter("grp" + i, grupos.get(i));
        }
        return q.getResultList();
    }

}
