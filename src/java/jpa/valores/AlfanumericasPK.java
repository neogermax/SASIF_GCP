/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Embeddable
public class AlfanumericasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ALF_COD_PK")
    private Integer alfCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ALF_VALOR")
    private String alfValor;

    public AlfanumericasPK() {
    }

    public AlfanumericasPK(Integer alfCodPk, String alfValor) {
        this.alfCodPk = alfCodPk;
        this.alfValor = alfValor;
    }

    public Integer getAlfCodPk() {
        return alfCodPk;
    }

    public void setAlfCodPk(Integer alfCodPk) {
        this.alfCodPk = alfCodPk;
    }

    public String getAlfValor() {
        return alfValor;
    }

    public void setAlfValor(String alfValor) {
        this.alfValor = alfValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) alfCodPk;
        hash += (alfValor != null ? alfValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlfanumericasPK)) {
            return false;
        }
        AlfanumericasPK other = (AlfanumericasPK) object;
        if (this.alfCodPk != other.alfCodPk) {
            return false;
        }
        if ((this.alfValor == null && other.alfValor != null) || (this.alfValor != null && !this.alfValor.equals(other.alfValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.AlfanumericasPK[ alfCodPk=" + alfCodPk + ", alfValor=" + alfValor + " ]";
    }
    
}
