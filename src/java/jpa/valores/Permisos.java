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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author analista03
 */
@Entity
@Table(name = "PERMISOS")
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p"),
    @NamedQuery(name = "Permisos.findByAct", query = "SELECT p FROM Permisos p WHERE p.clases = :clase AND p.etapas = :etapa AND p.actividades = :actividad")
})
public class Permisos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PermisosPK permisosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PER_ACC_PROY")
    private String perAccProy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PER_IND_GES")
    private String perIndGes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PER_IND_AUT")
    private String perIndAut;
    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "PER_IND_CONS")
    private String perIndCons;
    @JoinColumn(name = "PER_ETP_COD_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas;
    @JoinColumn(name = "PER_CLS_COD_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "PER_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;

    public Permisos() {
    }

    public Permisos(PermisosPK permisosPK) {
        this.permisosPK = permisosPK;
    }

    public Permisos(PermisosPK permisosPK, String perAccProy, String perIndGes, String perIndAut, String perDocCons, String perDocActua, String perIndCons) {
        this.permisosPK = permisosPK;
        this.perAccProy = perAccProy;
        this.perIndGes = perIndGes;
        this.perIndAut = perIndAut;
        
       
        this.perIndCons = perIndCons;
    }

    public Permisos(String perUsuFk, Integer perClsCodFk, Integer perEtpCodFk, Integer perActCodFk) {
        this.permisosPK = new PermisosPK(perUsuFk, perClsCodFk, perEtpCodFk, perActCodFk);
    }

    public PermisosPK getPermisosPK() {
        return permisosPK;
    }

    public void setPermisosPK(PermisosPK permisosPK) {
        this.permisosPK = permisosPK;
    }

    public String getPerAccProy() {
        return perAccProy;
    }

    public void setPerAccProy(String perAccProy) {
        this.perAccProy = perAccProy;
    }

    public String getPerIndGes() {
        return perIndGes;
    }

    public void setPerIndGes(String perIndGes) {
        this.perIndGes = perIndGes;
    }

    public String getPerIndAut() {
        return perIndAut;
    }

    public void setPerIndAut(String perIndAut) {
        this.perIndAut = perIndAut;
    }

   

    


    public String getPerIndCons() {
        return perIndCons;
    }

    public void setPerIndCons(String perIndCons) {
        this.perIndCons = perIndCons;
    }
    
    
    

    public Etapas getEtapas() {
        return etapas;
    }

    public void setEtapas(Etapas etapas) {
        this.etapas = etapas;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permisosPK != null ? permisosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.permisosPK == null && other.permisosPK != null) || (this.permisosPK != null && !this.permisosPK.equals(other.permisosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Permisos[ permisosPK=" + permisosPK + " ]";
    }
    
}
