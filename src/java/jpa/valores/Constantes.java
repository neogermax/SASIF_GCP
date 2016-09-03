/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author analista03
 */
@Entity
@Table(name = "CONSTANTES")
@NamedQueries({
    @NamedQuery(name = "Constantes.findAll", query = "SELECT c FROM Constantes c")})
public class Constantes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONS_COD_PK")
    private Integer consCodPk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CONS_VALOR_NUM")
    private BigDecimal consValorNum;
    @Size(max = 30)
    @Column(name = "CONS_VALOR_ALF")
    private String consValorAlf;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CONS_DESCRIPCION")
    private String consDescripcion;

    public Constantes() {
    }

    public Constantes(Integer consCodPk) {
        this.consCodPk = consCodPk;
    }

    public Constantes(Integer consCodPk, String consDescripcion) {
        this.consCodPk = consCodPk;
        this.consDescripcion = consDescripcion;
    }

    public Integer getConsCodPk() {
        return consCodPk;
    }

    public void setConsCodPk(Integer consCodPk) {
        this.consCodPk = consCodPk;
    }

    public BigDecimal getConsValorNum() {
        return consValorNum;
    }

    public void setConsValorNum(BigDecimal consValorNum) {
        this.consValorNum = consValorNum;
    }

    public String getConsValorAlf() {
        return consValorAlf;
    }

    public void setConsValorAlf(String consValorAlf) {
        this.consValorAlf = consValorAlf;
    }

    public String getConsDescripcion() {
        return consDescripcion;
    }

    public void setConsDescripcion(String consDescripcion) {
        this.consDescripcion = consDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consCodPk != null ? consCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constantes)) {
            return false;
        }
        Constantes other = (Constantes) object;
        if ((this.consCodPk == null && other.consCodPk != null) || (this.consCodPk != null && !this.consCodPk.equals(other.consCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Constantes[ consCodPk=" + consCodPk + " ]";
    }
    
}
