/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import jpa.valores.Actividades;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Analista02
 */
public class ActividadOpciones {
    private TreeNode node;
    private Actividades actividad;
    private String opcion = "N";
    private String enlace = "N";
    
    public ActividadOpciones(Actividades actividad, TreeNode node) {
        this.actividad = actividad;
        this.node = node;
    }
    
    public TreeNode getNode() {
        return node;
    }
    
    public String getOpcion() {
        return opcion;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public String getEnlace() {
        return enlace;
    }
    
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    
    public String getComponente() {
        if(opcion.equals("N")) {
            return "";
        } else if(opcion.equals("O")) {
            return "Origen";
        } else {
            return "Paralela/" + enlace;
        }
    }
    
    public Actividades getActividad() {
        return actividad;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ActividadOpciones)) {
            return false;
        }
        ActividadOpciones other = (ActividadOpciones) object;
        if ((this.actividad == null && other.actividad != null) || (this.actividad != null && !this.actividad.equals(other.actividad))) {
            return false;
        }
        return true;
    }
}
