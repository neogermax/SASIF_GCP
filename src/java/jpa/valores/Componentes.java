/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Analista02
 */
@Entity
@Table(name = "COMPONENTES")
@NamedQueries({
    @NamedQuery(name = "Componentes.findAll", query = "SELECT c FROM Componentes c"),
    @NamedQuery(name = "Componentes.findByProy", query = "SELECT c FROM Componentes c WHERE c.proyectos = :proyecto")
})
public class Componentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComponentesPK componentesPK;
    @JoinColumn(name = "COM_TIP_COD_FK", referencedColumnName = "TIP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoComps tipoComps;
    @JoinColumn(name = "COM_PRO_COD_FK", referencedColumnName = "PRO_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;

    public Componentes() {
    }

    public Componentes(ComponentesPK componentesPK) {
        this.componentesPK = componentesPK;
    }

    public Componentes(Integer comProCodFk, Integer comTipCodFk, String comNomPk) {
        this.componentesPK = new ComponentesPK(comProCodFk, comTipCodFk, comNomPk);
    }

    public ComponentesPK getComponentesPK() {
        return componentesPK;
    }

    public void setComponentesPK(ComponentesPK componentesPK) {
        this.componentesPK = componentesPK;
    }

    public TipoComps getTipoComps() {
        return tipoComps;
    }

    public void setTipoComps(TipoComps tipoComps) {
        this.tipoComps = tipoComps;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (componentesPK != null ? componentesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componentes)) {
            return false;
        }
        Componentes other = (Componentes) object;
        if ((this.componentesPK == null && other.componentesPK != null) || (this.componentesPK != null && !this.componentesPK.equals(other.componentesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Componentes[ componentesPK=" + componentesPK + " ]";
    }
    
}
