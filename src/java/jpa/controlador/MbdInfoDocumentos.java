/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.InfoDocumentos;
import jpa.valores.InfoDocumentosPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdInfoDocumentos implements MbdInfoDocumentosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<InfoDocumentos> encontrarTodos() {
        return em.createNamedQuery("InfoDocumentos.findAll", InfoDocumentos.class).getResultList();
    }

    @Override
    public void insertar(InfoDocumentos infoDocumentos) throws Exception {
        InfoDocumentos a = em.find(InfoDocumentos.class, infoDocumentos.getInfoDocumentosPK());
        if(a != null)
            throw new Exception();
        em.persist(infoDocumentos);
    }

    @Override
    public void actualizar(InfoDocumentos infoDocumentos) {
        em.merge(infoDocumentos);
    }

    @Override
    public void eliminar(InfoDocumentosPK infoDocumentosPk) {
        InfoDocumentos a = em.find(InfoDocumentos.class, infoDocumentosPk);
        em.remove(a);
    }
    
}
