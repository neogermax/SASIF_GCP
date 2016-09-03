/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import jpa.valores.Roles;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdRoles;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesRoles")
@SessionScoped
public class BGesRoles implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdRoles ptdRoles = new PtdRoles();
    private Roles rol;
    private Roles cRol = new Roles();
    private List<Roles> roles;
    private String rolUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesRoles() {
        rolUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        roles = ptdRoles.encontrarTodos();
        if(!roles.isEmpty()) {
            rol = roles.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
    }
    
    public Roles getRol() {
        return rol;
    }
    
    public void setRol(Roles rol) {
        this.rol = rol;
    }
    
    public Roles getCRol() {
        return cRol;
    }
    
    public void setCRol(Roles cRol) {
        this.cRol = cRol;
    }
    
    public List<Roles> getRoles() {
        roles = ptdRoles.encontrarTodos();
        selectRol();
        return roles;
    }
    
    private void selectRol() {
        if(rol == null && !roles.isEmpty()) {
            rol = roles.get(0);
        } else if(!roles.isEmpty()) {
            int index = roles.indexOf(rol);
            if(index == -1) {
                rol = roles.get(0);
            } else {
                rol = roles.get(index);
            }
        }
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
            ptdRoles.insertar(cRol);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             rol = cRol;
             cRol = new Roles();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdRoles.actualizar(rol);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        
    try {
            ptdRoles.eliminar(rol.getRolRolPk());
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
