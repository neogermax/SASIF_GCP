/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;
import jpa.valores.Etapas;

/**
 *
 * @author analista02
 */
public class EtapaProyActividades {
    private Etapas etapa;
    private List<ActividadProyActs> actividadProyActs = new ArrayList<ActividadProyActs>();
    
    public Etapas getEtapa() {
        return etapa;
    }
    
    public void setEtapa(Etapas etapa) {
        this.etapa = etapa;
    }
    
    public List<ActividadProyActs> getActividadProyActs() {
        return actividadProyActs;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtapaProyActividades)) {
            return false;
        }
        EtapaProyActividades other = (EtapaProyActividades) object;
        if ((this.etapa == null && other.etapa != null) || (this.etapa != null && !this.etapa.equals(other.etapa))) {
            return false;
        }
        return true;
    }
}
