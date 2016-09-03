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
@Table(name = "ERRORES")
@NamedQueries({
    @NamedQuery(name = "Errores.findAll", query = "SELECT e FROM Errores e ORDER BY e.errCodPk")})
public class Errores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ERR_COD_PK")
    private Integer errCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ERR_DESCRIP")
    private String errDescrip;

    public Errores() {
    }

    public Errores(Integer errCodPk) {
        this.errCodPk = errCodPk;
    }

    public Errores(Integer errCodPk, String errDescrip) {
        this.errCodPk = errCodPk;
        this.errDescrip = errDescrip;
    }

    public Integer getErrCodPk() {
        return errCodPk;
    }

    public void setErrCodPk(Integer errCodPk) {
        this.errCodPk = errCodPk;
    }

    public String getErrDescrip() {
        return errDescrip;
    }

    public void setErrDescrip(String errDescrip) {
        this.errDescrip = errDescrip;
    } 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (errCodPk != null ? errCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Errores)) {
            return false;
        }
        Errores other = (Errores) object;
        if ((this.errCodPk == null && other.errCodPk != null) || (this.errCodPk != null && !this.errCodPk.equals(other.errCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Errores[ errCodPk=" + errCodPk + " ]";
    }
    
}
