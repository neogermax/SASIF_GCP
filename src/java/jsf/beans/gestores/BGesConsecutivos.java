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
import jpa.valores.Consecutivos;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdConsecutivos;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesConsecutivos")
@SessionScoped
public class BGesConsecutivos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdConsecutivos ptdConsecutivos = new PtdConsecutivos();
    private Consecutivos consecutivo;
    private Consecutivos cConsecutivo = new Consecutivos();
    private List<Consecutivos> consecutivos;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesConsecutivos() {
        consecutivos = ptdConsecutivos.encontrarTodos();
        if(!consecutivos.isEmpty()) {
            consecutivo = consecutivos.get(0);
        }
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
    }
    
    public Consecutivos getConsecutivo() {
        return consecutivo;
    }
    
    public void setConsecutivo(Consecutivos consecutivo) {
        this.consecutivo = consecutivo;
    }
    
    public Consecutivos getCConsecutivo() {
        return cConsecutivo;
    }
    
    public void setCConsecutivo(Consecutivos cConsecutivo) {
        this.cConsecutivo = cConsecutivo;
    }
    
    public List<Consecutivos> getConsecutivos() {
        consecutivos = ptdConsecutivos.encontrarTodos();
        selectConsecutivo();
        return consecutivos;
    }
    
    private void selectConsecutivo() {
        if(consecutivo == null && !consecutivos.isEmpty()) {
            consecutivo = consecutivos.get(0);
        } else if(!consecutivos.isEmpty()) {
            int index = consecutivos.indexOf(consecutivo);
            if(index == -1) {
                consecutivo = consecutivos.get(0);
            } else {
                consecutivo = consecutivos.get(index);
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
            ptdConsecutivos.insertar(cConsecutivo);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             consecutivo = cConsecutivo;
             cConsecutivo = new Consecutivos();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null,
            bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdConsecutivos.actualizar(consecutivo);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdConsecutivos.eliminar(consecutivo.getConsecCodPk());
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
