/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jpa.valores.Etapas;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Analista02
 */
public class EtapaActividades implements Serializable {
    private TreeNode node;
    private Etapas etapa;
    private List<ActividadOpciones> actividades = new ArrayList<ActividadOpciones>();
    
    public EtapaActividades() {
    }
    
    public EtapaActividades(Etapas etapa, TreeNode node) {
        this.etapa = etapa;
        this.node = node;
    }
    
    public Etapas getEtapa() {
        return etapa;
    }
    
    public TreeNode getNode() {
        return node;
    }
    
    public List<ActividadOpciones> getActividades() {
        return actividades;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EtapaActividades)) {
            return false;
        }
        EtapaActividades other = (EtapaActividades) object;
        if ((this.etapa == null && other.etapa != null) || (this.etapa != null && !this.etapa.equals(other.etapa))) {
            return false;
        }
        return true;
    }
}
