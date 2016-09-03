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
import javax.faces.component.UIInput;
import jpa.valores.Caracteristicas;
import jpa.valores.CaracteristicasPK;
import jpa.valores.Parametrias;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdCaracteristicas;
import jsf.controlador.PtdParametrias;
import jsf.beans.generales.BGenErrores;

@ManagedBean(name = "bgesCaracteristicas")
@SessionScoped
public class BGesCaracteristicas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdCaracteristicas ptdCaracteristicas = new PtdCaracteristicas();
    private PtdParametrias ptdParametrias = new PtdParametrias();
    
    private Caracteristicas caracteristica;
    private Caracteristicas cCaracteristica = new Caracteristicas(new CaracteristicasPK());
    private List<Caracteristicas> caracteristicas;
    private List<Parametrias> parametrias;
    
    private String carUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesCaracteristicas() {
        carUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        caracteristicas = ptdCaracteristicas.encontrarOpcion();
        if(!caracteristicas.isEmpty()) {
            caracteristica = caracteristicas.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
    }
    
    public Caracteristicas getOpcionRol() {
        return caracteristica;
    }
    
    public void setOpcionRol(Caracteristicas caracteristica) {
        this.caracteristica = caracteristica;
    }
    
    public Caracteristicas getCOpcionRol() {
        return cCaracteristica;
    }
    
    public void setCOpcionRol(Caracteristicas cCaracteristica) {
        this.cCaracteristica = cCaracteristica;
    }
    
    public List<Caracteristicas> getCaracteristicas() {
        caracteristicas = ptdCaracteristicas.encontrarOpcion();
        selectOpcionRol();
        return caracteristicas;
    }
    
    private void selectOpcionRol() {
        if(caracteristica == null && !caracteristicas.isEmpty()) {
            caracteristica = caracteristicas.get(0);
        } else if (!caracteristicas.isEmpty()) {
            int index = caracteristicas.indexOf(caracteristica);
            if(index == -1) {
                caracteristica = caracteristicas.get(0);
            } else {
                caracteristica = caracteristicas.get(index);
            }
        }
    }
    
    public List<Parametrias> getParametrias() {
        parametrias = ptdParametrias.encontrarTodos();
        return parametrias;
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
            ptdCaracteristicas.insertar(cCaracteristica);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             caracteristica = cCaracteristica;
             cCaracteristica = new Caracteristicas();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdCaracteristicas.actualizar(caracteristica);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        caracteristica.setParametrias(seleccionarParametrias(caracteristica.getParametrias()));
        return null;
    }

    public String eliminar() {
        try {
        ptdCaracteristicas.eliminar(caracteristica.getCaracteristicasPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
     } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private Parametrias seleccionarParametrias(Parametrias p) {
        int index = parametrias.indexOf(p);
        return parametrias.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
