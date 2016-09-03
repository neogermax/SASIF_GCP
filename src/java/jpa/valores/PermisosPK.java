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
public class PermisosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PER_USU_FK")
    private String perUsuFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_CLS_COD_FK")
    private Integer perClsCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ETP_COD_FK")
    private Integer perEtpCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PER_ACT_COD_FK")
    private Integer perActCodFk;

    public PermisosPK() {
    }

    public PermisosPK(String perUsuFk, Integer perClsCodFk, Integer perEtpCodFk, Integer perActCodFk) {
        this.perUsuFk = perUsuFk;
        this.perClsCodFk = perClsCodFk;
        this.perEtpCodFk = perEtpCodFk;
        this.perActCodFk = perActCodFk;
    }

    public String getPerUsuFk() {
        return perUsuFk;
    }

    public void setPerUsuFk(String perUsuFk) {
        this.perUsuFk = perUsuFk;
    }

    public Integer getPerClsCodFk() {
        return perClsCodFk;
    }

    public void setPerClsCodFk(Integer perClsCodFk) {
        this.perClsCodFk = perClsCodFk;
    }

    public Integer getPerEtpCodFk() {
        return perEtpCodFk;
    }

    public void setPerEtpCodFk(Integer perEtpCodFk) {
        this.perEtpCodFk = perEtpCodFk;
    }

    public Integer getPerActCodFk() {
        return perActCodFk;
    }

    public void setPerActCodFk(Integer perActCodFk) {
        this.perActCodFk = perActCodFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perUsuFk != null ? perUsuFk.hashCode() : 0);
        hash += (int) perClsCodFk;
        hash += (int) perEtpCodFk;
        hash += (int) perActCodFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosPK)) {
            return false;
        }
        PermisosPK other = (PermisosPK) object;
        if ((this.perUsuFk == null && other.perUsuFk != null) || (this.perUsuFk != null && !this.perUsuFk.equals(other.perUsuFk))) {
            return false;
        }
        if ((this.perClsCodFk == null && other.perClsCodFk != null) || (this.perClsCodFk != null && !this.perClsCodFk.equals(other.perClsCodFk))) {
            return false;
        }
        if ((this.perEtpCodFk == null && other.perEtpCodFk != null) || (this.perEtpCodFk != null && !this.perEtpCodFk.equals(other.perEtpCodFk))) {
            return false;
        }
        if ((this.perActCodFk == null && other.perActCodFk != null) || (this.perActCodFk != null && !this.perActCodFk.equals(other.perActCodFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.PermisosPK[ perUsuFk=" + perUsuFk + ", perClsCodFk=" + perClsCodFk + ", perEtpCodFk=" + perEtpCodFk + ", perActCodFk=" + perActCodFk + " ]";
    }
    
}
