/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Analista02
 */
@Entity
@Table(name = "OPCION_ROLES")
@NamedQueries({
    @NamedQuery(name = "OpcionRoles.findAll", query = "SELECT o FROM OpcionRoles o")})
public class OpcionRoles implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OpcionRolesPK opcionRolesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "OPC_TIPO")
    private String opcTipo;
    @Size(max = 1)
    @Column(name = "OPC_TIPO_TRAB")
    private String opcTipoTrab;
    @JoinColumn(name = "OPC_ROL_PK", referencedColumnName = "ROL_ROL_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roles roles;
    @JoinColumn(name = "OPC_SUBROL", referencedColumnName = "ROL_ROL_PK")
    @ManyToOne
    private Roles opcSubrol;
    @JoinColumn(name = "OPC_NOMBRE", referencedColumnName = "LINK_COD_PK")
    @ManyToOne
    private Links opcNombre;

    public OpcionRoles() {
    }

    public OpcionRoles(OpcionRolesPK opcionRolesPK) {
        this.opcionRolesPK = opcionRolesPK;
    }

    public OpcionRoles(OpcionRolesPK opcionRolesPK, String opcTipo) {
        this.opcionRolesPK = opcionRolesPK;
        this.opcTipo = opcTipo;
    }

    public OpcionRoles(String opcRolPk, Short opcConsPk) {
        this.opcionRolesPK = new OpcionRolesPK(opcRolPk, opcConsPk);
    }

    public OpcionRolesPK getOpcionRolesPK() {
        return opcionRolesPK;
    }

    public void setOpcionRolesPK(OpcionRolesPK opcionRolesPK) {
        this.opcionRolesPK = opcionRolesPK;
    }

    public String getOpcTipo() {
        return opcTipo;
    }

    public void setOpcTipo(String opcTipo) {
        this.opcTipo = opcTipo;
    }

    public String getOpcTipoTrab() {
        return opcTipoTrab;
    }

    public void setOpcTipoTrab(String opcTipoTrab) {
        this.opcTipoTrab = opcTipoTrab;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Roles getOpcSubrol() {
        return opcSubrol;
    }

    public void setOpcSubrol(Roles opcSubrol) {
        this.opcSubrol = opcSubrol;
    }

    public Links getOpcNombre() {
        return opcNombre;
    }

    public void setOpcNombre(Links opcNombre) {
        this.opcNombre = opcNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (opcionRolesPK != null ? opcionRolesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionRoles)) {
            return false;
        }
        OpcionRoles other = (OpcionRoles) object;
        if ((this.opcionRolesPK == null && other.opcionRolesPK != null) || (this.opcionRolesPK != null && !this.opcionRolesPK.equals(other.opcionRolesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.OpcionRoles[ opcionRolesPK=" + opcionRolesPK + " ]";
    }
    
}
