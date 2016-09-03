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

@ManagedBean(name = "bgesProyResp")
@SessionScoped
public class BGesProyResp implements Serializable {
    private BGesNavegacion bgesNavegacion = ((BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion"));
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private List<ProyActs> proyActs;
    private ProyActs proyAct;
    private String resUsuCodFk = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    
    public void init() {
        List<ProyActs> pActs = ptdProyActs.encontrarActDisp();
        proyActs = new ArrayList<ProyActs>();
        PermisosAct permiso = new PermisosAct();
        for(ProyActs p : pActs) {
            if(permiso.permiso(p, resUsuCodFk)) {
                proyActs.add(p);
            }
        }
        if(!proyActs.isEmpty()) {
            selectProyAct();
        }
    }
    
    private void selectProyAct() {
        if(proyAct == null) {
            setProyAct(proyActs.get(0));
        } else {
            int index = proyActs.indexOf(proyAct);
            if(index == -1) {
                setProyAct(proyActs.get(0));
            } else {
                setProyAct(proyActs.get(index));
            }
        }
    }
    
    public List<ProyActs> getProyActs() {
        return proyActs;
    }
    
    public ProyActs getProyAct() {
        return proyAct;
    }
    
    public void setProyAct(ProyActs proyAct) {
        this.proyAct = proyAct;
    }
    
    public String action() {
        if(proyAct == null) {
            UtileriaHTTP.addMessage(null, "No hay proyectos disponibles para trabajar", FacesMessage.SEVERITY_ERROR); 
        } else {
            bgesNavegacion.trabajarProyecto(proyAct);
        }
        return null;
    }
}
