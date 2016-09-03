/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author saflap
 */
@Entity
@Table(name = "CONTACTOS")
@NamedQueries({
    @NamedQuery(name = "Contactos.findAll", query = "SELECT c FROM Contactos c"),
    @NamedQuery(name = "Contactos.findByEmpleadoPK", query = "SELECT c FROM Contactos c WHERE c.contactosPK.conEmplIdPk = :empleadoId AND c.contactosPK.conEmplTipPk = :empleadoTipoId")})
public class Contactos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContactosPK contactosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CON_DIRECCION")
    private String conDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CON_TELEFONO1")
    private String conTelefono1;
    @Size(max = 20)
    @Column(name = "CON_TELEFONO2")
    private String conTelefono2;
    @Size(max = 20)
    @Column(name = "CON_TELEFONO3")
    private String conTelefono3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CON_CORREO1")
    private String conCorreo1;
    @Size(max = 50)
    @Column(name = "CON_CORREO2")
    private String conCorreo2;
    @Size(max = 50)
    @Column(name = "CON_CORREO3")
    private String conCorreo3;
    @JoinColumns({
        @JoinColumn(name = "CON_EMPL_ID_PK", referencedColumnName = "EMPL_ID_PK", insertable = false, updatable = false),
        @JoinColumn(name = "CON_EMPL_TIP_PK", referencedColumnName = "EMPL_TIPO_ID_PK", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Empleados empleados;

    public Contactos() {
    }

    public Contactos(ContactosPK contactosPK) {
        this.contactosPK = contactosPK;
    }

    public Contactos(ContactosPK contactosPK, String conDireccion, String conTelefono1, String conCorreo1) {
        this.contactosPK = contactosPK;
        this.conDireccion = conDireccion;
        this.conTelefono1 = conTelefono1;
        this.conCorreo1 = conCorreo1;
    }

    public Contactos(Long conEmplIdPk, Integer conConsecPk, String conEmplTipPk) {
        this.contactosPK = new ContactosPK(conEmplIdPk, conConsecPk, conEmplTipPk);
    }

    public ContactosPK getContactosPK() {
        return contactosPK;
    }

    public void setContactosPK(ContactosPK contactosPK) {
        this.contactosPK = contactosPK;
    }

    public String getConDireccion() {
        return conDireccion;
    }

    public void setConDireccion(String conDireccion) {
        this.conDireccion = conDireccion;
    }

    public String getConTelefono1() {
        return conTelefono1;
    }

    public void setConTelefono1(String conTelefono1) {
        this.conTelefono1 = conTelefono1;
    }

    public String getConTelefono2() {
        return conTelefono2;
    }

    public void setConTelefono2(String conTelefono2) {
        this.conTelefono2 = conTelefono2;
    }

    public String getConTelefono3() {
        return conTelefono3;
    }

    public void setConTelefono3(String conTelefono3) {
        this.conTelefono3 = conTelefono3;
    }

    public String getConCorreo1() {
        return conCorreo1;
    }

    public void setConCorreo1(String conCorreo1) {
        this.conCorreo1 = conCorreo1;
    }

    public String getConCorreo2() {
        return conCorreo2;
    }

    public void setConCorreo2(String conCorreo2) {
        this.conCorreo2 = conCorreo2;
    }

    public String getConCorreo3() {
        return conCorreo3;
    }

    public void setConCorreo3(String conCorreo3) {
        this.conCorreo3 = conCorreo3;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactosPK != null ? contactosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactos)) {
            return false;
        }
        Contactos other = (Contactos) object;
        if ((this.contactosPK == null && other.contactosPK != null) || (this.contactosPK != null && !this.contactosPK.equals(other.contactosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Contactos[ contactosPK=" + contactosPK + " ]";
    }
    
}
