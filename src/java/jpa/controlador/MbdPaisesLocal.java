/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Paises;

/**
 *
 * @author analista02
 */
@Local
public interface MbdPaisesLocal {

    List<Paises> encontrarTodos();

    Paises encontrar(Integer paiCodPk);

    void insertar(Paises paises) throws Exception;

    void actualizar(Paises paises);

    void eliminar(Integer paiCodPk);
    
}
