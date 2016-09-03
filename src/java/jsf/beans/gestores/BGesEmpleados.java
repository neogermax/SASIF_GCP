/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import jpa.valores.Areas;
import jpa.valores.Empleados;
import jpa.valores.EmpleadosPK;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAreas;
import jsf.controlador.PtdEmpleados;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesEmpleados")
@SessionScoped
public class BGesEmpleados implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdEmpleados ptdEmpleados = new PtdEmpleados();
    private PtdAreas ptdAreas = new PtdAreas();
    private Empleados empleado;
    private Empleados cEmpleado = new Empleados(new EmpleadosPK());
    private List<Areas> areas;
    private List<Empleados> empleados;
    private String emplUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesEmpleados() {
        emplUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        empleados = ptdEmpleados.encontrarTodos();
        if(!empleados.isEmpty()) {
            empleado = empleados.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
        columnas.add("7");
        columnas.add("8");
        columnas.add("9");
        columnas.add("10");
        columnas.add("11");
    }
    
    public Empleados getEmpleado() {
        return empleado;
    }
    
    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }
    
    public Empleados getCEmpleado() {
        return cEmpleado;
    }
    
    public void setCEmpleado(Empleados cEmpleado) {
        this.cEmpleado = cEmpleado;
    }
    
    public List<Empleados> getEmpleados() {
        empleados = ptdEmpleados.encontrarTodos();
        selectEmpleado();
        return empleados;
    }
    
    private void selectEmpleado() {
        if(empleado == null && !empleados.isEmpty()) {
            empleado = empleados.get(0);
        } else if (!empleados.isEmpty()) {
            int index = empleados.indexOf(empleado);
            if(index == -1) {
                empleado = empleados.get(0);
            } else {
                empleado = empleados.get(index);
            }
        }
    }
    
    public List<Areas> getAreas() {
        areas = ptdAreas.encontrarTodos();
        return areas;
    }
    
    public List<Empleados> getEmpleadosList() {
        List<Empleados> empls = new ArrayList<Empleados>();
        empls.add(null);
        empls.addAll(ptdEmpleados.encontrarTodos());
        return empls;
    }
    
    public String getOpcion() {
        return opcion;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public List<String> getColumnas() {
        return columnas;
    }
    
    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }
    
    public UIInput getInputCodigo() {
        return inputCodigo;
    }
    
    public void setInputCodigo(UIInput inputCodigo) {
        this.inputCodigo = inputCodigo;
    }
    
    public String crear() {
        try {
            ptdEmpleados.insertar(cEmpleado);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             empleado = cEmpleado;
             cEmpleado = new Empleados(new EmpleadosPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdEmpleados.actualizar(empleado);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdEmpleados.eliminar(empleado.getEmpleadosPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
      } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
    
}
