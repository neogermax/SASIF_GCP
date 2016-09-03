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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "REPORTES")
@NamedQueries({
    @NamedQuery(name = "Reportes.findAll", query = "SELECT r FROM Reportes r ORDER BY r.reportesPK.repNomFil, r.reportesPK.repNomCol"),
    @NamedQuery(name = "Reportes.findCaractAct", query = "SELECT r FROM Reportes r WHERE r.reportesPK.repCodRepFk = :codrep AND r.reportesPK.repCarSecFk = :carsecfk ORDER BY r.reportesPK.repNomFil, r.reportesPK.repNomCol"),
    @NamedQuery(name = "Reportes.findByCol", query = "SELECT DISTINCT r.reportesPK.repNomCol FROM Reportes r WHERE r.caracteristicas = :caract ORDER BY r.reportesPK.repNomCol"),
    @NamedQuery(name = "Reportes.findByFil", query = "SELECT DISTINCT r.reportesPK.repNomFil FROM Reportes r WHERE r.caracteristicas = :caract ORDER BY r.reportesPK.repNomFil"),
    @NamedQuery(name = "Reportes.findDele", query = "DELETE FROM Reportes r WHERE r.reportesPK.repCodRepFk = :codrepor AND r.reportesPK.repCarSecFk = :carsec")
})
public class Reportes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReportesPK reportesPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REP_VALOR")
    private Integer repValor;
    
    @JoinColumns({
        @JoinColumn(name = "REP_CAR_SEC_FK", referencedColumnName = "CAR_SECU_PK", insertable = false, updatable = false),
        @JoinColumn(name = "REP_COD_REP_FK", referencedColumnName = "CAR_COD_REP_FK", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Caracteristicas caracteristicas;

    public Reportes() {
    }

    public Reportes(ReportesPK reportesPK) {
        this.reportesPK = reportesPK;
    }

    public Reportes(ReportesPK reportesPK, Integer repValor) {
        this.reportesPK = reportesPK;
        this.repValor = repValor;
        
    }

    public Reportes(Integer repCodRepFk, Integer repCarSecFk, String repNomFil, String repNomCol) {
        this.reportesPK = new ReportesPK(repCodRepFk, repCarSecFk, repNomFil, repNomCol);
    }

    public ReportesPK getReportesPK() {
        return reportesPK;
    }

    public void setReportesPK(ReportesPK reportesPK) {
        this.reportesPK = reportesPK;
    }

    public Integer getRepValor() {
        return repValor;
    }

    public void setRepValor(Integer repValor) {
        this.repValor = repValor;
    }

    
  

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportesPK != null ? reportesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reportes)) {
            return false;
        }
        Reportes other = (Reportes) object;
        if ((this.reportesPK == null && other.reportesPK != null) || (this.reportesPK != null && !this.reportesPK.equals(other.reportesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Reportes[ reportesPK=" + reportesPK + " ]";
    }
    
}
