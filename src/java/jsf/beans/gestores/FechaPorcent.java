/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author analista02
 */
public class FechaPorcent {
    private List<ProyectoActividades> proyActs = new ArrayList<ProyectoActividades>();
    private int porcentaje;
    private String color = "green";
    
    public List<ProyectoActividades> getProyectoActividades() {
        return proyActs;
    }
    
    private void color() {
        if(porcentaje < 50) {
            color = "green";
        } else if(porcentaje < 100) {
            color = "yellow";
        } else {
            color = "red";
        }
    }
    
    public void addPorActividad(String proyecto, String actividad, Short porcentaje, Date fechaIni, Date fechaFin) {
        ProyectoActividades proyAct = new ProyectoActividades();
        proyAct.setProyecto(proyecto);
        proyAct.setActividad(actividad);
        proyAct.setPorcentaje(porcentaje);
        proyAct.setFechaIni(fechaIni);
        proyAct.setFechaFin(fechaFin);
        proyActs.add(proyAct);
        this.porcentaje += porcentaje;
        color();
    }
    
    public int getPorcentaje() {
        return porcentaje;
    }
    
    public String getColor() {
        return color;
    }
}
