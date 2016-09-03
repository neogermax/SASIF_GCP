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
 * @author Analista02
 */
@Entity
@Table(name = "GDOCUMENTOS")
@NamedQueries({
    @NamedQuery(name = "Gdocumentos.findAll", query = "SELECT g FROM Gdocumentos g")})
public class Gdocumentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "GDO_GRUPO_PK")
    private Integer gdoGrupoPk;
    @Size(max = 50)
    @Column(name = "GDO_DESCRIPCION")
    private String gdoDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdoGrupoFk")
    private List<Pdocumentos> pdocumentosList;

    public Gdocumentos() {
    }

    public Gdocumentos(Integer gdoGrupoPk) {
        this.gdoGrupoPk = gdoGrupoPk;
    }

    public Integer getGdoGrupoPk() {
        return gdoGrupoPk;
    }

    public void setGdoGrupoPk(Integer gdoGrupoPk) {
        this.gdoGrupoPk = gdoGrupoPk;
    }

    public String getGdoDescripcion() {
        return gdoDescripcion;
    }

    public void setGdoDescripcion(String gdoDescripcion) {
        this.gdoDescripcion = gdoDescripcion;
    }

    public List<Pdocumentos> getPdocumentosList() {
        return pdocumentosList;
    }

    public void setPdocumentosList(List<Pdocumentos> pdocumentosList) {
        this.pdocumentosList = pdocumentosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gdoGrupoPk != null ? gdoGrupoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gdocumentos)) {
            return false;
        }
        Gdocumentos other = (Gdocumentos) object;
        if ((this.gdoGrupoPk == null && other.gdoGrupoPk != null) || (this.gdoGrupoPk != null && !this.gdoGrupoPk.equals(other.gdoGrupoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Gdocumentos[ gdoGrupoPk=" + gdoGrupoPk + " ]";
    }
    
}
