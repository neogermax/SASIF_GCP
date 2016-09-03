/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "ACT_ITEMS")
@NamedQueries({
    @NamedQuery(name = "ActItems.findAll", query = "SELECT a FROM ActItems a ORDER BY a.actItemsPK.acitmActCodFk, a.actItemsPK.acitmSec"),
    @NamedQuery(name = "ActItems.deleteAll", query = "DELETE FROM ActItems")
})
public class ActItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActItemsPK actItemsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACITM_PROTEG")
    private String acitmProteg;
    @JoinColumn(name = "ACITM_ITM_COD_FK", referencedColumnName = "ITM_COD_PK")
    @ManyToOne(optional = false)
    private Items acitmItmCodFk;
    @JoinColumn(name = "ACITM_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;

    public ActItems() {
    }

    public ActItems(ActItemsPK actItemsPK) {
        this.actItemsPK = actItemsPK;
    }

    public ActItems(ActItemsPK actItemsPK, String acitmProteg) {
        this.actItemsPK = actItemsPK;
        this.acitmProteg = acitmProteg;
    }

    public ActItems(Integer acitmActCodFk, Integer acitmSec) {
        this.actItemsPK = new ActItemsPK(acitmActCodFk, acitmSec);
    }

    public ActItemsPK getActItemsPK() {
        return actItemsPK;
    }

    public void setActItemsPK(ActItemsPK actItemsPK) {
        this.actItemsPK = actItemsPK;
    }

    public String getAcitmProteg() {
        return acitmProteg;
    }

    public void setAcitmProteg(String acitmProteg) {
        this.acitmProteg = acitmProteg;
    }

    public Items getAcitmItmCodFk() {
        return acitmItmCodFk;
    }

    public void setAcitmItmCodFk(Items acitmItmCodFk) {
        this.acitmItmCodFk = acitmItmCodFk;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actItemsPK != null ? actItemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActItems)) {
            return false;
        }
        ActItems other = (ActItems) object;
        if ((this.actItemsPK == null && other.actItemsPK != null) || (this.actItemsPK != null && !this.actItemsPK.equals(other.actItemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ActItems[ actItemsPK=" + actItemsPK + " ]";
    }
    
}
