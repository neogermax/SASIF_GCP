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
import jpa.valores.Permisos;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.PermisosPK;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdPermisos;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdEtapas;
import jsf.beans.generales.BGenErrores;



@ManagedBean(name = "bgesPermisos")
@SessionScoped
public class BGesPermisos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");

    private PtdPermisos ptdPermisos = new PtdPermisos();
    private PtdActividades ptdActividades = new PtdActividades();
    private PtdClases ptdClases = new PtdClases();
    private PtdEtapas ptdEtapas = new PtdEtapas();
    private Permisos permiso;
    private Permisos uPermiso;
    private Permisos cPermiso = new Permisos(new PermisosPK());
    private List<Permisos> permisos;
    private List<Actividades> actividades;
    private List<Clases> clases;
    private List<Etapas> etapas;
    private MapaRel cMapa = new MapaRel();
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesPermisos() {
        init();
        permisos = ptdPermisos.encontrarOpcion();
        if(!permisos.isEmpty()) {
            permiso = permisos.get(0);
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
        
    }
    
    private void init() {
        cPermiso.setPerAccProy("T");
        cPermiso.setPerIndAut("N");
        cPermiso.setPerIndCons("N");
        cPermiso.setPerIndGes("N");
    }
    
    
    
    
    public Permisos getPermiso() {
        return permiso;
    }
    
    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
    }
    
    public Permisos getCPermiso() {
        return cPermiso;
    }
    
    public void setCPermiso(Permisos cPermiso) {
        this.cPermiso = cPermiso;
    }
    
    
    public Permisos getUPermiso() {
        return uPermiso;
    }
    
    public void setUPermiso(Permisos uPermiso) {
        this.uPermiso = uPermiso;
    }
    
    public List<Permisos> getPermisos() {
        permisos = ptdPermisos.encontrarOpcion();
        selectPermiso();
        return permisos;
    }
    
    
    public MapaRel getCMapaRelacion() {
        return cMapa;
    }
    
    private void selectPermiso() {
        if(permiso == null && !permisos.isEmpty()) {
            
            permiso = permisos.get(0);
            
        } else if(!permisos.isEmpty()) {
            
            int index = permisos.indexOf(permiso);
            
            if(index == -1) {
                
                permiso = permisos.get(0);
                
            } else {
                
                permiso = permisos.get(index);
            }
        }
    }
    
    public List<Actividades> getActividades() {
        actividades = ptdActividades.encontrarTodos();
        return actividades;
    }
    
    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        return clases;
    }
    
    public List<Etapas> getEtapas() {
        etapas = ptdEtapas.encontrarTodos();
        return etapas;
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
            
            cPermiso.setClases(cMapa.getClase().getClase());
            cPermiso.setEtapas(cMapa.getEtapa().getEtapa());
            cPermiso.setActividades(cMapa.getActividad());
                    
            cPermiso.getPermisosPK().setPerClsCodFk(cMapa.getClase().getClase().getClsCodPk());
            cPermiso.getPermisosPK().setPerEtpCodFk(cMapa.getEtapa().getEtapa().getEtpCodPk());
            cPermiso.getPermisosPK().setPerActCodFk(cMapa.getActividad().getActCodPk());
            
            
                       
            ptdPermisos.insertar(cPermiso);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             permiso = cPermiso;
             cPermiso = new Permisos(new PermisosPK());
             init();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
            e.printStackTrace();
        }
        return null;
    }

    public String actualizar() {
        
        
        ptdPermisos.actualizar(permiso);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        
        try {
        ptdPermisos.eliminar(permiso.getPermisosPK());
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
