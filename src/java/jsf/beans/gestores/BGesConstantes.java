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
import jpa.valores.Constantes;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdConstantes;


@ManagedBean(name = "bgesConstantes")
@SessionScoped
public class BGesConstantes implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdConstantes ptdConstantes = new PtdConstantes();
    private Constantes constante;
    private Constantes cConstante = new Constantes();
    private List<Constantes> constantes;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesConstantes() {
        constantes = ptdConstantes.encontrarTodos();
        if(!constantes.isEmpty()) {
            constante = constantes.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        
    }
    
    public Constantes getConstante() {
        return constante;
    }
    
    public void setConstante(Constantes constante) {
        this.constante = constante;
    }
    
    public Constantes getCConstante() {
        return cConstante;
    }
    
    public void setCConstante(Constantes cConstante) {
        this.cConstante = cConstante;
    }
    
    public List<Constantes> getConstantes() {
        constantes = ptdConstantes.encontrarTodos();
        selectConstante();
        return constantes;
    }
    
    private void selectConstante() {
        if(constante == null && !constantes.isEmpty()) {
            constante = constantes.get(0);
        } else if (!constantes.isEmpty()) {
            int index = constantes.indexOf(constante);
            if(index == -1) {
                constante = constantes.get(0);
            } else {
                constante = constantes.get(index);
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
            ptdConstantes.insertar(cConstante);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             constante = cConstante;
             cConstante = new Constantes();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdConstantes.actualizar(constante);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdConstantes.eliminar(constante.getConsCodPk());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_ERROR);
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
