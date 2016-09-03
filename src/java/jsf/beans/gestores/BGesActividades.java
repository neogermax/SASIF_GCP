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
import jpa.valores.Actividades;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdActividades;


@ManagedBean(name = "bgesActividades")
@SessionScoped
public class BGesActividades implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdActividades ptdActividades = new PtdActividades();
    private Actividades actividad;
    private Actividades cActividad = new Actividades();
    private List<Actividades> actividades;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesActividades() {
        init();
        
        actividades = ptdActividades.encontrarTodos();
        if(!actividades.isEmpty()) {
            actividad = actividades.get(0);
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
        columnas.add("12");
        columnas.add("13");
        columnas.add("14");
        columnas.add("15");
        columnas.add("16");
        columnas.add("17");
        columnas.add("18");
        columnas.add("19");
        columnas.add("20");
        columnas.add("21");
        columnas.add("22");
    }
    
    private void init() {
        cActividad.setActAsign("N");
        cActividad.setActCalend("P");
        cActividad.setActComp("N");
        cActividad.setActEnlace("S");
        cActividad.setActFes("N");
        cActividad.setActCrono("N");
        cActividad.setActIcoCrono("N");
        cActividad.setActIco2("N");
        cActividad.setActIco3("N");
        cActividad.setActIco4("N");
        cActividad.setActIco5("N");
        cActividad.setActPorAlert(new Short("0"));
        cActividad.setActAsign2("S");
        cActividad.setActCrono2("S");
        cActividad.setActEstado("N");
        cActividad.setActIco6("N");
        cActividad.setActIco7("N");
        
    }
    
    public Actividades getActividad() {
        return actividad;
    }
    
    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }
    
    public Actividades getCActividad() {
        return cActividad;
    }
    
    public void setCActividad(Actividades cActividad) {
        this.cActividad = cActividad;
    }
    
    public List<Actividades> getActividades() {
        actividades = ptdActividades.encontrarTodos();
        selectActividad();
        return actividades;
    }
    
    private void selectActividad() {
        if(actividad == null && !actividades.isEmpty()) {
            actividad = actividades.get(0);
        } else if (!actividades.isEmpty()) {
            int index = actividades.indexOf(actividad);
            if(index == -1) {
                actividad = actividades.get(0);
            } else {
                actividad = actividades.get(index);
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
            
            ptdActividades.insertar(cActividad);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             actividad = cActividad;
             cActividad = new Actividades();
             init();
        } catch(Exception e) {
            
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdActividades.actualizar(actividad);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
            ptdActividades.eliminar(actividad.getActCodPk());
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
