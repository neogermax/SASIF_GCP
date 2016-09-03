/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "DOC_EXISTENTES")
@NamedQueries({
    @NamedQuery(name = "DocExistentes.findAll", query = "SELECT d FROM DocExistentes d"),
    @NamedQuery(name = "DocExistentes.findSec", query = "SELECT MAX(d.docExistentesPK.doexSecDpc) FROM DocExistentes d WHERE d.docExistentesPK.doexCodAplOr = :codAplOr AND d.docExistentesPK.doexTipoDoc = :tipoDoc AND d.docExistentesPK.doexIdeApli = :ideApli AND d.docExistentesPK.doexNomDoc = :nomDoc")
})
public class DocExistentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocExistentesPK docExistentesPK;
    @Size(max = 30)
    @Column(name = "DOEX_IDE_ALFA")
    private String doexIdeAlfa;
    @Column(name = "DOEX_COD_EMP_ORI")
    private Integer doexCodEmpOri;
    @Column(name = "DOEX_COD_ARE_ORI")
    private Integer doexCodAreOri;
    @Size(max = 10)
    @Column(name = "DOEX_COD_USU_ORI")
    private String doexCodUsuOri;
    @Column(name = "DOEX_FECHA_CREO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doexFechaCreo;
    @Column(name = "DOEX_FECHA_MOD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doexFechaMod;
    @Size(max = 10)
    @Column(name = "DOEX_USU_MOD")
    private String doexUsuMod;
    @Size(max = 200)
    @Column(name = "DOEX_RUTA_ALMA")
    private String doexRutaAlma;
    @Size(max = 256)
    @Column(name = "DOEX_ASUNTO")
    private String doexAsunto;
    @Column(name = "DOEX_SERIE")
    private Integer doexSerie;
    @Column(name = "DOEX_SUBSERIE")
    private Integer doexSubserie;
    @Size(max = 4000)
    @Column(name = "DOEX_TRAMA_ENV")
    private String doexTramaEnv;

    public DocExistentes() {
    }

    public DocExistentes(DocExistentesPK docExistentesPK) {
        this.docExistentesPK = docExistentesPK;
    }

    public DocExistentes(String doexCodAplOr, String doexTipoDoc, long doexSecDpc, long doexIdeApli, String doexNomDoc) {
        this.docExistentesPK = new DocExistentesPK(doexCodAplOr, doexTipoDoc, doexSecDpc, doexIdeApli, doexNomDoc);
    }

    public DocExistentesPK getDocExistentesPK() {
        return docExistentesPK;
    }

    public void setDocExistentesPK(DocExistentesPK docExistentesPK) {
        this.docExistentesPK = docExistentesPK;
    }

    public String getDoexIdeAlfa() {
        return doexIdeAlfa;
    }

    public void setDoexIdeAlfa(String doexIdeAlfa) {
        this.doexIdeAlfa = doexIdeAlfa;
    }

    public Integer getDoexCodEmpOri() {
        return doexCodEmpOri;
    }

    public void setDoexCodEmpOri(Integer doexCodEmpOri) {
        this.doexCodEmpOri = doexCodEmpOri;
    }

    public Integer getDoexCodAreOri() {
        return doexCodAreOri;
    }

    public void setDoexCodAreOri(Integer doexCodAreOri) {
        this.doexCodAreOri = doexCodAreOri;
    }

    public String getDoexCodUsuOri() {
        return doexCodUsuOri;
    }

    public void setDoexCodUsuOri(String doexCodUsuOri) {
        this.doexCodUsuOri = doexCodUsuOri;
    }

    public Date getDoexFechaCreo() {
        return doexFechaCreo;
    }

    public void setDoexFechaCreo(Date doexFechaCreo) {
        this.doexFechaCreo = doexFechaCreo;
    }

    public Date getDoexFechaMod() {
        return doexFechaMod;
    }

    public void setDoexFechaMod(Date doexFechaMod) {
        this.doexFechaMod = doexFechaMod;
    }

    public String getDoexUsuMod() {
        return doexUsuMod;
    }

    public void setDoexUsuMod(String doexUsuMod) {
        this.doexUsuMod = doexUsuMod;
    }

    public String getDoexRutaAlma() {
        return doexRutaAlma;
    }

    public void setDoexRutaAlma(String doexRutaAlma) {
        this.doexRutaAlma = doexRutaAlma;
    }

    public String getDoexAsunto() {
        return doexAsunto;
    }

    public void setDoexAsunto(String doexAsunto) {
        this.doexAsunto = doexAsunto;
    }

    public Integer getDoexSerie() {
        return doexSerie;
    }

    public void setDoexSerie(Integer doexSerie) {
        this.doexSerie = doexSerie;
    }

    public Integer getDoexSubserie() {
        return doexSubserie;
    }

    public void setDoexSubserie(Integer doexSubserie) {
        this.doexSubserie = doexSubserie;
    }

    public String getDoexTramaEnv() {
        return doexTramaEnv;
    }

    public void setDoexTramaEnv(String doexTramaEnv) {
        this.doexTramaEnv = doexTramaEnv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docExistentesPK != null ? docExistentesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocExistentes)) {
            return false;
        }
        DocExistentes other = (DocExistentes) object;
        if ((this.docExistentesPK == null && other.docExistentesPK != null) || (this.docExistentesPK != null && !this.docExistentesPK.equals(other.docExistentesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.DocExistentes[ docExistentesPK=" + docExistentesPK + " ]";
    }
    
}
