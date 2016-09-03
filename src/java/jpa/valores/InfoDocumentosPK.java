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
public class InfoDocumentosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "IDOC_COD_DOC_FK")
    private String idocCodDocFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDOC_SEC")
    private Integer idocSec;

    public InfoDocumentosPK() {
    }

    public InfoDocumentosPK(String idocCodDocFk, Integer idocSec) {
        this.idocCodDocFk = idocCodDocFk;
        this.idocSec = idocSec;
    }

    public String getIdocCodDocFk() {
        return idocCodDocFk;
    }

    public void setIdocCodDocFk(String idocCodDocFk) {
        this.idocCodDocFk = idocCodDocFk;
    }

    public Integer getIdocSec() {
        return idocSec;
    }

    public void setIdocSec(Integer idocSec) {
        this.idocSec = idocSec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idocCodDocFk != null ? idocCodDocFk.hashCode() : 0);
        hash += (int) idocSec;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoDocumentosPK)) {
            return false;
        }
        InfoDocumentosPK other = (InfoDocumentosPK) object;
        if ((this.idocCodDocFk == null && other.idocCodDocFk != null) || (this.idocCodDocFk != null && !this.idocCodDocFk.equals(other.idocCodDocFk))) {
            return false;
        }
        if (this.idocSec != other.idocSec) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.InfoDocumentosPK[ idocCodDocFk=" + idocCodDocFk + ", idocSec=" + idocSec + " ]";
    }
    
}
