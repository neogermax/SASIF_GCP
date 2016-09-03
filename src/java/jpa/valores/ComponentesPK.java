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
 * @author Analista02
 */
@Embeddable
public class ComponentesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "COM_PRO_COD_FK")
    private Integer comProCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COM_TIP_COD_FK")
    private Integer comTipCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COM_NOM_PK")
    private String comNomPk;

    public ComponentesPK() {
    }

    public ComponentesPK(Integer comProCodFk, Integer comTipCodFk, String comNomPk) {
        this.comProCodFk = comProCodFk;
        this.comTipCodFk = comTipCodFk;
        this.comNomPk = comNomPk;
    }

    public Integer getComProCodFk() {
        return comProCodFk;
    }

    public void setComProCodFk(Integer comProCodFk) {
        this.comProCodFk = comProCodFk;
    }

    public Integer getComTipCodFk() {
        return comTipCodFk;
    }

    public void setComTipCodFk(Integer comTipCodFk) {
        this.comTipCodFk = comTipCodFk;
    }

    public String getComNomPk() {
        return comNomPk;
    }

    public void setComNomPk(String comNomPk) {
        this.comNomPk = comNomPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) comProCodFk;
        hash += (int) comTipCodFk;
        hash += (comNomPk != null ? comNomPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComponentesPK)) {
            return false;
        }
        ComponentesPK other = (ComponentesPK) object;
        if (this.comProCodFk != other.comProCodFk) {
            return false;
        }
        if (this.comTipCodFk != other.comTipCodFk) {
            return false;
        }
        if ((this.comNomPk == null && other.comNomPk != null) || (this.comNomPk != null && !this.comNomPk.equals(other.comNomPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ComponentesPK[ comProCodFk=" + comProCodFk + ", comTipCodFk=" + comTipCodFk + ", comNomPk=" + comNomPk + " ]";
    }
    
}
