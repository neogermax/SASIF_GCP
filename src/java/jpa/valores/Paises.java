/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author saflap
 */
@Entity
@Table(name = "PAISES")
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p")})
public class Paises implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAI_COD_PK")
    private Integer paiCodPk;
    @Size(max = 50)
    @Column(name = "PAI_NOM")
    private String paiNom;
    @Size(max = 1)
    @Column(name = "PAI_EST_LUN")
    private String paiEstLun;
    @Column(name = "PAI_HOI1_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi1Lun;
    @Column(name = "PAI_HOF1_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof1Lun;
    @Column(name = "PAI_HOI2_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi2Lun;
    @Column(name = "PAI_HOF2_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof2Lun;
    @Column(name = "PAI_HOI3_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi3Lun;
    @Column(name = "PAI_HOF3_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof3Lun;
    @Column(name = "PAI_HOI4_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi4Lun;
    @Column(name = "PAI_HOF4_LUN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof4Lun;
    @Column(name = "PAI_HOI1_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi1Mar;
    @Column(name = "PAI_HOF1_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof1Mar;
    @Column(name = "PAI_HOI2_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi2Mar;
    @Column(name = "PAI_HOF2_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof2Mar;
    @Column(name = "PAI_HOI3_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi3Mar;
    @Column(name = "PAI_HOF3_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof3Mar;
    @Column(name = "PAI_HOI4_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi4Mar;
    @Column(name = "PAI_HOF4_MAR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof4Mar;
    @Column(name = "PAI_HOI1_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi1Mie;
    @Column(name = "PAI_HOF1_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof1Mie;
    @Column(name = "PAI_HOI2_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi2Mie;
    @Column(name = "PAI_HOF2_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof2Mie;
    @Column(name = "PAI_HOI3_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi3Mie;
    @Column(name = "PAI_HOF3_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof3Mie;
    @Column(name = "PAI_HOI4_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi4Mie;
    @Column(name = "PAI_HOF4_MIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof4Mie;
    @Column(name = "PAI_HOI1_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi1Jue;
    @Column(name = "PAI_HOF1_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof1Jue;
    @Column(name = "PAI_HOI2_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi2Jue;
    @Column(name = "PAI_HOF2_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof2Jue;
    @Column(name = "PAI_HOI3_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi3Jue;
    @Column(name = "PAI_HOF3_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof3Jue;
    @Column(name = "PAI_HOI4_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi4Jue;
    @Column(name = "PAI_HOF4_JUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof4Jue;
    @Column(name = "PAI_HOI1_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi1Vie;
    @Column(name = "PAI_HOF1_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof1Vie;
    @Column(name = "PAI_HOI2_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi2Vie;
    @Column(name = "PAI_HOF2_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof2Vie;
    @Column(name = "PAI_HOI3_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi3Vie;
    @Column(name = "PAI_HOF3_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof3Vie;
    @Column(name = "PAI_HOI4_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi4Vie;
    @Column(name = "PAI_HOF4_VIE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof4Vie;
    @Column(name = "PAI_HOI1_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi1Sab;
    @Column(name = "PAI_HOF1_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof1Sab;
    @Column(name = "PAI_HOI2_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi2Sab;
    @Column(name = "PAI_HOF2_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof2Sab;
    @Column(name = "PAI_HOI3_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi3Sab;
    @Column(name = "PAI_HOF3_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof3Sab;
    @Column(name = "PAI_HOI4_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi4Sab;
    @Column(name = "PAI_HOF4_SAB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof4Sab;
    @Column(name = "PAI_HOI1_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi1Dom;
    @Column(name = "PAI_HOF1_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof1Dom;
    @Column(name = "PAI_HOI2_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi2Dom;
    @Column(name = "PAI_HOF2_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof2Dom;
    @Column(name = "PAI_HOI3_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi3Dom;
    @Column(name = "PAI_HOF3_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof3Dom;
    @Column(name = "PAI_HOI4_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHoi4Dom;
    @Column(name = "PAI_HOF4_DOM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paiHof4Dom;
    @Size(max = 1)
    @Column(name = "PAI_EST_MAR")
    private String paiEstMar;
    @Size(max = 1)
    @Column(name = "PAI_EST_MIE")
    private String paiEstMie;
    @Size(max = 1)
    @Column(name = "PAI_EST_JUE")
    private String paiEstJue;
    @Size(max = 1)
    @Column(name = "PAI_EST_VIE")
    private String paiEstVie;
    @Size(max = 1)
    @Column(name = "PAI_EST_SAB")
    private String paiEstSab;
    @Size(max = 1)
    @Column(name = "PAI_EST_DOM")
    private String paiEstDom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paises")
    private List<Festivos> festivosList;
    
    
    
    

    public Paises() {
    }

    public Paises(Integer paiCodPk) {
        this.paiCodPk = paiCodPk;
    }

    public Integer getPaiCodPk() {
        return paiCodPk;
    }

    public void setPaiCodPk(Integer paiCodPk) {
        this.paiCodPk = paiCodPk;
    }

    public String getPaiNom() {
        return paiNom;
    }

    public void setPaiNom(String paiNom) {
        this.paiNom = paiNom;
    }

    public String getPaiEstLun() {
        return paiEstLun;
    }

    public void setPaiEstLun(String paiEstLun) {
        this.paiEstLun = paiEstLun;
    }

    public Date getPaiHoi1Lun() {
        return paiHoi1Lun;
    }

    public void setPaiHoi1Lun(Date paiHoi1Lun) {
        this.paiHoi1Lun = paiHoi1Lun;
    }

    public Date getPaiHof1Lun() {
        return paiHof1Lun;
    }

    public void setPaiHof1Lun(Date paiHof1Lun) {
        this.paiHof1Lun = paiHof1Lun;
    }

    public Date getPaiHoi2Lun() {
        return paiHoi2Lun;
    }

    public void setPaiHoi2Lun(Date paiHoi2Lun) {
        this.paiHoi2Lun = paiHoi2Lun;
    }

    public Date getPaiHof2Lun() {
        return paiHof2Lun;
    }

    public void setPaiHof2Lun(Date paiHof2Lun) {
        this.paiHof2Lun = paiHof2Lun;
    }

    public Date getPaiHoi3Lun() {
        return paiHoi3Lun;
    }

    public void setPaiHoi3Lun(Date paiHoi3Lun) {
        this.paiHoi3Lun = paiHoi3Lun;
    }

    public Date getPaiHof3Lun() {
        return paiHof3Lun;
    }

    public void setPaiHof3Lun(Date paiHof3Lun) {
        this.paiHof3Lun = paiHof3Lun;
    }

    public Date getPaiHoi4Lun() {
        return paiHoi4Lun;
    }

    public void setPaiHoi4Lun(Date paiHoi4Lun) {
        this.paiHoi4Lun = paiHoi4Lun;
    }

    public Date getPaiHof4Lun() {
        return paiHof4Lun;
    }

    public void setPaiHof4Lun(Date paiHof4Lun) {
        this.paiHof4Lun = paiHof4Lun;
    }

    public Date getPaiHoi1Mar() {
        return paiHoi1Mar;
    }

    public void setPaiHoi1Mar(Date paiHoi1Mar) {
        this.paiHoi1Mar = paiHoi1Mar;
    }

    public Date getPaiHof1Mar() {
        return paiHof1Mar;
    }

    public void setPaiHof1Mar(Date paiHof1Mar) {
        this.paiHof1Mar = paiHof1Mar;
    }

    public Date getPaiHoi2Mar() {
        return paiHoi2Mar;
    }

    public void setPaiHoi2Mar(Date paiHoi2Mar) {
        this.paiHoi2Mar = paiHoi2Mar;
    }

    public Date getPaiHof2Mar() {
        return paiHof2Mar;
    }

    public void setPaiHof2Mar(Date paiHof2Mar) {
        this.paiHof2Mar = paiHof2Mar;
    }

    public Date getPaiHoi3Mar() {
        return paiHoi3Mar;
    }

    public void setPaiHoi3Mar(Date paiHoi3Mar) {
        this.paiHoi3Mar = paiHoi3Mar;
    }

    public Date getPaiHof3Mar() {
        return paiHof3Mar;
    }

    public void setPaiHof3Mar(Date paiHof3Mar) {
        this.paiHof3Mar = paiHof3Mar;
    }

    public Date getPaiHoi4Mar() {
        return paiHoi4Mar;
    }

    public void setPaiHoi4Mar(Date paiHoi4Mar) {
        this.paiHoi4Mar = paiHoi4Mar;
    }

    public Date getPaiHof4Mar() {
        return paiHof4Mar;
    }

    public void setPaiHof4Mar(Date paiHof4Mar) {
        this.paiHof4Mar = paiHof4Mar;
    }

    public Date getPaiHoi1Mie() {
        return paiHoi1Mie;
    }

    public void setPaiHoi1Mie(Date paiHoi1Mie) {
        this.paiHoi1Mie = paiHoi1Mie;
    }

    public Date getPaiHof1Mie() {
        return paiHof1Mie;
    }

    public void setPaiHof1Mie(Date paiHof1Mie) {
        this.paiHof1Mie = paiHof1Mie;
    }

    public Date getPaiHoi2Mie() {
        return paiHoi2Mie;
    }

    public void setPaiHoi2Mie(Date paiHoi2Mie) {
        this.paiHoi2Mie = paiHoi2Mie;
    }

    public Date getPaiHof2Mie() {
        return paiHof2Mie;
    }

    public void setPaiHof2Mie(Date paiHof2Mie) {
        this.paiHof2Mie = paiHof2Mie;
    }

    public Date getPaiHoi3Mie() {
        return paiHoi3Mie;
    }

    public void setPaiHoi3Mie(Date paiHoi3Mie) {
        this.paiHoi3Mie = paiHoi3Mie;
    }

    public Date getPaiHof3Mie() {
        return paiHof3Mie;
    }

    public void setPaiHof3Mie(Date paiHof3Mie) {
        this.paiHof3Mie = paiHof3Mie;
    }

    public Date getPaiHoi4Mie() {
        return paiHoi4Mie;
    }

    public void setPaiHoi4Mie(Date paiHoi4Mie) {
        this.paiHoi4Mie = paiHoi4Mie;
    }

    public Date getPaiHof4Mie() {
        return paiHof4Mie;
    }

    public void setPaiHof4Mie(Date paiHof4Mie) {
        this.paiHof4Mie = paiHof4Mie;
    }

    public Date getPaiHoi1Jue() {
        return paiHoi1Jue;
    }

    public void setPaiHoi1Jue(Date paiHoi1Jue) {
        this.paiHoi1Jue = paiHoi1Jue;
    }

    public Date getPaiHof1Jue() {
        return paiHof1Jue;
    }

    public void setPaiHof1Jue(Date paiHof1Jue) {
        this.paiHof1Jue = paiHof1Jue;
    }

    public Date getPaiHoi2Jue() {
        return paiHoi2Jue;
    }

    public void setPaiHoi2Jue(Date paiHoi2Jue) {
        this.paiHoi2Jue = paiHoi2Jue;
    }

    public Date getPaiHof2Jue() {
        return paiHof2Jue;
    }

    public void setPaiHof2Jue(Date paiHof2Jue) {
        this.paiHof2Jue = paiHof2Jue;
    }

    public Date getPaiHoi3Jue() {
        return paiHoi3Jue;
    }

    public void setPaiHoi3Jue(Date paiHoi3Jue) {
        this.paiHoi3Jue = paiHoi3Jue;
    }

    public Date getPaiHof3Jue() {
        return paiHof3Jue;
    }

    public void setPaiHof3Jue(Date paiHof3Jue) {
        this.paiHof3Jue = paiHof3Jue;
    }

    public Date getPaiHoi4Jue() {
        return paiHoi4Jue;
    }

    public void setPaiHoi4Jue(Date paiHoi4Jue) {
        this.paiHoi4Jue = paiHoi4Jue;
    }

    public Date getPaiHof4Jue() {
        return paiHof4Jue;
    }

    public void setPaiHof4Jue(Date paiHof4Jue) {
        this.paiHof4Jue = paiHof4Jue;
    }

    public Date getPaiHoi1Vie() {
        return paiHoi1Vie;
    }

    public void setPaiHoi1Vie(Date paiHoi1Vie) {
        this.paiHoi1Vie = paiHoi1Vie;
    }

    public Date getPaiHof1Vie() {
        return paiHof1Vie;
    }

    public void setPaiHof1Vie(Date paiHof1Vie) {
        this.paiHof1Vie = paiHof1Vie;
    }

    public Date getPaiHoi2Vie() {
        return paiHoi2Vie;
    }

    public void setPaiHoi2Vie(Date paiHoi2Vie) {
        this.paiHoi2Vie = paiHoi2Vie;
    }

    public Date getPaiHof2Vie() {
        return paiHof2Vie;
    }

    public void setPaiHof2Vie(Date paiHof2Vie) {
        this.paiHof2Vie = paiHof2Vie;
    }

    public Date getPaiHoi3Vie() {
        return paiHoi3Vie;
    }

    public void setPaiHoi3Vie(Date paiHoi3Vie) {
        this.paiHoi3Vie = paiHoi3Vie;
    }

    public Date getPaiHof3Vie() {
        return paiHof3Vie;
    }

    public void setPaiHof3Vie(Date paiHof3Vie) {
        this.paiHof3Vie = paiHof3Vie;
    }

    public Date getPaiHoi4Vie() {
        return paiHoi4Vie;
    }

    public void setPaiHoi4Vie(Date paiHoi4Vie) {
        this.paiHoi4Vie = paiHoi4Vie;
    }

    public Date getPaiHof4Vie() {
        return paiHof4Vie;
    }

    public void setPaiHof4Vie(Date paiHof4Vie) {
        this.paiHof4Vie = paiHof4Vie;
    }

    public Date getPaiHoi1Sab() {
        return paiHoi1Sab;
    }

    public void setPaiHoi1Sab(Date paiHoi1Sab) {
        this.paiHoi1Sab = paiHoi1Sab;
    }

    public Date getPaiHof1Sab() {
        return paiHof1Sab;
    }

    public void setPaiHof1Sab(Date paiHof1Sab) {
        this.paiHof1Sab = paiHof1Sab;
    }

    public Date getPaiHoi2Sab() {
        return paiHoi2Sab;
    }

    public void setPaiHoi2Sab(Date paiHoi2Sab) {
        this.paiHoi2Sab = paiHoi2Sab;
    }

    public Date getPaiHof2Sab() {
        return paiHof2Sab;
    }

    public void setPaiHof2Sab(Date paiHof2Sab) {
        this.paiHof2Sab = paiHof2Sab;
    }

    public Date getPaiHoi3Sab() {
        return paiHoi3Sab;
    }

    public void setPaiHoi3Sab(Date paiHoi3Sab) {
        this.paiHoi3Sab = paiHoi3Sab;
    }

    public Date getPaiHof3Sab() {
        return paiHof3Sab;
    }

    public void setPaiHof3Sab(Date paiHof3Sab) {
        this.paiHof3Sab = paiHof3Sab;
    }

    public Date getPaiHoi4Sab() {
        return paiHoi4Sab;
    }

    public void setPaiHoi4Sab(Date paiHoi4Sab) {
        this.paiHoi4Sab = paiHoi4Sab;
    }

    public Date getPaiHof4Sab() {
        return paiHof4Sab;
    }

    public void setPaiHof4Sab(Date paiHof4Sab) {
        this.paiHof4Sab = paiHof4Sab;
    }

    public Date getPaiHoi1Dom() {
        return paiHoi1Dom;
    }

    public void setPaiHoi1Dom(Date paiHoi1Dom) {
        this.paiHoi1Dom = paiHoi1Dom;
    }

    public Date getPaiHof1Dom() {
        return paiHof1Dom;
    }

    public void setPaiHof1Dom(Date paiHof1Dom) {
        this.paiHof1Dom = paiHof1Dom;
    }

    public Date getPaiHoi2Dom() {
        return paiHoi2Dom;
    }

    public void setPaiHoi2Dom(Date paiHoi2Dom) {
        this.paiHoi2Dom = paiHoi2Dom;
    }

    public Date getPaiHof2Dom() {
        return paiHof2Dom;
    }

    public void setPaiHof2Dom(Date paiHof2Dom) {
        this.paiHof2Dom = paiHof2Dom;
    }

    public Date getPaiHoi3Dom() {
        return paiHoi3Dom;
    }

    public void setPaiHoi3Dom(Date paiHoi3Dom) {
        this.paiHoi3Dom = paiHoi3Dom;
    }

    public Date getPaiHof3Dom() {
        return paiHof3Dom;
    }

    public void setPaiHof3Dom(Date paiHof3Dom) {
        this.paiHof3Dom = paiHof3Dom;
    }

    public Date getPaiHoi4Dom() {
        return paiHoi4Dom;
    }

    public void setPaiHoi4Dom(Date paiHoi4Dom) {
        this.paiHoi4Dom = paiHoi4Dom;
    }

    public Date getPaiHof4Dom() {
        return paiHof4Dom;
    }

    public void setPaiHof4Dom(Date paiHof4Dom) {
        this.paiHof4Dom = paiHof4Dom;
    }

    public String getPaiEstMar() {
        return paiEstMar;
    }

    public void setPaiEstMar(String paiEstMar) {
        this.paiEstMar = paiEstMar;
    }

    public String getPaiEstMie() {
        return paiEstMie;
    }

    public void setPaiEstMie(String paiEstMie) {
        this.paiEstMie = paiEstMie;
    }

    public String getPaiEstJue() {
        return paiEstJue;
    }

    public void setPaiEstJue(String paiEstJue) {
        this.paiEstJue = paiEstJue;
    }

    public String getPaiEstVie() {
        return paiEstVie;
    }

    public void setPaiEstVie(String paiEstVie) {
        this.paiEstVie = paiEstVie;
    }

    public String getPaiEstSab() {
        return paiEstSab;
    }

    public void setPaiEstSab(String paiEstSab) {
        this.paiEstSab = paiEstSab;
    }

    public String getPaiEstDom() {
        return paiEstDom;
    }

    public void setPaiEstDom(String paiEstDom) {
        this.paiEstDom = paiEstDom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paiCodPk != null ? paiCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
        if ((this.paiCodPk == null && other.paiCodPk != null) || (this.paiCodPk != null && !this.paiCodPk.equals(other.paiCodPk))) {
            System.out.println("return false");
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Paises[ paiCodPk=" + paiCodPk + " ]";
    }

    public List<Festivos> getFestivosList() {
        return festivosList;
    }

    public void setFestivosList(List<Festivos> festivosList) {
        this.festivosList = festivosList;
    }

}
