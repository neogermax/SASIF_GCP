/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "GRUPO_REPORTES")
@NamedQueries({
    @NamedQuery(name = "GrupoReportes.findAll", query = "SELECT g FROM GrupoReportes g")})
public class GrupoReportes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRP_COD_PK")
    private Integer grpCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "GRP_DESCRIP")
    private String grpDescrip;

    public GrupoReportes() {
    }

    public GrupoReportes(Integer grpCodPk) {
        this.grpCodPk = grpCodPk;
    }

    public GrupoReportes(Integer grpCodPk, String grpDescrip) {
        this.grpCodPk = grpCodPk;
        this.grpDescrip = grpDescrip;
    }

    public Integer getGrpCodPk() {
        return grpCodPk;
    }

    public void setGrpCodPk(Integer grpCodPk) {
        this.grpCodPk = grpCodPk;
    }

    public String getGrpDescrip() {
        return grpDescrip;
    }

    public void setGrpDescrip(String grpDescrip) {
        this.grpDescrip = grpDescrip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grpCodPk != null ? grpCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoReportes)) {
            return false;
        }
        GrupoReportes other = (GrupoReportes) object;
        if ((this.grpCodPk == null && other.grpCodPk != null) || (this.grpCodPk != null && !this.grpCodPk.equals(other.grpCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.GrupoReportes[ grpCodPk=" + grpCodPk + " ]";
    }
    
}
