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
@Table(name = "RELACIONES")
@NamedQueries({
    @NamedQuery(name = "Relaciones.findAll", query = "SELECT r FROM Relaciones r ORDER BY r.relacionesPK.relClsCodFk,r.relacionesPK.relSec,r.relacionesPK.relSubsec"),
    @NamedQuery(name = "Relaciones.findByClass", query = "SELECT r FROM Relaciones r WHERE r.clases = :clases"),
    @NamedQuery(name = "Relaciones.deleteAll", query = "DELETE FROM Relaciones")
})
public class Relaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelacionesPK relacionesPK;
    @JoinColumn(name = "REL_ETP_COD_FK", referencedColumnName = "ETP_COD_PK")
    @ManyToOne
    private Etapas relEtpCodFk;
    @JoinColumn(name = "REL_CLS_COD_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "REL_ACT_COD_FK", referencedColumnName = "ACT_COD_PK")
    @ManyToOne
    private Actividades relActCodFk;

    public Relaciones() {
    }

    public Relaciones(RelacionesPK relacionesPK) {
        this.relacionesPK = relacionesPK;
    }

    public Relaciones(Integer relClsCodFk, Integer relSec, Integer relSubsec) {
        this.relacionesPK = new RelacionesPK(relClsCodFk, relSec, relSubsec);
    }

    public RelacionesPK getRelacionesPK() {
        return relacionesPK;
    }

    public void setRelacionesPK(RelacionesPK relacionesPK) {
        this.relacionesPK = relacionesPK;
    }

    public Etapas getRelEtpCodFk() {
        return relEtpCodFk;
    }

    public void setRelEtpCodFk(Etapas relEtpCodFk) {
        this.relEtpCodFk = relEtpCodFk;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    public Actividades getRelActCodFk() {
        return relActCodFk;
    }

    public void setRelActCodFk(Actividades relActCodFk) {
        this.relActCodFk = relActCodFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relacionesPK != null ? relacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relaciones)) {
            return false;
        }
        Relaciones other = (Relaciones) object;
        if((this.clases == null && other.clases != null) || (this.clases != null && !this.clases.equals(other.clases))) {
            return false;
        }
        if((this.relEtpCodFk == null && other.relEtpCodFk != null) || (this.relEtpCodFk != null && !this.relEtpCodFk.equals(other.relEtpCodFk))) {
            return false;
        }
        if((this.relActCodFk == null && other.relActCodFk != null) || (this.relActCodFk != null && !this.relActCodFk.equals(other.relActCodFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Relaciones[ relacionesPK=" + relacionesPK + " ]";
    }
    
}
