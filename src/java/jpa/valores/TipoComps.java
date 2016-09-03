/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Analista02
 */
@Entity
@Table(name = "TIPO_COMPS")
@NamedQueries({
    @NamedQuery(name = "TipoComps.findAll", query = "SELECT t FROM TipoComps t")})
public class TipoComps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIP_COD_PK")
    private Integer tipCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TIP_NOMBRE")
    private String tipNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoComps")
    private List<Componentes> componentesList;

    public TipoComps() {
    }

    public TipoComps(Integer tipCodPk) {
        this.tipCodPk = tipCodPk;
    }

    public TipoComps(Integer tipCodPk, String tipNombre) {
        this.tipCodPk = tipCodPk;
        this.tipNombre = tipNombre;
    }

    public Integer getTipCodPk() {
        return tipCodPk;
    }

    public void setTipCodPk(Integer tipCodPk) {
        this.tipCodPk = tipCodPk;
    }

    public String getTipNombre() {
        return tipNombre;
    }

    public void setTipNombre(String tipNombre) {
        this.tipNombre = tipNombre;
    }

    public List<Componentes> getComponentesList() {
        return componentesList;
    }

    public void setComponentesList(List<Componentes> componentesList) {
        this.componentesList = componentesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCodPk != null ? tipCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComps)) {
            return false;
        }
        TipoComps other = (TipoComps) object;
        if ((this.tipCodPk == null && other.tipCodPk != null) || (this.tipCodPk != null && !this.tipCodPk.equals(other.tipCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.TipoComps[ tipCodPk=" + tipCodPk + " ]";
    }
    
}
