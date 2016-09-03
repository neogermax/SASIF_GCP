/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.controlador.MbdReportesLocal;
import jpa.valores.Caracteristicas;

import jpa.valores.Reportes;
import jpa.valores.ReportesPK;


/**
 *
 * @author analista02
 */
public class PtdReportes {
    MbdReportesLocal mbdReportes = lookupReportesLocal();

    private MbdReportesLocal lookupReportesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdReportesLocal) c.lookup("java:comp/env/MbdReportes");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Reportes> encontrarCaracteristica(Caracteristicas caracteristica, List<String> filas, List<String> cols) {
        return mbdReportes.encontrarCaracteristica(caracteristica, filas, cols);
    }
    
   
    public List<String> encontrarFilas(Caracteristicas caracteristicas) {        
       return mbdReportes.encontrarFilas(caracteristicas);
                
    }
    
    
    public List<String> encontrarColumnas(Caracteristicas caracteristicas) {
        return mbdReportes.encontrarColumnas(caracteristicas);
    }
    
    public List<Reportes> encontrarOpcion() {
        return mbdReportes.encontrarOpcion();
    }
    
    public void insertar(Reportes caracteristicas) throws Exception {
        this.mbdReportes.insertar(caracteristicas);
    }
    
    public List<Reportes> encontrarCarAct(Integer repCodRepFk, Integer repCarSecFk) {
       return this.mbdReportes.encontrarCaractAct(repCodRepFk, repCarSecFk);
    }
    
    public void insertar(Integer repCodRepFk, Integer repCarSecFk, List<Reportes> reportes) {
        mbdReportes.insertar(repCodRepFk, repCarSecFk, reportes);
    }

    public void actualizar(Reportes caracteristicas) {
        this.mbdReportes.actualizar(caracteristicas);
    }

    public void eliminar(ReportesPK caracteristicasPK) {
        mbdReportes.eliminar(caracteristicasPK);
    }
    
}
