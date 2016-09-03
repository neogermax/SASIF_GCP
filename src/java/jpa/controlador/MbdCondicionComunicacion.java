/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.CondicionComunicacion;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdCondicionComunicacion implements MbdCondicionComunicacionLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<CondicionComunicacion> encontrarTodos() {
        return em.createNamedQuery("CondicionComunicacion.findAll", CondicionComunicacion.class).getResultList();
    }

    @Override
    public CondicionComunicacion encontrar(Integer concomCodigoPk) {
        return em.find(CondicionComunicacion.class, concomCodigoPk);
   } 
        
   @Override
    public void actualizar(CondicionComunicacion condicionComunicacion) {
        em.merge(condicionComunicacion);
    }
   
   @Override
    public void insertar(CondicionComunicacion condicionComunicacion) throws Exception {
        CondicionComunicacion a = em.find(CondicionComunicacion.class, condicionComunicacion.getConcomCodPk());
        if(a != null)
            throw new Exception();
        em.persist(condicionComunicacion);
    }

    @Override
    public void eliminar(Integer concomCodigoPk) {
        CondicionComunicacion c = em.find(CondicionComunicacion.class, concomCodigoPk);
        em.remove(c);
    }

}
