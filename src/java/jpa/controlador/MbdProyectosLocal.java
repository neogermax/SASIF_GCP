/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import jpa.valores.Proyectos;

/**
 *
 * @author analista02
 */
@Local
public interface MbdProyectosLocal {

    void insertar(Proyectos proyectos) throws Exception;

    void actualizar(Proyectos proyectos);

    void eliminar(Integer proCodPk);

    List<Proyectos> encontrarTodos();

    Proyectos encontrar(Integer proCodPk);

//    public List<Proyectos> consultaGerencia1(String filEstado);

    public List<Proyectos> consultaGerencia1(String filEstado, int filClase, boolean varClas, Date fecMin, Date fecMac);

}
