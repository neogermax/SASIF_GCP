/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Embeddable
public class ValorHoraPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALHO_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valhoFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALHO_ACT_COD_FK")
    private int valhoActCodFk;
    
    @Size(min = 1, max = 10)
    @Column(name = "VALHO_USU_COD")
    private String valhoUsuCod;

    public ValorHoraPK() {
    }

    public ValorHoraPK(Date valhoFecha, int valhoActCodFk, String valhoUsuCod) {
        this.valhoFecha = valhoFecha;
        this.valhoActCodFk = valhoActCodFk;
        this.valhoUsuCod = valhoUsuCod;
    }

    public Date getValhoFecha() {
        return valhoFecha;
    }

    public void setValhoFecha(Date valhoFecha) {
        this.valhoFecha = valhoFecha;
    }

    public int getValhoActCodFk() {
        return valhoActCodFk;
    }

    public void setValhoActCodFk(int valhoActCodFk) {
        this.valhoActCodFk = valhoActCodFk;
    }

    public String getValhoUsuCod() {
        return valhoUsuCod;
    }

    public void setValhoUsuCod(String valhoUsuCod) {
        this.valhoUsuCod = valhoUsuCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valhoFecha != null ? valhoFecha.hashCode() : 0);
        hash += (int) valhoActCodFk;
        hash += (valhoUsuCod != null ? valhoUsuCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorHoraPK)) {
            return false;
        }
        ValorHoraPK other = (ValorHoraPK) object;
        if ((this.valhoFecha == null && other.valhoFecha != null) || (this.valhoFecha != null && !this.valhoFecha.equals(other.valhoFecha))) {
            return false;
        }
        if (this.valhoActCodFk != other.valhoActCodFk) {
            return false;
        }
        if ((this.valhoUsuCod == null && other.valhoUsuCod != null) || (this.valhoUsuCod != null && !this.valhoUsuCod.equals(other.valhoUsuCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ValorHoraPK[ valhoFecha=" + valhoFecha + ", valhoActCodFk=" + valhoActCodFk + ", valhoUsuCod=" + valhoUsuCod + " ]";
    }
    
}
