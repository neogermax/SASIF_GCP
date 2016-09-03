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
 * @author analista03
 */
@Embeddable
public class AccesoRepUsuPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ARU_USU_COD_FK")
    private String aruUsuCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARU_COD_REP_FK")
    private Integer aruCodRepFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARU_GRP_COD_FK")
    private Integer aruGrpCodFk;

    public AccesoRepUsuPK() {
    }

    public AccesoRepUsuPK(String aruUsuCodFk, Integer aruCodRepFk, Integer aruGrpCodFk) {
        this.aruUsuCodFk = aruUsuCodFk;
        this.aruCodRepFk = aruCodRepFk;
        this.aruGrpCodFk = aruGrpCodFk;
    }

    public String getAruUsuCodFk() {
        return aruUsuCodFk;
    }

    public void setAruUsuCodFk(String aruUsuCodFk) {
        this.aruUsuCodFk = aruUsuCodFk;
    }

    public Integer getAruCodRepFk() {
        return aruCodRepFk;
    }

    public void setAruCodRepFk(Integer aruCodRepFk) {
        this.aruCodRepFk = aruCodRepFk;
    }

    public Integer getAruGrpCodFk() {
        return aruGrpCodFk;
    }

    public void setAruGrpCodFk(Integer aruGrpCodFk) {
        this.aruGrpCodFk = aruGrpCodFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aruUsuCodFk != null ? aruUsuCodFk.hashCode() : 0);
        hash += (int) aruCodRepFk;
        hash += (int) aruGrpCodFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccesoRepUsuPK)) {
            return false;
        }
        AccesoRepUsuPK other = (AccesoRepUsuPK) object;
        if ((this.aruUsuCodFk == null && other.aruUsuCodFk != null) || (this.aruUsuCodFk != null && !this.aruUsuCodFk.equals(other.aruUsuCodFk))) {
            return false;
        }
        if (this.aruCodRepFk != other.aruCodRepFk) {
            return false;
        }
        if (this.aruGrpCodFk != other.aruGrpCodFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.AccesoRepUsuPK[ aruUsuCodFk=" + aruUsuCodFk + ", aruCodRepFk=" + aruCodRepFk + ", aruGrpCodFk=" + aruGrpCodFk + " ]";
    }
    
}
