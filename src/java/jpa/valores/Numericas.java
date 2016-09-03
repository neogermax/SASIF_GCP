/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author Analista02
 */
@Entity
@Table(name = "NUMERICAS")
@NamedQueries({
    @NamedQuery(name = "Numericas.findAll", query = "SELECT n FROM Numericas n"),
    @NamedQuery(name = "Numericas.findByCode", query = "SELECT n FROM Numericas n WHERE n.numericasPK.numCodPk = :numCodPk"),
    @NamedQuery(name = "Numericas.findCodes", query = "SELECT DISTINCT n.numericasPK.numCodPk FROM Numericas n")
})
public class Numericas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NumericasPK numericasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NUM_DESCRIP")
    private String numDescrip;
    @Size(max = 1)
    @Column(name = "NUM_CONTEN")
    private String numConten;
    @Column(name = "NUM_GRUPO_DOC_FK")
    private Integer numGrupoDocFk;
    @Size(max = 20)
    @Column(name = "NUM_DOCUMENTO_FK")
    private String numDocumentoFk;
    @Size(max = 1)
    @Column(name = "NUM_CORREO")
    private String numCorreo;
    @Size(max = 1)
    @Column(name = "NUM_MENSAJES")
    private String numMensajes;
    @Size(max = 1)
    @Column(name = "NUM_IND_DUDAS")
    private String numIndDudas;
    @Size(max = 1)
    @Column(name = "NUM_AUTORIZA")
    private String numAutoriza;
    @JoinColumn(name = "NUM_ETP_COD_FK", referencedColumnName = "ETP_COD_PK")
    @ManyToOne(optional = false)
    private Etapas numEtpCodFk;
    @JoinColumn(name = "NUM_CLS_COD_FK", referencedColumnName = "CLS_COD_PK")
    @ManyToOne(optional = false)
    private Clases numClsCodFk;
    @JoinColumn(name = "NUM_ACT_COD_FK", referencedColumnName = "ACT_COD_PK")
    @ManyToOne(optional = false)
    private Actividades numActCodFk;

    public Numericas() {
    }

    public Numericas(NumericasPK numericasPK) {
        this.numericasPK = numericasPK;
    }

    public Numericas(NumericasPK numericasPK, String numDescrip) {
        this.numericasPK = numericasPK;
        this.numDescrip = numDescrip;
    }

    public Numericas(Integer numCodPk, BigDecimal numValor) {
        this.numericasPK = new NumericasPK(numCodPk, numValor);
    }

    public NumericasPK getNumericasPK() {
        return numericasPK;
    }

    public void setNumericasPK(NumericasPK numericasPK) {
        this.numericasPK = numericasPK;
    }

    public String getNumDescrip() {
        return numDescrip;
    }

    public void setNumDescrip(String numDescrip) {
        this.numDescrip = numDescrip;
    }

    public String getNumConten() {
        return numConten;
    }

    public void setNumConten(String numConten) {
        this.numConten = numConten;
    }

    public Integer getNumGrupoDocFk() {
        return numGrupoDocFk;
    }

    public void setNumGrupoDocFk(Integer numGrupoDocFk) {
        this.numGrupoDocFk = numGrupoDocFk;
    }

    public String getNumDocumentoFk() {
        return numDocumentoFk;
    }

    public void setNumDocumentoFk(String numDocumentoFk) {
        this.numDocumentoFk = numDocumentoFk;
    }

    public String getNumCorreo() {
        return numCorreo;
    }

    public void setNumCorreo(String numCorreo) {
        this.numCorreo = numCorreo;
    }

    public String getNumMensajes() {
        return numMensajes;
    }

    public void setNumMensajes(String numMensajes) {
        this.numMensajes = numMensajes;
    }

    public String getNumIndDudas() {
        return numIndDudas;
    }

    public void setNumIndDudas(String numIndDudas) {
        this.numIndDudas = numIndDudas;
    }
    
    
    public String getNumAutoriza() {
        return numAutoriza;
    }

    public void setNumAutoriza(String numAutoriza) {
        this.numAutoriza = numAutoriza;
    }
    

    public Etapas getNumEtpCodFk() {
        return numEtpCodFk;
    }

    public void setNumEtpCodFk(Etapas numEtpCodFk) {
        this.numEtpCodFk = numEtpCodFk;
    }

    public Clases getNumClsCodFk() {
        return numClsCodFk;
    }

    public void setNumClsCodFk(Clases numClsCodFk) {
        this.numClsCodFk = numClsCodFk;
    }

    public Actividades getNumActCodFk() {
        return numActCodFk;
    }

    public void setNumActCodFk(Actividades numActCodFk) {
        this.numActCodFk = numActCodFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numericasPK != null ? numericasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Numericas)) {
            return false;
        }
        Numericas other = (Numericas) object;
        if ((this.numericasPK == null && other.numericasPK != null) || (this.numericasPK != null && !this.numericasPK.equals(other.numericasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Numericas[ numericasPK=" + numericasPK + " ]";
    }
    
}
