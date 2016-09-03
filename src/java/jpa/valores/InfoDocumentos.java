/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "INFO_DOCUMENTOS")
@NamedQueries({
    @NamedQuery(name = "InfoDocumentos.findAll", query = "SELECT i FROM InfoDocumentos i")})
public class InfoDocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InfoDocumentosPK infoDocumentosPK;
    @Size(max = 50)
    @Column(name = "IDOC_NOMBRE")
    private String idocNombre;
    @Size(max = 1)
    @Column(name = "IDOC_TIPO_DATO")
    private String idocTipoDato;
    @Size(max = 1)
    @Column(name = "IDOC_IDE_DATO")
    private String idocIdeDato;
    @Column(name = "IDOC_COD_ITEM")
    private Integer idocCodItem;
    @Column(name = "IDOC_NUM_VAR_SESION")
    private Short idocNumVarSesion;
    @Size(max = 20)
    @Column(name = "IDOC_NOM_TABLA")
    private String idocNomTabla;
    @Size(max = 20)
    @Column(name = "IDOC_NOM_CAMPO")
    private String idocNomCampo;
    @Column(name = "IDOC_NUM_CONS")
    private Integer idocNumCons;
    @Size(max = 1)
    @Column(name = "IDOC_METADATO")
    private String idocMetadato;
    @Column(name = "IDOC_NUM_TABLA")
    private Short idocNumTabla;
    @Size(max = 30)
    @Column(name = "IDOC_FORMATO")
    private String idocFormato;
    @Column(name = "IDOC_SECUENCIA")
    private Short idocSecuencia;
    @Column(name = "IDOC_REPETICION")
    private Short idocRepeticion;
    @Size(max = 30)
    @Column(name = "IDOC_TABLA")
    private String idocTabla;
    @Size(max = 30)
    @Column(name = "IDOC_CAMPO")
    private String idocCampo;
    @JoinColumn(name = "IDOC_COD_DOC_FK", referencedColumnName = "PDO_DOCUMENTO_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pdocumentos pdocumentos;

    public InfoDocumentos() {
    }

    public InfoDocumentos(InfoDocumentosPK infoDocumentosPK) {
        this.infoDocumentosPK = infoDocumentosPK;
    }

    public InfoDocumentos(String idocCodDocFk, Integer idocSec) {
        this.infoDocumentosPK = new InfoDocumentosPK(idocCodDocFk, idocSec);
    }

    public InfoDocumentosPK getInfoDocumentosPK() {
        return infoDocumentosPK;
    }

    public void setInfoDocumentosPK(InfoDocumentosPK infoDocumentosPK) {
        this.infoDocumentosPK = infoDocumentosPK;
    }

    public String getIdocNombre() {
        return idocNombre;
    }

    public void setIdocNombre(String idocNombre) {
        this.idocNombre = idocNombre;
    }

    public String getIdocTipoDato() {
        return idocTipoDato;
    }

    public void setIdocTipoDato(String idocTipoDato) {
        this.idocTipoDato = idocTipoDato;
    }

    public String getIdocIdeDato() {
        return idocIdeDato;
    }

    public void setIdocIdeDato(String idocIdeDato) {
        this.idocIdeDato = idocIdeDato;
    }

    public Integer getIdocCodItem() {
        return idocCodItem;
    }

    public void setIdocCodItem(Integer idocCodItem) {
        this.idocCodItem = idocCodItem;
    }

    public Short getIdocNumVarSesion() {
        return idocNumVarSesion;
    }

    public void setIdocNumVarSesion(Short idocNumVarSesion) {
        this.idocNumVarSesion = idocNumVarSesion;
    }

    public String getIdocNomTabla() {
        return idocNomTabla;
    }

    public void setIdocNomTabla(String idocNomTabla) {
        this.idocNomTabla = idocNomTabla;
    }

    public String getIdocNomCampo() {
        return idocNomCampo;
    }

    public void setIdocNomCampo(String idocNomCampo) {
        this.idocNomCampo = idocNomCampo;
    }

    public Integer getIdocNumCons() {
        return idocNumCons;
    }

    public void setIdocNumCons(Integer idocNumCons) {
        this.idocNumCons = idocNumCons;
    }

    public String getIdocMetadato() {
        return idocMetadato;
    }

    public void setIdocMetadato(String idocMetadato) {
        this.idocMetadato = idocMetadato;
    }

    public Short getIdocNumTabla() {
        return idocNumTabla;
    }

    public void setIdocNumTabla(Short idocNumTabla) {
        this.idocNumTabla = idocNumTabla;
    }

    public String getIdocFormato() {
        return idocFormato;
    }

    public void setIdocFormato(String idocFormato) {
        this.idocFormato = idocFormato;
    }

    public Short getIdocSecuencia() {
        return idocSecuencia;
    }

    public void setIdocSecuencia(Short idocSecuencia) {
        this.idocSecuencia = idocSecuencia;
    }

    public Short getIdocRepeticion() {
        return idocRepeticion;
    }

    public void setIdocRepeticion(Short idocRepeticion) {
        this.idocRepeticion = idocRepeticion;
    }

    public String getIdocTabla() {
        return idocTabla;
    }

    public void setIdocTabla(String idocTabla) {
        this.idocTabla = idocTabla;
    }

    public String getIdocCampo() {
        return idocCampo;
    }

    public void setIdocCampo(String idocCampo) {
        this.idocCampo = idocCampo;
    }

    public Pdocumentos getPdocumentos() {
        return pdocumentos;
    }

    public void setPdocumentos(Pdocumentos pdocumentos) {
        this.pdocumentos = pdocumentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infoDocumentosPK != null ? infoDocumentosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoDocumentos)) {
            return false;
        }
        InfoDocumentos other = (InfoDocumentos) object;
        if ((this.infoDocumentosPK == null && other.infoDocumentosPK != null) || (this.infoDocumentosPK != null && !this.infoDocumentosPK.equals(other.infoDocumentosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.InfoDocumentos[ infoDocumentosPK=" + infoDocumentosPK + " ]";
    }
    
}
