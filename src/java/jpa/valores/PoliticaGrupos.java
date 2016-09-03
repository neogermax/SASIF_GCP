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
@Table(name = "POLITICA_GRUPOS")
@NamedQueries({
    @NamedQuery(name = "PoliticaGrupos.findAll", query = "SELECT p FROM PoliticaGrupos p")})
public class PoliticaGrupos implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_DIAS_VIG")
    private Short polDiasVig;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_CAN_NUM")
    private Short polCanNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_CAN_LET")
    private Short polCanLet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_ULT_CLA")
    private Short polUltCla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_INTENTOS")
    private Short polIntentos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_LOG_MAX")
    private Short polLogMax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_LOG_MIN")
    private Short polLogMin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuPolGrupFk")
    private List<Usuarios> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emprGrupPolFk")
    private List<Empresas> empresasList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "POL_COD_PK")
    private Integer polCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "POL_DESCRIP")
    private String polDescrip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "POL_TIPO_CRYP")
    private String polTipoCryp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "POL_REP_CAR")
    private String polRepCar;

    public PoliticaGrupos() {
    }

    public PoliticaGrupos(Integer polCodPk) {
        this.polCodPk = polCodPk;
    }

    public PoliticaGrupos(Integer polCodPk, String polDescrip, Short polDiasVig, Short polCanNum, Short polCanLet, Short polUltCla, Short polIntentos, String polTipoCryp, String polRepCar, Short polLogMax, Short polLogMin) {
        this.polCodPk = polCodPk;
        this.polDescrip = polDescrip;
        this.polDiasVig = polDiasVig;
        this.polCanNum = polCanNum;
        this.polCanLet = polCanLet;
        this.polUltCla = polUltCla;
        this.polIntentos = polIntentos;
        this.polTipoCryp = polTipoCryp;
        this.polRepCar = polRepCar;
        this.polLogMax = polLogMax;
        this.polLogMin = polLogMin;
    }

    public Integer getPolCodPk() {
        return polCodPk;
    }

    public void setPolCodPk(Integer polCodPk) {
        this.polCodPk = polCodPk;
    }

    public String getPolDescrip() {
        return polDescrip;
    }

    public void setPolDescrip(String polDescrip) {
        this.polDescrip = polDescrip;
    }

    public Short getPolDiasVig() {
        return polDiasVig;
    }

    public void setPolDiasVig(Short polDiasVig) {
        this.polDiasVig = polDiasVig;
    }

    public Short getPolCanNum() {
        return polCanNum;
    }

    public void setPolCanNum(Short polCanNum) {
        this.polCanNum = polCanNum;
    }

    public Short getPolCanLet() {
        return polCanLet;
    }

    public void setPolCanLet(Short polCanLet) {
        this.polCanLet = polCanLet;
    }

    public Short getPolUltCla() {
        return polUltCla;
    }

    public void setPolUltCla(Short polUltCla) {
        this.polUltCla = polUltCla;
    }

    public Short getPolIntentos() {
        return polIntentos;
    }

    public void setPolIntentos(Short polIntentos) {
        this.polIntentos = polIntentos;
    }

    public String getPolTipoCryp() {
        return polTipoCryp;
    }

    public void setPolTipoCryp(String polTipoCryp) {
        this.polTipoCryp = polTipoCryp;
    }

    public String getPolRepCar() {
        return polRepCar;
    }

    public void setPolRepCar(String polRepCar) {
        this.polRepCar = polRepCar;
    }

    public Short getPolLogMax() {
        return polLogMax;
    }

    public void setPolLogMax(Short polLogMax) {
        this.polLogMax = polLogMax;
    }

    public Short getPolLogMin() {
        return polLogMin;
    }

    public void setPolLogMin(Short polLogMin) {
        this.polLogMin = polLogMin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (polCodPk != null ? polCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoliticaGrupos)) {
            return false;
        }
        PoliticaGrupos other = (PoliticaGrupos) object;
        if ((this.polCodPk == null && other.polCodPk != null) || (this.polCodPk != null && !this.polCodPk.equals(other.polCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.PoliticaGrupos[ polCodPk=" + polCodPk + " ]";
    }

    public List<Usuarios> getUsuariosCollection() {
        return usuariosList;
    }

    public void setUsuariosCollection(List<Usuarios> usuariosCollection) {
        this.usuariosList = usuariosCollection;
    }

    public List<Empresas> getEmpresasCollection() {
        return empresasList;
    }

    public void setEmpresasCollection(List<Empresas> empresasCollection) {
        this.empresasList = empresasList;
    }
}
