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
import jpa.valores.Paralelas;
import jpa.valores.ParalelasPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdParalelasLocal {

    List<Paralelas> encontrarTodos();

    List<Paralelas> encontrarPorCodigo(Integer parClsCodFk);

    void insetar(Paralelas paralelas) throws Exception;

    void actualizar(Paralelas paralelas);

    void eliminar(ParalelasPK paralelasPK);

    Paralelas encontrar(ParalelasPK paralelasPk);

    void insertar(List<Paralelas> paralelas);

    List<Paralelas> encontrar(Clases clase, Etapas etapa, Actividades actividad);
    
}
