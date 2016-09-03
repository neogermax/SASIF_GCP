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
 * @author analista03
 */
@Embeddable
public class AsignActsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIGN_ORG_CLS_FK")
    private int asignOrgClsFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIGN_ORG_ETP_FK")
    private int asignOrgEtpFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIGN_ORG_ACT_FK")
    private int asignOrgActFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIGN_DES_CLS_FK")
    private int asignDesClsFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIGN_DES_ETP_FK")
    private int asignDesEtpFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASIGN_DES_ACT_FK")
    private int asignDesActFk;

    public AsignActsPK() {
    }

    public AsignActsPK(int asignOrgClsFk, int asignOrgEtpFk, int asignOrgActFk, int asignDesClsFk, int asignDesEtpFk, int asignDesActFk) {
        this.asignOrgClsFk = asignOrgClsFk;
        this.asignOrgEtpFk = asignOrgEtpFk;
        this.asignOrgActFk = asignOrgActFk;
        this.asignDesClsFk = asignDesClsFk;
        this.asignDesEtpFk = asignDesEtpFk;
        this.asignDesActFk = asignDesActFk;
    }

    public int getAsignOrgClsFk() {
        return asignOrgClsFk;
    }

    public void setAsignOrgClsFk(int asignOrgClsFk) {
        this.asignOrgClsFk = asignOrgClsFk;
    }

    public int getAsignOrgEtpFk() {
        return asignOrgEtpFk;
    }

    public void setAsignOrgEtpFk(int asignOrgEtpFk) {
        this.asignOrgEtpFk = asignOrgEtpFk;
    }

    public int getAsignOrgActFk() {
        return asignOrgActFk;
    }

    public void setAsignOrgActFk(int asignOrgActFk) {
        this.asignOrgActFk = asignOrgActFk;
    }

    public int getAsignDesClsFk() {
        return asignDesClsFk;
    }

    public void setAsignDesClsFk(int asignDesClsFk) {
        this.asignDesClsFk = asignDesClsFk;
    }

    public int getAsignDesEtpFk() {
        return asignDesEtpFk;
    }

    public void setAsignDesEtpFk(int asignDesEtpFk) {
        this.asignDesEtpFk = asignDesEtpFk;
    }

    public int getAsignDesActFk() {
        return asignDesActFk;
    }

    public void setAsignDesActFk(int asignDesActFk) {
        this.asignDesActFk = asignDesActFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) asignOrgClsFk;
        hash += (int) asignOrgEtpFk;
        hash += (int) asignOrgActFk;
        hash += (int) asignDesClsFk;
        hash += (int) asignDesEtpFk;
        hash += (int) asignDesActFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignActsPK)) {
            return false;
        }
        AsignActsPK other = (AsignActsPK) object;
        if (this.asignOrgClsFk != other.asignOrgClsFk) {
            return false;
        }
        if (this.asignOrgEtpFk != other.asignOrgEtpFk) {
            return false;
        }
        if (this.asignOrgActFk != other.asignOrgActFk) {
            return false;
        }
        if (this.asignDesClsFk != other.asignDesClsFk) {
            return false;
        }
        if (this.asignDesEtpFk != other.asignDesEtpFk) {
            return false;
        }
        if (this.asignDesActFk != other.asignDesActFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.AsignActsPK[ asignOrgClsFk=" + asignOrgClsFk + ", asignOrgEtpFk=" + asignOrgEtpFk + ", asignOrgActFk=" + asignOrgActFk + ", asignDesClsFk=" + asignDesClsFk + ", asignDesEtpFk=" + asignDesEtpFk + ", asignDesActFk=" + asignDesActFk + " ]";
    }
    
}
