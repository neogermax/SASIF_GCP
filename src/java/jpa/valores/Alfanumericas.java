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
 * @author saflap
 */
@Entity
@Table(name = "ALFANUMERICAS")
@NamedQueries({
    @NamedQuery(name = "Alfanumericas.findAll", query = "SELECT a FROM Alfanumericas a"),
    @NamedQuery(name = "Alfanumericas.findByCode", query = "SELECT a FROM Alfanumericas a WHERE a.alfanumericasPK.alfCodPk = :alfCodPk"),
    @NamedQuery(name = "Alfanumericas.findCodes", query = "SELECT DISTINCT a.alfanumericasPK.alfCodPk FROM Alfanumericas a")    
})
public class Alfanumericas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlfanumericasPK alfanumericasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ALF_DESCRIP")
    private String alfDescrip;
    @Size(max = 1)
    @Column(name = "ALF_CONTEN")
    private String alfConten;
    @Size(max = 5)
    @Column(name = "ALF_GRUPO_DOC_FK")
    private String alfGrupoDocFk;
    @Size(max = 20)
    @Column(name = "ALF_DOCUMENTO_FK")
    private String alfDocumentoFk;
    @Size(max = 1)
    @Column(name = "ALF_CORREO")
    private String alfCorreo;
    @Size(max = 1)
    @Column(name = "ALF_MENSAJES")
    private String alfMensajes;
    @Size(max = 20)
    @Column(name = "ALF_IND_DUDAS")
    private String alfIndDudas;
    @Size(max = 1)
    @Column(name = "ALF_AUTORIZA")
    private String alfAutoriza;
    @JoinColumn(name = "ALF_ETP_COD_FK", referencedColumnName = "ETP_COD_PK")
    @ManyToOne
    private Etapas alfEtpCodFk;
    @JoinColumn(name = "ALF_CLS_COD_FK", referencedColumnName = "CLS_COD_PK")
    @ManyToOne
    private Clases alfClsCodFk;
    @JoinColumn(name = "ALF_ACT_COD_FK", referencedColumnName = "ACT_COD_PK")
    @ManyToOne
    private Actividades alfActCodFk;

    public Alfanumericas() {
    }

    public Alfanumericas(AlfanumericasPK alfanumericasPK) {
        this.alfanumericasPK = alfanumericasPK;
    }

    public Alfanumericas(AlfanumericasPK alfanumericasPK, String alfDescrip) {
        this.alfanumericasPK = alfanumericasPK;
        this.alfDescrip = alfDescrip;
    }

    public Alfanumericas(int alfCodPk, String alfValor) {
        this.alfanumericasPK = new AlfanumericasPK(alfCodPk, alfValor);
    }

    public AlfanumericasPK getAlfanumericasPK() {
        return alfanumericasPK;
    }

    public void setAlfanumericasPK(AlfanumericasPK alfanumericasPK) {
        this.alfanumericasPK = alfanumericasPK;
    }

    public String getAlfDescrip() {
        return alfDescrip;
    }

    public void setAlfDescrip(String alfDescrip) {
        this.alfDescrip = alfDescrip;
    }

    public String getAlfConten() {
        return alfConten;
    }

    public void setAlfConten(String alfConten) {
        this.alfConten = alfConten;
    }

    public String getAlfGrupoDocFk() {
        return alfGrupoDocFk;
    }

    public void setAlfGrupoDocFk(String alfGrupoDocFk) {
        this.alfGrupoDocFk = alfGrupoDocFk;
    }

    public String getAlfDocumentoFk() {
        return alfDocumentoFk;
    }

    public void setAlfDocumentoFk(String alfDocumentoFk) {
        this.alfDocumentoFk = alfDocumentoFk;
    }

    public String getAlfCorreo() {
        return alfCorreo;
    }

    public void setAlfCorreo(String alfCorreo) {
        this.alfCorreo = alfCorreo;
    }

    public String getAlfMensajes() {
        return alfMensajes;
    }

    public void setAlfMensajes(String alfMensajes) {
        this.alfMensajes = alfMensajes;
    }

    public String getAlfIndDudas() {
        return alfIndDudas;
    }

    public void setAlfIndDudas(String alfIndDudas) {
        this.alfIndDudas = alfIndDudas;
    }
    
    public String getAlfAutoriza() {
        return alfAutoriza;
    }

    public void setAlfAutoriza(String alfAutoriza) {
        this.alfAutoriza = alfAutoriza;
    }
    

    public Etapas getAlfEtpCodFk() {
        return alfEtpCodFk;
    }

    public void setAlfEtpCodFk(Etapas alfEtpCodFk) {
        this.alfEtpCodFk = alfEtpCodFk;
    }

    public Clases getAlfClsCodFk() {
        return alfClsCodFk;
    }

    public void setAlfClsCodFk(Clases alfClsCodFk) {
        this.alfClsCodFk = alfClsCodFk;
    }

    public Actividades getAlfActCodFk() {
        return alfActCodFk;
    }

    public void setAlfActCodFk(Actividades alfActCodFk) {
        this.alfActCodFk = alfActCodFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alfanumericasPK != null ? alfanumericasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alfanumericas)) {
            return false;
        }
        Alfanumericas other = (Alfanumericas) object;
        if ((this.alfanumericasPK == null && other.alfanumericasPK != null) || (this.alfanumericasPK != null && !this.alfanumericasPK.equals(other.alfanumericasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Alfanumericas[ alfanumericasPK=" + alfanumericasPK + " ]";
    }
    
}
