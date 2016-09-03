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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "PROY_ACTS")
@NamedQueries({
    @NamedQuery(name = "ProyActs.findAll", query = "SELECT p FROM ProyActs p ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findNoTerm", query = "SELECT p FROM ProyActs p WHERE p.proyectos = :proyecto AND p.pryEstado != 'T' AND p.pryEstado != 'E' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findActDisp", query = "SELECT p FROM ProyActs p WHERE p.proyectos = :proyecto AND p.pryEstado = 'D' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findActDisp2", query = "SELECT p FROM ProyActs p WHERE p.clases = :clase AND p.etapas = :etapa AND p.actividades = :actividad AND p.pryEstado = 'D' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findActDisp3", query = "SELECT p FROM ProyActs p WHERE p.pryEstado = 'D' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.countAct", query = "SELECT COUNT(p) FROM ProyActs p WHERE p.proyectos = :proyecto AND p.actividades = :act AND p.pryEstado != 'E' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findActComp", query = "SELECT p FROM ProyActs p WHERE p.proyectos = :proyecto AND p.clases = :clase AND p.etapas = :etapa AND p.actividades = :actividad AND p.pryEstado = 'E' ORDER BY p.proyActsPK.pryProCodFk"),    
    @NamedQuery(name = "ProyActs.findProyComp", query = "SELECT p FROM ProyActs p WHERE p.proyectos = :proyecto AND p.pryEstado = 'E' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findProyComp2", query = "SELECT p FROM ProyActs p WHERE p.proyectos = :proyecto AND p.clases = :clase AND p.etapas = :etapa AND p.actividades = :actividad AND p.pryEstado = 'E' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findCompPar", query = "SELECT p FROM ProyActs p WHERE p.pryEstado = 'R' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findByProy", query = "SELECT p FROM ProyActs p WHERE p.proyActsPK.pryProCodFk = :proCodFk ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findProy1", query = "SELECT p FROM ProyActs p WHERE p.proyActsPK.pryProCodFk = :proCodFk AND p.pryEstado = 'D' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findProy2", query = "SELECT p FROM ProyActs p WHERE LOWER(p.proyectos.proDescrip) = LOWER(:proDescrip) AND p.pryEstado = 'D' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findProy3", query = "SELECT p FROM ProyActs p WHERE p.proyActsPK.pryProCodFk = :proCodFk AND LOWER(p.proyectos.proDescrip) = LOWER(:proDescrip) AND p.pryEstado = 'D' ORDER BY p.proyActsPK.pryProCodFk"),
    @NamedQuery(name = "ProyActs.findRel", query = "SELECT p FROM ProyActs p, Relaciones r WHERE p.proyActsPK.pryProCodFk = :proCodFk AND p.clases = r.clases AND p.etapas = r.relEtpCodFk AND p.actividades = r.relActCodFk ORDER BY r.relacionesPK.relSec, r.relacionesPK.relSubsec"),
    @NamedQuery(name = "ProyActs.findone", query = "SELECT p FROM ProyActs p WHERE p.proyActsPK.pryProCodFk = :proCodFk"),
    @NamedQuery(name = "ProyActs.updateProy", query = "UPDATE ProyActs p SET p.pryEstado = 'T' WHERE p.proyectos = :proyecto AND p.pryEstado != 'T'"),
    @NamedQuery(name = "ProyActs.deleteComp", query = "DELETE FROM ProyActs p WHERE  p.proyectos = :proyecto AND p.clases = :clase AND p.etapas = :etapa AND p.actividades = :actividad AND p.pryEstado = 'E'"),
    @NamedQuery(name = "ProyActs.delete", query = "DELETE FROM ProyActs p WHERE  p.proyectos = :proyecto AND p.clases = :clase AND p.etapas = :etapa AND p.actividades = :actividad")
})
public class ProyActs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyActsPK proyActsPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PRY_ESTADO")
    private String pryEstado;
    @Column(name = "PRY_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryEntrada;
    @Column(name = "PRY_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date prySalida;
    @Size(max = 20)
    @Column(name = "PRY_USU_ENT")
    private String pryUsuEnt;
    @Size(max = 20)
    @Column(name = "PRY_USU_SAL")
    private String pryUsuSal;
    @JoinColumn(name = "PRY_PRO_COD_FK", referencedColumnName = "PRO_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;
    @JoinColumn(name = "PRY_ETP_COD_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas;
    @JoinColumn(name = "PRY_CLS_COD_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "PRY_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;

    public ProyActs() {
    }

    public ProyActs(ProyActsPK proyActsPK) {
        this.proyActsPK = proyActsPK;
    }

    public ProyActs(ProyActsPK proyActsPK, String pryEstado) {
        this.proyActsPK = proyActsPK;
        this.pryEstado = pryEstado;
    }

    public ProyActs(Integer pryProCodFk, Integer pryClsCodFk, Integer pryEtpCodFk, Integer pryActCodFk, String pryComNomFk, Integer pryComTipFk) {
        this.proyActsPK = new ProyActsPK(pryProCodFk, pryClsCodFk, pryEtpCodFk, pryActCodFk, pryComNomFk, pryComTipFk);
    }

    public ProyActsPK getProyActsPK() {
        return proyActsPK;
    }

    public void setProyActsPK(ProyActsPK proyActsPK) {
        this.proyActsPK = proyActsPK;
    }

    public String getPryEstado() {
        return pryEstado;
    }

    public void setPryEstado(String pryEstado) {
        this.pryEstado = pryEstado;
    }

    public Date getPryEntrada() {
        return pryEntrada;
    }

    public void setPryEntrada(Date pryEntrada) {
        this.pryEntrada = pryEntrada;
    }

    public Date getPrySalida() {
        return prySalida;
    }

    public void setPrySalida(Date prySalida) {
        this.prySalida = prySalida;
    }

    public String getPryUsuEnt() {
        return pryUsuEnt;
    }

    public void setPryUsuEnt(String pryUsuEnt) {
        this.pryUsuEnt = pryUsuEnt;
    }

    public String getPryUsuSal() {
        return pryUsuSal;
    }

    public void setPryUsuSal(String pryUsuSal) {
        this.pryUsuSal = pryUsuSal;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Etapas getEtapas() {
        return etapas;
    }

    public void setEtapas(Etapas etapas) {
        this.etapas = etapas;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
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
        hash += (proyActsPK != null ? proyActsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyActs)) {
            return false;
        }
        ProyActs other = (ProyActs) object;
        if ((this.proyActsPK == null && other.proyActsPK != null) || (this.proyActsPK != null && !this.proyActsPK.equals(other.proyActsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ProyActs[ proyActsPK=" + proyActsPK + " ]";
    }
    
}
