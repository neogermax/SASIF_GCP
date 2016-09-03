
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.PoliticaGrupos;

/**
 *
 * @author analista02
 */
@Local
public interface MbdPoliticaGruposLocal {

    List<PoliticaGrupos> encontrarTodos();
    
    PoliticaGrupos encontrar(Integer polCodPk);

    void insertar(PoliticaGrupos politica) throws Exception;

    void actualizar(PoliticaGrupos politica);

    void eliminar(Integer polCodPk);
    
}
