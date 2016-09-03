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
@Table(name = "CLASES")
@NamedQueries({
    @NamedQuery(name = "Clases.findAll", query = "SELECT c FROM Clases c")})
public class Clases implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private List<DocmActv> docmActvList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLS_COD_PK")
    private Integer clsCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CLS_DESCRIP")
    private String clsDescrip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLS_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date clsModif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CLS_USU_COD")
    private String clsUsuCod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proClsCodFk")
    private List<Proyectos> proyectosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private List<Responsables> responsablesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases1")
    private List<Paralelas> paralelasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private List<Paralelas> paralelasList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private List<ProyActs> proyActsList;
    @OneToMany(mappedBy = "alfClsCodFk")
    private List<Alfanumericas> alfanumericasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private List<Permisos> permisosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numClsCodFk")
    private List<Numericas> numericasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clases")
    private List<Relaciones> relacionesList;

    public Clases() {
    }

    public Clases(Integer clsCodPk) {
        this.clsCodPk = clsCodPk;
    }

    public Clases(Integer clsCodPk, String clsDescrip, Date clsModif, String clsUsuCod) {
        this.clsCodPk = clsCodPk;
        this.clsDescrip = clsDescrip;
        this.clsModif = clsModif;
        this.clsUsuCod = clsUsuCod;
    }

    public Integer getClsCodPk() {
        return clsCodPk;
    }

    public void setClsCodPk(Integer clsCodPk) {
        this.clsCodPk = clsCodPk;
    }

    public String getClsDescrip() {
        return clsDescrip;
    }

    public void setClsDescrip(String clsDescrip) {
        this.clsDescrip = clsDescrip;
    }

    public Date getClsModif() {
        return clsModif;
    }

    public void setClsModif(Date clsModif) {
        this.clsModif = clsModif;
    }

    public String getClsUsuCod() {
        return clsUsuCod;
    }

    public void setClsUsuCod(String clsUsuCod) {
        this.clsUsuCod = clsUsuCod;
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
        hash += (clsCodPk != null ? clsCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clases)) {
            return false;
        }
        Clases other = (Clases) object;
        if ((this.clsCodPk == null && other.clsCodPk != null) || (this.clsCodPk != null && !this.clsCodPk.equals(other.clsCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Clases[ clsCodPk=" + clsCodPk + " ]";
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
