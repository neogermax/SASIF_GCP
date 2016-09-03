/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Analista02
 */
@Entity
@Table(name = "ROLES")
@NamedQueries({
    @NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r")})
public class Roles implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuRolFk")
    private List<Usuarios> usuariosList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ROL_ROL_PK")
    private String rolRolPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROL_DESCRIP")
    private String rolDescrip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ROL_SIGLA")
    private String rolSigla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ROL_ESTADO")
    private String rolEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private List<OpcionRoles> opcionRolesList;
    @OneToMany(mappedBy = "opcSubrol")
    private List<OpcionRoles> opcionRolesList1;

    public Roles() {
    }

    public Roles(String rolRolPk) {
        this.rolRolPk = rolRolPk;
    }

    public Roles(String rolRolPk, String rolDescrip, String rolSigla, String rolEstado) {
        this.rolRolPk = rolRolPk;
        this.rolDescrip = rolDescrip;
        this.rolSigla = rolSigla;
        this.rolEstado = rolEstado;
    }

    public String getRolRolPk() {
        return rolRolPk;
    }

    public void setRolRolPk(String rolRolPk) {
        this.rolRolPk = rolRolPk;
    }

    public String getRolDescrip() {
        return rolDescrip;
    }

    public void setRolDescrip(String rolDescrip) {
        this.rolDescrip = rolDescrip;
    }

    public String getRolSigla() {
        return rolSigla;
    }

    public void setRolSigla(String rolSigla) {
        this.rolSigla = rolSigla;
    }

    public String getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(String rolEstado) {
        this.rolEstado = rolEstado;
    }

    public List<OpcionRoles> getOpcionRolesList() {
        return opcionRolesList;
    }

    public void setOpcionRolesList(List<OpcionRoles> opcionRolesList) {
        this.opcionRolesList = opcionRolesList;
    }

    public List<OpcionRoles> getOpcionRolesList1() {
        return opcionRolesList1;
    }

    public void setOpcionRolesList1(List<OpcionRoles> opcionRolesList1) {
        this.opcionRolesList1 = opcionRolesList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolRolPk != null ? rolRolPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roles)) {
            return false;
        }
        Roles other = (Roles) object;
        if ((this.rolRolPk == null && other.rolRolPk != null) || (this.rolRolPk != null && !this.rolRolPk.equals(other.rolRolPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Roles[ rolRolPk=" + rolRolPk + " ]";
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }
    
}
