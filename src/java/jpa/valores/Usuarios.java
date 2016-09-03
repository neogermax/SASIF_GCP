/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SAFLAP
 */
@Entity
@Table(name = "USUARIOS")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByArea", query = "SELECT u FROM Usuarios u WHERE u.empleados.areas = :area"),
    @NamedQuery(name = "Usuarios.findByCod", query = "SELECT u FROM Usuarios u WHERE u.usuCodPk = :cod"),
    @NamedQuery(name = "Usuarios.findByEmp", query = "SELECT u FROM Usuarios u WHERE u.empleados.areas.empresas = :empresa")
})
public class Usuarios implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<PermisosDocUsu> permisosDocUsuList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_COD_PK")
    private String usuCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USU_ESTADO")
    private String usuEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "USU_CLAVE_ENCRIP")
    private String usuClaveEncrip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_FECHA_CLAVE")
    @Temporal(TemporalType.DATE)
    private Date usuFechaClave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_NUM_INTENT")
    private short usuNumIntent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ACC_DOC")
    private short usuAccDoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ACC_IDO")
    private short usuAccIdo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ACC_ACT")
    private short usuAccAct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USU_ACC_IAC")
    private short usuAccIac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USU_IND_GES")
    private String usuIndGes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USU_IND_AUT")
    private String usuIndAut;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USU_IND_CONS")
    private String usuIndCons;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "USU_ACC_REP")
    private String usuAccRep;
    @Basic(optional = false)
    
    @Column(name = "USU_GRUP_REP")
    private Integer usuGrupRep;
    
    @Size(min = 1, max = 1)
    @Column(name = "USU_TIP_ACC_CON")
    private String usuTipAccCon;
    @Size(min = 1, max = 1)
    @Column(name = "USU_TIP_ACC_ACT")
    private String usuTipAccAct;
    @JoinColumn(name = "USU_ROL_FK", referencedColumnName = "ROL_ROL_PK")
    @ManyToOne(optional = false)
    private Roles usuRolFk;
    @JoinColumn(name = "USU_POL_GRUP_FK", referencedColumnName = "POL_COD_PK")
    @ManyToOne(optional = false)
    private PoliticaGrupos usuPolGrupFk;
    @JoinColumns({
        @JoinColumn(name = "USU_EMPL_ID_FK", referencedColumnName = "EMPL_ID_PK"),
        @JoinColumn(name = "USU_EMPL_TIP_FK", referencedColumnName = "EMPL_TIPO_ID_PK")})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public Usuarios() {
    }

    public Usuarios(String usuCodPk) {
        this.usuCodPk = usuCodPk;
    }

    public Usuarios(String usuCodPk, String usuEstado, String usuClaveEncrip, Date usuFechaClave, short usuNumIntent, short usuAccDoc, short usuAccIdo, short usuAccAct, short usuAccIac, String usuIndGes, String usuIndAut, String usuIndCons, String usuAccRep, Integer usuGrupRep, String usuTipAccCon, String usuTipAccAct) {
        this.usuCodPk = usuCodPk;
        this.usuEstado = usuEstado;
        this.usuClaveEncrip = usuClaveEncrip;
        this.usuFechaClave = usuFechaClave;
        this.usuNumIntent = usuNumIntent;
        this.usuAccDoc = usuAccDoc;
        this.usuAccIdo = usuAccIdo;
        this.usuAccAct = usuAccAct;
        this.usuAccIac = usuAccIac;
        this.usuIndGes = usuIndGes;
        this.usuIndAut = usuIndAut;
        this.usuIndCons = usuIndCons;
        this.usuAccRep = usuAccRep;
        this.usuGrupRep = usuGrupRep;
        this.usuTipAccCon = usuTipAccCon;
        this.usuTipAccAct = usuTipAccAct;
        
    }

    public String getUsuCodPk() {
        return usuCodPk;
    }

    public void setUsuCodPk(String usuCodPk) {
        this.usuCodPk = usuCodPk;
    }

    public String getUsuEstado() {
        return usuEstado;
    }

    public void setUsuEstado(String usuEstado) {
        this.usuEstado = usuEstado;
    }

    public String getUsuClaveEncrip() {
        return usuClaveEncrip;
    }

    public void setUsuClaveEncrip(String usuClaveEncrip) {
        this.usuClaveEncrip = usuClaveEncrip;
    }

    public Date getUsuFechaClave() {
        return usuFechaClave;
    }

    public void setUsuFechaClave(Date usuFechaClave) {
        this.usuFechaClave = usuFechaClave;
    }

    public short getUsuNumIntent() {
        return usuNumIntent;
    }

    public void setUsuNumIntent(short usuNumIntent) {
        this.usuNumIntent = usuNumIntent;
    }

    public short getUsuAccDoc() {
        return usuAccDoc;
    }

    public void setUsuAccDoc(short usuAccDoc) {
        this.usuAccDoc = usuAccDoc;
    }

    public short getUsuAccIdo() {
        return usuAccIdo;
    }

    public void setUsuAccIdo(short usuAccIdo) {
        this.usuAccIdo = usuAccIdo;
    }

    public short getUsuAccAct() {
        return usuAccAct;
    }

    public void setUsuAccAct(short usuAccAct) {
        this.usuAccAct = usuAccAct;
    }

    public short getUsuAccIac() {
        return usuAccIac;
    }

    public void setUsuAccIac(short usuAccIac) {
        this.usuAccIac = usuAccIac;
    }

    public String getUsuIndGes() {
        return usuIndGes;
    }

    public void setUsuIndGes(String usuIndGes) {
        this.usuIndGes = usuIndGes;
    }

    public String getUsuIndAut() {
        return usuIndAut;
    }

    public void setUsuIndAut(String usuIndAut) {
        this.usuIndAut = usuIndAut;
    }

    public String getUsuIndCons() {
        return usuIndCons;
    }

    public void setUsuIndCons(String usuIndCons) {
        this.usuIndCons = usuIndCons;
    }
    
    public String getUsuAccRep() {
        return usuAccRep;
    }

    public void setUsuAccRep(String usuAccRep) {
        this.usuAccRep = usuAccRep;
    }
    
    public String getUsuTipAccCon() {
        return usuTipAccCon;
    }

    public void setUsuTipAccCon(String usuTipAccCon) {
        this.usuTipAccCon = usuTipAccCon;
    }
    
    public String getUsuTipAccAct() {
        return usuTipAccAct;
    }

    public void setUsuTipAccAct(String usuTipAccAct) {
        this.usuTipAccAct = usuTipAccAct;
    }
    
    
    public Integer getUsuGrupRep() {
        return usuGrupRep;
    }

    public void setUsuGrupRep(Integer usuGrupRep) {
        System.out.println(usuGrupRep);
        this.usuGrupRep = usuGrupRep;
    }

    public Roles getUsuRolFk() {
        return usuRolFk;
    }

    public void setUsuRolFk(Roles usuRolFk) {
        this.usuRolFk = usuRolFk;
    }

    public PoliticaGrupos getUsuPolGrupFk() {
        return usuPolGrupFk;
    }

    public void setUsuPolGrupFk(PoliticaGrupos usuPolGrupFk) {
        this.usuPolGrupFk = usuPolGrupFk;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuCodPk != null ? usuCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuCodPk == null && other.usuCodPk != null) || (this.usuCodPk != null && !this.usuCodPk.equals(other.usuCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Usuarios[ usuCodPk=" + usuCodPk + " ]";
    }

    public List<PermisosDocUsu> getPermisosDocUsuList() {
        return permisosDocUsuList;
    }

    public void setPermisosDocUsuList(List<PermisosDocUsu> permisosDocUsuList) {
        this.permisosDocUsuList = permisosDocUsuList;
    }
    
}
