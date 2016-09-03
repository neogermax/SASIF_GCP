/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Caracteristicas;
import jpa.valores.Reportes;
import jpa.valores.ReportesPK;

/**
 *
 * @author analista03
 */
@Local
public interface MbdReportesLocal {
    List<Reportes> encontrarCaracteristica(Caracteristicas caracteristica, List<String> filas, List<String> cols);
    
    List<String> encontrarFilas(Caracteristicas caracteristicas);
    
    List<String> encontrarColumnas(Caracteristicas caracteristicas);
    
    List<Reportes> encontrarOpcion();
    
    List<Reportes> encontrarCaractAct(Integer repCodRepFk, Integer repCarSecFk);
    
    void insertar(Integer repCodRepFk, Integer repCarSecFk, List<Reportes> reportes);

    void insertar(Reportes reportes) throws Exception;

    void actualizar(Reportes reportes);

    void eliminar(ReportesPK reportesPK);
    
}
