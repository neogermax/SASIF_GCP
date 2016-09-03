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
import jpa.valores.Clases;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdClases;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesClases")
@SessionScoped
public class BGesClases implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdClases ptdClases = new PtdClases();
    private Clases clase;
    private Clases cClase = new Clases();
    private List<Clases> clases;
    private String clsUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesClases() {
        clsUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        clases = ptdClases.encontrarTodos();
        if(!clases.isEmpty()) {
            clase = clases.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
    }
    
    public Clases getClase() {
        return clase;
    }
    
    public void setClase(Clases clase) {
        this.clase = clase;
    }
    
    public Clases getCClase() {
        return cClase;
    }
    
    public void setCClase(Clases cClase) {
        this.cClase = cClase;
    }
    
    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        selectClase();
        return clases;
    }
    
    private void selectClase() {
        if(clase == null && !clases.isEmpty()) {
            clase = clases.get(0);
        } else if (!clases.isEmpty()) {
            int index = clases.indexOf(clase);
            if(index == -1) {
                clase = clases.get(0);
            } else {
                clase = clases.get(index);
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
            cClase.setClsModif(new Date());
            cClase.setClsUsuCod(clsUsuCod);
            ptdClases.insertar(cClase);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             clase = cClase;
             cClase = new Clases();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        clase.setClsModif(new Date());
        clase.setClsUsuCod(clsUsuCod);
        ptdClases.actualizar(clase);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdClases.eliminar(clase.getClsCodPk());
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
