/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.math.BigDecimal;
import jpa.valores.Relaciones;
import org.primefaces.event.SlideEndEvent;

/**
 *
 * @author analista02
 */
public class PermisoUsuario {
    private Relaciones relacion;
    private String actividad;
    private String usuario;
    private String empleado;
    private int porcentaje;
    private String empresaArea;
    private String grupo;
    private String comNom;
    private Integer comTip;
    
    public String getActividad() {
        return actividad;
    }
    
    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
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
    
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    public int getPorcentaje() {
        return porcentaje;
    }
    
    public String getEmpresaArea() {
        return empresaArea;
    }
    
    public void setEmpresaArea(String empresaArea) {
        this.empresaArea = empresaArea;
    }
    
    public String getGrupo() {
        return grupo;
    }
    
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    public String getComNom() {
        return comNom;
    }
    
    public void setComNom(String comNom) {
        this.comNom = comNom;
    }
    
    public Integer getComTip() {
        return comTip;
    }
    
    public void setComTip(Integer comTip) {
        this.comTip = comTip;
    }
    
    public Relaciones getRelacion() {
        return relacion;
    }
    
    public void setRelacion(Relaciones relacion) {
        this.relacion = relacion;
    }
    
    public void onSlideEnd(SlideEndEvent event) {
        porcentaje = event.getValue();
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoUsuario)) {
            return false;
        }
        PermisoUsuario other = (PermisoUsuario) object;
        if ((this.actividad == null && other.actividad != null) || (this.actividad != null && !this.actividad.equals(other.actividad))) {
            return false;
        }
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }
}
