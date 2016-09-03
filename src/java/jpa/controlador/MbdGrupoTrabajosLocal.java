/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.GrupoTrabajos;

/**
 *
 * @author analista02
 */
@Local
public interface MbdGrupoTrabajosLocal {

    GrupoTrabajos encontrar(Integer grpCodPk);

    List<GrupoTrabajos> encontrarTodos();

    void insertar(GrupoTrabajos grupoTrabajo) throws Exception;

    void actualizar(GrupoTrabajos grupoTrabajo);

    void eliminar(Integer grpCodPk);
    
}
