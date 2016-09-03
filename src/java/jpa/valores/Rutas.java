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
@Table(name = "RUTAS")
@NamedQueries({
    @NamedQuery(name = "Rutas.findAll", query = "SELECT r FROM Rutas r")})
public class Rutas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RUT_CODIGO_PK")
    private Integer rutCodigoPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RUT_RUTA")
    private String rutRuta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pdoCodRutaFk")
    private List<Pdocumentos> pdocumentosList;

    public Rutas() {
    }

    public Rutas(Integer rutCodigoPk) {
        this.rutCodigoPk = rutCodigoPk;
    }

    public Rutas(Integer rutCodigoPk, String rutRuta) {
        this.rutCodigoPk = rutCodigoPk;
        this.rutRuta = rutRuta;
    }

    public Integer getRutCodigoPk() {
        return rutCodigoPk;
    }

    public void setRutCodigoPk(Integer rutCodigoPk) {
        this.rutCodigoPk = rutCodigoPk;
    }

    public String getRutRuta() {
        return rutRuta;
    }

    public void setRutRuta(String rutRuta) {
        this.rutRuta = rutRuta;
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
        hash += (rutCodigoPk != null ? rutCodigoPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rutas)) {
            return false;
        }
        Rutas other = (Rutas) object;
        if ((this.rutCodigoPk == null && other.rutCodigoPk != null) || (this.rutCodigoPk != null && !this.rutCodigoPk.equals(other.rutCodigoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Rutas[ rutCodigoPk=" + rutCodigoPk + " ]";
    }
    
}
