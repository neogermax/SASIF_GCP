/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;
import jpa.valores.Responsables;
import jpa.valores.ResponsablesPK;

/**
 *
 * @author Analista02
 */
@Local
public interface MbdResponsablesLocal {

    List<Responsables> encontrarTodos();

    void insertar(Responsables responsables) throws Exception;

    void actualizar(Responsables responsables);
    
    void actualizar(Proyectos proyecto);
    
    void actualizar(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad, String comp, Integer tipComp);

    void eliminar(ResponsablesPK responsablesPk);

    void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<Responsables> responsables);

    List<Responsables> encontrarPorClase(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad);

    Responsables encontrar(ResponsablesPK responsablesPk);

    Long encontrarCantidadAutoriz(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad);

    Long encontrarCantidadNoAutoriz(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad);

    List<Responsables> encontrarActivos();
    
    List<Responsables> encontrarActivos(Proyectos proyecto);

}
