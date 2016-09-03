/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.valores;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "LINKS")
@NamedQueries({
     @NamedQuery(name = "Links.findAll", query = "SELECT l FROM Links l ORDER BY l.linkCodPk")})
public class Links implements Serializable {
    @Column(name = "LINK_PARAMETRO1")
    private Long linkParametro1;
    @Column(name = "LINK_PARAMETRO2")
    private Long linkParametro2;
    @Column(name = "LINK_PARAMETRO3")
    private Long linkParametro3;
    @OneToMany(mappedBy = "opcNombre")
    private List<OpcionRoles> opcionRolesList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LINK_COD_PK")
    private String linkCodPk;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LINK_DESCRIP")
    private String linkDescrip;
    @Size(min = 1, max = 20)
    @Column(name = "LINK_PARAMETRO4")
    private String linkParametro4;
    @Size(min = 1, max = 20)
    @Column(name = "LINK_PARAMETRO5")
    private String linkParametro5;
    @Size(min = 1, max = 20)
    @Column(name = "LINK_PARAMETRO6")
    private String linkParametro6;
    @Size(max = 200)
    @Column(name = "LINK_IMG")
    private String linkImg;
    @Size(min = 1, max = 50)
    @Column(name = "LINK_PAGINA")
    private String linkPagina;

    public Links() {
    }

    public Links(String linkCodPk) {
        this.linkCodPk = linkCodPk;
    }

    public Links(String linkCodPk, String linkDescrip, Long linkParametro1, Long linkParametro2, Long linkParametro3, String linkParametro4, String linkParametro5, 
            String linkParametro6, String linkImg, String linkPagina) 
    {
        this.linkCodPk = linkCodPk;
        this.linkDescrip = linkDescrip;
        this.linkParametro1 = linkParametro1;
        this.linkParametro2 = linkParametro2;
        this.linkParametro3 = linkParametro3;
        this.linkParametro4 = linkParametro4;
        this.linkParametro5 = linkParametro5;
        this.linkParametro6 = linkParametro6;
        this.linkImg = linkImg;
        this.linkPagina = linkPagina;
    }

    public String getLinkCodPk() {
        return linkCodPk;
    }

    public void setLinkCodPk(String linkCodPk) {
        this.linkCodPk = linkCodPk;
    }

    public String getLinkDescrip() {
        return linkDescrip;
    }

    public void setLinkDescrip(String linkDescrip) {
        this.linkDescrip = linkDescrip;
    }

    public Long getLinkParametro1() {
        return linkParametro1;
    }

    public void setLinkParametro1(Long linkParametro1) {
        this.linkParametro1 = linkParametro1;
    }

    public Long getLinkParametro2() {
        return linkParametro2;
    }

    public void setLinkParametro2(Long linkParametro2) {
        this.linkParametro2 = linkParametro2;
    }

    public Long getLinkParametro3() {
        return linkParametro3;
    }

    public void setLinkParametro3(Long linkParametro3) {
        this.linkParametro3 = linkParametro3;
    }

    public String getLinkParametro4() {
        return linkParametro4;
    }

    public void setLinkParametro4(String linkParametro4) {
        this.linkParametro4 = linkParametro4;
    }

    public String getLinkParametro5() {
        return linkParametro5;
    }

    public void setLinkParametro5(String linkParametro5) {
        this.linkParametro5 = linkParametro5;
    }

    public String getLinkParametro6() {
        return linkParametro6;
    }

    public void setLinkParametro6(String linkParametro6) {
        this.linkParametro6 = linkParametro6;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }
    
    public String getLinkPagina() {
        return linkPagina;
    }

    public void setLinkPagina(String linkPagina) {
        this.linkPagina = linkPagina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (linkCodPk != null ? linkCodPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Links)) {
            return false;
        }
        Links other = (Links) object;
        if ((this.linkCodPk == null && other.linkCodPk != null) || (this.linkCodPk != null && !this.linkCodPk.equals(other.linkCodPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.valores.Links[ linkCodPk=" + linkCodPk + " ]";
    }

    public List<OpcionRoles> getOpcionRolesList() {
        return opcionRolesList;
    }

    public void setOpcionRolesList(List<OpcionRoles> opcionRolesList) {
        this.opcionRolesList = opcionRolesList;
    }
    
}
