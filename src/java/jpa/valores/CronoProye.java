/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "CRONO_PROYE")
@NamedQueries({
    @NamedQuery(name = "CronoProye.findAll", query = "SELECT c FROM CronoProye c"),
    @NamedQuery(name = "CronoProye.findByCls", query = "SELECT c FROM CronoProye c WHERE c.proyectos = :proyecto AND c.clases = :clase AND c.etapas = :etapa AND c.actividades = :actividad"),
    @NamedQuery(name = "CronoProye.findFecMinMax", query = "SELECT MIN(c.croproFeiPla), MAX(c.croproFefPla) FROM CronoProye c WHERE c.cronoProyePK.croproProCodFk = :proyecto AND c.croproFeiRea is not null AND c.croproFefRea is null"),
    @NamedQuery(name = "CronoProye.findFecMinMax2", query = "SELECT MIN(c.croproFeiPla), MAX(c.croproFefPla) FROM CronoProye c WHERE c.croproFefRea is null"),
    @NamedQuery(name = "CronoProye.findByDisp", query = "SELECT c FROM CronoProye c WHERE c.croproFefRea is null"),
    @NamedQuery(name = "CronoProye.findByProyCron", query = "SELECT c FROM CronoProye c WHERE c.cronoProyePK.croproProCodFk = :proyectoPK AND c.cronoProyePK.croproActCodFk = c.actividades.actCodPk"),
    @NamedQuery(name = "CronoProye.findByProy", query = "SELECT c FROM CronoProye c WHERE c.cronoProyePK.croproProCodFk = :proyectoPK"),
    @NamedQuery(name = "CronoProye.deleteByAct", query = "DELETE FROM CronoProye c WHERE c.proyectos = :proyecto AND c.clases = :clase AND c.etapas = :etapa AND c.actividades = :actividad"),
    @NamedQuery(name = "CronoProyePK.findByProy", query = "SELECT c.cronoProyePK FROM CronoProye c WHERE c.cronoProyePK.croproProCodFk = :proyectoPK")})
public class CronoProye implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CronoProyePK cronoProyePK;
    @Column(name = "CROPRO_FEI_PLA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croproFeiPla;
    @Column(name = "CROPRO_FEF_PLA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croproFefPla;
    @Column(name = "CROPRO_TIE_PLA")
    private Long croproTiePla;
    @Column(name = "CROPRO_FEI_REA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croproFeiRea;
    @Column(name = "CROPRO_FEF_REA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croproFefRea;
    @Column(name = "CROPRO_TIE_REA")
    private Long croproTieRea;
    @Column(name = "CROPRO_FEI_REP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croproFeiRep;
    @Column(name = "CROPRO_FEF_REP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date croproFefRep;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CROPRO_POR_REA")
    private BigDecimal croproPorRea;
    @Column(name = "CROPRO_TIE_ATR")
    private Long croproTieAtr;
    @Column(name = "CROPRO_POR_CUMPL")
    private BigDecimal croproPorCumpl;
    @Column(name = "CROPRO_VAH_PLA")
    private Long croproVahPla;
    @Column(name = "CROPRO_COS_PLA")
    private Long croproCosPla;
    @Column(name = "CROPRO_COS_REA")
    private Long croproCosRea;
    @JoinColumn(name = "CROPRO_PRO_COD_FK", referencedColumnName = "PRO_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;
    @JoinColumn(name = "CROPRO_ETP_COD_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas;
    @JoinColumn(name = "CROPRO_CLS_COD_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "CROPRO_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;

    public CronoProye() {
    }

    public CronoProye(CronoProyePK cronoProyePK) {
        this.cronoProyePK = cronoProyePK;
    }

    public CronoProye(Integer croproProCodFk, Integer croproClsCodFk, Integer croproEtpCodFk, Integer croproActCodFk, String croproComNomFk, Integer croproTipCodFk) {
        this.cronoProyePK = new CronoProyePK(croproProCodFk, croproClsCodFk, croproEtpCodFk, croproActCodFk, croproComNomFk, croproTipCodFk);
    }

    public CronoProyePK getCronoProyePK() {
        return cronoProyePK;
    }

    public void setCronoProyePK(CronoProyePK cronoProyePK) {
        this.cronoProyePK = cronoProyePK;
    }

    public Date getCroproFeiPla() {
        return croproFeiPla;
    }

    public void setCroproFeiPla(Date croproFeiPla) {
        this.croproFeiPla = croproFeiPla;
    }

    public Date getCroproFefPla() {
        return croproFefPla;
    }

    public void setCroproFefPla(Date croproFefPla) {
        this.croproFefPla = croproFefPla;
    }

    public Long getCroproTiePla() {
        return croproTiePla;
    }

    public void setCroproTiePla(Long croproTiePla) {
        this.croproTiePla = croproTiePla;
    }

    public Date getCroproFeiRea() {
        return croproFeiRea;
    }

    public void setCroproFeiRea(Date croproFeiRea) {
        this.croproFeiRea = croproFeiRea;
    }

    public Date getCroproFefRea() {
        return croproFefRea;
    }

    public void setCroproFefRea(Date croproFefRea) {
        this.croproFefRea = croproFefRea;
    }

    public Long getCroproTieRea() {
        return croproTieRea;
    }

    public void setCroproTieRea(Long croproTieRea) {
        this.croproTieRea = croproTieRea;
    }

    public Date getCroproFeiRep() {
        return croproFeiRep;
    }

    public void setCroproFeiRep(Date croproFeiRep) {
        this.croproFeiRep = croproFeiRep;
    }

    public Date getCroproFefRep() {
        return croproFefRep;
    }

    public void setCroproFefRep(Date croproFefRep) {
        this.croproFefRep = croproFefRep;
    }

    public BigDecimal getCroproPorRea() {
        return croproPorRea;
    }

    public void setCroproPorRea(BigDecimal croproPorRea) {
        this.croproPorRea = croproPorRea;
    }

    public Long getCroproTieAtr() {
        return croproTieAtr;
    }

    public void setCroproTieAtr(Long croproTieAtr) {
        this.croproTieAtr = croproTieAtr;
    }

    public BigDecimal getCroproPorCumpl() {
        return croproPorCumpl;
    }

    public void setCroproPorCumpl(BigDecimal croproPorCumpl) {
        this.croproPorCumpl = croproPorCumpl;
    }

    public Long getCroproVahPla() {
        return croproVahPla;
    }

    public void setCroproVahPla(Long croproVahPla) {
        this.croproVahPla = croproVahPla;
    }

    public Long getCroproCosPla() {
        return croproCosPla;
    }

    public void setCroproCosPla(Long croproCosPla) {
        this.croproCosPla = croproCosPla;
    }

    public Long getCroproCosRea() {
        return croproCosRea;
    }

    public void setCroproCosRea(Long croproCosRea) {
        this.croproCosRea = croproCosRea;
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
        hash += (cronoProyePK != null ? cronoProyePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CronoProye)) {
            return false;
        }
        CronoProye other = (CronoProye) object;
        if ((this.cronoProyePK == null && other.cronoProyePK != null) || (this.cronoProyePK != null && !this.cronoProyePK.equals(other.cronoProyePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.CronoProye[ cronoProyePK=" + cronoProyePK + " ]";
    }
    
}
