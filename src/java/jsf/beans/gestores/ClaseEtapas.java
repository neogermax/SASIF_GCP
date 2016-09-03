/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jpa.valores.Clases;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Analista02
 */
public class ClaseEtapas implements Serializable {
    private TreeNode node;
    private Clases clase;
    private List<EtapaActividades> etapas = new ArrayList<EtapaActividades>();
    
    public ClaseEtapas() {
    }
    
    public ClaseEtapas(Clases clase, TreeNode node) {
        this.clase = clase;
        this.node = node;
    }
    
    public Clases getClase() {
        return clase;
    }
    
    public TreeNode getNode() {
        return node;
    }
    
    public List<EtapaActividades> getEtapas() {
        return etapas;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ClaseEtapas)) {
            return false;
        }
        ClaseEtapas other = (ClaseEtapas) object;
        if ((this.clase == null && other.clase != null) || (this.clase != null && !this.clase.equals(other.clase))) {
            return false;
        }
        return true;
    }
}
