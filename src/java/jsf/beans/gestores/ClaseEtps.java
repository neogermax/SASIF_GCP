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
 * @author SAFLAP
 */
public class ClaseEtps {
    private Clases clase;
    private List<EtapaActs> etapaActs = new ArrayList<EtapaActs>();
    
    public ClaseEtps() {
    }
    
    public ClaseEtps(Clases clase) {
        this.clase = clase;
    }
    
    public Clases getClase() {
        return clase;
    }
    
    public List<EtapaActs> getEtapas() {
        return etapaActs;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ClaseEtps)) {
            return false;
        }
        ClaseEtps other = (ClaseEtps) object;
        if ((this.clase == null && other.clase != null) || (this.clase != null && !this.clase.equals(other.clase))) {
            return false;
        }
        return true;
    }
}
