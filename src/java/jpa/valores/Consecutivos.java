/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "CONSECUTIVOS")
@NamedQueries({
    @NamedQuery(name = "Consecutivos.findAll", query = "SELECT c FROM Consecutivos c")})
public class Consecutivos implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSEC_VALOR")
    private BigInteger consecValor;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONSEC_COD_PK")
    private Integer consecCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONSEC_DESCRIP")
    private String consecDescrip;
    @OneToMany(mappedBy = "itmConsecCodFk")
    private List<Items> itemsList;

    public Consecutivos() {
    }

    public Consecutivos(Integer consecCodPk) {
        this.consecCodPk = consecCodPk;
    }

    public Consecutivos(Integer consecCodPk, BigInteger consecValor, String consecDescrip) {
        this.consecCodPk = consecCodPk;
        this.consecValor = consecValor;
        this.consecDescrip = consecDescrip;
    }

    public Integer getConsecCodPk() {
        return consecCodPk;
    }

    public void setConsecCodPk(Integer consecCodPk) {
        this.consecCodPk = consecCodPk;
    }

    public BigInteger getConsecValor() {
        return consecValor;
    }

    public void setConsecValor(BigInteger consecValor) {
        this.consecValor = consecValor;
    }

    public String getConsecDescrip() {
        return consecDescrip;
    }

    public void setConsecDescrip(String consecDescrip) {
        this.consecDescrip = consecDescrip;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consecCodPk != null ? consecCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consecutivos)) {
            return false;
        }
        Consecutivos other = (Consecutivos) object;
        if ((this.consecCodPk == null && other.consecCodPk != null) || (this.consecCodPk != null && !this.consecCodPk.equals(other.consecCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Consecutivos[ consecCodPk=" + consecCodPk + " ]";
    }
    
}
