/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.TipoComps;

/**
 *
 * @author Analista02
 */
@Stateless
public class MbdTipoComps implements MbdTipoCompsLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<TipoComps> encontrarTodos() {
        return em.createNamedQuery("TipoComps.findAll", TipoComps.class).getResultList();
    }

    @Override
    public void insertar(TipoComps tipoComps) throws Exception {
        TipoComps t = em.find(TipoComps.class, tipoComps.getTipCodPk());
        if(t != null)
            throw new Exception();
        em.persist(tipoComps);
    }

    @Override
    public void actualizar(TipoComps tipoComps) {
        em.merge(tipoComps);
    }

    @Override
    public void eliminar(Integer tipCodPk) {
        TipoComps t = em.find(TipoComps.class, tipCodPk);
        em.remove(t);
    }

}
