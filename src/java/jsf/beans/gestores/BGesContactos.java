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
import jpa.valores.Contactos;
import jpa.valores.ContactosPK;
import jpa.valores.Empleados;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdContactos;
import jsf.controlador.PtdEmpleados;
import jsf.beans.generales.BGenErrores;

@ManagedBean(name = "bgesContactos")
@SessionScoped
public class BGesContactos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdContactos ptdContactos = new PtdContactos();
    private PtdEmpleados ptdEmpleados = new PtdEmpleados();
    private Contactos contacto;
    private Contactos cContacto = new Contactos(new ContactosPK());
    private List<Contactos> contactos;
    private List<Empleados> empleados;
    private String conUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    private int conss = 0;
    
    public BGesContactos() {
        
        conUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        contactos = ptdContactos.encontrarTodos();
        System.out.println(contactos.size());
        conss = contactos.size()+ 1;
        
        if(!contactos.isEmpty()) {
            contacto = contactos.get(0);
          
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
    }
    
    public Contactos getContacto() {
        return contacto;
    }
    
    public void setContacto(Contactos contacto) {
        this.contacto = contacto;
    }
    
    public Contactos getCContacto() {
        return cContacto;
    }
    
    public void setCContacto(Contactos cContacto) {
        this.cContacto = cContacto;
    }
    
    public List<Contactos> getContactos() {
        contactos = ptdContactos.encontrarTodos();
        selectContacto();
        return contactos;
    }
    
    private void selectContacto() {
        if(contacto == null && !contactos.isEmpty()) {
            contacto = contactos.get(0);
        } else if (!contactos.isEmpty()) {
            int index = contactos.indexOf(contacto);
            
            if(index == -1) {
                contacto = contactos.get(0);
            } else {
                contacto = contactos.get(index);
            }
        }
        
    }
    
    public List<Empleados> getEmpleados() {
        empleados = ptdEmpleados.encontrarTodos();
        return empleados;
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
            
            cContacto.getContactosPK().setConEmplIdPk(cContacto.getEmpleados().getEmpleadosPK().getEmplId());
            cContacto.getContactosPK().setConEmplTipPk(cContacto.getEmpleados().getEmpleadosPK().getEmplTipoId());
            
            ptdContactos.insertar(cContacto);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             contacto = cContacto;
             cContacto = new Contactos(new ContactosPK());
        } catch(Exception e) {
            e.printStackTrace();
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdContactos.actualizar(contacto);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
               return null;
    }

    public String eliminar() {
        try {
        ptdContactos.eliminar(contacto.getContactosPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private Empleados seleccionarPoliticas(Empleados p) {
        int index = empleados.indexOf(p);
        return empleados.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
