/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdEtapas;

@ManagedBean(name = "bgesRelaciones")
@SessionScoped
public class BGesRelaciones implements Serializable {
    private PtdClases ptdClases = new PtdClases();
    private PtdEtapas ptdEtapas = new PtdEtapas();
    private PtdActividades ptdActividades = new PtdActividades();
    private List<Clases> clases;
    private List<Etapas> etapas;
    private List<Actividades> actividades;
    private MapaNavegacion mapa = new MapaNavegacion();
    private Clases clase;
    private Etapas etapa;
    private Actividades actividad;
    private String opcion = "1";
    
    public String getOpcion() {
        return opcion;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public MapaNavegacion getMapaNavegacion() {
        return mapa;
    }
    
    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        return clases;
    }
    
    public List<Etapas> getEtapas() {
        etapas = ptdEtapas.encontrarTodos();
        return etapas;
    }
    
    public List<Actividades> getActividades() {
        actividades = ptdActividades.encontrarTodos();
        return actividades;
    }
    
    private Clases selectClase(Clases clase) {
        int index = clases.indexOf(clase);
        return clases.get(index);
    }
    
    public Clases getClase() {
        return clase;
    }
    
    public void setClase(Clases clase) {
        this.clase = clase;
    }
    
    private Etapas selectEtapa(Etapas etapa) {
        int index = etapas.indexOf(etapa);
        return etapas.get(index);
    }
    
    public Etapas getEtapa() {
        return etapa;
    }
    
    public void setEtapa(Etapas etapa) {
        this.etapa = etapa;
    }
    
    private Actividades selectActividad(Actividades actividad) {
        int index = actividades.indexOf(actividad);
        return actividades.get(index);
    }
    
    public Actividades getActividad() {
        return actividad;
    }
    
    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }
    
    public String opcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
    
    public String addClase() {
        mapa.addClase(selectClase(clase));
        return null;
    }
    
    public String removeClase() {
        mapa.removeClase();
        return null;
    }
    
    public String addEtapa() {
        mapa.addEtapa(selectEtapa(etapa));
        return null;
    }
    
    public String removeEtapa() {
        mapa.removeEtapa();
        return null;
    }
    
    public String addActividad() {
        mapa.addActividad(selectActividad(actividad));
        return null;
    }
    
    public String removeActividad() {
        mapa.removeActividad();
        return null;
    }
    
    public String crear() {
        mapa.actualizar();
        mapa.inicio();
        UtileriaHTTP.addMessage(null, 
                   "Actualizacion exitosa", FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    public String cancelar() {
        mapa.inicio();
        return null;
    }
}
