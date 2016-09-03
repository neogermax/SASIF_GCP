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
public class ResponsablesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_PRO_COD_FK")
    private Integer resProCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_CLS_COD_FK")
    private Integer resClsCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_ETP_COD_FK")
    private Integer resEtpCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_ACT_COD_FK")
    private Integer resActCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RES_USU_COD_FK")
    private String resUsuCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RES_COMP_PK")
    private String resCompPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RES_TIP_COMP_PK")
    private Integer resTipCompPk;

    public ResponsablesPK() {
    }

    public ResponsablesPK(Integer resProCodFk, Integer resClsCodFk, Integer resEtpCodFk, Integer resActCodFk, String resUsuCodFk, String resCompPk, Integer resTipCompPk) {
        this.resProCodFk = resProCodFk;
        this.resClsCodFk = resClsCodFk;
        this.resEtpCodFk = resEtpCodFk;
        this.resActCodFk = resActCodFk;
        this.resUsuCodFk = resUsuCodFk;
        this.resCompPk = resCompPk;
        this.resTipCompPk = resTipCompPk;
    }

    public Integer getResProCodFk() {
        return resProCodFk;
    }

    public void setResProCodFk(Integer resProCodFk) {
        this.resProCodFk = resProCodFk;
    }

    public Integer getResClsCodFk() {
        return resClsCodFk;
    }

    public void setResClsCodFk(Integer resClsCodFk) {
        this.resClsCodFk = resClsCodFk;
    }

    public Integer getResEtpCodFk() {
        return resEtpCodFk;
    }

    public void setResEtpCodFk(Integer resEtpCodFk) {
        this.resEtpCodFk = resEtpCodFk;
    }

    public Integer getResActCodFk() {
        return resActCodFk;
    }

    public void setResActCodFk(Integer resActCodFk) {
        this.resActCodFk = resActCodFk;
    }

    public String getResUsuCodFk() {
        return resUsuCodFk;
    }

    public void setResUsuCodFk(String resUsuCodFk) {
        this.resUsuCodFk = resUsuCodFk;
    }

    public String getResCompPk() {
        return resCompPk;
    }

    public void setResCompPk(String resCompPk) {
        this.resCompPk = resCompPk;
    }

    public Integer getResTipCompPk() {
        return resTipCompPk;
    }

    public void setResTipCompPk(Integer resTipCompPk) {
        this.resTipCompPk = resTipCompPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) resProCodFk;
        hash += (int) resClsCodFk;
        hash += (int) resEtpCodFk;
        hash += (int) resActCodFk;
        hash += (resUsuCodFk != null ? resUsuCodFk.hashCode() : 0);
        hash += (resCompPk != null ? resCompPk.hashCode() : 0);
        hash += (resTipCompPk != null ? resTipCompPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsablesPK)) {
            return false;
        }
        ResponsablesPK other = (ResponsablesPK) object;
        if (this.resProCodFk != other.resProCodFk) {
            return false;
        }
        if (this.resClsCodFk != other.resClsCodFk) {
            return false;
        }
        if (this.resEtpCodFk != other.resEtpCodFk) {
            return false;
        }
        if (this.resActCodFk != other.resActCodFk) {
            return false;
        }
        if ((this.resUsuCodFk == null && other.resUsuCodFk != null) || (this.resUsuCodFk != null && !this.resUsuCodFk.equals(other.resUsuCodFk))) {
            return false;
        }
        if ((this.resCompPk == null && other.resCompPk != null) || (this.resCompPk != null && !this.resCompPk.equals(other.resCompPk))) {
            return false;
        }
        if ((this.resTipCompPk == null && other.resTipCompPk != null) || (this.resTipCompPk != null && !this.resTipCompPk.equals(other.resTipCompPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ResponsablesPK[ resProCodFk=" + resProCodFk + ", resClsCodFk=" + resClsCodFk + ", resEtpCodFk=" + resEtpCodFk + ", resActCodFk=" + resActCodFk + ", resUsuCodFk=" + resUsuCodFk + ", resCompPk=" + resCompPk + ", resTipCompPk=" + resTipCompPk + " ]";
    }
    
}
