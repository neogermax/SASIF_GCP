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
public class PermisosDocUsuPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PDOU_USU_COD_FK")
    private String pdouUsuCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PDOU_DOC_COD_FK")
    private String pdouDocCodFk;

    public PermisosDocUsuPK() {
    }

    public PermisosDocUsuPK(String pdouUsuCodFk, String pdouDocCodFk) {
        this.pdouUsuCodFk = pdouUsuCodFk;
        this.pdouDocCodFk = pdouDocCodFk;
    }

    public String getPdouUsuCodFk() {
        return pdouUsuCodFk;
    }

    public void setPdouUsuCodFk(String pdouUsuCodFk) {
        this.pdouUsuCodFk = pdouUsuCodFk;
    }

    public String getPdouDocCodFk() {
        return pdouDocCodFk;
    }

    public void setPdouDocCodFk(String pdouDocCodFk) {
        this.pdouDocCodFk = pdouDocCodFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdouUsuCodFk != null ? pdouUsuCodFk.hashCode() : 0);
        hash += (pdouDocCodFk != null ? pdouDocCodFk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosDocUsuPK)) {
            return false;
        }
        PermisosDocUsuPK other = (PermisosDocUsuPK) object;
        if ((this.pdouUsuCodFk == null && other.pdouUsuCodFk != null) || (this.pdouUsuCodFk != null && !this.pdouUsuCodFk.equals(other.pdouUsuCodFk))) {
            return false;
        }
        if ((this.pdouDocCodFk == null && other.pdouDocCodFk != null) || (this.pdouDocCodFk != null && !this.pdouDocCodFk.equals(other.pdouDocCodFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.PermisosDocUsuPK[ pdouUsuCodFk=" + pdouUsuCodFk + ", pdouDocCodFk=" + pdouDocCodFk + " ]";
    }
    
}
