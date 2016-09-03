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
public class AreasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARE_COD_EMP_FK")
    private Integer areCodEmpFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ARE_CODIGO_PK")
    private Integer areCodigoPk;

    public AreasPK() {
    }

    public AreasPK(Integer areCodEmpFk, Integer areCodigoPk) {
        this.areCodEmpFk = areCodEmpFk;
        this.areCodigoPk = areCodigoPk;
    }

    public Integer getAreCodEmpFk() {
        return areCodEmpFk;
    }

    public void setAreCodEmpFk(Integer areCodEmpFk) {
        this.areCodEmpFk = areCodEmpFk;
    }

    public Integer getAreCodigoPk() {
        return areCodigoPk;
    }

    public void setAreCodigoPk(Integer areCodigoPk) {
        this.areCodigoPk = areCodigoPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) areCodEmpFk;
        hash += (int) areCodigoPk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreasPK)) {
            return false;
        }
        AreasPK other = (AreasPK) object;
        if (this.areCodEmpFk != other.areCodEmpFk) {
            return false;
        }
        if (this.areCodigoPk != other.areCodigoPk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.AreasPK[ areCodEmpFk=" + areCodEmpFk + ", areCodigoPk=" + areCodigoPk + " ]";
    }
    
}
