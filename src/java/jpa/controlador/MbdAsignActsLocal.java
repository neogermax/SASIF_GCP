/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Actividades;
import jpa.valores.AsignActs;
import jpa.valores.AsignActsPK;
import jpa.valores.Clases;
import jpa.valores.Etapas;

/**
 *
 * @author analista02
 */
@Local
public interface MbdAsignActsLocal {

    List<AsignActs> encontrarOpcion();

    void insertar(AsignActs asignacts) throws Exception;

    void actualizar(AsignActs asignacts);

    void eliminar (AsignActsPK asignactsPK);

    List<AsignActs> encontrarAsignaciones(Clases clase, Etapas etapa, Actividades actividad);

    List<AsignActs> encontrarCronograma(Clases clase, Etapas etapa, Actividades actividad);
    
}
