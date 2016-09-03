/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "PERMISOS_DOC_USU")
@NamedQueries({
    @NamedQuery(name = "PermisosDocUsu.findAll", query = "SELECT p FROM PermisosDocUsu p")})
public class PermisosDocUsu implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisosDocUsuPK permisosDocUsuPK;
    @Column(name = "PDOU_ACC_IDO")
    private Short pdouAccIdo;
    @Size(max = 1)
    @Column(name = "PDOU_TIP_ACC_CON")
    private String pdouTipAccCon;
    @Size(max = 1)
    @Column(name = "PDOU_TIP_ACC_ACT")
    private String pdouTipAccAct;
    @JoinColumn(name = "PDOU_USU_COD_FK", referencedColumnName = "USU_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;
    @JoinColumn(name = "PDOU_DOC_COD_FK", referencedColumnName = "PDO_DOCUMENTO_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pdocumentos pdocumentos;

    public PermisosDocUsu() {
    }

    public PermisosDocUsu(PermisosDocUsuPK permisosDocUsuPK) {
        this.permisosDocUsuPK = permisosDocUsuPK;
    }

    public PermisosDocUsu(String pdouUsuCodFk, String pdouDocCodFk) {
        this.permisosDocUsuPK = new PermisosDocUsuPK(pdouUsuCodFk, pdouDocCodFk);
    }

    public PermisosDocUsuPK getPermisosDocUsuPK() {
        return permisosDocUsuPK;
    }

    public void setPermisosDocUsuPK(PermisosDocUsuPK permisosDocUsuPK) {
        this.permisosDocUsuPK = permisosDocUsuPK;
    }

    public Short getPdouAccIdo() {
        return pdouAccIdo;
    }

    public void setPdouAccIdo(Short pdouAccIdo) {
        this.pdouAccIdo = pdouAccIdo;
    }

    public String getPdouTipAccCon() {
        return pdouTipAccCon;
    }

    public void setPdouTipAccCon(String pdouTipAccCon) {
        this.pdouTipAccCon = pdouTipAccCon;
    }

    public String getPdouTipAccAct() {
        return pdouTipAccAct;
    }

    public void setPdouTipAccAct(String pdouTipAccAct) {
        this.pdouTipAccAct = pdouTipAccAct;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Pdocumentos getPdocumentos() {
        return pdocumentos;
    }

    public void setPdocumentos(Pdocumentos pdocumentos) {
        this.pdocumentos = pdocumentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisosDocUsuPK != null ? permisosDocUsuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisosDocUsu)) {
            return false;
        }
        PermisosDocUsu other = (PermisosDocUsu) object;
        if ((this.permisosDocUsuPK == null && other.permisosDocUsuPK != null) || (this.permisosDocUsuPK != null && !this.permisosDocUsuPK.equals(other.permisosDocUsuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.PermisosDocUsu[ permisosDocUsuPK=" + permisosDocUsuPK + " ]";
    }
    
}
