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
import jpa.valores.TipoComps;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdTipoComps;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesTipoComps")
@SessionScoped
public class BGesTipoComps implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdTipoComps ptdTipoComps = new PtdTipoComps();
    private TipoComps tipoComp;
    private TipoComps cTipoComp = new TipoComps();
    private List<TipoComps> tipoComps;
    private String tipoCompUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas = new ArrayList<String>();
    
    public BGesTipoComps() {
        
        columnas.add("1");
        columnas.add("2");
    }
    
    public TipoComps getTipoComp() {
        return tipoComp;
    }
    
    public void setTipoComp(TipoComps tipoComp) {
        this.tipoComp = tipoComp;
    }
    
    public TipoComps getCTipoComp() {
        return cTipoComp;
    }
    
    public void setCTipoComps(TipoComps cTipoComp) {
        this.cTipoComp = cTipoComp;
    }
    
    public List<TipoComps> getTipoComps() {
        tipoComps = ptdTipoComps.encontrarTodos();
        selectTipoComp();
        return tipoComps;
    }
    
    private void selectTipoComp() {
        if(tipoComp == null && !tipoComps.isEmpty()) {
            tipoComp = tipoComps.get(0);
        } else if (!tipoComps.isEmpty()) {
            int index = tipoComps.indexOf(tipoComp);
            if(index == -1) {
                tipoComp = tipoComps.get(0);
            } else {
                tipoComp = tipoComps.get(index);
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
            ptdTipoComps.insertar(cTipoComp);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             tipoComp = cTipoComp;
             cTipoComp = new TipoComps();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }
    
    public String actualizar() {
        ptdTipoComps.actualizar(tipoComp);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    public String eliminar() {
        try {
        ptdTipoComps.eliminar(tipoComp.getTipCodPk());
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
