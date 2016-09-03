/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import jpa.valores.Componentes;
import jpa.valores.Relaciones;

public class ActividadComponente {
    private Relaciones relacion;
    private Componentes componente;
    
    public Relaciones getRelacion() {
        return relacion;
    }
    
    public void setRelacion(Relaciones relacion) {
        this.relacion = relacion;
    }
    
    public Componentes getComponente() {
        return componente;
    }
    
    public void setComponente(Componentes componente) {
        this.componente = componente;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadComponente)) {
            return false;
        }
        ActividadComponente other = (ActividadComponente) object;
        if ((this.relacion == null && other.relacion != null) || (this.relacion != null && !this.relacion.equals(other.relacion))) {
            return false;
        }
        if ((this.componente == null && other.componente != null) || (this.componente != null && !this.componente.equals(other.componente))) {
            return false;
        }
        return true;
    }
}
