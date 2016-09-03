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
public class ProyItemsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_PRO_COD_FK")
    private Integer pryProCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_ITM_COD_FK")
    private Integer pryItmCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRY_COM_NOM_FK")
    private String pryComNomFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRY_COM_TIP_FK")
    private Integer pryComTipFk;

    public ProyItemsPK() {
    }

    public ProyItemsPK(Integer pryProCodFk, Integer pryItmCodFk, String pryComNomFk, Integer pryComTipFk) {
        this.pryProCodFk = pryProCodFk;
        this.pryItmCodFk = pryItmCodFk;
        this.pryComNomFk = pryComNomFk;
        this.pryComTipFk = pryComTipFk;
    }

    public Integer getPryProCodFk() {
        return pryProCodFk;
    }

    public void setPryProCodFk(Integer pryProCodFk) {
        this.pryProCodFk = pryProCodFk;
    }

    public Integer getPryItmCodFk() {
        return pryItmCodFk;
    }

    public void setPryItmCodFk(Integer pryItmCodFk) {
        this.pryItmCodFk = pryItmCodFk;
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
        hash += (int) pryItmCodFk;
        hash += (pryComNomFk != null ? pryComNomFk.hashCode() : 0);
        hash += (int) pryComTipFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyItemsPK)) {
            return false;
        }
        ProyItemsPK other = (ProyItemsPK) object;
        if (this.pryProCodFk != other.pryProCodFk) {
            return false;
        }
        if (this.pryItmCodFk != other.pryItmCodFk) {
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
        return "jpa.valores.ProyItemsPK[ pryProCodFk=" + pryProCodFk + ", pryItmCodFk=" + pryItmCodFk + ", pryComNomFk=" + pryComNomFk + ", pryComTipFk=" + pryComTipFk + " ]";
    }
    
}
