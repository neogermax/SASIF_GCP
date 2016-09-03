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
import jpa.valores.Ayudas;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAyudas;

@ManagedBean(name = "bgenAyudas")
@ApplicationScoped
public class BGenAyudas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdAyudas ptdAyudas = new PtdAyudas();
    private Ayudas ayuda;
    private Ayudas cAyuda = new Ayudas();
    private List<Ayudas> ayudas = ptdAyudas.encontrarTodos();
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas = new ArrayList<String>();
    
    public BGenAyudas() {
        if(!ayudas.isEmpty()) {
            ayuda = ayudas.get(0);
        }
        columnas.add("1");
        columnas.add("2");
    }
    
    public String obtenerAyuda(Integer aydCodPk) {
        Ayudas a = new Ayudas(aydCodPk);
        int index = ayudas.indexOf(a);
        if(index == -1)
            return null;
        a = ayudas.get(index);
        return a.getAydDescrip();
    }
    
    public Ayudas getAyuda() {
        return ayuda;
    }
    
    public void setAyuda(Ayudas ayuda) {
        this.ayuda = ayuda;
    }
    
    public Ayudas getCAyuda() {
        return cAyuda;
    }
    
    public void setCAyuda(Ayudas cAyuda) {
        this.cAyuda = cAyuda;
    }
    
    public List<Ayudas> getAyudas() {
        ayudas = ptdAyudas.encontrarTodos();
        selectAyuda();
        return ayudas;
    }
    
    private void selectAyuda() {
        if(ayuda == null && !ayudas.isEmpty()) {
            ayuda = ayudas.get(0);
        } else if (!ayudas.isEmpty()) {
            int index = ayudas.indexOf(ayuda);
            if(index == -1) {
                ayuda = ayudas.get(0);
            } else {
                ayuda = ayudas.get(index);
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
            ptdAyudas.insertar(cAyuda);
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                         FacesMessage.SEVERITY_INFO);
             ayuda = cAyuda;
             cAyuda = new Ayudas();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdAyudas.actualizar(ayuda);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdAyudas.eliminar(ayuda.getAydCodPk());
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
