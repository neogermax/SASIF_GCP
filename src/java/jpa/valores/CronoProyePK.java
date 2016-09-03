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
public class CronoProyePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CROPRO_PRO_COD_FK")
    private Integer croproProCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CROPRO_CLS_COD_FK")
    private Integer croproClsCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CROPRO_ETP_COD_FK")
    private Integer croproEtpCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CROPRO_ACT_COD_FK")
    private Integer croproActCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CROPRO_COM_NOM_FK")
    private String croproComNomFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CROPRO_TIP_COD_FK")
    private Integer croproTipCodFk;

    public CronoProyePK() {
    }

    public CronoProyePK(Integer croproProCodFk, Integer croproClsCodFk, Integer croproEtpCodFk, Integer croproActCodFk, String croproComNomFk, Integer croproTipCodFk) {
        this.croproProCodFk = croproProCodFk;
        this.croproClsCodFk = croproClsCodFk;
        this.croproEtpCodFk = croproEtpCodFk;
        this.croproActCodFk = croproActCodFk;
        this.croproComNomFk = croproComNomFk;
        this.croproTipCodFk = croproTipCodFk;
    }

    public Integer getCroproProCodFk() {
        return croproProCodFk;
    }

    public void setCroproProCodFk(Integer croproProCodFk) {
        this.croproProCodFk = croproProCodFk;
    }

    public Integer getCroproClsCodFk() {
        return croproClsCodFk;
    }

    public void setCroproClsCodFk(Integer croproClsCodFk) {
        this.croproClsCodFk = croproClsCodFk;
    }

    public Integer getCroproEtpCodFk() {
        return croproEtpCodFk;
    }

    public void setCroproEtpCodFk(Integer croproEtpCodFk) {
        this.croproEtpCodFk = croproEtpCodFk;
    }

    public Integer getCroproActCodFk() {
        return croproActCodFk;
    }

    public void setCroproActCodFk(Integer croproActCodFk) {
        this.croproActCodFk = croproActCodFk;
    }

    public String getCroproComNomFk() {
        return croproComNomFk;
    }

    public void setCroproComNomFk(String croproComNomFk) {
        this.croproComNomFk = croproComNomFk;
    }

    public Integer getCroproTipCodFk() {
        return croproTipCodFk;
    }

    public void setCroproTipCodFk(Integer croproTipCodFk) {
        this.croproTipCodFk = croproTipCodFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) croproProCodFk;
        hash += (int) croproClsCodFk;
        hash += (int) croproEtpCodFk;
        hash += (int) croproActCodFk;
        hash += (croproComNomFk != null ? croproComNomFk.hashCode() : 0);
        hash += (int) croproTipCodFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CronoProyePK)) {
            return false;
        }
        CronoProyePK other = (CronoProyePK) object;
        if (this.croproProCodFk != other.croproProCodFk) {
            return false;
        }
        if (this.croproClsCodFk != other.croproClsCodFk) {
            return false;
        }
        if (this.croproEtpCodFk != other.croproEtpCodFk) {
            return false;
        }
        if (this.croproActCodFk != other.croproActCodFk) {
            return false;
        }
        if ((this.croproComNomFk == null && other.croproComNomFk != null) || (this.croproComNomFk != null && !this.croproComNomFk.equals(other.croproComNomFk))) {
            return false;
        }
        if (this.croproTipCodFk != other.croproTipCodFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.CronoProyePK[ croproProCodFk=" + croproProCodFk + ", croproClsCodFk=" + croproClsCodFk + ", croproEtpCodFk=" + croproEtpCodFk + ", croproActCodFk=" + croproActCodFk + ", croproComNomFk=" + croproComNomFk + ", croproTipCodFk=" + croproTipCodFk + " ]";
    }
    
}
