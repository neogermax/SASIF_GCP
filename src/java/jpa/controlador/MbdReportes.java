/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.valores.Caracteristicas;
import jpa.valores.Reportes;
import jpa.valores.ReportesPK;

/**
 *
 * @author analista03
 */
@Stateless
public class MbdReportes implements MbdReportesLocal {
    @PersistenceContext(unitName = "CGPLUISPU3")
    private EntityManager em;
    
    private String query(String inicial, int filas, int cols) {
        StringBuilder q = new StringBuilder(inicial);
        q.append("(");
        for(int i=0; i<filas; i++) {
            q.append("r.reportesPK.repNomFil = :fil").append(i);
            if(i<filas-1) {
                q.append(" OR ");
            }
        }
        q.append(") AND (");
        for(int i=0; i<cols; i++) {
            q.append("r.reportesPK.repNomCol = :col").append(i);
            if(i<cols-1) {
                q.append(" OR ");
            }
        }
        q.append(") ORDER BY r.reportesPK.repNomFil, r.reportesPK.repNomCol");
        return q.toString();
    }
    
    private Query encontrarFilCol(String inicial, List<String> filas, List<String> cols) {
        Query q = em.createQuery(query(inicial, filas.size(), cols.size()), Reportes.class);
        for(int i=0; i<filas.size(); i++) {
            q.setParameter("fil" + i, filas.get(i));
        }
        for(int i=0; i<cols.size(); i++) {
            q.setParameter("col" + i, cols.get(i));
        }
        return q;
    }
    
    @Override
    public List<Reportes> encontrarCaracteristica(Caracteristicas caracteristica, List<String> filas, List<String> cols) {
        Query q = encontrarFilCol("SELECT r FROM Reportes r WHERE r.caracteristicas = :caract AND ",
                filas, cols);
        q.setParameter("caract", caracteristica);
        return q.getResultList();
    }
    
    @Override
    public List<String> encontrarFilas(Caracteristicas caracteristicas) {
        return em.createNamedQuery("Reportes.findByFil", String.class)
                .setParameter("caract", caracteristicas).getResultList();
    }
    
    @Override
    public List<String> encontrarColumnas(Caracteristicas caracteristicas) {
        return em.createNamedQuery("Reportes.findByCol", String.class)
                .setParameter("caract", caracteristicas).getResultList();
    }
    
    @Override
    public List<Reportes> encontrarOpcion() {
        return em.createNamedQuery("Reportes.findAll", Reportes.class)
                .getResultList();
    }
    
     @Override
    public List<Reportes> encontrarCaractAct(Integer repCodRepFk, Integer repCarSecFk) {
         return em.createNamedQuery("Reportes.findCaractAct", Reportes.class)
                .setParameter("codrep", repCodRepFk)
                .setParameter("carsecfk", repCarSecFk).getResultList();
    }
    
    @Override
    public void insertar(Integer repCodRepFk, Integer repCarSecFk, List<Reportes> reportes) {
        em.createNamedQuery("Reportes.findDele", Reportes.class)
                .setParameter("codrepor", repCodRepFk)
                .setParameter("carsec", repCarSecFk)
                .executeUpdate();
        for(Reportes r : reportes) {
            em.persist(r);
        }
    }

    @Override
    public void insertar(Reportes reportes) throws Exception {
        Reportes e = em.find(Reportes.class, reportes.getReportesPK());
        if(e != null)
            throw new Exception();
        em.persist(reportes);
    }

    @Override
    public void actualizar(Reportes reportes) {
        em.merge(reportes);
    }

    @Override
    public void eliminar(ReportesPK reportesPK) {
        Reportes e = em.find(Reportes.class, reportesPK);
        em.remove(e);
    }
}
