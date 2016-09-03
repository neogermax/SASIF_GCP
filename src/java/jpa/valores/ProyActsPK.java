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
public class ProyActsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_PRO_COD_FK")
    private Integer pryProCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_CLS_COD_FK")
    private Integer pryClsCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_ETP_COD_FK")
    private Integer pryEtpCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_ACT_COD_FK")
    private Integer pryActCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRY_COM_NOM_FK")
    private String pryComNomFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_COM_TIP_FK")
    private Integer pryComTipFk;

    public ProyActsPK() {
    }

    public ProyActsPK(Integer pryProCodFk, Integer pryClsCodFk, Integer pryEtpCodFk, Integer pryActCodFk, String pryComNomFk, Integer pryComTipFk) {
        this.pryProCodFk = pryProCodFk;
        this.pryClsCodFk = pryClsCodFk;
        this.pryEtpCodFk = pryEtpCodFk;
        this.pryActCodFk = pryActCodFk;
        this.pryComNomFk = pryComNomFk;
        this.pryComTipFk = pryComTipFk;
    }

    public Integer getPryProCodFk() {
        return pryProCodFk;
    }

    public void setPryProCodFk(Integer pryProCodFk) {
        this.pryProCodFk = pryProCodFk;
    }

    public Integer getPryClsCodFk() {
        return pryClsCodFk;
    }

    public void setPryClsCodFk(Integer pryClsCodFk) {
        this.pryClsCodFk = pryClsCodFk;
    }

    public Integer getPryEtpCodFk() {
        return pryEtpCodFk;
    }

    public void setPryEtpCodFk(Integer pryEtpCodFk) {
        this.pryEtpCodFk = pryEtpCodFk;
    }

    public Integer getPryActCodFk() {
        return pryActCodFk;
    }

    public void setPryActCodFk(Integer pryActCodFk) {
        this.pryActCodFk = pryActCodFk;
    }

    public String getPryComNomFk() {
        return pryComNomFk;
    }

    public void setPryComNomFk(String pryComNomFk) {
        this.pryComNomFk = pryComNomFk;
    }

    public Integer getPryComTipFk() {
        return pryComTipFk;
    }

    public void setPryComTipFk(Integer pryComTipFk) {
        this.pryComTipFk = pryComTipFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pryProCodFk;
        hash += (int) pryClsCodFk;
        hash += (int) pryEtpCodFk;
        hash += (int) pryActCodFk;
        hash += (pryComNomFk != null ? pryComNomFk.hashCode() : 0);
        hash += (int) pryComTipFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyActsPK)) {
            return false;
        }
        ProyActsPK other = (ProyActsPK) object;
        if (this.pryProCodFk != other.pryProCodFk) {
            return false;
        }
        if (this.pryClsCodFk != other.pryClsCodFk) {
            return false;
        }
        if (this.pryEtpCodFk != other.pryEtpCodFk) {
            return false;
        }
        if (this.pryActCodFk != other.pryActCodFk) {
            return false;
        }
        if ((this.pryComNomFk == null && other.pryComNomFk != null) || (this.pryComNomFk != null && !this.pryComNomFk.equals(other.pryComNomFk))) {
            return false;
        }
        if (this.pryComTipFk != other.pryComTipFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ProyActsPK[ pryProCodFk=" + pryProCodFk + ", pryClsCodFk=" + pryClsCodFk + ", pryEtpCodFk=" + pryEtpCodFk + ", pryActCodFk=" + pryActCodFk + ", pryComNomFk=" + pryComNomFk + ", pryComTipFk=" + pryComTipFk + " ]";
    }
    
}
