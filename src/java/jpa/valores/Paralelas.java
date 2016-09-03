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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "PARALELAS")
@NamedQueries({
    @NamedQuery(name = "Paralelas.findAll", query = "SELECT p FROM Paralelas p"),
    @NamedQuery(name = "Paralelas.findByCls", query = "SELECT p FROM Paralelas p WHERE p.clases = :clase AND p.etapas = :etapa AND p.actividades = :actividad"),
    @NamedQuery(name = "Paralelas.deleteAll", query = "DELETE FROM Paralelas")
})
public class Paralelas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParalelasPK paralelasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PAR_COMP")
    private String parComp;
    @JoinColumn(name = "PAR_ETP_COD_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas;
    @JoinColumn(name = "PAR_ETP_COD", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas1;
    @JoinColumn(name = "PAR_CLS_COD_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "PAR_CLS_COD", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases1;
    @JoinColumn(name = "PAR_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;
    @JoinColumn(name = "PAR_ACT_COD", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades1;

    public Paralelas() {
    }

    public Paralelas(ParalelasPK paralelasPK) {
        this.paralelasPK = paralelasPK;
    }

    public Paralelas(ParalelasPK paralelasPK, String parComp) {
        this.paralelasPK = paralelasPK;
        this.parComp = parComp;
    }

    public Paralelas(Integer parClsCodFk, Integer parEtpCodFk, Integer parActCodFk, Integer parClsCod, Integer parEtpCod, Integer parActCod) {
        this.paralelasPK = new ParalelasPK(parClsCodFk, parEtpCodFk, parActCodFk, parClsCod, parEtpCod, parActCod);
    }

    public ParalelasPK getParalelasPK() {
        return paralelasPK;
    }

    public void setParalelasPK(ParalelasPK paralelasPK) {
        this.paralelasPK = paralelasPK;
    }

    public String getParComp() {
        return parComp;
    }

    public void setParComp(String parComp) {
        this.parComp = parComp;
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
        hash += (paralelasPK != null ? paralelasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paralelas)) {
            return false;
        }
        Paralelas other = (Paralelas) object;
        if ((this.paralelasPK == null && other.paralelasPK != null) || (this.paralelasPK != null && !this.paralelasPK.equals(other.paralelasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Paralelas[ paralelasPK=" + paralelasPK + " ]";
    }
    
}
