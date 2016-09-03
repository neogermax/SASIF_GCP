/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import jpa.valores.AccesoRepUsu;
import jpa.valores.AccesoRepUsuPK;

import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAccesoRepUsu;

import jsf.beans.generales.BGenErrores;

/**
 *
 * @author analista02
 */
@ManagedBean(name = "bgesAccesoRepUsu")
@SessionScoped
public class BGesAccesoRepUsu implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdAccesoRepUsu ptdAccesoRepUsu = new PtdAccesoRepUsu();
    
    private AccesoRepUsu accesoRepUs;
    private AccesoRepUsu cAccesoRepUs = new AccesoRepUsu(new AccesoRepUsuPK());
    private List<AccesoRepUsu> accesoRepUsu;
    
    private String areUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesAccesoRepUsu() {
        areUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        accesoRepUsu = ptdAccesoRepUsu.encontrarTodos();
        if(!accesoRepUsu.isEmpty()) {
            accesoRepUs = accesoRepUsu.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
    }
    
    public AccesoRepUsu getAccesoRepUs() {
        return accesoRepUs;
    }
    
    public void setAccesoRepUs(AccesoRepUsu accesoRepUs) {
        this.accesoRepUs = accesoRepUs;
    }
    
    public AccesoRepUsu getCAccesoRepUs() {
        return cAccesoRepUs;
    }
    
    public void setCAccesoRepUs(AccesoRepUsu cAccesoRepUs) {
        this.cAccesoRepUs = cAccesoRepUs;
    }
    
    public List<AccesoRepUsu> getAccesoRepUsu() {
        accesoRepUsu = ptdAccesoRepUsu.encontrarTodos();
        selectAccesoRepUs();
        return accesoRepUsu;
    }
    
    private void selectAccesoRepUs() {
        if(accesoRepUs == null && !accesoRepUsu.isEmpty()) {
            accesoRepUs = accesoRepUsu.get(0);
        } else if (!accesoRepUsu.isEmpty()) {
            int index = accesoRepUsu.indexOf(accesoRepUs);
            if(index == -1) {
                accesoRepUs = accesoRepUsu.get(0);
            } else {
                accesoRepUs = accesoRepUsu.get(index);
            }
        }
    }
    
    
    public String getOpcion() {
        return opcion;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public List<String> getColumnas() {
        return columnas;
    }
    
    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }
    
    public UIInput getInputCodigo() {
        return inputCodigo;
    }
    
    public void setInputCodigo(UIInput inputCodigo) {
        this.inputCodigo = inputCodigo;
    }
    
    public String crear() {
        try {
            
            ptdAccesoRepUsu.insertar(cAccesoRepUs);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             accesoRepUs = cAccesoRepUs;
             cAccesoRepUs = new AccesoRepUsu(new AccesoRepUsuPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdAccesoRepUsu.actualizar(accesoRepUs);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdAccesoRepUsu.eliminar(accesoRepUs.getAccesoRepUsuPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
