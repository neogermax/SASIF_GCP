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
import jpa.valores.PermisosDocUsu;
import jpa.valores.PermisosDocUsuPK;
import jpa.valores.Usuarios;
import jpa.valores.Pdocumentos;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdPermisosDocUsu;
import jsf.controlador.PtdUsuarios;
import jsf.controlador.PtdPdocumentos;
import jsf.beans.generales.BGenErrores;

/**
 *
 * @author analista02
 */
@ManagedBean(name = "bgesPermisosDocUsu")
@SessionScoped
public class BGesPermisosDocUsu implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdPermisosDocUsu ptdPermisosDocUsu = new PtdPermisosDocUsu();
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private PtdPdocumentos ptdPdocumentos = new PtdPdocumentos();
    private PermisosDocUsu permisosDocUs;
    private PermisosDocUsu cPermisosDocUs = new PermisosDocUsu(new PermisosDocUsuPK());
    private List<PermisosDocUsu> PermisosDocUsu;
    private List<Usuarios> usuarios;
    private List<Pdocumentos> pdocumentos;
    private String areUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesPermisosDocUsu() {
        areUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        PermisosDocUsu = ptdPermisosDocUsu.encontrarTodos();
        if(!PermisosDocUsu.isEmpty()) {
            permisosDocUs = PermisosDocUsu.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
    }
    
    public PermisosDocUsu getPermisosDocUs() {
        return permisosDocUs;
    }
    
    public void setPermisosDocUs(PermisosDocUsu permisosDocUs) {
        this.permisosDocUs = permisosDocUs;
    }
    
    public PermisosDocUsu getCPermisosDocUs() {
        return cPermisosDocUs;
    }
    
    public void setCPermisosDocUs(PermisosDocUsu cPermisosDocUs) {
        this.cPermisosDocUs = cPermisosDocUs;
    }
    
    public List<PermisosDocUsu> getPermisosDocUsu() {
        PermisosDocUsu = ptdPermisosDocUsu.encontrarTodos();
        selectPermisosDocUs();
        return PermisosDocUsu;
    }
    
    private void selectPermisosDocUs() {
        if(permisosDocUs == null && !PermisosDocUsu.isEmpty()) {
            permisosDocUs = PermisosDocUsu.get(0);
        } else if (!PermisosDocUsu.isEmpty()) {
            int index = PermisosDocUsu.indexOf(permisosDocUs);
            if(index == -1) {
                permisosDocUs = PermisosDocUsu.get(0);
            } else {
                permisosDocUs = PermisosDocUsu.get(index);
            }
        }
    }
    
    public List<Usuarios> getUsuarios() {
        usuarios = ptdUsuarios.encontrarTodos();
        return usuarios;
    }
    
    public List<Pdocumentos> getPdocumentos() {
        pdocumentos = ptdPdocumentos.encontrarTodos();
        return pdocumentos;
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
            
            ptdPermisosDocUsu.insertar(cPermisosDocUs);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             permisosDocUs = cPermisosDocUs;
             cPermisosDocUs = new PermisosDocUsu(new PermisosDocUsuPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdPermisosDocUsu.actualizar(permisosDocUs);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdPermisosDocUsu.eliminar(permisosDocUs.getPermisosDocUsuPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private Usuarios seleccionarUsuarios(Usuarios usu) {
        int index = usuarios.indexOf(usu);
        return usuarios.get(index);
    }
    
    private Pdocumentos seleccionarPdocumentos(Pdocumentos pdoc) {
        int index = pdocumentos.indexOf(pdoc);
        return pdocumentos.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}