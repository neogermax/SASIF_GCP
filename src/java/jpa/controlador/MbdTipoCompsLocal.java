/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.TipoComps;

/**
 *
 * @author Analista02
 */
@Local
public interface MbdTipoCompsLocal {

    List<TipoComps> encontrarTodos();

    void insertar(TipoComps tipoComps) throws Exception;

    void actualizar(TipoComps tipoComps);

    void eliminar(Integer tipCodPk);
    
}
