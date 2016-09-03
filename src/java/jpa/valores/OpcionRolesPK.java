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
public class OpcionRolesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "OPC_ROL_PK")
    private String opcRolPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OPC_CONS_PK")
    private Short opcConsPk;

    public OpcionRolesPK() {
    }

    public OpcionRolesPK(String opcRolPk, Short opcConsPk) {
        this.opcRolPk = opcRolPk;
        this.opcConsPk = opcConsPk;
    }

    public String getOpcRolPk() {
        return opcRolPk;
    }

    public void setOpcRolPk(String opcRolPk) {
        this.opcRolPk = opcRolPk;
    }

    public Short getOpcConsPk() {
        return opcConsPk;
    }

    public void setOpcConsPk(Short opcConsPk) {
        this.opcConsPk = opcConsPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcRolPk != null ? opcRolPk.hashCode() : 0);
        hash += (int) opcConsPk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionRolesPK)) {
            return false;
        }
        OpcionRolesPK other = (OpcionRolesPK) object;
        if ((this.opcRolPk == null && other.opcRolPk != null) || (this.opcRolPk != null && !this.opcRolPk.equals(other.opcRolPk))) {
            return false;
        }
        if (this.opcConsPk != other.opcConsPk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.OpcionRolesPK[ opcRolPk=" + opcRolPk + ", opcConsPk=" + opcConsPk + " ]";
    }
    
}
