/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "ACTIVIDADES")
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a")})
public class Actividades implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividades")
    private List<CronoProye> cronoProyeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proActCodFk")
    private List<Proyectos> proyectosList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_COD_PK")
    private Integer actCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACT_DESCRIP")
    private String actDescrip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ACT_SIGLA")
    private String actSigla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACT_ENLACE")
    private String actEnlace;
    @Column(name = "ACT_ENLACE_AUTO")
    private Integer actEnlaceAuto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACT_COMP")
    private String actComp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACT_ASIGN")
    private String actAsign;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_AUTORIZAR")
    private short actAutorizar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACT_CALEND")
    private String actCalend;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ACT_FES")
    private String actFes;
    @Size(max = 1)
    @Column(name = "ACT_CRONO")
    private String actCrono;
    @Size(max = 1)
    @Column(name = "ACT_ICO_CRONO")
    private String actIcoCrono;
    @Size(max = 1)
    @Column(name = "ACT_ICO2")
    private String actIco2;
    @Size(max = 1)
    @Column(name = "ACT_ICO3")
    private String actIco3;
    @Size(max = 1)
    @Column(name = "ACT_ICO4")
    private String actIco4;
    @Size(max = 1)
    @Column(name = "ACT_ICO5")
    private String actIco5;
    @Column(name = "ACT_COD_PAI_FK")
    private Integer actCodPaiFk;
    @Column(name = "ACT_POR_ALERT")
    private Short actPorAlert;
    @Size(max = 1)
    @Column(name = "ACT_CRONO2")
    private String actCrono2;
    @Size(min = 1, max = 1)
    @Column(name = "ACT_ASIGN2")
    private String actAsign2;
    @Size(min = 1, max = 1)
    @Column(name = "ACT_ESTADO")
    private String actEstado;
    @Size(max = 1)
    @Column(name = "ACT_ICO6")
    private String actIco6;
    @Size(max = 1)
    @Column(name = "ACT_ICO7")
    private String actIco7;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividades")
    private List<ActItems> actItemsList;

    public Actividades() {
    }

    public Actividades(Integer actCodPk) {
        this.actCodPk = actCodPk;
    }

    public Actividades(Integer actCodPk, String actDescrip, String actSigla, String actEnlace, String actComp, String actAsign, short actAutorizar, String actCalend, String actFes, String actAsign2, String actCrono2, Integer actEnlaceAuto,String actCrono, String actIcoCrono, String actIco2, String actIco3, String actIco4, String actIco5, Integer actCodPaiFk,short actPorAlert, String actEstado, String actIco6,String actIco7 ) {
        this.actCodPk = actCodPk;
        this.actDescrip = actDescrip;
        this.actSigla = actSigla;
        this.actEnlace = actEnlace;
        this.actComp = actComp;
        this.actAsign = actAsign;
        this.actAutorizar = actAutorizar;
        this.actCalend = actCalend;
        this.actFes = actFes;
        this.actAsign2 = actAsign2;
        this.actCrono2 = actCrono2;
        this.actEnlaceAuto = actEnlaceAuto;
        this.actCrono = actCrono;
        this.actIcoCrono = actIcoCrono;
        this.actIco2 = actIco2;
        this.actIco3 = actIco3;
        this.actIco4 = actIco4;
        this.actIco5 = actIco5;
        this.actCodPaiFk = actCodPaiFk;
        this.actPorAlert = actPorAlert;
        this.actEstado = actEstado;
        this.actIco6 = actIco6;
        this.actIco7 = actIco7;
    }

    public Integer getActCodPk() {
        return actCodPk;
    }

    public void setActCodPk(Integer actCodPk) {
        this.actCodPk = actCodPk;
    }

    public String getActDescrip() {
        return actDescrip;
    }

    public void setActDescrip(String actDescrip) {
        this.actDescrip = actDescrip;
    }

    public String getActSigla() {
        return actSigla;
    }

    public void setActSigla(String actSigla) {
        this.actSigla = actSigla;
    }

    public String getActEnlace() {
        return actEnlace;
    }

    public void setActEnlace(String actEnlace) {
        this.actEnlace = actEnlace;
    }

    public Integer getActEnlaceAuto() {
        return actEnlaceAuto;
    }

    public void setActEnlaceAuto(Integer actEnlaceAuto) {
        this.actEnlaceAuto = actEnlaceAuto;
    }

    public String getActComp() {
        return actComp;
    }

    public void setActComp(String actComp) {
        this.actComp = actComp;
    }

    public String getActAsign() {
        return actAsign;
    }

    public void setActAsign(String actAsign) {
        this.actAsign = actAsign;
    }

    public short getActAutorizar() {
        return actAutorizar;
    }

    public void setActAutorizar(short actAutorizar) {
        this.actAutorizar = actAutorizar;
    }

    public String getActCalend() {
        return actCalend;
    }

    public void setActCalend(String actCalend) {
        this.actCalend = actCalend;
    }

    public String getActFes() {
        return actFes;
    }

    public void setActFes(String actFes) {
        this.actFes = actFes;
    }

    public String getActCrono() {
        return actCrono;
    }

    public void setActCrono(String actCrono) {
        this.actCrono = actCrono;
    }

    public String getActIcoCrono() {
        return actIcoCrono;
    }

    public void setActIcoCrono(String actIcoCrono) {
        this.actIcoCrono = actIcoCrono;
    }

    public String getActIco2() {
        return actIco2;
    }

    public void setActIco2(String actIco2) {
        this.actIco2 = actIco2;
    }

    public String getActIco3() {
        return actIco3;
    }

    public void setActIco3(String actIco3) {
        this.actIco3 = actIco3;
    }

    public String getActIco4() {
        return actIco4;
    }

    public void setActIco4(String actIco4) {
        this.actIco4 = actIco4;
    }

    public String getActIco5() {
        return actIco5;
    }

    public void setActIco5(String actIco5) {
        this.actIco5 = actIco5;
    }

    public Integer getActCodPaiFk() {
        return actCodPaiFk;
    }

    public void setActCodPaiFk(Integer actCodPaiFk) {
        this.actCodPaiFk = actCodPaiFk;
    }

    public Short getActPorAlert() {
        return actPorAlert;
    }

    public void setActPorAlert(Short actPorAlert) {
        this.actPorAlert = actPorAlert;
    }
    
    public String getActAsign2() {
        return actAsign2;
    }

    public void setActAsign2(String actAsign2) {
        this.actAsign2 = actAsign2;
    }
    
    public String getActCrono2() {
        return actCrono2;
    }

    public void setActCrono2(String actCrono2) {
        this.actCrono2 = actCrono2;
    }
    
    public String getActEstado() {
        return actEstado;
    }

    public void setActEstado(String actEstado) {
        this.actEstado = actEstado;
    }
    
    public String getActIco6() {
        return actIco6;
    }

    public void setActIco6(String actIco6) {
        this.actIco6 = actIco6;
    }
    
    public String getActIco7() {
        return actIco7;
    }

    public void setActIco7(String actIco7) {
        this.actIco7 = actIco7;
    }
    
    
    
    public List<ActItems> getActItemsList() {
        return actItemsList;
    }

    public void setActItemsList(List<ActItems> actItemsList) {
        this.actItemsList = actItemsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actCodPk != null ? actCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.actCodPk == null && other.actCodPk != null) || (this.actCodPk != null && !this.actCodPk.equals(other.actCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Actividades[ actCodPk=" + actCodPk + " ]";
    }

    public List<CronoProye> getCronoProyeList() {
        return cronoProyeList;
    }

    public void setCronoProyeList(List<CronoProye> cronoProyeList) {
        this.cronoProyeList = cronoProyeList;
    }

    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }
    
}
