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
import jpa.valores.AsignActs;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.AsignActsPK;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAsignActs;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdEtapas;
import jsf.beans.generales.BGenErrores;



@ManagedBean(name = "bgesAsignActs")
@SessionScoped
public class BGesAsignActs implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");

    private PtdAsignActs ptdAsignActs = new PtdAsignActs();
    private PtdActividades ptdActividades = new PtdActividades();
    private PtdClases ptdClases = new PtdClases();
    private PtdEtapas ptdEtapas = new PtdEtapas();
    private AsignActs asignactt;
    private AsignActs uAsignAct;
    private AsignActs cAsignAct = new AsignActs(new AsignActsPK());
    private List<AsignActs> asignacts;
    private List<Actividades> actividades;
    private List<Clases> clases;
    private List<Etapas> etapas;
    private MapaRel cMapa = new MapaRel();
    private MapaRel dMapa = new MapaRel();
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesAsignActs() {
        init();
        asignacts = ptdAsignActs.encontrarOpcion();
        if(!asignacts.isEmpty()) {
            asignactt = asignacts.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
        columnas.add("7");
        
        
    }
    
    
    private void init() {
        cAsignAct.setAsignTipo("R");
        
    }
    
    
    
    public AsignActs getAsignAct() {
        return asignactt;
    }
    
    public void setAsignAct(AsignActs asignact) {
        this.asignactt = asignact;
    }
    
    public AsignActs getCAsignAct() {
        return cAsignAct;
    }
    
    public void setCAsignAct(AsignActs cAsignAct) {
        this.cAsignAct = cAsignAct;
    }
    
    
    public AsignActs getUAsignAct() {
        return uAsignAct;
    }
    
    public void setUAsignAct(AsignActs uAsignAct) {
        this.uAsignAct = uAsignAct;
    }
    
    public List<AsignActs> getAsignActs() {
        asignacts = ptdAsignActs.encontrarOpcion();
        selectAsignAct();
        return asignacts;
    }
    
    
    public MapaRel getCMapaRelacion() {
        return cMapa;
    }
    
    public MapaRel getDMapaRelacion() {
        return dMapa;
    }
    
    
    
    
    private void selectAsignAct() {
        if(asignactt == null && !asignacts.isEmpty()) {
            
            asignactt = asignacts.get(0);
            
        } else if(!asignacts.isEmpty()) {
            
            int index = asignacts.indexOf(asignactt);
            
            if(index == -1) {
                
                asignactt = asignacts.get(0);
                
            } else {
                
                asignactt = asignacts.get(index);
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
            
            cAsignAct.setClases(cMapa.getClase().getClase());
            cAsignAct.setEtapas(cMapa.getEtapa().getEtapa());
            cAsignAct.setActividades(cMapa.getActividad());
            
            cAsignAct.setClases1(dMapa.getClase().getClase());
            cAsignAct.setEtapas1(dMapa.getEtapa().getEtapa());
            cAsignAct.setActividades1(dMapa.getActividad());
            
                    
            cAsignAct.getAsignActsPK().setAsignOrgClsFk(cMapa.getClase().getClase().getClsCodPk());
            cAsignAct.getAsignActsPK().setAsignOrgEtpFk(cMapa.getEtapa().getEtapa().getEtpCodPk());
            cAsignAct.getAsignActsPK().setAsignOrgActFk(cMapa.getActividad().getActCodPk());
            
            
            cAsignAct.getAsignActsPK().setAsignDesClsFk(dMapa.getClase().getClase().getClsCodPk());
            cAsignAct.getAsignActsPK().setAsignDesEtpFk(dMapa.getEtapa().getEtapa().getEtpCodPk());
            cAsignAct.getAsignActsPK().setAsignDesActFk(dMapa.getActividad().getActCodPk());
            
                       
            ptdAsignActs.insertar(cAsignAct);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             asignactt = cAsignAct;
             cAsignAct = new AsignActs(new AsignActsPK());
             init();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
            e.printStackTrace();
        }
        return null;
    }

    public String actualizar() {
        
        
        ptdAsignActs.actualizar(asignactt);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdAsignActs.eliminar(asignactt.getAsignActsPK());
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
