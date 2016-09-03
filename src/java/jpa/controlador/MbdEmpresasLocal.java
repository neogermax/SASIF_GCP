/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Empresas;

/**
 *
 * @author analista02
 */
@Local
public interface MbdEmpresasLocal {

    List<Empresas> encontrarTodos();

    void insertar(Empresas empresa) throws Exception;

    void actualizar(Empresas empresa);

    void eliminar(Integer emprCodigoPk);
    
}
