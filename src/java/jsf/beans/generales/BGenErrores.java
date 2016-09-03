/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIInput;
import jpa.valores.Errores;
import jsf.controlador.PtdErrores;

@ManagedBean(name = "bgenErrores")
@ApplicationScoped
public class BGenErrores implements Serializable {
    private PtdErrores ptdErrores = new PtdErrores();
    private Errores error;
    private Errores cError = new Errores();
    private List<Errores> errores = ptdErrores.encontrarTodos();
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas = new ArrayList<String>();
    
    public BGenErrores() {
        if(!errores.isEmpty()) {
            error = errores.get(0);
        }
        columnas.add("1");
        columnas.add("2");
    }
    
    public String obtenerError(Integer errCodPk) {
        Errores e = new Errores(errCodPk);
        int index = errores.indexOf(e);
        if(index == -1)
            return null;
        e = errores.get(index);
        return e.getErrDescrip();
    }
    
    public Errores getError() {
        return error;
    }
    
    public void setError(Errores error) {
        this.error = error;
    }
    
    public Errores getCError() {
        return cError;
    }
    
    public void setCError(Errores cError) {
        this.cError = cError;
    }
    
    public List<Errores> getErrores() {
        errores = ptdErrores.encontrarTodos();
        selectError();
        return errores;
    }
    
    private void selectError() {
        if(error == null && !errores.isEmpty()) {
            error = errores.get(0);
        } else if (!errores.isEmpty()) {
            int index = errores.indexOf(error);
            if(index == -1) {
                error = errores.get(0);
            } else {
                error = errores.get(index);
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
            ptdErrores.insertar(cError);
             UtileriaHTTP.addMessage(null, obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             error = cError;
             cError = new Errores();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdErrores.actualizar(error);
        UtileriaHTTP.addMessage(null, obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdErrores.eliminar(error.getErrCodPk());
        UtileriaHTTP.addMessage(null, obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
    
}
