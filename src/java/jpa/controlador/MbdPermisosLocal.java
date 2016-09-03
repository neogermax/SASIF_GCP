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
import jpa.valores.Permisos;
import jpa.valores.PermisosPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdPermisosLocal {

    List<Permisos> encontrarOpcion();

    void insertar(Permisos permisos) throws Exception;

    void actualizar(Permisos permisos);

    void eliminar (PermisosPK permisosPK);

    List<Permisos> encontrarPorActividad(Clases clase, Etapas etapa, Actividades actividad);

    Permisos encontrar(PermisosPK permisosPK);
    
}
