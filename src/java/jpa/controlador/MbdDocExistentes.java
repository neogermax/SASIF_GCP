/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import jpa.valores.DocExistentes;
import jpa.valores.DocExistentesPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdDocExistentes implements MbdDocExistentesLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<DocExistentes> encontrarTodos() {
        return em.createNamedQuery("DocExistentes.findAll", DocExistentes.class).getResultList();
    }

    @Override
    public void insertar(DocExistentes docExistentes) throws Exception {
        DocExistentes a = em.find(DocExistentes.class, docExistentes.getDocExistentesPK());
        if(a != null)
            throw new Exception();
        em.persist(docExistentes);
    }

    @Override
    public void actualizar(DocExistentes docExistentes) {
        em.merge(docExistentes);
    }

    @Override
    public void eliminar(DocExistentesPK docExistentesPk) {
        DocExistentes a = em.find(DocExistentes.class, docExistentesPk);
        em.remove(a);
    }

    @Override
    public DocExistentes encontrar(DocExistentesPK docExistentesPK) {
        return em.find(DocExistentes.class, docExistentesPK);
    }

    @Override
    public Long secuencia(String codAplOr, String tipoDoc, Long ideApli, String nomDoc) {
        Long sec = em.createNamedQuery("DocExistentes.findSec", Long.class)
                        .setParameter("codAplOr", codAplOr)
                        .setParameter("tipoDoc", tipoDoc)
                        .setParameter("ideApli", ideApli)
                        .setParameter("nomDoc", nomDoc).getSingleResult();
        return (sec != null) ? sec : new Long(0);
    }
    
}
