/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Gdocumentos;

/**
 *
 * @author Analista02
 */
@Stateless
public class MbdGdocumentos implements MbdGdocumentosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;
    
    @Override
    public List<Gdocumentos> encontrarTodos() {
        return em.createNamedQuery("Gdocumentos.findAll", Gdocumentos.class).getResultList();
    }

    @Override
    public Gdocumentos encontrar(Integer gdoGrupoPk) {
        return em.find(Gdocumentos.class, gdoGrupoPk);
    }

    @Override
    public void insertar(Gdocumentos gdocumento) throws Exception {
        Gdocumentos gd = em.find(Gdocumentos.class, gdocumento.getGdoGrupoPk());
        if(gd != null)
            throw new Exception();
        em.persist(gdocumento);
    }

    @Override
    public void actualizar(Gdocumentos gdocumento) {
        em.merge(gdocumento);
    }

    @Override
    public void eliminar(Integer gdoGrupoPk) {
        Gdocumentos gd = em.find(Gdocumentos.class, gdoGrupoPk);
        em.remove(gd);
    }

}
