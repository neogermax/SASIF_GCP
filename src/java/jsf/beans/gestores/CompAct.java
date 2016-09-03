/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.List;
import jpa.valores.Componentes;
import jpa.valores.ProyActs;

/**
 *
 * @author analista02
 */
public class CompAct {
    private Componentes componente;
    private List<ProyActs> proyActs;
    
    public Componentes getComponente() {
        return componente;
    }
    
    public void setComponente(Componentes componente) {
        this.componente = componente;
    }
    
    public List<ProyActs> getProyActs() {
        return proyActs;
    }
    
    public void setProyActs(List<ProyActs> proyActs) {
        this.proyActs = proyActs;
    }
    
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompAct)) {
            return false;
        }
        CompAct other = (CompAct) object;
        if ((this.componente == null && other.componente != null) || (this.componente != null && !this.componente.equals(other.componente))) {
            return false;
        }
        return true;
    }
}
