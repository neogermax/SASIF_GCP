/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista02
 */
@Entity
@Table(name = "CARGOS ")
@NamedQueries({
    @NamedQuery(name = "Cargos.findAll", query = "SELECT c FROM Cargos c")})
public class Cargos implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "emplCodCargoFk")
    private Collection<Empleados> empleadosCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAR_CODIGO_PK")
    private Integer carCodigoPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CAR_DESCRIP")
    private String carDescrip;

    public Cargos() {
    }

    public Cargos(Integer carCodigoPk) {
        this.carCodigoPk = carCodigoPk;
    }

    public Cargos(Integer carCodigoPk, String carDescrip) {
        this.carCodigoPk = carCodigoPk;
        this.carDescrip = carDescrip;
    }

    public Integer getCarCodigoPk() {
        return carCodigoPk;
    }

    public void setCarCodigoPk(Integer carCodigoPk) {
        this.carCodigoPk = carCodigoPk;
    }

    public String getCarDescrip() {
        return carDescrip;
    }

    public void setCarDescrip(String carDescrip) {
        this.carDescrip = carDescrip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carCodigoPk != null ? carCodigoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargos)) {
            return false;
        }
        Cargos other = (Cargos) object;
        if ((this.carCodigoPk == null && other.carCodigoPk != null) || (this.carCodigoPk != null && !this.carCodigoPk.equals(other.carCodigoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Cargos[ carCodigoPk=" + carCodigoPk + " ]";
    }

    public Collection<Empleados> getEmpleadosCollection() {
        return empleadosCollection;
    }

    public void setEmpleadosCollection(Collection<Empleados> empleadosCollection) {
        this.empleadosCollection = empleadosCollection;
    }
    
}
