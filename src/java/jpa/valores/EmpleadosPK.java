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
public class EmpleadosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMPL_ID_PK")
    private Long emplId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "EMPL_TIPO_ID_PK")
    private String emplTipoId;

    public EmpleadosPK() {
    }

    public EmpleadosPK(Long emplId, String emplTipoId) {
        this.emplId = emplId;
        this.emplTipoId = emplTipoId;
    }

    public Long getEmplId() {
        return emplId;
    }

    public void setEmplId(Long emplId) {
        this.emplId = emplId;
    }

    public String getEmplTipoId() {
        return emplTipoId;
    }

    public void setEmplTipoId(String emplTipoId) {
        this.emplTipoId = emplTipoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int)emplId.intValue();
        hash += (emplTipoId != null ? emplTipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadosPK)) {
            return false;
        }
        EmpleadosPK other = (EmpleadosPK) object;
        if (this.emplId.longValue() != other.emplId.longValue()) {
            return false;
        }
        if ((this.emplTipoId == null && other.emplTipoId != null) || (this.emplTipoId != null && !this.emplTipoId.equals(other.emplTipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.EmpleadosPK[ emplId=" + emplId + ", emplTipoId=" + emplTipoId + " ]";
    }
    
}
