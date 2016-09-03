/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Embeddable
public class GrupoUsuariosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRP_COD_PK")
    private Integer grpCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "GRP_USU_COD_PK")
    private String grpUsuCodPk;

    public GrupoUsuariosPK() {
    }

    public GrupoUsuariosPK(Integer grpCodPk, String grpUsuCodPk) {
        this.grpCodPk = grpCodPk;
        this.grpUsuCodPk = grpUsuCodPk;
    }

    public Integer getGrpCodPk() {
        return grpCodPk;
    }

    public void setGrpCodPk(Integer grpCodPk) {
        this.grpCodPk = grpCodPk;
    }

    public String getGrpUsuCodPk() {
        return grpUsuCodPk;
    }

    public void setGrpUsuCodPk(String grpUsuCodPk) {
        this.grpUsuCodPk = grpUsuCodPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) grpCodPk;
        hash += (grpUsuCodPk != null ? grpUsuCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoUsuariosPK)) {
            return false;
        }
        GrupoUsuariosPK other = (GrupoUsuariosPK) object;
        if (this.grpCodPk != other.grpCodPk) {
            return false;
        }
        if ((this.grpUsuCodPk == null && other.grpUsuCodPk != null) || (this.grpUsuCodPk != null && !this.grpUsuCodPk.equals(other.grpUsuCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.GrupoUsuariosPK[ grpCodPk=" + grpCodPk + ", grpUsuCodPk=" + grpUsuCodPk + " ]";
    }
    
}
