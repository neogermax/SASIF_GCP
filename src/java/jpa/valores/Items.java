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
@Table(name = "ITEMS")
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i")})
public class Items implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "items")
    private List<ProyItems> proyItemsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acitmItmCodFk")
    private List<ActItems> actItemsList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITM_COD_PK")
    private Integer itmCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ITM_DESCRIP")
    private String itmDescrip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ITM_LABEL")
    private String itmLabel;
    @Column(name = "ITM_AYD_COD")
    private Integer itmAydCod;
    @Column(name = "ITM_TAMANO")
    private Integer itmTamano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ITM_DATO")
    private String itmDato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ITM_CONTEN")
    private String itmConten;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ITM_VAL_ESTAND")
    private String itmValEstand;
    @Column(name = "ITM_COD_TAB")
    private Integer itmCodTab;
    @Size(max = 20)
    @Column(name = "ITM_SESSION")
    private String itmSession;
    @Size(max = 20)
    @Column(name = "ITM_TABLA")
    private String itmTabla;
    @Size(max = 20)
    @Column(name = "ITM_CAMPO")
    private String itmCampo;
    @Size(max = 1)
    @Column(name = "ITM_SEG")
    private String itmSeg;
    @Size(max = 1)
    @Column(name = "ITM_DESC")
    private String itmDesc;
    @Column(name = "ITM_GRUPO_DOC")
    private Integer itmGrupoDoc;
    @Size(max = 20)
    @Column(name = "ITM_DOCUMENTO")
    private String itmDocumento;
    @Size(max = 1)
    @Column(name = "ITM_CORREO")
    private String itmCorreo;
    @Size(max = 1)
    @Column(name = "ITM_MENSAJES")
    private String itmMensajes;
    @Size(max = 1)
    @Column(name = "ITM_IND_DUDAS")
    private String itmIndDudas;
    @JoinColumn(name = "ITM_PROG_NOM_FK", referencedColumnName = "PROG_NOM_PK")
    @ManyToOne
    private Programas itmProgNomFk;
    @JoinColumn(name = "ITM_FOR_COD_FK", referencedColumnName = "FOR_COD_PK")
    @ManyToOne
    private Formulas itmForCodFk;
    @JoinColumn(name = "ITM_CONS_COD_FK", referencedColumnName = "CONS_COD_PK")
    @ManyToOne
    private Constantes itmConsCodFk;
    @JoinColumn(name = "ITM_CONSEC_COD_FK", referencedColumnName = "CONSEC_COD_PK")
    @ManyToOne
    private Consecutivos itmConsecCodFk;
    
    public Items() {
    }

    public Items(Integer itmCodPk) {
        this.itmCodPk = itmCodPk;
    }

    public Items(Integer itmCodPk, String itmDescrip, String itmLabel, String itmDato, String itmConten, String itmValEstand) {
        this.itmCodPk = itmCodPk;
        this.itmDescrip = itmDescrip;
        this.itmLabel = itmLabel;
        this.itmDato = itmDato;
        this.itmConten = itmConten;
        this.itmValEstand = itmValEstand;
        
    }

    public Integer getItmCodPk() {
        return itmCodPk;
    }

    public void setItmCodPk(Integer itmCodPk) {
        this.itmCodPk = itmCodPk;
    }

    public String getItmDescrip() {
        return itmDescrip;
    }

    public void setItmDescrip(String itmDescrip) {
        this.itmDescrip = itmDescrip;
    }

    public String getItmLabel() {
        return itmLabel;
    }

    public void setItmLabel(String itmLabel) {
        this.itmLabel = itmLabel;
    }

    public Integer getItmAydCod() {
        return itmAydCod;
    }

    public void setItmAydCod(Integer itmAydCod) {
        this.itmAydCod = itmAydCod;
    }

    public Integer getItmTamano() {
        return itmTamano;
    }

    public void setItmTamano(Integer itmTamano) {
        this.itmTamano = itmTamano;
    }

    public String getItmDato() {
        return itmDato;
    }

    public void setItmDato(String itmDato) {
        this.itmDato = itmDato;
    }

    public String getItmConten() {
        return itmConten;
    }

    public void setItmConten(String itmConten) {
        this.itmConten = itmConten;
    }

    public String getItmValEstand() {
        return itmValEstand;
    }

    public void setItmValEstand(String itmValEstand) {
        this.itmValEstand = itmValEstand;
    }

    public Integer getItmCodTab() {
        return itmCodTab;
    }

    public void setItmCodTab(Integer itmCodTab) {
        this.itmCodTab = itmCodTab;
    }

    public String getItmSession() {
        return itmSession;
    }

    public void setItmSession(String itmSession) {
        this.itmSession = itmSession;
    }

    public String getItmTabla() {
        return itmTabla;
    }

    public void setItmTabla(String itmTabla) {
        this.itmTabla = itmTabla;
    }

    public String getItmCampo() {
        return itmCampo;
    }

    public void setItmCampo(String itmCampo) {
        this.itmCampo = itmCampo;
    }

    public String getItmSeg() {
        return itmSeg;
    }

    public void setItmSeg(String itmSeg) {
        this.itmSeg = itmSeg;
    }

    public String getItmDesc() {
        return itmDesc;
    }

    public void setItmDesc(String itmDesc) {
        this.itmDesc = itmDesc;
    }

    public Integer getItmGrupoDoc() {
        return itmGrupoDoc;
    }

    public void setItmGrupoDoc(Integer itmGrupoDoc) {
        this.itmGrupoDoc = itmGrupoDoc;
    }

    public String getItmDocumento() {
        return itmDocumento;
    }

    public void setItmDocumento(String itmDocumento) {
        this.itmDocumento = itmDocumento;
    }

    public String getItmCorreo() {
        return itmCorreo;
    }

    public void setItmCorreo(String itmCorreo) {
        this.itmCorreo = itmCorreo;
    }

    public String getItmMensajes() {
        return itmMensajes;
    }

    public void setItmMensajes(String itmMensajes) {
        this.itmMensajes = itmMensajes;
    }

    public String getItmIndDudas() {
        return itmIndDudas;
    }

    public void setItmIndDudas(String itmIndDudas) {
        this.itmIndDudas = itmIndDudas;
    }

    public Programas getItmProgNomFk() {
        return itmProgNomFk;
    }

    public void setItmProgNomFk(Programas itmProgNomFk) {
        this.itmProgNomFk = itmProgNomFk;
    }

    public Formulas getItmForCodFk() {
        return itmForCodFk;
    }

    public void setItmForCodFk(Formulas itmForCodFk) {
        this.itmForCodFk = itmForCodFk;
    }

    public Constantes getItmConsCodFk() {
        return itmConsCodFk;
    }

    public void setItmConsCodFk(Constantes itmConsCodFk) {
        this.itmConsCodFk = itmConsCodFk;
    }

    public Consecutivos getItmConsecCodFk() {
        return itmConsecCodFk;
    }

    public void setItmConsecCodFk(Consecutivos itmConsecCodFk) {
        this.itmConsecCodFk = itmConsecCodFk;
    }
    
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itmCodPk != null ? itmCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.itmCodPk == null && other.itmCodPk != null) || (this.itmCodPk != null && !this.itmCodPk.equals(other.itmCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Items[ itmCodPk=" + itmCodPk + " ]";
    }

    public List<ActItems> getActItemsList() {
        return actItemsList;
    }

    public void setActItemsList(List<ActItems> actItemsList) {
        this.actItemsList = actItemsList;
    }

    public List<ProyItems> getProyItemsList() {
        return proyItemsList;
    }

    public void setProyItemsList(List<ProyItems> proyItemsList) {
        this.proyItemsList = proyItemsList;
    }
    
}
