/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Paises;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdPaises implements MbdPaisesLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Paises> encontrarTodos() {
        return em.createNamedQuery("Paises.findAll", Paises.class).getResultList();
    }

    @Override
    public Paises encontrar(Integer paiCodPk) {
        return em.find(Paises.class, paiCodPk);
    }

    @Override
    public void insertar(Paises paises) throws Exception {
        Paises e = em.find(Paises.class, paises.getPaiCodPk());
        if(e != null)
            throw new Exception();
        em.persist(paises);
    }

    @Override
    public void actualizar(Paises paises) {
        em.merge(paises);
    }

    @Override
    public void eliminar(Integer paiCodPk) {
        Paises e = em.find(Paises.class, paiCodPk);
        em.remove(e);
    }
    
}
