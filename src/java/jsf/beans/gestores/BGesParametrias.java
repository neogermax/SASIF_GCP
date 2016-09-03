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
import jpa.valores.Parametrias;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdParametrias;


@ManagedBean(name = "bgesParametrias")
@SessionScoped
public class BGesParametrias implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdParametrias ptdParametrias = new PtdParametrias();
    private Parametrias parametria;
    private Parametrias cParametria = new Parametrias();
    private List<Parametrias> parametrias;
    private String parUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesParametrias() {
        parUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        parametrias = ptdParametrias.encontrarTodos();
        if(!parametrias.isEmpty()) 
            {
            parametria = parametrias.get(0);
             }
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
        columnas.add("7");
        columnas.add("8");
        
    }
    
    public Parametrias getParametria() {
        return parametria;
    }
    
    public void setParametria(Parametrias parametria) {
        this.parametria = parametria;
    }
    
    public Parametrias getCParametria() {
        return cParametria;
    }
    
    public void setCParametria(Parametrias cParametria) {
        this.cParametria = cParametria;
    }
    
    public List<Parametrias> getParametrias() {
        parametrias = ptdParametrias.encontrarTodos();
        selectParametria();
        return parametrias;
    }
    
    private void selectParametria() {
        if(parametria == null && !parametrias.isEmpty()) 
            {
            parametria = parametrias.get(0);
            } 
        else if(!parametrias.isEmpty())
           {
            int index = parametrias.indexOf(parametria);
            if(index == -1) 
                {
                parametria = parametrias.get(0);
                } 
            else 
                {
                parametria = parametrias.get(index);
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
            
            ptdParametrias.insertar(cParametria);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             parametria = cParametria;
             cParametria = new Parametrias();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        
        ptdParametrias.actualizar(parametria);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdParametrias.eliminar(parametria.getParCodRepPk());
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
