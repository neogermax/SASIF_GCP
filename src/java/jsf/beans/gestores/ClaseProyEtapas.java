/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;
import jpa.valores.Clases;

/**
 *
 * @author analista02
 */
public class ClaseProyEtapas {
    private Clases clase;
    private List<EtapaProyActividades> etapaProyActividades = new ArrayList<EtapaProyActividades>();
    
    public Clases getClase() {
        return clase;
    }
    
    public void setClase(Clases clase) {
        this.clase = clase;
    }
    
    public List<EtapaProyActividades> getEtapaProyActividades() {
        return etapaProyActividades;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClaseProyEtapas)) {
            return false;
        }
        ClaseProyEtapas other = (ClaseProyEtapas) object;
        if ((this.clase == null && other.clase != null) || (this.clase != null && !this.clase.equals(other.clase))) {
            return false;
        }
        return true;
    }
}
