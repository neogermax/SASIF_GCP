/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 *
 * @author analista02
 */
@Entity
@Table(name = "AYUDAS")
@NamedQueries({
    @NamedQuery(name = "Ayudas.findAll", query = "SELECT a FROM Ayudas a ORDER BY a.aydCodPk")})
public class Ayudas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AYD_COD_PK")
    private Integer aydCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "AYD_DESCRIP")
    private String aydDescrip;
    
   
    
    public Ayudas() {
    }

    public Ayudas(Integer aydCodPk) {
        this.aydCodPk = aydCodPk;
    }

    public Ayudas(Integer aydCodPk, String aydDescrip) {
        this.aydCodPk = aydCodPk;
        this.aydDescrip = aydDescrip;
    }

    public Integer getAydCodPk() {
        return aydCodPk;
    }

    public void setAydCodPk(Integer aydCodPk) {
        this.aydCodPk = aydCodPk;
    }

    public String getAydDescrip() {
        return aydDescrip;
    }

    public void setAydDescrip(String aydDescrip) {
        this.aydDescrip = aydDescrip;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aydCodPk != null ? aydCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ayudas)) {
            return false;
        }
        Ayudas other = (Ayudas) object;
        if (!this.aydCodPk.equals(other.getAydCodPk())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Ayudas[ aydCodPk=" + aydCodPk + " ]";
    }
    
}
