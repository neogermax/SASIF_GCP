/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.CronoProye;
import jpa.valores.CronoProyePK;
import jpa.valores.Etapas;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;


/**
 *
 * @author Analista02
 */
@Local
public interface MbdCronoProyeLocal {

    List<CronoProye> encontrarTodos();

    CronoProye encontrar(CronoProyePK cronoProyePK);
    
    List<CronoProye> encontrarProy(Integer cronoProyePK);
    
    List<CronoProye> encontrarProyecto(Integer CronoProyPK);
    
    List<CronoProye> encontrarProyCron(Integer CronoProyPK);
    
    List<CronoProyePK> encontrarProyect(Integer CronoProyPK);

    void insertar(CronoProye cronoProy) throws Exception;

    void actualizar(CronoProye cronoProy);

    void eliminar(CronoProyePK cronoProyePK);
    
    void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<CronoProye> cronoProye);
    
    List<CronoProye> encontrarPorClase(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad);
    
    List<CronoProye> encontrarDisp();
    
    List<Object[]> fechMinMax(Integer proyecto);
    
    List<Object[]> fechMinMax();
    
    List<CronoProye> encontrarProyecto(Object[] parametros);
    
}
