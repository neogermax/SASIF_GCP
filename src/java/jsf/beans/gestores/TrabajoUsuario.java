/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author analista02
 */
public class TrabajoUsuario {
    private String usuario;
    private String empleado;
    private List<ProyectoActividades> proyActs = new ArrayList<ProyectoActividades>();
    private FechaPorcent[] valores;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getEmpleado() {
        return empleado;
    }
    
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    public int getProyPend() {
        return proyActs.size();
    }
    
    public List<ProyectoActividades> getProyectoActividades() {
        return proyActs;
    }
    
    public FechaPorcent[] getValores() {
        return valores;
    }
    
    public void setValores(FechaPorcent[] valores) {
        this.valores = valores;
    }
    
    public void addActividad(String proyecto, String actividad, Short porcentaje) {
        ProyectoActividades proyAct = new ProyectoActividades();
        proyAct.setProyecto(proyecto);
        proyAct.setActividad(actividad);
        proyAct.setPorcentaje(porcentaje);
        proyActs.add(proyAct);
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TrabajoUsuario)) {
            return false;
        }
        TrabajoUsuario other = (TrabajoUsuario) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }
}
