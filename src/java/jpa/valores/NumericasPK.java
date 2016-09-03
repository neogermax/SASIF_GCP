/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author analista02
 */
@Embeddable
public class NumericasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_COD_PK")
    private Integer numCodPk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_VALOR")
    private BigDecimal numValor;

    public NumericasPK() {
    }

    public NumericasPK(Integer numCodPk, BigDecimal numValor) {
        this.numCodPk = numCodPk;
        this.numValor = numValor;
    }

    public Integer getNumCodPk() {
        return numCodPk;
    }

    public void setNumCodPk(Integer numCodPk) {
        this.numCodPk = numCodPk;
    }

    public BigDecimal getNumValor() {
        return numValor;
    }

    public void setNumValor(BigDecimal numValor) {
        this.numValor = numValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numCodPk;
        hash += (int) numValor.byteValueExact();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NumericasPK)) {
            return false;
        }
        NumericasPK other = (NumericasPK) object;
        if (this.numCodPk != other.numCodPk) {
            return false;
        }
        if (this.numValor != other.numValor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.NumericasPK[ numCodPk=" + numCodPk + ", numValor=" + numValor + " ]";
    }
    
}
