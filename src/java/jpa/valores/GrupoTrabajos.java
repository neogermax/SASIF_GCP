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
 * @author analista02
 */
@Entity
@Table(name = "GRUPO_TRABAJOS")
@NamedQueries({
    @NamedQuery(name = "GrupoTrabajos.findAll", query = "SELECT g FROM GrupoTrabajos g")})
public class GrupoTrabajos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GRP_COD_PK")
    private Integer grpCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "GRP_DESCRIP")
    private String grpDescrip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupoTrabajos")
    private List<GrupoUsuarios> grupoUsuariosList;

    public GrupoTrabajos() {
    }

    public GrupoTrabajos(Integer grpCodPk) {
        this.grpCodPk = grpCodPk;
    }

    public GrupoTrabajos(Integer grpCodPk, String grpDescrip) {
        this.grpCodPk = grpCodPk;
        this.grpDescrip = grpDescrip;
    }

    public Integer getGrpCodPk() {
        return grpCodPk;
    }

    public void setGrpCodPk(Integer grpCodPk) {
        this.grpCodPk = grpCodPk;
    }

    public String getGrpDescrip() {
        return grpDescrip;
    }

    public void setGrpDescrip(String grpDescrip) {
        this.grpDescrip = grpDescrip;
    }

    public List<GrupoUsuarios> getGrupoUsuariosList() {
        return grupoUsuariosList;
    }

    public void setGrupoUsuariosList(List<GrupoUsuarios> grupoUsuariosList) {
        this.grupoUsuariosList = grupoUsuariosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (grpCodPk != null ? grpCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoTrabajos)) {
            return false;
        }
        GrupoTrabajos other = (GrupoTrabajos) object;
        if ((this.grpCodPk == null && other.grpCodPk != null) || (this.grpCodPk != null && !this.grpCodPk.equals(other.grpCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.GrupoTrabajos[ grpCodPk=" + grpCodPk + " ]";
    }
    
}
