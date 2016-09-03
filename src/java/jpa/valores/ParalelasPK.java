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
public class ParalelasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_CLS_COD_FK")
    private Integer parClsCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_ETP_COD_FK")
    private Integer parEtpCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_ACT_COD_FK")
    private Integer parActCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_CLS_COD")
    private Integer parClsCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_ETP_COD")
    private Integer parEtpCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_ACT_COD")
    private Integer parActCod;

    public ParalelasPK() {
    }

    public ParalelasPK(Integer parClsCodFk, Integer parEtpCodFk, Integer parActCodFk, Integer parClsCod, Integer parEtpCod, Integer parActCod) {
        this.parClsCodFk = parClsCodFk;
        this.parEtpCodFk = parEtpCodFk;
        this.parActCodFk = parActCodFk;
        this.parClsCod = parClsCod;
        this.parEtpCod = parEtpCod;
        this.parActCod = parActCod;
    }

    public Integer getParClsCodFk() {
        return parClsCodFk;
    }

    public void setParClsCodFk(Integer parClsCodFk) {
        this.parClsCodFk = parClsCodFk;
    }

    public Integer getParEtpCodFk() {
        return parEtpCodFk;
    }

    public void setParEtpCodFk(Integer parEtpCodFk) {
        this.parEtpCodFk = parEtpCodFk;
    }

    public Integer getParActCodFk() {
        return parActCodFk;
    }

    public void setParActCodFk(Integer parActCodFk) {
        this.parActCodFk = parActCodFk;
    }

    public Integer getParClsCod() {
        return parClsCod;
    }

    public void setParClsCod(Integer parClsCod) {
        this.parClsCod = parClsCod;
    }

    public Integer getParEtpCod() {
        return parEtpCod;
    }

    public void setParEtpCod(Integer parEtpCod) {
        this.parEtpCod = parEtpCod;
    }

    public Integer getParActCod() {
        return parActCod;
    }

    public void setParActCod(Integer parActCod) {
        this.parActCod = parActCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) parClsCodFk;
        hash += (int) parEtpCodFk;
        hash += (int) parActCodFk;
        hash += (int) parClsCod;
        hash += (int) parEtpCod;
        hash += (int) parActCod;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParalelasPK)) {
            return false;
        }
        ParalelasPK other = (ParalelasPK) object;
        if (this.parClsCodFk != other.parClsCodFk) {
            return false;
        }
        if (this.parEtpCodFk != other.parEtpCodFk) {
            return false;
        }
        if (this.parActCodFk != other.parActCodFk) {
            return false;
        }
        if (this.parClsCod != other.parClsCod) {
            return false;
        }
        if (this.parEtpCod != other.parEtpCod) {
            return false;
        }
        if (this.parActCod != other.parActCod) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ParalelasPK[ parClsCodFk=" + parClsCodFk + ", parEtpCodFk=" + parEtpCodFk + ", parActCodFk=" + parActCodFk + ", parClsCod=" + parClsCod + ", parEtpCod=" + parEtpCod + ", parActCod=" + parActCod + " ]";
    }
    
}
