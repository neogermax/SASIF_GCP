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
 * @author saflap
 */
@Embeddable
public class FestivosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FES_ANO_PK")
    private Short fesAnoPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FES_MESDIA_PK")
    private Short fesMesdiaPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FES_COD_PK")
    private Integer fesCodPk;

    public FestivosPK() {
    }

    public FestivosPK(Short fesAnoPk, Short fesMesdiaPk, Integer fesCodPk) {
        this.fesAnoPk = fesAnoPk;
        this.fesMesdiaPk = fesMesdiaPk;
        this.fesCodPk = fesCodPk;
    }

    public Short getFesAnoPk() {
        return fesAnoPk;
    }

    public void setFesAnoPk(Short fesAnoPk) {
        this.fesAnoPk = fesAnoPk;
    }

    public Short getFesMesdiaPk() {
        return fesMesdiaPk;
    }

    public void setFesMesdiaPk(Short fesMesdiaPk) {
        this.fesMesdiaPk = fesMesdiaPk;
    }

    public Integer getFesCodPk() {
        return fesCodPk;
    }

    public void setFesCodPk(Integer fesCodPk) {
        this.fesCodPk = fesCodPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fesAnoPk;
        hash += (int) fesMesdiaPk;
        hash += (int) fesCodPk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FestivosPK)) {
            return false;
        }
        FestivosPK other = (FestivosPK) object;
        if (this.fesAnoPk != other.fesAnoPk) {
            return false;
        }
        if (this.fesMesdiaPk != other.fesMesdiaPk) {
            return false;
        }
        if (this.fesCodPk != other.fesCodPk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.FestivosPK[ fesAnoPk=" + fesAnoPk + ", fesMesdiaPk=" + fesMesdiaPk + ", fesCodPk=" + fesCodPk + " ]";
    }
    
}
