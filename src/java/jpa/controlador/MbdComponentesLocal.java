/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Componentes;
import jpa.valores.ComponentesPK;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;

/**
 *
 * @author Analista02
 */
@Local
public interface MbdComponentesLocal {

    Componentes encontrar(ComponentesPK componentesPK);

    List<Componentes> encontrarTodos();

    void insertar(Componentes componentes) throws Exception;

    void actualizar(Componentes componentes);

    void eliminar(ComponentesPK componentesPK);

    List<Componentes> encontrarPorProyecto(Proyectos proyecto);

    void insertar(List<Componentes> componentes);
    
}
