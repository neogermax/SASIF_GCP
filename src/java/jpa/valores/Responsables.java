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
 * @author Analista02
 */
@Entity
@Table(name = "RESPONSABLES")
@NamedQueries({
    @NamedQuery(name = "Responsables.findAll", query = "SELECT r FROM Responsables r"),
    @NamedQuery(name = "Responsables.findByCls", query = "SELECT r FROM Responsables r WHERE r.proyectos = :proyecto AND r.clases = :clase AND r.etapas = :etapa AND r.actividades = :actividad"),    
    @NamedQuery(name = "Responsables.findCountAut", query = "SELECT COUNT(r) FROM Responsables r WHERE r.proyectos = :proyecto AND r.clases = :clase AND r.etapas = :etapa AND r.actividades = :actividad AND r.resAutoriz = 'S'"),
    @NamedQuery(name = "Responsables.findCountNoAut", query = "SELECT COUNT(r) FROM Responsables r WHERE r.proyectos = :proyecto AND r.clases = :clase AND r.etapas = :etapa AND r.actividades = :actividad AND r.resAutoriz = 'N'"),
    @NamedQuery(name = "Responsables.findActivos", query = "SELECT r FROM Responsables r WHERE r.resEstado IS NULL"),
    @NamedQuery(name = "Responsables.findActivos2", query = "SELECT r FROM Responsables r WHERE r.proyectos = :proyecto AND r.resEstado IS NULL"),
    @NamedQuery(name = "Responsables.updateActivos", query = "UPDATE Responsables r SET r.resEstado = 'T' WHERE r.proyectos = :proyecto AND r.resEstado IS NULL"),
    @NamedQuery(name = "Responsables.updateActivos2", query = "UPDATE Responsables r SET r.resEstado = 'T' WHERE r.proyectos = :proyecto AND r.clases = :clase AND r.etapas = :etapa AND r.actividades = :actividad AND r.responsablesPK.resCompPk = :comp AND r.responsablesPK.resTipCompPk = :tipComp AND r.resEstado IS NULL"),
    @NamedQuery(name = "Responsables.deleteByAct", query = "DELETE FROM Responsables r WHERE r.proyectos = :proyecto AND r.clases = :clase AND r.etapas = :etapa AND r.actividades = :actividad")
})
public class Responsables implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResponsablesPK responsablesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "RES_TRAB")
    private String resTrab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "RES_AUTORIZ")
    private String resAutoriz;
    @Column(name = "RES_PORCENT")
    private Short resPorcent;
    @Size(min = 1, max = 1)
    @Column(name = "RES_ESTADO")
    private String resEstado;
    @JoinColumn(name = "RES_PRO_COD_FK", referencedColumnName = "PRO_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Proyectos proyectos;
    @JoinColumn(name = "RES_ETP_COD_FK", referencedColumnName = "ETP_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Etapas etapas;
    @JoinColumn(name = "RES_CLS_COD_FK", referencedColumnName = "CLS_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clases clases;
    @JoinColumn(name = "RES_ACT_COD_FK", referencedColumnName = "ACT_COD_PK", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Actividades actividades;

    public Responsables() {
    }

    public Responsables(ResponsablesPK responsablesPK) {
        this.responsablesPK = responsablesPK;
    }

    public Responsables(ResponsablesPK responsablesPK, String resTrab, String resAutoriz, Short resPorcent, String resEstado) {
        this.responsablesPK = responsablesPK;
        this.resTrab = resTrab;
        this.resAutoriz = resAutoriz;
        this.resPorcent = resPorcent;
        this.resEstado = resEstado;
    }

    public Responsables(Integer resProCodFk, Integer resClsCodFk, Integer resEtpCodFk, Integer resActCodFk, String resUsuCodFk, String resCompPk, Integer resTipCompPk) {
        this.responsablesPK = new ResponsablesPK(resProCodFk, resClsCodFk, resEtpCodFk, resActCodFk, resUsuCodFk, resCompPk, resTipCompPk);
    }

    public ResponsablesPK getResponsablesPK() {
        return responsablesPK;
    }

    public void setResponsablesPK(ResponsablesPK responsablesPK) {
        this.responsablesPK = responsablesPK;
    }

    public String getResTrab() {
        return resTrab;
    }

    public void setResTrab(String resTrab) {
        this.resTrab = resTrab;
    }

    public String getResAutoriz() {
        return resAutoriz;
    }

    public void setResAutoriz(String resAutoriz) {
        this.resAutoriz = resAutoriz;
    }

    public Short getResPorcent() {
        return resPorcent;
    }

    public void setResPorcent(Short resPorcent) {
        this.resPorcent = resPorcent;
    }
    
    public String getResEstado() {
        return resEstado;
    }

    public void setResEstado(String resEstado) {
        this.resEstado = resEstado;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
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
        hash += (responsablesPK != null ? responsablesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsables)) {
            return false;
        }
        Responsables other = (Responsables) object;
        if ((this.responsablesPK == null && other.responsablesPK != null) || (this.responsablesPK != null && !this.responsablesPK.equals(other.responsablesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Responsables[ responsablesPK=" + responsablesPK + " ]";
    }
    
}
