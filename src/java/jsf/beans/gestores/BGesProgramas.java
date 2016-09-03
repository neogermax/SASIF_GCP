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
import jpa.valores.Programas;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdProgramas;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesProgramas")
@SessionScoped
public class BGesProgramas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdProgramas ptdProgramas = new PtdProgramas();
    private Programas programa;
    private Programas cPrograma = new Programas();
    private List<Programas> programas;
    private String progUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesProgramas() {
        progUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        programas = ptdProgramas.encontrarTodos();
        if(!programas.isEmpty()) {
            programa = programas.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        
    }
    
    public Programas getPrograma() {
        return programa;
    }
    
    public void setPrograma(Programas programa) {
        this.programa = programa;
    }
    
    public Programas getCPrograma() {
        return cPrograma;
    }
    
    public void setCPrograma(Programas cPrograma) {
        this.cPrograma = cPrograma;
    }
    
    public List<Programas> getProgramas() {
        programas = ptdProgramas.encontrarTodos();
        selectPrograma();
        return programas;
    }
    
    private void selectPrograma() {
        if(programa == null && !programas.isEmpty()) {
            programa = programas.get(0);
        } else if(!programas.isEmpty()) {
            int index = programas.indexOf(programa);
            if(index == -1) {
                programa = programas.get(0);
            } else {
                programa = programas.get(index);
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
            cPrograma.setProgModif(new Date());
            cPrograma.setProgUsuCod(progUsuCod);
            ptdProgramas.insertar(cPrograma);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             programa = cPrograma;
             cPrograma = new Programas();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        programa.setProgModif(new Date());
        programa.setProgUsuCod(progUsuCod);
        ptdProgramas.actualizar(programa);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdProgramas.eliminar(programa.getProgNomPk());
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
