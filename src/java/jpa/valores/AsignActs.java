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
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "ASIGN_ACTS")
@NamedQueries({
    @NamedQuery(name = "AsignActs.findAll", query = "SELECT a FROM AsignActs a"),
    @NamedQuery(name = "AsignActs.findAsign", query = "SELECT a FROM AsignActs a WHERE a.clases = :clase AND a.etapas = :etapa AND a.actividades = :actividad AND (a.asignTipo = 'R' OR a.asignTipo = 'A')"),
    @NamedQuery(name = "AsignActs.findCronog", query = "SELECT a FROM AsignActs a WHERE a.clases = :clase AND a.etapas = :etapa AND a.actividades = :actividad AND (a.asignTipo = 'C' OR a.asignTipo = 'A')")
})
public class AsignActs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignActsPK asignActsPK;
    
    @Basic(optional = false)
    
    @Size(min = 1, max = 1)
    @Column(name = "ASIGN_TIPO")
    private String asignTipo;
    @JoinColumn(name = "ASIGN_ORG_ETP_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas;
    @JoinColumn(name = "ASIGN_DES_ETP_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas1;
    @JoinColumn(name = "ASIGN_ORG_CLS_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "ASIGN_DES_CLS_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases1;
    @JoinColumn(name = "ASIGN_ORG_ACT_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;
    @JoinColumn(name = "ASIGN_DES_ACT_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades1;

    public AsignActs() {
    }

    public AsignActs(AsignActsPK asignActsPK) {
        this.asignActsPK = asignActsPK;
    }
    
    
    public AsignActs(AsignActsPK asignActsPK, String asignTipo) {
        this.asignActsPK = asignActsPK;
        this.asignTipo = asignTipo;
    }
    
    

    public AsignActs(Integer asignOrgClsFk, Integer asignOrgEtpFk, Integer asignOrgActFk, Integer asignDesClsFk, Integer asignDesEtpFk, Integer asignDesActFk) {
        this.asignActsPK = new AsignActsPK(asignOrgClsFk, asignOrgEtpFk, asignOrgActFk, asignDesClsFk, asignDesEtpFk, asignDesActFk);
    }
    
    
    public String getAsignTipo() {
        return asignTipo;
    }

    public void setAsignTipo(String asignTipo) {
        this.asignTipo = asignTipo;
    }

    public AsignActsPK getAsignActsPK() {
        return asignActsPK;
    }

    public void setAsignActsPK(AsignActsPK asignActsPK) {
        this.asignActsPK = asignActsPK;
    }

    public Etapas getEtapas() {
        return etapas;
    }

    public void setEtapas(Etapas etapas) {
        this.etapas = etapas;
    }

    public Etapas getEtapas1() {
        return etapas1;
    }

    public void setEtapas1(Etapas etapas1) {
        this.etapas1 = etapas1;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    public Clases getClases1() {
        return clases1;
    }

    public void setClases1(Clases clases1) {
        this.clases1 = clases1;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    public Actividades getActividades1() {
        return actividades1;
    }

    public void setActividades1(Actividades actividades1) {
        this.actividades1 = actividades1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignActsPK != null ? asignActsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignActs)) {
            return false;
        }
        AsignActs other = (AsignActs) object;
        if ((this.asignActsPK == null && other.asignActsPK != null) || (this.asignActsPK != null && !this.asignActsPK.equals(other.asignActsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.AsignActs[ asignActsPK=" + asignActsPK + " ]";
    }
    
}
