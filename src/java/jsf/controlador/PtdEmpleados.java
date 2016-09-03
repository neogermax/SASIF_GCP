/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.controlador.MbdEmpleadosLocal;
import jpa.valores.Empleados;
import jpa.valores.EmpleadosPK;


/**
 *
 * @author analista02
 */
public class PtdEmpleados {
    MbdEmpleadosLocal mbdEmpleados = lookupEmpresaLocal();

    private MbdEmpleadosLocal lookupEmpresaLocal() {
        try {
            Context c = new InitialContext();
            return (MbdEmpleadosLocal) c.lookup("java:comp/env/MbdEmpleados");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   
    
    public List<Empleados> encontrarTodos() {
        return mbdEmpleados.encontrarTodos();
    }
    
    public void insertar(Empleados empleado) throws Exception {
        this.mbdEmpleados.insertar(empleado);
    }

    public void actualizar(Empleados empleado) {
        this.mbdEmpleados.actualizar(empleado);
    }

    public void eliminar(EmpleadosPK empleadosPK) {
        mbdEmpleados.eliminar(empleadosPK);
    }

    public Empleados encontrar(EmpleadosPK empleadosPK) {
        return mbdEmpleados.encontrar(empleadosPK);
    }
    
    public List<Empleados> encontrarNoUsuarios() {
        return mbdEmpleados.encontrarNoUsuarios();
    }
    
}
