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
import jpa.valores.ProyActs;
import jpa.valores.Relaciones;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdRelaciones;

@ManagedBean(name = "bgesProcesos")
@SessionScoped
public class BGesProcesos implements Serializable {
    private BGesNavegacion bgesNavegacion = ((BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion"));
    private PtdRelaciones ptdRelaciones = new PtdRelaciones();
    private List<ClaseProyEtapas> clases;
    private List<EtapaProyActividades> etapas;
    private List<ActividadProyActs> actividades;
    private ClaseProyEtapas clase;
    private EtapaProyActividades etapa;
    private ActividadProyActs actividad;
    private ProyActs proyAct;
    
    public void init() {
        List<Relaciones> relaciones = ptdRelaciones.encontrarTodos();
        clases = new ArrayList<ClaseProyEtapas>();
        etapas = new ArrayList<EtapaProyActividades>();
        actividades = new ArrayList<ActividadProyActs>();
        ClaseProyEtapas clase = new ClaseProyEtapas();
        EtapaProyActividades etapa = new EtapaProyActividades();
        for(Relaciones rel : relaciones) {
            if(!rel.getClases().equals(clase.getClase())) {
                clase = new ClaseProyEtapas();
                clase.setClase(rel.getClases());
                etapas = clase.getEtapaProyActividades();
                clases.add(clase);
            }
            if(rel.getRelEtpCodFk() != null && !rel.getRelEtpCodFk().equals(etapa.getEtapa())) {
                etapa = new EtapaProyActividades();
                etapa.setEtapa(rel.getRelEtpCodFk());
                actividades = etapa.getActividadProyActs();
                etapas.add(etapa);
            }
            if(rel.getRelActCodFk() != null) {
                ActividadProyActs actividad = new ActividadProyActs(rel);
                actividades.add(actividad);
            }
        }
    }
    
    private void selectClase() {
        if(clase == null) {
            setClase(clases.get(0));
        } else {
            int index = clases.indexOf(clase);
            if(index == -1) {
                setClase(clases.get(0));
            } else {
                setClase(clases.get(index));
            }
        }
    }
    
    private void selectEtapa() {
        if(etapa == null) {
            setEtapa(etapas.get(0));
        } else {
            int index = etapas.indexOf(etapa);
            if(index == -1) {
                setEtapa(etapas.get(0));
            } else {
                setEtapa(etapas.get(index));
            }
        }
    }
    
    private void selectActividad() {
        if(actividad == null) {
            setActividad(actividades.get(0));
        } else {
            int index = actividades.indexOf(actividad);
            if(index == -1) {
                setActividad(actividades.get(0));
            } else {
                setActividad(actividades.get(index));
            }
        }
    }
    
    public List<ClaseProyEtapas> getClases() {
        if(!clases.isEmpty()) {
            selectClase();
        }
        return clases;
    }
    
    public List<EtapaProyActividades> getEtapas() {
        if(!etapas.isEmpty()) {
            selectEtapa();
        }
        return etapas;
    }
    
    public List<ActividadProyActs> getActividades() {
        if(!actividades.isEmpty()) {
            selectActividad();
        }
        return actividades;
    }
    
    private ClaseProyEtapas selectClase(ClaseProyEtapas clase) {
        int index = clases.indexOf(clase);
        return clases.get(index);
    }
    
    private EtapaProyActividades selectEtapa(EtapaProyActividades etapa) {
        int index = etapas.indexOf(etapa);
        return etapas.get(index);
    }
    
    private ActividadProyActs selectActividad(ActividadProyActs actividad) {
        int index = actividades.indexOf(actividad);
        return actividades.get(index);
    }
    
    public ClaseProyEtapas getClase() {
        return clase;
    }
    
    public void setClase(ClaseProyEtapas clase) {
        if(clase != null) {
            this.clase = selectClase(clase);
            etapas = this.clase.getEtapaProyActividades();
        } else {
            this.clase = null;
        }
    }
    
    public EtapaProyActividades getEtapa() {
        return etapa;
    }
    
    public void setEtapa(EtapaProyActividades etapa) {
        if(etapa != null) {
            this.etapa = selectEtapa(etapa);
            actividades = this.etapa.getActividadProyActs();
        } else {
            this.etapas = null;
            actividades = new ArrayList<ActividadProyActs>();
        }
    }
    
    public ActividadProyActs getActividad() {
        return actividad;
    }
    
    public void setActividad(ActividadProyActs actividad) {
        this.actividad = selectActividad(actividad);
        if(actividad.getProyActs().isEmpty()) {
            proyAct = null;
        } else {
            selectProyActs();
        }
    }
    
    private void selectProyActs() {
        if(proyAct == null) {
            setProyecto(actividad.getProyActs().get(0));
        } else {
            int index = actividad.getProyActs().indexOf(proyAct);
            if(index == -1) {
                setProyecto(actividad.getProyActs().get(0));
            } else {
                setProyecto(actividad.getProyActs().get(index));
            }
        }
    }
    
    public ProyActs getProyecto() {
        return proyAct;
    }
    
    public void setProyecto(ProyActs proyAct) {
        this.proyAct = proyAct;
    }
    
    public String action() {
        if(proyAct != null) {
            bgesNavegacion.trabajarProyecto(proyAct);
        } else {
            UtileriaHTTP.addMessage(null, "No existen proyectos disponibles para trabajar.",
                    FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
}
