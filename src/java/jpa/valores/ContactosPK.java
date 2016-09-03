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
 * @author saflap
 */
@Embeddable
public class ContactosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CON_EMPL_ID_PK")
    private Long conEmplIdPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CON_CONSEC_PK")
    private Integer conConsecPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CON_EMPL_TIP_PK")
    private String conEmplTipPk;

    public ContactosPK() {
    }

    public ContactosPK(Long conEmplIdPk, Integer conConsecPk, String conEmplTipPk) {
        this.conEmplIdPk = conEmplIdPk;
        this.conConsecPk = conConsecPk;
        this.conEmplTipPk = conEmplTipPk;
    }

    public Long getConEmplIdPk() {
        return conEmplIdPk;
    }

    public void setConEmplIdPk(Long conEmplIdPk) {
        this.conEmplIdPk = conEmplIdPk;
    }

    public Integer getConConsecPk() {
        return conConsecPk;
    }

    public void setConConsecPk(Integer conConsecPk) {
        this.conConsecPk = conConsecPk;
    }

    public String getConEmplTipPk() {
        return conEmplTipPk;
    }

    public void setConEmplTipPk(String conEmplTipPk) {
        this.conEmplTipPk = conEmplTipPk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) conEmplIdPk.intValue();
        hash += (int) conConsecPk;
        hash += (conEmplTipPk != null ? conEmplTipPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactosPK)) {
            return false;
        }
        ContactosPK other = (ContactosPK) object;
        if (this.conEmplIdPk != other.conEmplIdPk) {
            return false;
        }
        if (this.conConsecPk != other.conConsecPk) {
            return false;
        }
        if ((this.conEmplTipPk == null && other.conEmplTipPk != null) || (this.conEmplTipPk != null && !this.conEmplTipPk.equals(other.conEmplTipPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ContactosPK[ conEmplIdPk=" + conEmplIdPk + ", conConsecPk=" + conConsecPk + ", conEmplTipPk=" + conEmplTipPk + " ]";
    }
    
}
