/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Empresas;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdEmpresas implements MbdEmpresasLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public List<Empresas> encontrarTodos() {
        return em.createNamedQuery("Empresas.findAll", Empresas.class)
                .getResultList();
    }

    @Override
    public void insertar(Empresas empresa) throws Exception {
        Empresas e = em.find(Empresas.class, empresa.getEmprCodigoPk());
        if(e != null)
            throw new Exception();
        em.persist(empresa);
    }

    @Override
    public void actualizar(Empresas empresa) {
        em.merge(empresa);
    }

    @Override
    public void eliminar(Integer emprCodigoPk) {
        Empresas e = em.find(Empresas.class, emprCodigoPk);
        em.remove(e);
    }
    
}
