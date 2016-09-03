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
import jpa.valores.CondicionComunicacion;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdCondicionComunicacion;
import jsf.beans.generales.BGenErrores;

@ManagedBean(name = "bgesCondicionComunicacion")
@SessionScoped
public class BGesCondicionComunicacion implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdCondicionComunicacion ptdCondicionComunicacion = new PtdCondicionComunicacion();
    private CondicionComunicacion condicionComunica;
    private CondicionComunicacion cCondicionComunica = new CondicionComunicacion();
    private List<CondicionComunicacion> condicionComunicacion;
    private String concomUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesCondicionComunicacion() {
        concomUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        condicionComunicacion = ptdCondicionComunicacion.encontrarTodos();
        if(!condicionComunicacion.isEmpty()) {
            condicionComunica = condicionComunicacion.get(0);
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
    
    public CondicionComunicacion getCondicionComunica() {
        return condicionComunica;
    }
    
    public void setCondicionComunica(CondicionComunicacion condicionComunica) {
        this.condicionComunica = condicionComunica;
    }
    
    public CondicionComunicacion getCCondicionComunica() {
        return cCondicionComunica;
    }
    
    public void setCCondicionComunica(CondicionComunicacion cCondicionComunica) {
        this.cCondicionComunica = cCondicionComunica;
    }
    
    public List<CondicionComunicacion> getCondicionComunicacion() {
        condicionComunicacion = ptdCondicionComunicacion.encontrarTodos();
        selectCondicionComunica();
        return condicionComunicacion;
    }
    
    private void selectCondicionComunica() {
        if(condicionComunica == null && !condicionComunicacion.isEmpty()) {
            condicionComunica = condicionComunicacion.get(0);
        } else if (!condicionComunicacion.isEmpty()) {
            int index = condicionComunicacion.indexOf(condicionComunica);
            if(index == -1) {
                condicionComunica = condicionComunicacion.get(0);
            } else {
                condicionComunica = condicionComunicacion.get(index);
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
            ptdCondicionComunicacion.insertar(cCondicionComunica);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             condicionComunica = cCondicionComunica;
             cCondicionComunica = new CondicionComunicacion();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdCondicionComunicacion.actualizar(condicionComunica);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdCondicionComunicacion.eliminar(condicionComunica.getConcomCodPk());
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
