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
import jpa.valores.Etapas;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdEtapas;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesEtapas")
@SessionScoped
public class BGesEtapas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdEtapas ptdEtapas = new PtdEtapas();
    private Etapas etapa;
    private Etapas cEtapa = new Etapas();
    private List<Etapas> etapas;
    private String etpUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesEtapas() {
        etpUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        etapas = ptdEtapas.encontrarTodos();
        if(!etapas.isEmpty()) {
            etapa = etapas.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
    }
    
    public Etapas getEtapa() {
        return etapa;
    }
    
    public void setEtapa(Etapas etapa) {
        this.etapa = etapa;
    }
    
    public Etapas getCEtapa() {
        return cEtapa;
    }
    
    public void setCEtapa(Etapas cEtapa) {
        this.cEtapa = cEtapa;
    }
    
    public List<Etapas> getEtapas() {
        etapas = ptdEtapas.encontrarTodos();
        selectEtapa();
        return etapas;
    }
    
    private void selectEtapa() {
        if(etapa == null && !etapas.isEmpty()) {
            etapa = etapas.get(0);
        } else if (!etapas.isEmpty()) {
            int index = etapas.indexOf(etapa);
            if(index == -1) {
                etapa = etapas.get(0);
            } else {
                etapa = etapas.get(index);
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
            cEtapa.setEtpModif(new Date());
            cEtapa.setEtpUsuCod(etpUsuCod);
            ptdEtapas.insertar(cEtapa);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             etapa = cEtapa;
             cEtapa = new Etapas();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        etapa.setEtpModif(new Date());
        etapa.setEtpUsuCod(etpUsuCod);
        ptdEtapas.actualizar(etapa);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdEtapas.eliminar(etapa.getEtpCodPk());
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
