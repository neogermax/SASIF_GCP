/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.Date;

/**
 *
 * @author analista02
 */
public class ProyectoActividades {
    private String proyecto;
    private String actividad;
    private Short porcentaje;
    private Date fechaIni;
    private Date fechaFin;
    
    public String getProyecto() {
        return proyecto;
    }
    
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }
    
    public String getActividad() {
        return actividad;
    }
    
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    public Short getPorcentaje() {
        return porcentaje;
    }
    
    public void setPorcentaje(Short porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public Date getFechaIni() {
        return fechaIni;
    }
    
    public void setFechaIni(Date fechaIni) {
        this.fechaIni = fechaIni;
    }
    
    public Date getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
