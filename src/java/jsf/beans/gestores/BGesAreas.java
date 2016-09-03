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
import jpa.valores.Areas;
import jpa.valores.AreasPK;
import jpa.valores.Empresas;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAreas;
import jsf.controlador.PtdEmpresas;
import jsf.beans.generales.BGenErrores;

/**
 *
 * @author analista02
 */
@ManagedBean(name = "bgesAreas")
@SessionScoped
public class BGesAreas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdAreas ptdAreas = new PtdAreas();
    private PtdEmpresas ptdEmpresas = new PtdEmpresas();
    private Areas area;
    private Areas cArea = new Areas(new AreasPK());
    private List<Areas> areas;
    private List<Empresas> empresas;
    private String areUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesAreas() {
        areUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        areas = ptdAreas.encontrarTodos();
        if(!areas.isEmpty()) {
            area = areas.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
    }
    
    public Areas getArea() {
        return area;
    }
    
    public void setArea(Areas area) {
        this.area = area;
    }
    
    public Areas getCArea() {
        return cArea;
    }
    
    public void setCArea(Areas cArea) {
        this.cArea = cArea;
    }
    
    public List<Areas> getAreas() {
        areas = ptdAreas.encontrarTodos();
        selectArea();
        return areas;
    }
    
    private void selectArea() {
        if(area == null && !areas.isEmpty()) {
            area = areas.get(0);
        } else if (!areas.isEmpty()) {
            int index = areas.indexOf(area);
            if(index == -1) {
                area = areas.get(0);
            } else {
                area = areas.get(index);
            }
        }
    }
    
    public List<Empresas> getEmpresas() {
        empresas = ptdEmpresas.encontrarTodos();
        return empresas;
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
            cArea.getAreasPK().setAreCodEmpFk(cArea.getEmpresas().getEmprCodigoPk());
            ptdAreas.insertar(cArea);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             area = cArea;
             cArea = new Areas(new AreasPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdAreas.actualizar(area);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        area.setEmpresas(seleccionarEmpresas(area.getEmpresas()));
        return null;
    }

    public String eliminar() {
        try {
        ptdAreas.eliminar(area.getAreasPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private Empresas seleccionarEmpresas(Empresas emp) {
        int index = empresas.indexOf(emp);
        return empresas.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
