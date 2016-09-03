/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import jpa.valores.Actividades;
import jpa.valores.ProyItems;
import jpa.valores.ProyItemsPK;
import jpa.valores.Proyectos;

/**
 *
 * @author analista02
 */
@Local
public interface MbdProyItemsLocal {
    
    ProyItems encontrar(ProyItemsPK proyItemsPK);

    void actualizar(ProyItems proyItems);

    void eliminar(ProyItemsPK proyItemsPK);

    void actualizar(List<ProyItems> proyItems);

    List<ProyItems> encontrarPorActItems(Integer act, Proyectos proy);

}
