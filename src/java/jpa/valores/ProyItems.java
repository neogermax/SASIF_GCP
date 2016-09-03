/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "PROY_ITEMS")
@NamedQueries({
    @NamedQuery(name = "ProyItems.findAll", query = "SELECT p FROM ProyItems p"),
    @NamedQuery(name = "ProyItems.comsultaItems", query = "SELECT p FROM ProyItems p"),
    @NamedQuery(name = "ProyItems.actItems", query = "SELECT p FROM ProyItems p, ActItems a WHERE a.actividades.actCodPk = :act AND a.acitmItmCodFk = p.items AND p.proyectos = :proy Order by a.actItemsPK.acitmSec")})
public class ProyItems implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProyItemsPK proyItemsPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRY_VALOR_NUM")
    private BigDecimal pryValorNum;
    @Size(max = 50)
    @Column(name = "PRY_VALOR_ALFA")
    private String pryValorAlfa;
    @Column(name = "PRY_VALOR_FECHA")
    @Temporal(TemporalType.DATE)
    private Date pryValorFecha;
    @JoinColumn(name = "PRY_PRO_COD_FK", referencedColumnName = "PRO_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;
    @JoinColumn(name = "PRY_ITM_COD_FK", referencedColumnName = "ITM_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Items items;

    public ProyItems() {
    }

    public ProyItems(ProyItemsPK proyItemsPK) {
        this.proyItemsPK = proyItemsPK;
    }

    public ProyItems(Integer pryProCodFk, Integer pryItmCodFk, String pryComNomFk, Integer pryComTipFk) {
        this.proyItemsPK = new ProyItemsPK(pryProCodFk, pryItmCodFk, pryComNomFk, pryComTipFk);
    }

    public ProyItemsPK getProyItemsPK() {
        return proyItemsPK;
    }

    public void setProyItemsPK(ProyItemsPK proyItemsPK) {
        this.proyItemsPK = proyItemsPK;
    }

    public BigDecimal getPryValorNum() {
        return pryValorNum;
    }

    public void setPryValorNum(BigDecimal pryValorNum) {
        this.pryValorNum = pryValorNum;
    }

    public String getPryValorAlfa() {
        return pryValorAlfa;
    }

    public void setPryValorAlfa(String pryValorAlfa) {
        this.pryValorAlfa = pryValorAlfa;
    }

    public Date getPryValorFecha() {
        return pryValorFecha;
    }

    public void setPryValorFecha(Date pryValorFecha) {
        this.pryValorFecha = pryValorFecha;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyItemsPK != null ? proyItemsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyItems)) {
            return false;
        }
        ProyItems other = (ProyItems) object;
        if ((this.proyItemsPK == null && other.proyItemsPK != null) || (this.proyItemsPK != null && !this.proyItemsPK.equals(other.proyItemsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ProyItems[ proyItemsPK=" + proyItemsPK + " ]";
    }
    
}
