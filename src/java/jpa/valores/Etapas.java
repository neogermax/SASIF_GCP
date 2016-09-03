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
 * @author analista02
 */
@Entity
@Table(name = "ETAPAS")
@NamedQueries({
    @NamedQuery(name = "Etapas.findAll", query = "SELECT e FROM Etapas e")})
public class Etapas implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapas")
    private List<DocmActv> docmActvList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETP_COD_PK")
    private Integer etpCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ETP_DESCRIP")
    private String etpDescrip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "ETP_SIGLA")
    private String etpSigla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ETP_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date etpModif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ETP_USU_COD")
    private String etpUsuCod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proEtpCodFk")
    private List<Proyectos> proyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapas")
    private List<Responsables> responsablesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapas")
    private List<Paralelas> paralelasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapas1")
    private List<Paralelas> paralelasList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapas")
    private List<ProyActs> proyActsList;
    @OneToMany(mappedBy = "alfEtpCodFk")
    private List<Alfanumericas> alfanumericasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapas")
    private List<Permisos> permisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numEtpCodFk")
    private List<Numericas> numericasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relEtpCodFk")
    private List<Relaciones> relacionesList;

    public Etapas() {
    }

    public Etapas(Integer etpCodPk) {
        this.etpCodPk = etpCodPk;
    }

    public Etapas(Integer etpCodPk, String etpDescrip, String etpSigla, Date etpModif, String etpUsuCod) {
        this.etpCodPk = etpCodPk;
        this.etpDescrip = etpDescrip;
        this.etpSigla = etpSigla;
        this.etpModif = etpModif;
        this.etpUsuCod = etpUsuCod;
    }

    public Integer getEtpCodPk() {
        return etpCodPk;
    }

    public void setEtpCodPk(Integer etpCodPk) {
        this.etpCodPk = etpCodPk;
    }

    public String getEtpDescrip() {
        return etpDescrip;
    }

    public void setEtpDescrip(String etpDescrip) {
        this.etpDescrip = etpDescrip;
    }

    public String getEtpSigla() {
        return etpSigla;
    }

    public void setEtpSigla(String etpSigla) {
        this.etpSigla = etpSigla;
    }

    public Date getEtpModif() {
        return etpModif;
    }

    public void setEtpModif(Date etpModif) {
        this.etpModif = etpModif;
    }

    public String getEtpUsuCod() {
        return etpUsuCod;
    }

    public void setEtpUsuCod(String etpUsuCod) {
        this.etpUsuCod = etpUsuCod;
    }

    public List<Alfanumericas> getAlfanumericasList() {
        return alfanumericasList;
    }

    public void setAlfanumericasList(List<Alfanumericas> alfanumericasList) {
        this.alfanumericasList = alfanumericasList;
    }

    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    public List<Numericas> getNumericasList() {
        return numericasList;
    }

    public void setNumericasList(List<Numericas> numericasList) {
        this.numericasList = numericasList;
    }

    public List<Relaciones> getRelacionesList() {
        return relacionesList;
    }

    public void setRelacionesList(List<Relaciones> relacionesList) {
        this.relacionesList = relacionesList;
    }

    public List<Proyectos> getProyectosList() {
        return proyectosList;
    }

    public void setProyectosList(List<Proyectos> proyectosList) {
        this.proyectosList = proyectosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etpCodPk != null ? etpCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapas)) {
            return false;
        }
        Etapas other = (Etapas) object;
        if ((this.etpCodPk == null && other.etpCodPk != null) || (this.etpCodPk != null && !this.etpCodPk.equals(other.etpCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Etapas[ etpCodPk=" + etpCodPk + " ]";
    }

    public List<ProyActs> getProyActsList() {
        return proyActsList;
    }

    public void setProyActsList(List<ProyActs> proyActsList) {
        this.proyActsList = proyActsList;
    }

    public List<Paralelas> getParalelasList() {
        return paralelasList;
    }

    public void setParalelasList(List<Paralelas> paralelasList) {
        this.paralelasList = paralelasList;
    }

    public List<Paralelas> getParalelasList1() {
        return paralelasList1;
    }

    public void setParalelasList1(List<Paralelas> paralelasList1) {
        this.paralelasList1 = paralelasList1;
    }

    public List<Responsables> getResponsablesList() {
        return responsablesList;
    }

    public void setResponsablesList(List<Responsables> responsablesList) {
        this.responsablesList = responsablesList;
    }

    public List<DocmActv> getDocmActvList() {
        return docmActvList;
    }

    public void setDocmActvList(List<DocmActv> docmActvList) {
        this.docmActvList = docmActvList;
    }

}
