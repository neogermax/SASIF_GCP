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
 * @author Analista02
 */
@Embeddable
public class ActItemsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACITM_ACT_COD_FK")
    private Integer acitmActCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACITM_SEC")
    private Integer acitmSec;

    public ActItemsPK() {
    }

    public ActItemsPK(Integer acitmActCodFk, Integer acitmSec) {
        this.acitmActCodFk = acitmActCodFk;
        this.acitmSec = acitmSec;
    }

    public Integer getAcitmActCodFk() {
        return acitmActCodFk;
    }

    public void setAcitmActCodFk(Integer acitmActCodFk) {
        this.acitmActCodFk = acitmActCodFk;
    }

    public Integer getAcitmSec() {
        return acitmSec;
    }

    public void setAcitmSec(Integer acitmSec) {
        this.acitmSec = acitmSec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) acitmActCodFk;
        hash += (int) acitmSec;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActItemsPK)) {
            return false;
        }
        ActItemsPK other = (ActItemsPK) object;
        if (this.acitmActCodFk != other.acitmActCodFk) {
            return false;
        }
        if (this.acitmSec != other.acitmSec) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ActItemsPK[ acitmActCodFk=" + acitmActCodFk + ", acitmSec=" + acitmSec + " ]";
    }
    
}
