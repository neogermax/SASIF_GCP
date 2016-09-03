/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.DocmActv;
import jpa.valores.DocmActvPK;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Actividades;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdDocmActv implements MbdDocmActvLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<DocmActv> encontrarOpcion() {
        return em.createNamedQuery("DocmActv.findAll", DocmActv.class).getResultList();
                
    }
    
    

    @Override
    public void insertar(DocmActv docmactv) throws Exception {
        DocmActv e = em.find(DocmActv.class, docmactv.getDocmActvPK());
        if(e != null)
            throw new Exception();
        em.persist(docmactv);
    }

    @Override
    public void actualizar(DocmActv docmactv) {
        em.merge(docmactv);
    }

    @Override
    public void eliminar(DocmActvPK docmactvPK) {
        DocmActv e = em.find(DocmActv.class, docmactvPK);
        em.remove(e);
    }
    
}
