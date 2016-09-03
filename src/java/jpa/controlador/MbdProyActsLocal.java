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
import jpa.valores.ProyActs;
import jpa.valores.ProyActsPK;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;

/**
 *
 * @author analista02
 */
@Local
public interface MbdProyActsLocal {

    List<ProyActs> encontrarTodos();

    ProyActs encontrar(ProyActsPK proyActsPk);

    void insertar(ProyActs proyActs);

    void actualizar(ProyActs proyActs);
    
    void actualizar(Proyectos proyecto);
    
    void actualizar(List<ProyActs> proyActs);

    void eliminar(ProyActsPK proyActsPk);

    List<ProyActs> encontrarNoTerminadas(Proyectos proyecto);
    
    List<ProyActs> encontrarActDisp();

    List<ProyActs> encontrarActDisp(Proyectos proyecto);

    List<ProyActs> encontrarActDisp(Clases clase, Etapas etapa, Actividades actividad);
    
    Long encontrarCountAct(Proyectos proyecto, Actividades actividad);

    List<ProyActs> encontrarActsComp(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad);

    void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<ProyActs> proyActs);

    List<ProyActs> encontrarProyComp(Proyectos proyecto);
    
    List<ProyActs> encontrarProyComp(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad);

    List<ProyActs> encontrarCompPar();

    List<ProyActs> encontrarPorProyCod(Integer proCodFk);

    List<ProyActs> encontrarPorProyDescrip(String proDescrip);

    List<ProyActs> encontrarPorProyCodDes(Integer proCodFk, String proDescrip);
    
    List<ProyActs> encontrarPorProy(Integer proCodFk);
    
    List<ProyActs> encontrarPorRelacion(Integer proCodFk);
    
    List<ProyActs> encontrarUno(Integer proCodFk);
}
