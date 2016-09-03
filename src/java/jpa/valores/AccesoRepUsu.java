/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "ACCESO_REP_USU")
@NamedQueries({
    @NamedQuery(name = "AccesoRepUsu.findAll", query = "SELECT a FROM AccesoRepUsu a"),
    @NamedQuery(name = "AccesoRepUsu.findByUser", query = "SELECT a FROM AccesoRepUsu a WHERE a.accesoRepUsuPK.aruUsuCodFk = :usucod")
})
public class AccesoRepUsu implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AccesoRepUsuPK accesoRepUsuPK;
    @Size(max = 1)
    @Column(name = "ARU_TIPO_ACC")
    private String aruTipoAcc;

    public AccesoRepUsu() {
    }

    public AccesoRepUsu(AccesoRepUsuPK accesoRepUsuPK) {
        this.accesoRepUsuPK = accesoRepUsuPK;
    }

    public AccesoRepUsu(String aruUsuCodFk, Integer aruCodRepFk, Integer aruGrpCodFk) {
        this.accesoRepUsuPK = new AccesoRepUsuPK(aruUsuCodFk, aruCodRepFk, aruGrpCodFk);
    }

    public AccesoRepUsuPK getAccesoRepUsuPK() {
        return accesoRepUsuPK;
    }

    public void setAccesoRepUsuPK(AccesoRepUsuPK accesoRepUsuPK) {
        this.accesoRepUsuPK = accesoRepUsuPK;
    }

    public String getAruTipoAcc() {
        return aruTipoAcc;
    }

    public void setAruTipoAcc(String aruTipoAcc) {
        this.aruTipoAcc = aruTipoAcc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accesoRepUsuPK != null ? accesoRepUsuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccesoRepUsu)) {
            return false;
        }
        AccesoRepUsu other = (AccesoRepUsu) object;
        if ((this.accesoRepUsuPK == null && other.accesoRepUsuPK != null) || (this.accesoRepUsuPK != null && !this.accesoRepUsuPK.equals(other.accesoRepUsuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.AccesoRepUsu[ accesoRepUsuPK=" + accesoRepUsuPK + " ]";
    }
    
}
