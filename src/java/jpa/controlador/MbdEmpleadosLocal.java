/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Empleados;
import jpa.valores.EmpleadosPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdEmpleadosLocal {

    List<Empleados> encontrarTodos();

    void insertar(Empleados empleado) throws Exception;

    void actualizar(Empleados empleado);

    void eliminar(EmpleadosPK empleadosPK);

    Empleados encontrar(EmpleadosPK empleadosPK);
    
    List<Empleados> encontrarNoUsuarios();
    
}
