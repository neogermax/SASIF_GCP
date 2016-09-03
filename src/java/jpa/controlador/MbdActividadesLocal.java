/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Actividades;

/**
 *
 * @author analista02
 */
@Local
public interface MbdActividadesLocal {

    Actividades encontrar(Integer actCodPk);

    List<Actividades> encontrarTodos();

    void insertar(Actividades actividades) throws Exception;

    void actualizar(Actividades actividades);

    void eliminar(Integer actCodPk);

    void actualizar();
    
}
