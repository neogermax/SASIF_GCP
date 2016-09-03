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
public class DocExistentesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "DOEX_COD_APL_OR")
    private String doexCodAplOr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "DOEX_TIPO_DOC")
    private String doexTipoDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOEX_SEC_DPC")
    private Long doexSecDpc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DOEX_IDE_APLI")
    private Long doexIdeApli;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DOEX_NOM_DOC")
    private String doexNomDoc;

    public DocExistentesPK() {
    }

    public DocExistentesPK(String doexCodAplOr, String doexTipoDoc, Long doexSecDpc, Long doexIdeApli, String doexNomDoc) {
        this.doexCodAplOr = doexCodAplOr;
        this.doexTipoDoc = doexTipoDoc;
        this.doexSecDpc = doexSecDpc;
        this.doexIdeApli = doexIdeApli;
        this.doexNomDoc = doexNomDoc;
    }

    public String getDoexCodAplOr() {
        return doexCodAplOr;
    }

    public void setDoexCodAplOr(String doexCodAplOr) {
        this.doexCodAplOr = doexCodAplOr;
    }

    public String getDoexTipoDoc() {
        return doexTipoDoc;
    }

    public void setDoexTipoDoc(String doexTipoDoc) {
        this.doexTipoDoc = doexTipoDoc;
    }

    public Long getDoexSecDpc() {
        return doexSecDpc;
    }

    public void setDoexSecDpc(Long doexSecDpc) {
        this.doexSecDpc = doexSecDpc;
    }

    public Long getDoexIdeApli() {
        return doexIdeApli;
    }

    public void setDoexIdeApli(Long doexIdeApli) {
        this.doexIdeApli = doexIdeApli;
    }

    public String getDoexNomDoc() {
        return doexNomDoc;
    }

    public void setDoexNomDoc(String doexNomDoc) {
        this.doexNomDoc = doexNomDoc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doexCodAplOr != null ? doexCodAplOr.hashCode() : 0);
        hash += (doexTipoDoc != null ? doexTipoDoc.hashCode() : 0);
        hash += doexSecDpc.intValue();
        hash += doexIdeApli.intValue();
        hash += (doexNomDoc != null ? doexNomDoc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocExistentesPK)) {
            return false;
        }
        DocExistentesPK other = (DocExistentesPK) object;
        if ((this.doexCodAplOr == null && other.doexCodAplOr != null) || (this.doexCodAplOr != null && !this.doexCodAplOr.equals(other.doexCodAplOr))) {
            return false;
        }
        if ((this.doexTipoDoc == null && other.doexTipoDoc != null) || (this.doexTipoDoc != null && !this.doexTipoDoc.equals(other.doexTipoDoc))) {
            return false;
        }
        if (this.doexSecDpc != other.doexSecDpc) {
            return false;
        }
        if (this.doexIdeApli != other.doexIdeApli) {
            return false;
        }
        if ((this.doexNomDoc == null && other.doexNomDoc != null) || (this.doexNomDoc != null && !this.doexNomDoc.equals(other.doexNomDoc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.DocExistentesPK[ doexCodAplOr=" + doexCodAplOr + ", doexTipoDoc=" + doexTipoDoc + ", doexSecDpc=" + doexSecDpc + ", doexIdeApli=" + doexIdeApli + ", doexNomDoc=" + doexNomDoc + " ]";
    }
    
}
