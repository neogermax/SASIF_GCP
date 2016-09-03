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
import jpa.valores.Links;
import jpa.valores.OpcionRoles;
import jpa.valores.OpcionRolesPK;
import jpa.valores.Roles;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdLinks;
import jsf.controlador.PtdOpcionRoles;
import jsf.controlador.PtdRoles;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesOpcionRoles")
@SessionScoped
public class BGesOpcionRoles implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private BGesMenu bgesMenu = (BGesMenu)UtileriaHTTP.getBean("bgesMenu");
    private PtdOpcionRoles ptdOpcionRoles = new PtdOpcionRoles();
    private PtdRoles ptdRoles = new PtdRoles();
    private PtdLinks ptdLinks = new PtdLinks();
    private OpcionRoles opcionrol;
    private OpcionRoles cOpcionRol = new OpcionRoles(new OpcionRolesPK());
    private List<OpcionRoles> opcionroles;
    private List<Roles> roles;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesOpcionRoles() {
        opcionroles = ptdOpcionRoles.encontrarOpcion();
        if(!opcionroles.isEmpty()) {
            opcionrol = opcionroles.get(0);
        }
       
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
    }
    
    public OpcionRoles getOpcionRol() {
        return opcionrol;
    }
    
    public void setOpcionRol(OpcionRoles opcionrol) {
        this.opcionrol = opcionrol;
    }
    
    public OpcionRoles getCOpcionRol() {
        return cOpcionRol;
    }
    
    public void setCOpcionRol(OpcionRoles cOpcionRol) {
        this.cOpcionRol = cOpcionRol;
    }
    
    public List<OpcionRoles> getOpcionRoles() {
        opcionroles = ptdOpcionRoles.encontrarOpcion();
        selectOpcionRol();
        return opcionroles;
    }
    
    private void selectOpcionRol() {
        if(opcionrol == null && !opcionroles.isEmpty()) {
            opcionrol = opcionroles.get(0);
        } else if (!opcionroles.isEmpty()) {
            int index = opcionroles.indexOf(opcionrol);
            if(index == -1) {
                opcionrol = opcionroles.get(0);
            } else {
                opcionrol = opcionroles.get(index);
            }
        }
    }
    
    public List<Roles> getRoles() {
        roles = ptdRoles.encontrarTodos();
        return roles;
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
            cOpcionRol.getOpcionRolesPK().setOpcRolPk(cOpcionRol.getRoles().getRolRolPk());
            Roles rol = seleccionarRoles(cOpcionRol.getRoles());
            rol.getOpcionRolesList().add(cOpcionRol);
            ptdRoles.actualizar(rol);
            bgesMenu.init();
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             opcionrol = cOpcionRol;
             cOpcionRol = new OpcionRoles(new OpcionRolesPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
            e.printStackTrace();
        }
        return null;
    }

    public String actualizar() {
        ptdOpcionRoles.actualizar(opcionrol);
        bgesMenu.init();
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        opcionrol.setRoles(seleccionarRoles(opcionrol.getRoles()));
        return null;
    }

    public String eliminar() {
        try {
        Roles rol = opcionrol.getRoles();
        rol.getOpcionRolesList().remove(opcionrol);
        ptdRoles.actualizar(rol);
        ptdOpcionRoles.eliminar(opcionrol.getOpcionRolesPK());
        bgesMenu.init();
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
       } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    
    private Roles seleccionarRoles(Roles p) {
        int index = roles.indexOf(p);
        return roles.get(index);
    }
    
    public List<Links> getLinks() {
        List<Links> l = ptdLinks.encontrarTodos();
        List<Links> ls = new ArrayList<Links>();
        ls.add(new Links(""));
        ls.addAll(l);
        return ls;
    }
    
    public List<Roles> getSubRoles() {
        roles = ptdRoles.encontrarTodos();
        List<Roles> subRoles = new ArrayList<Roles>();
        subRoles.add(new Roles(""));
        subRoles.addAll(roles);
        return subRoles;
    }
    
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
