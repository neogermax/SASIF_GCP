/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "VALOR_HORA")
@NamedQueries({
    @NamedQuery(name = "ValorHora.findAll", query = "SELECT v FROM ValorHora v")})
public class ValorHora implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ValorHoraPK valorHoraPK;
    @Column(name = "VALHO_VALOR")
    private Long valhoValor;
    @JoinColumn(name = "VALHO_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;

    public ValorHora() {
    }

    public ValorHora(ValorHoraPK valorHoraPK) {
        this.valorHoraPK = valorHoraPK;
    }

    public ValorHora(Date valhoFecha, int valhoActCodFk, String valhoUsuCod) {
        this.valorHoraPK = new ValorHoraPK(valhoFecha, valhoActCodFk, valhoUsuCod);
    }

    public ValorHoraPK getValorHoraPK() {
        return valorHoraPK;
    }

    public void setValorHoraPK(ValorHoraPK valorHoraPK) {
        this.valorHoraPK = valorHoraPK;
    }

    public Long getValhoValor() {
        return valhoValor;
    }

    public void setValhoValor(Long valhoValor) {
        this.valhoValor = valhoValor;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valorHoraPK != null ? valorHoraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValorHora)) {
            return false;
        }
        ValorHora other = (ValorHora) object;
        if ((this.valorHoraPK == null && other.valorHoraPK != null) || (this.valorHoraPK != null && !this.valorHoraPK.equals(other.valorHoraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ValorHora[ valorHoraPK=" + valorHoraPK + " ]";
    }
    
}
