/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.AccesoRepUsu;
import jpa.valores.AccesoRepUsuPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdAccesoRepUsuLocal {
    
    List<AccesoRepUsu> encontrarTodos();

    void insertar(AccesoRepUsu accesoRepUsu) throws Exception;

    void actualizar(AccesoRepUsu accesoRepUsu);

    void eliminar(AccesoRepUsuPK accesoRepUsuPk);

    List<AccesoRepUsu> encontrarPorUsuario(String usuario);
    
}

    

