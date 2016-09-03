
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.PoliticaGrupos;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdPoliticaGrupos implements MbdPoliticaGruposLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager po;

    @Override
    public List<PoliticaGrupos> encontrarTodos() {
        return po.createNamedQuery("PoliticaGrupos.findAll", PoliticaGrupos.class)
                .getResultList();
    }

    @Override
    public void insertar(PoliticaGrupos politica) throws Exception {
        PoliticaGrupos p = po.find(PoliticaGrupos.class, politica.getPolCodPk());
        if(p != null)
            throw new Exception();
        po.persist(politica);
    }

    @Override
    public void actualizar(PoliticaGrupos politica) {
        po.merge(politica);
    }

    @Override
    public void eliminar(Integer polCodPk) {
        PoliticaGrupos p = po.find(PoliticaGrupos.class, polCodPk);
        po.remove(p);
    }
    
    @Override
    public PoliticaGrupos encontrar(Integer polCodPk) {
        return po.find(PoliticaGrupos.class, polCodPk);
    }
}
