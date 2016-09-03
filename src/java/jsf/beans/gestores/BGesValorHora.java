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
import jpa.valores.ValorHora;
import jpa.valores.ValorHoraPK;
import jpa.valores.Actividades;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdValorHora;
import jsf.controlador.PtdActividades;
import jsf.beans.generales.BGenErrores;

/**
 *
 * @author analista02
 */
@ManagedBean(name = "bgesValorHora")
@SessionScoped
public class BGesValorHora implements Serializable  {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdValorHora ptdValorHora = new PtdValorHora();
    private PtdActividades ptdActividades = new PtdActividades();
    private ValorHora valorHor;
    private ValorHora cValorHor = new ValorHora(new ValorHoraPK());
    private List<ValorHora> valorHora;
    private List<Actividades> actividades;
    private String areUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesValorHora() {
        areUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        valorHora = ptdValorHora.encontrarTodos();
        if(!valorHora.isEmpty()) {
            valorHor = valorHora.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
    }
    
    public ValorHora getValorHor() {
        return valorHor;
    }
    
    public void setValorHor(ValorHora valorHor) {
        this.valorHor = valorHor;
    }
    
    public ValorHora getCValorHor() {
        return cValorHor;
    }
    
    public void setCValorHor(ValorHora cValorHor) {
        this.cValorHor = cValorHor;
    }
    
    public List<ValorHora> getValorHora() {
        valorHora = ptdValorHora.encontrarTodos();
        selectValorHor();
        return valorHora;
    }
    
    private void selectValorHor() {
        if(valorHor == null && !valorHora.isEmpty()) {
            valorHor = valorHora.get(0);
        } else if (!valorHora.isEmpty()) {
            int index = valorHora.indexOf(valorHor);
            if(index == -1) {
                valorHor = valorHora.get(0);
            } else {
                valorHor = valorHora.get(index);
            }
        }
    }
    
    public List<Actividades> getActividades() {
        actividades = ptdActividades.encontrarTodos();
        return actividades;
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
            
            
            ptdValorHora.insertar(cValorHor);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             valorHor = cValorHor;
             cValorHor = new ValorHora(new ValorHoraPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdValorHora.actualizar(valorHor);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdValorHora.eliminar(valorHor.getValorHoraPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private Actividades seleccionarActividades(Actividades act) {
        int index = actividades.indexOf(act);
        return actividades.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
