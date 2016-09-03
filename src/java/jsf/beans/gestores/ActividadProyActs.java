/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;
import jpa.valores.Actividades;
import jpa.valores.ProyActs;
import jpa.valores.Relaciones;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdProyActs;

/**
 *
 * @author analista02
 */
public class ActividadProyActs {
    private String usuario = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private Actividades actividad;
    private List<ProyActs> proyActs = new ArrayList<ProyActs>();
    
    public ActividadProyActs(Relaciones relacion) {
        actividad = relacion.getRelActCodFk();
        PermisosAct permisos = new PermisosAct();
        List<ProyActs> prs = ptdProyActs.encontrarActDisp(relacion.getClases(), relacion.getRelEtpCodFk(), actividad);
        for(ProyActs p : prs) {
            if(permisos.permiso(p, usuario)) {
                proyActs.add(p);
            }
        }
    }
    
    public Actividades getActividad() {
        return actividad;
    }
    
    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }
    
    public List<ProyActs> getProyActs() {
        return proyActs;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadProyActs)) {
            return false;
        }
        ActividadProyActs other = (ActividadProyActs) object;
        if ((this.actividad == null && other.actividad != null) || (this.actividad != null && !this.actividad.equals(other.actividad))) {
            return false;
        }
        return true;
    }
}
