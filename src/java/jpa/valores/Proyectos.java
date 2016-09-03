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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PROYECTOS")
@NamedQueries({
@NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p")})
public class Proyectos implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Componentes> componentesList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_COD_PK")
    private Integer proCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRO_DESCRIP")
    private String proDescrip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRO_USU_COD_FK")
    private String proUsuCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRO_FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proFechaHora;
    @Size(min = 1, max = 1)
    @Column(name = "PRO_ESTADO")
    private String proEstado;
    @JoinColumn(name = "PRO_ETP_COD_FK", referencedColumnName = "ETP_COD_PK")
    @ManyToOne(optional = false)
    private Etapas proEtpCodFk;
    @JoinColumn(name = "PRO_CLS_COD_FK", referencedColumnName = "CLS_COD_PK")
    @ManyToOne(optional = false)
    private Clases proClsCodFk;
    @JoinColumn(name = "PRO_ACT_COD_FK", referencedColumnName = "ACT_COD_PK")
    @ManyToOne(optional = false)
    private Actividades proActCodFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<Responsables> responsablesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<ProyActs> proyActsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectos")
    private List<ProyItems> proyItemsList;

    public Proyectos() {
    }

    public Proyectos(Integer proCodPk) {
        this.proCodPk = proCodPk;
    }

    public Proyectos(Integer proCodPk, String proDescrip, String proUsuCodFk, Date proFechaHora,String proEstado) {
        this.proCodPk = proCodPk;
        this.proDescrip = proDescrip;
        this.proUsuCodFk = proUsuCodFk;
        this.proFechaHora = proFechaHora;
        this.proEstado = proEstado;
    }

    public Integer getProCodPk() {
        return proCodPk;
    }

    public void setProCodPk(Integer proCodPk) {
        this.proCodPk = proCodPk;
    }

    public String getProDescrip() {
        return proDescrip;
    }

    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }

    public String getProUsuCodFk() {
        return proUsuCodFk;
    }

    public void setProUsuCodFk(String proUsuCodFk) {
        this.proUsuCodFk = proUsuCodFk;
    }

    public Date getProFechaHora() {
        return proFechaHora;
    }

    public void setProFechaHora(Date proFechaHora) {
        this.proFechaHora = proFechaHora;
    }
    
    public String getProEstado() {
        if (proEstado != null) {
            if (proEstado.equals("F") || proEstado.equals("Fin")) {
                proEstado = "Fin";
            }else if(proEstado.equals("A") || proEstado.equals("Activo")) {
                proEstado = "Activo";
            }else {
                proEstado = "Sin E.";
            }
        } else {
            proEstado = "Sin E.";
        }
        return proEstado;
    }

    public void setProEstado(String proEstado) {
        this.proEstado = proEstado;
    }

    public Etapas getProEtpCodFk() {
        return proEtpCodFk;
    }

    public void setProEtpCodFk(Etapas proEtpCodFk) {
        this.proEtpCodFk = proEtpCodFk;
    }

    public Clases getProClsCodFk() {
        return proClsCodFk;
    }

    public void setProClsCodFk(Clases proClsCodFk) {
        this.proClsCodFk = proClsCodFk;
    }

    public Actividades getProActCodFk() {
        return proActCodFk;
    }

    public void setProActCodFk(Actividades proActCodFk) {
        this.proActCodFk = proActCodFk;
    }

    public List<ProyItems> getProyItemsList() {
        return proyItemsList;
    }

    public void setProyItemsList(List<ProyItems> proyItemsList) {
        this.proyItemsList = proyItemsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proCodPk != null ? proCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.proCodPk == null && other.proCodPk != null) || (this.proCodPk != null && !this.proCodPk.equals(other.proCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Proyectos[ proCodPk=" + proCodPk + " ]";
    }

    public List<ProyActs> getProyActsList() {
        return proyActsList;
    }

    public void setProyActsList(List<ProyActs> proyActsList) {
        this.proyActsList = proyActsList;
    }

    public List<Responsables> getResponsablesList() {
        return responsablesList;
    }

    public void setResponsablesList(List<Responsables> responsablesList) {
        this.responsablesList = responsablesList;
    }

    public List<Componentes> getComponentesList() {
        return componentesList;
    }

    public void setComponentesList(List<Componentes> componentesList) {
        this.componentesList = componentesList;
    }
    
}
