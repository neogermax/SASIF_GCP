/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.GrupoReportes;

/**
 *
 * @author analista02
 */
@Local
public interface MbdGrupoReportesLocal {

    List<GrupoReportes> encontrarTodos();

    GrupoReportes encontrar(Integer grpCodPk);

    void actualizar(GrupoReportes grupoReportes);

    void insertar(GrupoReportes grupoReportes) throws Exception;

    void eliminar(Integer grpCodPk);
    
}
