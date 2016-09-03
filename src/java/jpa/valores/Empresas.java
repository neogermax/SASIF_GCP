/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "EMPRESAS")
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e ORDER BY e.emprCodigoPk")})
public class Empresas implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPR_IDENT")
    private Long emprIdent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresas")
    private Collection<Areas> areasCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPR_CODIGO_PK")
    private Integer emprCodigoPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMPR_NOMBRE")
    private String emprNombre;
    @JoinColumn(name = "EMPR_GRUP_POL_FK", referencedColumnName = "POL_COD_PK")
    @ManyToOne
    private PoliticaGrupos emprGrupPolFk;

    public Empresas() {
    }

    public Empresas(Integer emprCodigoPk) {
        this.emprCodigoPk = emprCodigoPk;
    }

    public Empresas(Integer emprCodigoPk, String emprNombre, Long emprIdent) {
        this.emprCodigoPk = emprCodigoPk;
        this.emprNombre = emprNombre;
        this.emprIdent = emprIdent;
    }

    public Integer getEmprCodigoPk() {
        return emprCodigoPk;
    }

    public void setEmprCodigoPk(Integer emprCodigoPk) {
        this.emprCodigoPk = emprCodigoPk;
    }

    public String getEmprNombre() {
        return emprNombre;
    }

    public void setEmprNombre(String emprNombre) {
        this.emprNombre = emprNombre;
    }

    public Long getEmprIdent() {
        return emprIdent;
    }

    public void setEmprIdent(Long emprIdent) {
        this.emprIdent = emprIdent;
    }

    public PoliticaGrupos getEmprGrupPolFk() {
        return emprGrupPolFk;
    }

    public void setEmprGrupPolFk(PoliticaGrupos emprGrupPolFk) {
        this.emprGrupPolFk = emprGrupPolFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emprCodigoPk != null ? emprCodigoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.emprCodigoPk == null && other.emprCodigoPk != null) || (this.emprCodigoPk != null && !this.emprCodigoPk.equals(other.emprCodigoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Empresas[ emprCodigoPk=" + emprCodigoPk + " ]";
    }

    public Collection<Areas> getAreasCollection() {
        return areasCollection;
    }

    public void setAreasCollection(Collection<Areas> areasCollection) {
        this.areasCollection = areasCollection;
    }
    
}
