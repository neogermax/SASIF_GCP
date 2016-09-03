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
 * @author analista03
 */
@Embeddable
public class ReportesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "REP_COD_REP_FK")
    private Integer repCodRepFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REP_CAR_SEC_FK")
    private Integer repCarSecFk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "REP_NOM_FIL")
    private String repNomFil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "REP_NOM_COL")
    private String repNomCol;

    public ReportesPK() {
    }

    public ReportesPK(Integer repCodRepFk, Integer repCarSecFk, String repNomFil, String repNomCol) {
        this.repCodRepFk = repCodRepFk;
        this.repCarSecFk = repCarSecFk;
        this.repNomFil = repNomFil;
        this.repNomCol = repNomCol;
    }

    public Integer getRepCodRepFk() {
        return repCodRepFk;
    }

    public void setRepCodRepFk(Integer repCodRepFk) {
        this.repCodRepFk = repCodRepFk;
    }

    public Integer getRepCarSecFk() {
        return repCarSecFk;
    }

    public void setRepCarSecFk(Integer repCarSecFk) {
        this.repCarSecFk = repCarSecFk;
    }

    public String getRepNomFil() {
        return repNomFil;
    }

    public void setRepNomFil(String repNomFil) {
        this.repNomFil = repNomFil;
    }

    public String getRepNomCol() {
        return repNomCol;
    }

    public void setRepNomCol(String repNomCol) {
        this.repNomCol = repNomCol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) repCodRepFk;
        hash += (int) repCarSecFk;
        hash += (repNomFil != null ? repNomFil.hashCode() : 0);
        hash += (repNomCol != null ? repNomCol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReportesPK)) {
            return false;
        }
        ReportesPK other = (ReportesPK) object;
        if (this.repCodRepFk != other.repCodRepFk) {
            return false;
        }
        if (this.repCarSecFk != other.repCarSecFk) {
            return false;
        }
        if ((this.repNomFil == null && other.repNomFil != null) || (this.repNomFil != null && !this.repNomFil.equals(other.repNomFil))) {
            return false;
        }
        if ((this.repNomCol == null && other.repNomCol != null) || (this.repNomCol != null && !this.repNomCol.equals(other.repNomCol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.ReportesPK[ repCodRepFk=" + repCodRepFk + ", repCarSecFk=" + repCarSecFk + ", repNomFil=" + repNomFil + ", repNomCol=" + repNomCol + " ]";
    }
    
}
