/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "EMPLEADOS ")
@NamedQueries({
    @NamedQuery(name = "Empleados.findAll", query = "SELECT e FROM Empleados e"),
    @NamedQuery(name = "Empleados.findNoUsuarios", query = "SELECT e FROM Empleados e WHERE e.usuariosList IS EMPTY")
    }
)
public class Empleados implements Serializable {
    @Size(max = 10)
    @Column(name = "EMPL_CODIGO")
    private String emplCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<Contactos> contactosList;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadosPK empleadosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMPL_APELLIDO1")
    private String emplApellido1;
    @Size(max = 20)
    @Column(name = "EMPL_APELLIDO2")
    private String emplApellido2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "EMPL_NOMBRE1")
    private String emplNombre1;
    @Size(max = 20)
    @Column(name = "EMPL_NOMBRE2")
    private String emplNombre2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleados")
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "empleados")
    private List<Empleados> empleadosList;
    @JoinColumns({
        @JoinColumn(name = "EMPL_JEFE_IMMED", referencedColumnName = "EMPL_ID_PK"),
        @JoinColumn(name = "EMPL_JEFE_TIP", referencedColumnName = "EMPL_TIPO_ID_PK")})
    @ManyToOne
    private Empleados empleados;
    @JoinColumn(name = "EMPL_COD_CARGO_FK", referencedColumnName = "CAR_CODIGO_PK")
    @ManyToOne(optional = false)
    private Cargos emplCodCargoFk;
    @JoinColumns({
        @JoinColumn(name = "EMPL_COD_EMPR_FK", referencedColumnName = "ARE_COD_EMP_FK"),
        @JoinColumn(name = "EMPL_COD_AREA_FK", referencedColumnName = "ARE_CODIGO_PK")})
    @ManyToOne(optional = false)
    private Areas areas;

    public Empleados() {
    }

    public Empleados(EmpleadosPK empleadosPK) {
        this.empleadosPK = empleadosPK;
    }

    public Empleados(EmpleadosPK empleadosPK, String emplApellido1, String emplNombre1) {
        this.empleadosPK = empleadosPK;
        this.emplApellido1 = emplApellido1;
        this.emplNombre1 = emplNombre1;
    }

    public Empleados(Long emplId, String emplTipoId) {
        this.empleadosPK = new EmpleadosPK(emplId, emplTipoId);
    }

    public EmpleadosPK getEmpleadosPK() {
        return empleadosPK;
    }

    public void setEmpleadosPK(EmpleadosPK empleadosPK) {
        this.empleadosPK = empleadosPK;
    }

    public String getEmplApellido1() {
        return emplApellido1;
    }

    public void setEmplApellido1(String emplApellido1) {
        this.emplApellido1 = emplApellido1;
    }

    public String getEmplApellido2() {
        return emplApellido2;
    }

    public void setEmplApellido2(String emplApellido2) {
        this.emplApellido2 = emplApellido2;
    }

    public String getEmplNombre1() {
        return emplNombre1;
    }

    public void setEmplNombre1(String emplNombre1) {
        this.emplNombre1 = emplNombre1;
    }

    public String getEmplNombre2() {
        return emplNombre2;
    }

    public void setEmplNombre2(String emplNombre2) {
        this.emplNombre2 = emplNombre2;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public List<Empleados> getEmpleadosList() {
        return empleadosList;
    }

    public void setEmpleadosList(List<Empleados> empleadosList) {
        this.empleadosList = empleadosList;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Cargos getEmplCodCargoFk() {
        return emplCodCargoFk;
    }

    public void setEmplCodCargoFk(Cargos emplCodCargoFk) {
        this.emplCodCargoFk = emplCodCargoFk;
    }

    public Areas getAreas() {
        return areas;
    }

    public void setAreas(Areas areas) {
        this.areas = areas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadosPK != null ? empleadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.empleadosPK == null && other.empleadosPK != null) || (this.empleadosPK != null && !this.empleadosPK.equals(other.empleadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Empleados[ empleadosPK=" + empleadosPK + " ]";
    }

    public List<Contactos> getContactosList() {
        return contactosList;
    }

    public void setContactosList(List<Contactos> contactosList) {
        this.contactosList = contactosList;
    }

    public String getEmplCodigo() {
        return emplCodigo;
    }

    public void setEmplCodigo(String emplCodigo) {
        this.emplCodigo = emplCodigo;
    }
    
}
