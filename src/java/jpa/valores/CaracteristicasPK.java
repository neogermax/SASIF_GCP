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

/**
 *
 * @author analista03
 */
@Embeddable
public class CaracteristicasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAR_SECU_PK")
    private Integer carSecuPk;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAR_COD_REP_FK")
    private Integer carCodRepFk;

    public CaracteristicasPK() {
    }

    public CaracteristicasPK(Integer carSecuPk, Integer carCodRepFk) {
        this.carSecuPk = carSecuPk;
        this.carCodRepFk = carCodRepFk;
    }

    public Integer getCarSecuPk() {
        return carSecuPk;
    }

    public void setCarSecuPk(Integer carSecuPk) {
        this.carSecuPk = carSecuPk;
    }

    public Integer getCarCodRepFk() {
        return carCodRepFk;
    }

    public void setCarCodRepFk(Integer carCodRepFk) {
        this.carCodRepFk = carCodRepFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) carSecuPk;
        hash += (int) carCodRepFk;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicasPK)) {
            return false;
        }
        CaracteristicasPK other = (CaracteristicasPK) object;
        if (this.carSecuPk != other.carSecuPk) {
            return false;
        }
        if (this.carCodRepFk != other.carCodRepFk) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.CaracteristicasPK[ carSecuPk=" + carSecuPk + ", carCodRepFk=" + carCodRepFk + " ]";
    }
    
}
