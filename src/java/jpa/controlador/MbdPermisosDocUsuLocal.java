/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.PermisosDocUsu;
import jpa.valores.PermisosDocUsuPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdPermisosDocUsuLocal {

    List<PermisosDocUsu> encontrarTodos();

    void insertar(PermisosDocUsu permisosDocUsu) throws Exception;

    void actualizar(PermisosDocUsu permisosDocUsu);

    void eliminar(PermisosDocUsuPK permisosDocUsuPk);
    
}
