/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;
import jpa.valores.Actividades;
import jpa.valores.Etapas;

/**
 *
 * @author SAFLAP
 */
public class EtapaActs {
    private Etapas etapa;
    private List<Actividades> actividades = new ArrayList<Actividades>();
    
    public EtapaActs() {
    }
    
    public EtapaActs(Etapas etapa) {
        this.etapa = etapa;
    }
    
    public Etapas getEtapa() {
        return etapa;
    }
    
    public List<Actividades> getActividades() {
        return actividades;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EtapaActs)) {
            return false;
        }
        EtapaActs other = (EtapaActs) object;
        if ((this.etapa == null && other.etapa != null) || (this.etapa != null && !this.etapa.equals(other.etapa))) {
            return false;
        }
        return true;
    }
}
