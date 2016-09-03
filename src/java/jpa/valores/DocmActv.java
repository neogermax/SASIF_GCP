/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DOCM_ACTV")
@NamedQueries({
    @NamedQuery(name = "DocmActv.findAll", query = "SELECT d FROM DocmActv d")})
public class DocmActv implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocmActvPK docmActvPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "DOA_IND_OBL")
    private String doaIndObl;
    @Size(min = 1, max = 1)
    @Column(name = "DOA_REST")
    private String doaRest;
    @JoinColumn(name = "DOA_CLS_COD_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas;
    @JoinColumn(name = "DOA_CLS_COD_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "DOA_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;

    public DocmActv() {
    }

    public DocmActv(DocmActvPK docmActvPK) {
        this.docmActvPK = docmActvPK;
    }

    public DocmActv(DocmActvPK docmActvPK, String doaIndObl, String doaRest) {
        this.docmActvPK = docmActvPK;
        this.doaIndObl = doaIndObl;
        this.doaRest = doaRest;
    }

    public DocmActv(int doaClsCodFk, int doaEtpCodFk, int doaActCodFk, String doaPdoDocFk) {
        this.docmActvPK = new DocmActvPK(doaClsCodFk, doaEtpCodFk, doaActCodFk, doaPdoDocFk);
    }

    public DocmActvPK getDocmActvPK() {
        return docmActvPK;
    }

    public void setDocmActvPK(DocmActvPK docmActvPK) {
        this.docmActvPK = docmActvPK;
    }

    public String getDoaIndObl() {
        return doaIndObl;
    }

    public void setDoaIndObl(String doaIndObl) {
        this.doaIndObl = doaIndObl;
    }
    
    public String getDoaRest() {
        return doaRest;
    }

    public void setDoaRest(String doaRest) {
        this.doaRest = doaRest;
    }

    public Etapas getEtapas() {
        return etapas;
    }

    public void setEtapas(Etapas etapas) {
        this.etapas = etapas;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docmActvPK != null ? docmActvPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocmActv)) {
            return false;
        }
        DocmActv other = (DocmActv) object;
        if ((this.docmActvPK == null && other.docmActvPK != null) || (this.docmActvPK != null && !this.docmActvPK.equals(other.docmActvPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.DocmActv[ docmActvPK=" + docmActvPK + " ]";
    }
    
}
