/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Pdocumentos;

/**
 *
 * @author Analista02
 */
@Stateless
public class MbdPdocumentos implements MbdPdocumentosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;
    
    @Override
    public List<Pdocumentos> encontrarTodos() {
        return em.createNamedQuery("Pdocumentos.findAll", Pdocumentos.class).getResultList();
    }

    @Override
    public Pdocumentos encontrar(String pdoDocumentoPk) {
        return em.find(Pdocumentos.class, pdoDocumentoPk);
    }

    @Override
    public void insertar(Pdocumentos pdocumento) throws Exception {
        Pdocumentos pd = em.find(Pdocumentos.class, pdocumento.getPdoDocumentoPk());
        if(pd != null)
            throw new Exception();
        em.persist(pdocumento);
    }

    @Override
    public void actualizar(Pdocumentos pdocumentos) {
        em.merge(pdocumentos);
    }

    @Override
    public void eliminar(String pdoDocumentoPk) {
        Pdocumentos pd = em.find(Pdocumentos.class, pdoDocumentoPk);
        em.remove(pd);
    }

}
