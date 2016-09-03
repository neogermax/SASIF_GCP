/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Embeddable
public class DocmActvPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOA_CLS_COD_FK")
    private int doaClsCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOA_ETP_COD_FK")
    private int doaEtpCodFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOA_ACT_COD_FK")
    private int doaActCodFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DOA_PDO_DOC_FK")
    private String doaPdoDocFk;

    public DocmActvPK() {
    }

    public DocmActvPK(Integer doaClsCodFk, Integer doaEtpCodFk, Integer doaActCodFk, String doaPdoDocFk) {
        this.doaClsCodFk = doaClsCodFk;
        this.doaEtpCodFk = doaEtpCodFk;
        this.doaActCodFk = doaActCodFk;
        this.doaPdoDocFk = doaPdoDocFk;
    }

    public int getDoaClsCodFk() {
        return doaClsCodFk;
    }

    public void setDoaClsCodFk(Integer doaClsCodFk) {
        this.doaClsCodFk = doaClsCodFk;
    }

    public int getDoaEtpCodFk() {
        return doaEtpCodFk;
    }

    public void setDoaEtpCodFk(Integer doaEtpCodFk) {
        this.doaEtpCodFk = doaEtpCodFk;
    }

    public int getDoaActCodFk() {
        return doaActCodFk;
    }

    public void setDoaActCodFk(Integer doaActCodFk) {
        this.doaActCodFk = doaActCodFk;
    }

    public String getDoaPdoDocFk() {
        return doaPdoDocFk;
    }

    public void setDoaPdoDocFk(String doaPdoDocFk) {
        this.doaPdoDocFk = doaPdoDocFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) doaClsCodFk;
        hash += (int) doaEtpCodFk;
        hash += (int) doaActCodFk;
        hash += (doaPdoDocFk != null ? doaPdoDocFk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocmActvPK)) {
            return false;
        }
        DocmActvPK other = (DocmActvPK) object;
        if (this.doaClsCodFk != other.doaClsCodFk) {
            return false;
        }
        if (this.doaEtpCodFk != other.doaEtpCodFk) {
            return false;
        }
        if (this.doaActCodFk != other.doaActCodFk) {
            return false;
        }
        if ((this.doaPdoDocFk == null && other.doaPdoDocFk != null) || (this.doaPdoDocFk != null && !this.doaPdoDocFk.equals(other.doaPdoDocFk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.DocmActvPK[ doaClsCodFk=" + doaClsCodFk + ", doaEtpCodFk=" + doaEtpCodFk + ", doaActCodFk=" + doaActCodFk + ", doaPdoDocFk=" + doaPdoDocFk + " ]";
    }
    
}
