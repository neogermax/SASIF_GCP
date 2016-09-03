/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Parametrias;

/**
 *
 * @author analista02
 */
@Local
public interface MbdParametriasLocal {

    List<Parametrias> encontrarTodos();
    
    List<Parametrias> encontrarSint();

    Parametrias encontrar(Integer parCodRepPk);

    void actualizar(Parametrias parametrias);

    void insertar(Parametrias parametrias) throws Exception;

    void eliminar(Integer parCodRepPk);

    List<Parametrias> encontrarPorTipo(String tipo);

    List<Parametrias> encontrarPorGrupo(String tipo, Integer grupo);

    List<Parametrias> encontrarPorAcceso(String tipo, List<Integer> reportes, List<Integer> grupos);
    
}
