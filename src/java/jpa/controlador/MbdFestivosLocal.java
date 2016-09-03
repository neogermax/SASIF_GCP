/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;

import jpa.valores.Festivos;
import jpa.valores.FestivosPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdFestivosLocal {

    List<Festivos> encontrarTodos();
    
       
    Festivos encontrar(FestivosPK festivosPK);

    void insertar(Festivos festivo) throws Exception;

    void eliminar(FestivosPK festivosPK);
    
}
