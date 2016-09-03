/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Cargos;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdCargos implements MbdCargosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Cargos> encontrarTodos() {
        return em.createNamedQuery("Cargos.findAll", Cargos.class).getResultList();
    }

    @Override
    public Cargos encontrar(Integer carCodigoPk) {
        return em.find(Cargos.class, carCodigoPk);
   } 
        
   @Override
    public void actualizar(Cargos cargos) {
        em.merge(cargos);
    }
   
   @Override
    public void insertar(Cargos cargos) throws Exception {
        Cargos a = em.find(Cargos.class, cargos.getCarCodigoPk());
        if(a != null)
            throw new Exception();
        em.persist(cargos);
    }

    @Override
    public void eliminar(Integer carCodigoPk) {
        Cargos c = em.find(Cargos.class, carCodigoPk);
        em.remove(c);
    }

}
