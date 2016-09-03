/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Clases;
import jpa.valores.Relaciones;
import jpa.valores.RelacionesPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdRelacionesLocal {

    List<Relaciones> encontrarTodos();

    List<Relaciones> encontrarPorClase(Clases clases);

    void insertar(Relaciones relaciones) throws Exception;

    void actualizar(Relaciones relaciones);

    void eliminar(RelacionesPK relacionesPk);

    void insertar(List<Relaciones> relaciones);
    
}
