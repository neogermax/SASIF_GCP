/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "CONDICION_COMUNICACION")
@NamedQueries({
    @NamedQuery(name = "CondicionComunicacion.findAll", query = "SELECT c FROM CondicionComunicacion c")})
public class CondicionComunicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONCOM_COD_PK")
    private Integer concomCodPk;
    @Size(max = 50)
    @Column(name = "CONCOM_DESCRIP")
    private String concomDescrip;
    @Size(max = 100)
    @Column(name = "CONCOM_CORR_SER_OR")
    private String concomCorrSerOr;
    @Size(max = 1)
    @Column(name = "CONCOM_TIPO_ENV")
    private String concomTipoEnv;
    @Size(max = 50)
    @Column(name = "CONCOM_PLANT")
    private String concomPlant;
    @Size(max = 1)
    @Column(name = "CONCOM_TIEMP")
    private String concomTiemp;
    @Column(name = "CONCOM_DIAS")
    private Integer concomDias;
    @Size(max = 1)
    @Column(name = "CONCOM_ENV_A")
    private String concomEnvA;

    public CondicionComunicacion() {
    }

    public CondicionComunicacion(Integer concomCodPk) {
        this.concomCodPk = concomCodPk;
    }

    public Integer getConcomCodPk() {
        return concomCodPk;
    }

    public void setConcomCodPk(Integer concomCodPk) {
        this.concomCodPk = concomCodPk;
    }

    public String getConcomDescrip() {
        return concomDescrip;
    }

    public void setConcomDescrip(String concomDescrip) {
        this.concomDescrip = concomDescrip;
    }

    public String getConcomCorrSerOr() {
        return concomCorrSerOr;
    }

    public void setConcomCorrSerOr(String concomCorrSerOr) {
        this.concomCorrSerOr = concomCorrSerOr;
    }

    public String getConcomTipoEnv() {
        return concomTipoEnv;
    }

    public void setConcomTipoEnv(String concomTipoEnv) {
        this.concomTipoEnv = concomTipoEnv;
    }

    public String getConcomPlant() {
        return concomPlant;
    }

    public void setConcomPlant(String concomPlant) {
        this.concomPlant = concomPlant;
    }

    public String getConcomTiemp() {
        return concomTiemp;
    }

    public void setConcomTiemp(String concomTiemp) {
        this.concomTiemp = concomTiemp;
    }

    public Integer getConcomDias() {
        return concomDias;
    }

    public void setConcomDias(Integer concomDias) {
        this.concomDias = concomDias;
    }

    public String getConcomEnvA() {
        return concomEnvA;
    }

    public void setConcomEnvA(String concomEnvA) {
        this.concomEnvA = concomEnvA;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (concomCodPk != null ? concomCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionComunicacion)) {
            return false;
        }
        CondicionComunicacion other = (CondicionComunicacion) object;
        if ((this.concomCodPk == null && other.concomCodPk != null) || (this.concomCodPk != null && !this.concomCodPk.equals(other.concomCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.CondicionComunicacion[ concomCodPk=" + concomCodPk + " ]";
    }
    
}
