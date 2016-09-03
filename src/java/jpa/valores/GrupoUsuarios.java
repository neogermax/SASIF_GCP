/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "GRUPO_USUARIOS")
@NamedQueries({
    @NamedQuery(name = "GrupoUsuarios.findAll", query = "SELECT g FROM GrupoUsuarios g")})
public class GrupoUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GrupoUsuariosPK grupoUsuariosPK;
    @JoinColumn(name = "GRP_COD_PK", referencedColumnName = "GRP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GrupoTrabajos grupoTrabajos;

    public GrupoUsuarios() {
    }

    public GrupoUsuarios(GrupoUsuariosPK grupoUsuariosPK) {
        this.grupoUsuariosPK = grupoUsuariosPK;
    }

    public GrupoUsuarios(Integer grpCodPk, String grpUsuCodPk) {
        this.grupoUsuariosPK = new GrupoUsuariosPK(grpCodPk, grpUsuCodPk);
    }

    public GrupoUsuariosPK getGrupoUsuariosPK() {
        return grupoUsuariosPK;
    }

    public void setGrupoUsuariosPK(GrupoUsuariosPK grupoUsuariosPK) {
        this.grupoUsuariosPK = grupoUsuariosPK;
    }

    public GrupoTrabajos getGrupoTrabajos() {
        return grupoTrabajos;
    }

    public void setGrupoTrabajos(GrupoTrabajos grupoTrabajos) {
        this.grupoTrabajos = grupoTrabajos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grupoUsuariosPK != null ? grupoUsuariosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoUsuarios)) {
            return false;
        }
        GrupoUsuarios other = (GrupoUsuarios) object;
        if ((this.grupoUsuariosPK == null && other.grupoUsuariosPK != null) || (this.grupoUsuariosPK != null && !this.grupoUsuariosPK.equals(other.grupoUsuariosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.GrupoUsuarios[ grupoUsuariosPK=" + grupoUsuariosPK + " ]";
    }
    
}
