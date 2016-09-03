/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "PROGRAMAS")
@NamedQueries({
    @NamedQuery(name = "Programas.findAll", query = "SELECT p FROM Programas p")})
public class Programas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PROG_NOM_PK")
    private String progNomPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PROG_PARM")
    private String progParm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PROG_VALOR")
    private String progValor;
    @Column(name = "PROG_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date progModif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PROG_USU_COD")
    private String progUsuCod;
    @OneToMany(mappedBy = "itmProgNomFk")
    private List<Items> itemsList;

    public Programas() {
    }

    public Programas(String progNomPk) {
        this.progNomPk = progNomPk;
    }

    public Programas(String progNomPk, String progParm, String progValor, String progUsuCod) {
        this.progNomPk = progNomPk;
        this.progParm = progParm;
        this.progValor = progValor;
        this.progUsuCod = progUsuCod;
    }

    public String getProgNomPk() {
        return progNomPk;
    }

    public void setProgNomPk(String progNomPk) {
        this.progNomPk = progNomPk;
    }

    public String getProgParm() {
        return progParm;
    }

    public void setProgParm(String progParm) {
        this.progParm = progParm;
    }

    public String getProgValor() {
        return progValor;
    }

    public void setProgValor(String progValor) {
        this.progValor = progValor;
    }

    public Date getProgModif() {
        return progModif;
    }

    public void setProgModif(Date progModif) {
        this.progModif = progModif;
    }

    public String getProgUsuCod() {
        return progUsuCod;
    }

    public void setProgUsuCod(String progUsuCod) {
        this.progUsuCod = progUsuCod;
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
        hash += (progNomPk != null ? progNomPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programas)) {
            return false;
        }
        Programas other = (Programas) object;
        if ((this.progNomPk == null && other.progNomPk != null) || (this.progNomPk != null && !this.progNomPk.equals(other.progNomPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Programas[ progNomPk=" + progNomPk + " ]";
    }
    
}
