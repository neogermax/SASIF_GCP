/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Links;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdLinks implements MbdLinksLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager li;

    @Override
    public List<Links> encontrarTodos() {
        return li.createNamedQuery("Links.findAll", Links.class)
                .getResultList();
    }

    @Override
    public void insertar(Links link) throws Exception {
        Links l = li.find(Links.class, link.getLinkCodPk());
        if(l != null)
            throw new Exception();
        li.persist(link);
    }

    @Override
    public void actualizar(Links link) {
        li.merge(link);
    }

    @Override
    public void eliminar(String linkCodPk) {
        Links l = li.find(Links.class, linkCodPk);
        li.remove(l);
    }
    
}
