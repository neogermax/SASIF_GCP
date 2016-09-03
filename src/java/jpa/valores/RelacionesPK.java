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

/**
 *
 * @author analista02
 */
@Embeddable
public class RelacionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "REL_CLS_COD_FK")
    private Integer relClsCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REL_SEC")
    private Integer relSec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REL_SUBSEC")
    private Integer relSubsec;

    public RelacionesPK() {
    }

    public RelacionesPK(Integer relClsCodFk, Integer relSec, Integer relSubsec) {
        this.relClsCodFk = relClsCodFk;
        this.relSec = relSec;
        this.relSubsec = relSubsec;
    }

    public Integer getRelClsCodFk() {
        return relClsCodFk;
    }

    public void setRelClsCodFk(Integer relClsCodFk) {
        this.relClsCodFk = relClsCodFk;
    }

    public Integer getRelSec() {
        return relSec;
    }

    public void setRelSec(Integer relSec) {
        this.relSec = relSec;
    }

    public Integer getRelSubsec() {
        return relSubsec;
    }

    public void setRelSubsec(Integer relSubsec) {
        this.relSubsec = relSubsec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) relClsCodFk;
        hash += (int) relSec;
        hash += (int) relSubsec;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacionesPK)) {
            return false;
        }
        RelacionesPK other = (RelacionesPK) object;
        if (this.relClsCodFk != other.relClsCodFk) {
            return false;
        }
        if (this.relSec != other.relSec) {
            return false;
        }
        if (this.relSubsec != other.relSubsec) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.RelacionesPK[ relClsCodFk=" + relClsCodFk + ", relSec=" + relSec + ", relSubsec=" + relSubsec + " ]";
    }
    
}
