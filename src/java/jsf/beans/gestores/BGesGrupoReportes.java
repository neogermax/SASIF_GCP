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
import jpa.valores.GrupoReportes;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdGrupoReportes;
import jsf.beans.generales.BGenErrores;

/**
 *
 * @author analista03
 */
@ManagedBean(name = "bgesGrupoReportes")
@SessionScoped
public class BGesGrupoReportes implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdGrupoReportes ptdGrupoReportes = new PtdGrupoReportes();
    private GrupoReportes grupoReporte;
    private GrupoReportes cGrupoReporte = new GrupoReportes();
    private List<GrupoReportes> grupoReportes;
    private String grpUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesGrupoReportes() {
        grpUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        grupoReportes = ptdGrupoReportes.encontrarTodos();
        if(!grupoReportes.isEmpty()) {
            grupoReporte = grupoReportes.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
    }
    
    public GrupoReportes getGrupoReporte() {
        return grupoReporte;
    }
    
    public void setGrupoReporte(GrupoReportes grupoReporte) {
        this.grupoReporte = grupoReporte;
    }
    
    public GrupoReportes getCGrupoReporte() {
        return cGrupoReporte;
    }
    
    public void setCGrupoReporte(GrupoReportes cGrupoReporte) {
        this.cGrupoReporte = cGrupoReporte;
    }
    
    public List<GrupoReportes> getGrupoReportes() {
        grupoReportes = ptdGrupoReportes.encontrarTodos();
        selectGrupoReporte();
        return grupoReportes;
    }
    
    private void selectGrupoReporte() {
        if(grupoReporte == null && !grupoReportes.isEmpty()) {
            grupoReporte = grupoReportes.get(0);
        } else if (!grupoReportes.isEmpty()) {
            int index = grupoReportes.indexOf(grupoReporte);
            if(index == -1) {
                grupoReporte = grupoReportes.get(0);
            } else {
                grupoReporte = grupoReportes.get(index);
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
            ptdGrupoReportes.insertar(cGrupoReporte);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             grupoReporte = cGrupoReporte;
             cGrupoReporte = new GrupoReportes();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdGrupoReportes.actualizar(grupoReporte);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdGrupoReportes.eliminar(grupoReporte.getGrpCodPk());
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