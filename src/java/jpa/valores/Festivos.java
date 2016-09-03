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
 * @author saflap
 */
@Entity
@Table(name = "FESTIVOS")
@NamedQueries({
    @NamedQuery(name = "Festivos.findAll", query = "SELECT f FROM Festivos f")})
public class Festivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FestivosPK festivosPK;
    @JoinColumn(name = "FES_COD_PK", referencedColumnName = "PAI_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paises paises;

    public Festivos() {
    }

    public Festivos(FestivosPK festivosPK) {
        this.festivosPK = festivosPK;
    }

    
    public Festivos(Short fesAnoPk, Short fesMesdiaPk, Integer fesCodPk) {
        this.festivosPK = new FestivosPK(fesAnoPk, fesMesdiaPk, fesCodPk);
    }

    public FestivosPK getFestivosPK() {
        return festivosPK;
    }

    public void setFestivosPK(FestivosPK festivosPK) {
        this.festivosPK = festivosPK;
    }

    public Paises getPaises() {
        return paises;
    }

    public void setPaises(Paises paises) {
        this.paises = paises;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (festivosPK != null ? festivosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Festivos)) {
            return false;
        }
        Festivos other = (Festivos) object;
        if ((this.festivosPK == null && other.festivosPK != null) || (this.festivosPK != null && !this.festivosPK.equals(other.festivosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Festivos[ festivosPK=" + festivosPK + " ]";
    }
    
}
