/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Festivos;
import jpa.valores.FestivosPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdFestivos implements MbdFestivosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Festivos> encontrarTodos() {
        return em.createNamedQuery("Festivos.findAll", Festivos.class)
                .getResultList();
    }

    @Override
    public void insertar(Festivos festivo) throws Exception {
        Festivos e = em.find(Festivos.class, festivo.getFestivosPK());
        if(e != null)
            throw new Exception();
        em.persist(festivo);
    }

       @Override
    public void eliminar(FestivosPK festivosPK) {
        Festivos e = em.find(Festivos.class, festivosPK);
        em.remove(e);
    }
    
    @Override
    public Festivos encontrar(FestivosPK festivosPK) {
        return em.find(Festivos.class, festivosPK);
    }
    
}
