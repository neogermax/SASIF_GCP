/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author analista03
 */
@Entity
@Table(name = "CARACTERISTICAS")
@NamedQueries({
    @NamedQuery(name = "Caracteristicas.findAll", query = "SELECT c FROM Caracteristicas c"),
    @NamedQuery(name = "Caracteristicas.findByCode", query = "SELECT c FROM Caracteristicas c WHERE c.parametrias = :parametria"),
    @NamedQuery(name = "Caracteristicas.findBySecuen", query = "SELECT c FROM Caracteristicas c WHERE c.carUsuGen = :CarUsuGen AND c.caracteristicasPK.carCodRepFk = :CarCodRepFk"),
    @NamedQuery(name = "Caracteristicas.findByMaxSec", query = "SELECT MAX(c.caracteristicasPK.carSecuPk) FROM Caracteristicas c WHERE c.carUsuGen = :carusugen AND c.caracteristicasPK.carCodRepFk = :carcodrepfk"),
    @NamedQuery(name = "Caracteristicas.findBySecCons", query = "SELECT MAX(c.caracteristicasPK.carSecuPk) FROM Caracteristicas c WHERE c.caracteristicasPK.carCodRepFk = :codrep"),
    @NamedQuery(name = "Caracteristicas.findByUsuario", query = "SELECT c FROM Caracteristicas c WHERE c.carUsuGen = :carUsuGen AND c.parametrias = :parametria"),
    @NamedQuery(name = "Caracteristicas.findByUltimo", 
        query = "SELECT c FROM Caracteristicas c WHERE c.carUsuGen = :carUsuGen AND c.caracteristicasPK.carCodRepFk = :cod1 AND c.caracteristicasPK.carSecuPk = (SELECT MAX(c2.caracteristicasPK.carSecuPk) FROM Caracteristicas c2 WHERE c2.carUsuGen = :carUsuGen AND c2.caracteristicasPK.carCodRepFk = :cod2)"),
    @NamedQuery(name = "Caracteristicas.findByUltimo2", 
        query = "SELECT c FROM Caracteristicas c WHERE c.caracteristicasPK.carCodRepFk = :cod1 AND c.caracteristicasPK.carSecuPk = (SELECT MAX(c2.caracteristicasPK.carSecuPk) FROM Caracteristicas c2 WHERE c2.carUsuGen = :carUsuGen AND c2.caracteristicasPK.carCodRepFk = :cod2)")
})

//query = "SELECT c FROM Caracteristicas c WHERE c.carUsuGen = :carUsuGen AND c.caracteristicasPK.carCodRepFk = :cod1 AND c.caracteristicasPK.carSecuPk = (SELECT MAX(c.caracteristicasPK.carSecuPk) FROM Caracteristicas c WHERE c.carUsuGen = :carUsuGen AND c.caracteristicasPK.carCodRepFk = :cod2)")

public class Caracteristicas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CaracteristicasPK caracteristicasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAR_FEC_HOR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date carFecHor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CAR_USU_GEN")
    private String carUsuGen;
    
    @JoinColumn(name = "CAR_COD_REP_FK", referencedColumnName = "PAR_COD_REP_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Parametrias parametrias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caracteristicas")
    private List<Reportes> reportesList;

    public Caracteristicas() {
    }

    public Caracteristicas(CaracteristicasPK caracteristicasPK) {
        this.caracteristicasPK = caracteristicasPK;
    }

    public Caracteristicas(CaracteristicasPK caracteristicasPK, Date carFecHor, String carUsuGen) {
        this.caracteristicasPK = caracteristicasPK;
        this.carFecHor = carFecHor;
        this.carUsuGen = carUsuGen;
        
    }

    public Caracteristicas(int carSecuPk, int carCodRepFk) {
        this.caracteristicasPK = new CaracteristicasPK(carSecuPk, carCodRepFk);
    }

    public CaracteristicasPK getCaracteristicasPK() {
        return caracteristicasPK;
    }

    public void setCaracteristicasPK(CaracteristicasPK caracteristicasPK) {
        this.caracteristicasPK = caracteristicasPK;
    }

    public Date getCarFecHor() {
        return carFecHor;
    }

    public void setCarFecHor(Date carFecHor) {
        this.carFecHor = carFecHor;
    }

    public String getCarUsuGen() {
        return carUsuGen;
    }

    public void setCarUsuGen(String carUsuGen) {
        this.carUsuGen = carUsuGen;
    }

    

    public Parametrias getParametrias() {
        return parametrias;
    }

    public void setParametrias(Parametrias parametrias) {
        this.parametrias = parametrias;
    }

    public List<Reportes> getReportesList() {
        return reportesList;
    }

    public void setReportesList(List<Reportes> reportesList) {
        this.reportesList = reportesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caracteristicasPK != null ? caracteristicasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristicas)) {
            return false;
        }
        Caracteristicas other = (Caracteristicas) object;
        if ((this.caracteristicasPK == null && other.caracteristicasPK != null) || (this.caracteristicasPK != null && !this.caracteristicasPK.equals(other.caracteristicasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Caracteristicas[ caracteristicasPK=" + caracteristicasPK + " ]";
    }
    
}
