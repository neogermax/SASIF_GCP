/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.ValorHora;
import jpa.valores.ValorHoraPK;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdValorHora implements MbdValorHoraLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;

    @Override
    public List<ValorHora> encontrarTodos() {
        return em.createNamedQuery("ValorHora.findAll", ValorHora.class).getResultList();
    }

    @Override
    public void insertar(ValorHora valorHora) throws Exception {
        ValorHora a = em.find(ValorHora.class, valorHora.getValorHoraPK());
        if(a != null)
            throw new Exception();
        em.persist(valorHora);
    }

    @Override
    public void actualizar(ValorHora valorHora) {
        em.merge(valorHora);
    }

    @Override
    public void eliminar(ValorHoraPK valorHoraPk) {
        ValorHora a = em.find(ValorHora.class, valorHoraPk);
        em.remove(a);
    }
    
}
