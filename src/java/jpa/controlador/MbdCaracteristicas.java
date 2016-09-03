/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Caracteristicas;
import jpa.valores.CaracteristicasPK;
import jpa.valores.Parametrias;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdCaracteristicas implements MbdCaracteristicasLocal {
    @PersistenceContext(unitName = "CGPLUISPU3")
    private EntityManager em;

    @Override
    public List<Caracteristicas> encontrarOpcion() {
        return em.createNamedQuery("Caracteristicas.findAll", Caracteristicas.class)
                .getResultList();
    }
    
    @Override
    public List<Caracteristicas> encontrarHistorico(String usuCod, Parametrias parametria) {
        return em.createNamedQuery("Caracteristicas.findByUsuario", Caracteristicas.class)
                .setParameter("carUsuGen", usuCod)                
                .setParameter("parametria", parametria).getResultList();
    }
    
    @Override
    public Caracteristicas encontrarUltimo(String usuCod, Integer carCodRepFk) {
        try {
            return em.createNamedQuery("Caracteristicas.findByUltimo", Caracteristicas.class)
                .setParameter("carUsuGen", usuCod)
                .setParameter("cod1", carCodRepFk)
                .setParameter("cod2", carCodRepFk).getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }

 @Override
    public Caracteristicas encontrarSecuencia(String usuCod, Integer carCodRepFk) {
        try {
            return em.createNamedQuery("Caracteristicas.findBySecuen", Caracteristicas.class)
                .setParameter("CarUsuGen", usuCod)
                .setParameter("CarCodRepFk", carCodRepFk).getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }
    
    @Override
    public Integer encontrarSecCons(Integer carCodRepFk) {
        try {
            return em.createNamedQuery("Caracteristicas.findBySecCons", Integer.class)
                .setParameter("codrep", carCodRepFk).getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }
    
    @Override
    public Integer encontrarMaxSecu(String usuCod,Integer carCodRepFk) {
        try {
            return em.createNamedQuery("Caracteristicas.findByMaxSec", Integer.class)
                .setParameter("carusugen", usuCod)
                .setParameter("carcodrepfk", carCodRepFk).getSingleResult();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
    @Override
    public void insertar(Caracteristicas caracteristicas) throws Exception {
        Caracteristicas e = em.find(Caracteristicas.class, caracteristicas.getCaracteristicasPK());
        if(e != null)
            throw new Exception();
        em.persist(caracteristicas);
    }

    @Override
    public void actualizar(Caracteristicas caracteristicas) {
        em.merge(caracteristicas);
    }

    @Override
    public void eliminar(CaracteristicasPK caracteristicasPK) {
        Caracteristicas e = em.find(Caracteristicas.class, caracteristicasPK);
        em.remove(e);
    }

    @Override
    public List<Caracteristicas> encontrarTodos(Parametrias parametria) {
        return em.createNamedQuery("Caracteristicas.findByCode", Caracteristicas.class)
                .setParameter("parametria", parametria).getResultList();
    }

    @Override
    public Caracteristicas encontrarUltimo2(Integer carCodRepFk) {
        try {
            return em.createNamedQuery("Caracteristicas.findByUltimo2", Caracteristicas.class)
                .setParameter("cod1", carCodRepFk)
                .setParameter("cod2", carCodRepFk).getSingleResult();
        } catch(Exception e) {
            return null;
        }
    }
    
}
