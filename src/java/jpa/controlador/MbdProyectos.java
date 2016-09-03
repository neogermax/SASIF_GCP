/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.valores.Proyectos;

/**
 *
 * @author analista02
 */
@Stateless
public class MbdProyectos implements MbdProyectosLocal {
    @PersistenceContext(unitName = "CGPLUISPU2")
    private EntityManager em;
            
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CGPLUISPU2");
//    EntityManager em = emf.createEntityManager();
    
    @Override
    public void insertar(Proyectos proyectos) throws Exception {
        Proyectos p = em.find(Proyectos.class, proyectos.getProCodPk());
        if(p != null)
            throw new Exception();
        em.persist(proyectos);
    }

    @Override
    public void actualizar(Proyectos proyectos) {
        em.merge(proyectos);
    }

    @Override
    public void eliminar(Integer proCodPk) {
        Proyectos p = em.find(Proyectos.class, proCodPk);
        em.remove(p);
    }

    @Override
    public List<Proyectos> encontrarTodos() {
        return em.createNamedQuery("Proyectos.findAll", Proyectos.class).getResultList();
    }

    @Override
    public Proyectos encontrar(Integer proCodPk) {
        return em.find(Proyectos.class, proCodPk);
    }
    
//    @Override
//    public List<Proyectos> consultaGerencia1(String consultaGerencia){
//    Query query;
//        query = em.createQuery(consultaGerencia);
//        return (List<Proyectos>) query.getResultList();
//    }
    
    @Override
    public List<Proyectos> consultaGerencia1(String filEstado, int filClase, boolean varClas, Date fecMin, Date fecMac){
    Query query;
    String consultaGerencia = "SELECT p FROM Proyectos p";
        boolean wh = false;
        if (!(filEstado.equals("Todos"))) {
            if (wh == false) {
                consultaGerencia += " WHERE p.proEstado = '" + filEstado + "'";
                wh = true;
            }
        }
        if (varClas == true) {
            if (wh == false) {
                consultaGerencia += " WHERE p.proClsCodFk.clsCodPk = " + filClase + "";
                wh = true;
            } else {
                consultaGerencia += " AND p.proClsCodFk.clsCodPk = " + filClase + "";
            }
        }
        if (fecMin != null && fecMac != null) {
            SimpleDateFormat smpFec = new SimpleDateFormat("yyyy/MM/dd");
            String stFecMin = smpFec.format(fecMin);
            String stFecMac = smpFec.format(fecMac);

            if (wh == false) {
                consultaGerencia += " WHERE p.proFechaHora BETWEEN '" + stFecMin + "'AND '" + stFecMac + "'ORDER BY p.proFechaHora";
                wh = true;
            } else {
                consultaGerencia += " AND p.proFechaHora BETWEEN '" + stFecMin + "'AND '" + stFecMac + "' ORDER BY p.proFechaHora";
            }
        }
        query = em.createQuery(consultaGerencia);// Pendiente a este query no se le ha colocado el filtro de condición (al día, atrasados) por que no se conoce el párametro de la tabla
        return (List<Proyectos>) query.getResultList();
    }
}
