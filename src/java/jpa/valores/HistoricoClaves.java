/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "HISTORICO_CLAVES")
@NamedQueries({
    @NamedQuery(name = "HistoricoClaves.findAll", query = "SELECT h FROM HistoricoClaves h WHERE h.hisUsuarioFk = :usuario")})
public class HistoricoClaves implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIS_ID_PK")
    private Long hisIdPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "HIS_USUARIO_FK")
    private String hisUsuarioFk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIS_FECHA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hisFechaHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "HIS_CLAVE")
    private String hisClave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HIS_MODIF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hisModif;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "HIS_USU_COD")
    private String hisUsuCod;

    public HistoricoClaves() {
    }

    public HistoricoClaves(Long hisIdPk) {
        this.hisIdPk = hisIdPk;
    }

    public HistoricoClaves(Long hisIdPk, Date hisFechaHora, String hisClave, Date hisModif, String hisUsuCod) {
        this.hisIdPk = hisIdPk;
        this.hisFechaHora = hisFechaHora;
        this.hisClave = hisClave;
        this.hisModif = hisModif;
        this.hisUsuCod = hisUsuCod;
    }

    public Long getHisIdPk() {
        return hisIdPk;
    }

    public void setHisIdPk(Long hisIdPk) {
        this.hisIdPk = hisIdPk;
    }
    
    public String getHisUsuarioFk() {
        return hisUsuarioFk;
    }

    public void setHisUsuarioFk(String hisUsuarioFk) {
        this.hisUsuarioFk = hisUsuarioFk;
    }

    public Date getHisFechaHora() {
        return hisFechaHora;
    }

    public void setHisFechaHora(Date hisFechaHora) {
        this.hisFechaHora = hisFechaHora;
    }

    public String getHisClave() {
        return hisClave;
    }

    public void setHisClave(String hisClave) {
        this.hisClave = hisClave;
    }

    public Date getHisModif() {
        return hisModif;
    }

    public void setHisModif(Date hisModif) {
        this.hisModif = hisModif;
    }

    public String getHisUsuCod() {
        return hisUsuCod;
    }

    public void setHisUsuCod(String hisUsuCod) {
        this.hisUsuCod = hisUsuCod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hisIdPk != null ? hisIdPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoClaves)) {
            return false;
        }
        HistoricoClaves other = (HistoricoClaves) object;
        return hisClave.equals(other.getHisClave());
    }

    @Override
    public String toString() {
        return "jpa.valores.HistoricoClaves[ hisIdPk=" + hisIdPk + " ]";
    }
    
}
