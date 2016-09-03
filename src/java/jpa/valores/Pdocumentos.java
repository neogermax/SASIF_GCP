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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Analista02
 */
@Entity
@Table(name = "PDOCUMENTOS")
@NamedQueries({
    @NamedQuery(name = "Pdocumentos.findAll", query = "SELECT p FROM Pdocumentos p")})
public class Pdocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PDO_DOCUMENTO_PK")
    private String pdoDocumentoPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PDO_DESCRIPCION")
    private String pdoDescripcion;
    @Size(max = 30)
    @Column(name = "PDO_TIPOC")
    private String pdoTipoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "PDO_TIPOD")
    private String pdoTipod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PDO_VERSION")
    private String pdoVersion;
    @Size(max = 50)
    @Column(name = "PDO_RUTA_PLA")
    private String pdoRutaPla;
    @Size(max = 50)
    @Column(name = "PDO_NOM_PLA")
    private String pdoNomPla;
    @Size(max = 256)
    @Column(name = "PDO_ASUNTO")
    private String pdoAsunto;
    @JoinColumn(name = "PDO_COD_RUTA_FK", referencedColumnName = "RUT_CODIGO_PK")
    @ManyToOne(optional = false)
    private Rutas pdoCodRutaFk;
    @JoinColumn(name = "PDO_GRUPO_FK", referencedColumnName = "GDO_GRUPO_PK")
    @ManyToOne
    private Gdocumentos pdoGrupoFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdocumentos")
    private List<InfoDocumentos> infoDocumentosList;

    public Pdocumentos() {
    }

    public Pdocumentos(String pdoDocumentoPk) {
        this.pdoDocumentoPk = pdoDocumentoPk;
    }

    public Pdocumentos(String pdoDocumentoPk, String pdoDescripcion, String pdoTipoc, String pdoTipod, String pdoVersion, String pdoRutaPla, String pdoNomPla, String pdoAsunto) {
        this.pdoDocumentoPk = pdoDocumentoPk;
        this.pdoDescripcion = pdoDescripcion;
        this.pdoTipoc = pdoTipoc;
        this.pdoTipod = pdoTipod;
        this.pdoVersion = pdoVersion;
        this.pdoRutaPla = pdoRutaPla;
        this.pdoNomPla = pdoNomPla;
        this.pdoAsunto = pdoAsunto;
    }

    public String getPdoDocumentoPk() {
        return pdoDocumentoPk;
    }

    public void setPdoDocumentoPk(String pdoDocumentoPk) {
        this.pdoDocumentoPk = pdoDocumentoPk;
    }

    public String getPdoDescripcion() {
        return pdoDescripcion;
    }

    public void setPdoDescripcion(String pdoDescripcion) {
        this.pdoDescripcion = pdoDescripcion;
    }

    public String getPdoTipoc() {
        return pdoTipoc;
    }

    public void setPdoTipoc(String pdoTipoc) {
        this.pdoTipoc = pdoTipoc;
    }

    public String getPdoTipod() {
        return pdoTipod;
    }

    public void setPdoTipod(String pdoTipod) {
        this.pdoTipod = pdoTipod;
    }

    public String getPdoVersion() {
        return pdoVersion;
    }

    public void setPdoVersion(String pdoVersion) {
        this.pdoVersion = pdoVersion;
    }
    
    public String getPdoRutaPla() {
        return pdoRutaPla;
    }

    public void setPdoRutaPla(String pdoRutaPla) {
        this.pdoRutaPla = pdoRutaPla;
    }
    
    public String getPdoNomPla() {
        return pdoNomPla;
    }

    public void setPdoNomPla(String pdoNomPla) {
        this.pdoNomPla = pdoNomPla;
    }
    
    public String getPdoAsunto() {
        return pdoAsunto;
    }

    public void setPdoAsunto(String pdoAsunto) {
        this.pdoAsunto = pdoAsunto;
    }

    public Rutas getPdoCodRutaFk() {
        return pdoCodRutaFk;
    }

    public void setPdoCodRutaFk(Rutas pdoCodRutaFk) {
        this.pdoCodRutaFk = pdoCodRutaFk;
    }

    public Gdocumentos getPdoGrupoFk() {
        return pdoGrupoFk;
    }

    public void setPdoGrupoFk(Gdocumentos pdoGrupoFk) {
        this.pdoGrupoFk = pdoGrupoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pdoDocumentoPk != null ? pdoDocumentoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pdocumentos)) {
            return false;
        }
        Pdocumentos other = (Pdocumentos) object;
        if ((this.pdoDocumentoPk == null && other.pdoDocumentoPk != null) || (this.pdoDocumentoPk != null && !this.pdoDocumentoPk.equals(other.pdoDocumentoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Pdocumentos[ pdoDocumentoPk=" + pdoDocumentoPk + " ]";
    }

    public List<InfoDocumentos> getInfoDocumentosList() {
        return infoDocumentosList;
    }

    public void setInfoDocumentosList(List<InfoDocumentos> infoDocumentosList) {
        this.infoDocumentosList = infoDocumentosList;
    }
}
