/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.ProyActs;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdProyActs;

@ManagedBean(name = "bgesProyConsulta")
@SessionScoped
public class BGesProyConsulta implements Serializable {
    private BGesNavegacion bgesNavegacion = ((BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion"));
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private boolean ident;
    private boolean descrip;
    private Integer proCodPk;
    private String proDescrip;
    private String usuario = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    
    public boolean isIdent() {
        return ident;
    }
    
    public void setIdent(boolean ident) {
        this.ident = ident;
    }
    
    public boolean isDescrip() {
        return descrip;
    }
    
    public void setDescrip(boolean descrip) {
        this.descrip = descrip;
    }
    
    public Integer getProCodPk() {
        return proCodPk;
    }
    
    public void setProCodPk(Integer proCodPk) {
        this.proCodPk = proCodPk;
    }
    
    public String getProDescrip() {
        return proDescrip;
    }
    
    public void setProDescrip(String proDescrip) {
        this.proDescrip = proDescrip;
    }
    
    private ProyActs getProyAct() {
        List<ProyActs> proyActs = new ArrayList<ProyActs>();
        PermisosAct permiso = new PermisosAct();
        for(ProyActs p : consultar()) {
            if(permiso.permiso(p, usuario)) {
                proyActs.add(p);
            }
        }
        if(proyActs.isEmpty()) {
            return null;
        } else {
            return proyActs.get(0);
        }
    }
    
    private List<ProyActs> consultar() {
        if(ident && descrip) {
            return ptdProyActs.encontrarPorProyCodDes(proCodPk, proDescrip);
        } else if(ident) {
            return ptdProyActs.encontrarPorProyCod(proCodPk);
        } else if(descrip) {
            return ptdProyActs.encontrarPorProyDescrip(proDescrip);
        }
        return null;
    }
    
    public String action() {
        ProyActs pr = getProyAct();
        if(pr != null) {
            bgesNavegacion.trabajarProyecto(pr);
            proCodPk = null;
            proDescrip = null;
        } else {
            UtileriaHTTP.addMessage(null, "No hay proyectos disponibles para trabajar", FacesMessage.SEVERITY_ERROR); 
        }
        return null;
    }
}
