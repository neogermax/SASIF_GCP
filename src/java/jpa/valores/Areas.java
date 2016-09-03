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
 * @author analista02
 */
@Entity
@Table(name = "AREAS")
@NamedQueries({
    @NamedQuery(name = "Areas.findAll", query = "SELECT a FROM Areas a")})
public class Areas implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areas")
    private List<Empleados> empleadosList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreasPK areasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ARE_NOMBRE")
    private String areNombre;
    @JoinColumn(name = "ARE_COD_EMP_FK", referencedColumnName = "EMPR_CODIGO_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresas empresas;

    public Areas() {
    }

    public Areas(AreasPK areasPK) {
        this.areasPK = areasPK;
    }

    public Areas(AreasPK areasPK, String areNombre) {
        this.areasPK = areasPK;
        this.areNombre = areNombre;
    }

    public Areas(Integer areCodEmpFk, Integer areCodigoPk) {
        this.areasPK = new AreasPK(areCodEmpFk, areCodigoPk);
    }

    public AreasPK getAreasPK() {
        return areasPK;
    }

    public void setAreasPK(AreasPK areasPK) {
        this.areasPK = areasPK;
    }

    public String getAreNombre() {
        return areNombre;
    }

    public void setAreNombre(String areNombre) {
        this.areNombre = areNombre;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areasPK != null ? areasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Areas)) {
            return false;
        }
        Areas other = (Areas) object;
        if ((this.areasPK == null && other.areasPK != null) || (this.areasPK != null && !this.areasPK.equals(other.areasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Areas[ areasPK=" + areasPK + " ]";
    }

    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }
    
}
