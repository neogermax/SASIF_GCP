/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author analista02
 */
@Entity
@Table(name = "FORMULAS")
@NamedQueries({
    @NamedQuery(name = "Formulas.findAll", query = "SELECT f FROM Formulas f")})
public class Formulas implements Serializable {
    @OneToMany(mappedBy = "itmForCodFk")
    private List<Items> itemsList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOR_COD_PK")
    private Integer forCodPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOR_SECUENCIA")
    private Short forSecuencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FOR_COMP_VAL")
    private String forCompVal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FOR_VALOR")
    private String forValor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FOR_OPER")
    private String forOper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "FOR_COMP_OPER")
    private String forCompOper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FOR_VALOR_OPER")
    private String forValorOper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOR_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date forModif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FOR_USU_COD")
    private String forUsuCod;

    public Formulas() {
    }

    public Formulas(Integer forCodPk) {
        this.forCodPk = forCodPk;
    }

    public Formulas(Integer forCodPk, Short forSecuencia, String forCompVal, String forValor, String forOper, String forCompOper, String forValorOper, Date forModif, String forUsuCod) {
        this.forCodPk = forCodPk;
        this.forSecuencia = forSecuencia;
        this.forCompVal = forCompVal;
        this.forValor = forValor;
        this.forOper = forOper;
        this.forCompOper = forCompOper;
        this.forValorOper = forValorOper;
        this.forModif = forModif;
        this.forUsuCod = forUsuCod;
    }

    public Integer getForCodPk() {
        return forCodPk;
    }

    public void setForCodPk(Integer forCodPk) {
        this.forCodPk = forCodPk;
    }

    public Short getForSecuencia() {
        return forSecuencia;
    }

    public void setForSecuencia(Short forSecuencia) {
        this.forSecuencia = forSecuencia;
    }

    public String getForCompVal() {
        return forCompVal;
    }

    public void setForCompVal(String forCompVal) {
        this.forCompVal = forCompVal;
    }

    public String getForValor() {
        return forValor;
    }

    public void setForValor(String forValor) {
        this.forValor = forValor;
    }

    public String getForOper() {
        return forOper;
    }

    public void setForOper(String forOper) {
        this.forOper = forOper;
    }

    public String getForCompOper() {
        return forCompOper;
    }

    public void setForCompOper(String forCompOper) {
        this.forCompOper = forCompOper;
    }

    public String getForValorOper() {
        return forValorOper;
    }

    public void setForValorOper(String forValorOper) {
        this.forValorOper = forValorOper;
    }

    public Date getForModif() {
        return forModif;
    }

    public void setForModif(Date forModif) {
        this.forModif = forModif;
    }

    public String getForUsuCod() {
        return forUsuCod;
    }

    public void setForUsuCod(String forUsuCod) {
        this.forUsuCod = forUsuCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (forCodPk != null ? forCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulas)) {
            return false;
        }
        Formulas other = (Formulas) object;
        if ((this.forCodPk == null && other.forCodPk != null) || (this.forCodPk != null && !this.forCodPk.equals(other.forCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Formulas[ forCodPk=" + forCodPk + " ]";
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }
    
}
