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
 * @author analista03
 */
@Entity
@Table(name = "PARAMETRIAS")
@NamedQueries({
    @NamedQuery(name = "Parametrias.findAll", query = "SELECT p FROM Parametrias p ORDER BY p.parCodRepPk"),
    @NamedQuery(name = "Parametrias.findBySint", query = "SELECT p FROM Parametrias p WHERE p.parTipoRep <> 'T' OR p.parTipoRep IS NULL ORDER BY p.parCodRepPk"),
    @NamedQuery(name = "Parametrias.findByTipo", query = "SELECT p FROM Parametrias p WHERE p.parTipoRep = :tipo ORDER BY p.parCodRepPk"),
    @NamedQuery(name = "Parametrias.findByGrupo", query = "SELECT p FROM Parametrias p WHERE p.parTipoRep = :tipo AND p.parCodGrpRepFk = :grupo ORDER BY p.parCodRepPk")
})
public class Parametrias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAR_COD_REP_PK")
    private Integer parCodRepPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PAR_NOMBRE_REP")
    private String parNombreRep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PAR_ARG_FIL")
    private String parArgFil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PAR_ARG_COL")
    private String parArgCol;
    @Size(max = 20)
    @Column(name = "PAR_ARG_DZ")
    private String parArgDz;
    @Size(max = 1)
    @Column(name = "PAR_TIPO_REP")
    private String parTipoRep;
    @Basic(optional = false)
    @Column(name = "PAR_COD_GRP_REP_FK")
    private Integer parCodGrpRepFk;
    @Size(max = 1)
    @Column(name = "PAR_PROG_LLAM")
    private String parProgLlam;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parametrias")
    private List<Caracteristicas> caracteristicasList;

    public Parametrias() {
    }

    public Parametrias(Integer parCodRepPk) {
        this.parCodRepPk = parCodRepPk;
    }

    public Parametrias(Integer parCodRepPk, String parNombreRep, String parArgFil, String parArgCol, String parUsuCod, Date parModif, String parTipoRep, Integer parCodGrpRepFk, String parProgLlam) {
        this.parCodRepPk = parCodRepPk;
        this.parNombreRep = parNombreRep;
        this.parArgFil = parArgFil;
        this.parArgCol = parArgCol;
        this.parTipoRep = parTipoRep;
        this.parCodGrpRepFk = parCodGrpRepFk;
        this.parProgLlam = parProgLlam;
        
    }

    public Integer getParCodRepPk() {
        return parCodRepPk;
    }

    public void setParCodRepPk(Integer parCodRepPk) {
        this.parCodRepPk = parCodRepPk;
    }

    public String getParNombreRep() {
        return parNombreRep;
    }

    public void setParNombreRep(String parNombreRep) {
        this.parNombreRep = parNombreRep;
    }

    public String getParArgFil() {
        return parArgFil;
    }

    public void setParArgFil(String parArgFil) {
        this.parArgFil = parArgFil;
    }

    public String getParArgCol() {
        return parArgCol;
    }

    public void setParArgCol(String parArgCol) {
        this.parArgCol = parArgCol;
    }

    public String getParArgDz() {
        return parArgDz;
    }

    public void setParArgDz(String parArgDz) {
        this.parArgDz = parArgDz;
    }
    
    public String getParTipoRep() {
        return parTipoRep;
    }

    public void setParTipoRep(String parTipoRep) {
        this.parTipoRep = parTipoRep;
    }
    
    public Integer getParCodGrpRepFk() {
        return parCodGrpRepFk;
    }

    public void setParCodGrpRepFk(Integer parCodGrpRepFk) {
        this.parCodGrpRepFk = parCodGrpRepFk;
    }
    
    public String getParProgLlam() {
        return parProgLlam;
    }

    public void setParProgLlam(String parProgLlam) {
        this.parProgLlam = parProgLlam;
    }

    public List<Caracteristicas> getCaracteristicasList() {
        return caracteristicasList;
    }

    public void setCaracteristicasList(List<Caracteristicas> caracteristicasList) {
        this.caracteristicasList = caracteristicasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parCodRepPk != null ? parCodRepPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametrias)) {
            return false;
        }
        Parametrias other = (Parametrias) object;
        if ((this.parCodRepPk == null && other.parCodRepPk != null) || (this.parCodRepPk != null && !this.parCodRepPk.equals(other.parCodRepPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Parametrias[ parCodRepPk=" + parCodRepPk + " ]";
    }
    
}
