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
import jpa.valores.DocExistentes;
import jpa.valores.DocExistentesPK;

import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdDocExistentes;

import jsf.beans.generales.BGenErrores;

/**
 *
 * @author analista02
 */
@ManagedBean(name = "bgesDocExistentes")
@SessionScoped
public class BGesDocExistentes implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdDocExistentes ptdDocExistentes = new PtdDocExistentes();
   
    private DocExistentes docExistente;
    private DocExistentes cDocExistente = new DocExistentes(new DocExistentesPK());
    private List<DocExistentes> docExistentes;
    
    private String areUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesDocExistentes() {
        areUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        docExistentes = ptdDocExistentes.encontrarTodos();
        if(!docExistentes.isEmpty()) {
            docExistente = docExistentes.get(0);
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
        columnas.add("9");
        columnas.add("10");
        columnas.add("11");
        columnas.add("12");
        columnas.add("13");
        columnas.add("14");
        columnas.add("15");
        columnas.add("16");
        columnas.add("17");
        
    }
    
    public DocExistentes getDocExistente() {
        return docExistente;
    }
    
    public void setDocExistente(DocExistentes docExistente) {
        this.docExistente = docExistente;
    }
    
    public DocExistentes getCDocExistente() {
        return cDocExistente;
    }
    
    public void setCDocExistente(DocExistentes cDocExistente) {
        this.cDocExistente = cDocExistente;
    }
    
    public List<DocExistentes> getDocExistentes() {
        docExistentes = ptdDocExistentes.encontrarTodos();
        selectDocExistente();
        return docExistentes;
    }
    
    private void selectDocExistente() {
        if(docExistente == null && !docExistentes.isEmpty()) {
            docExistente = docExistentes.get(0);
        } else if (!docExistentes.isEmpty()) {
            int index = docExistentes.indexOf(docExistente);
            if(index == -1) {
                docExistente = docExistentes.get(0);
            } else {
                docExistente = docExistentes.get(index);
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
            
            ptdDocExistentes.insertar(cDocExistente);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             docExistente = cDocExistente;
             cDocExistente = new DocExistentes(new DocExistentesPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdDocExistentes.actualizar(docExistente);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdDocExistentes.eliminar(docExistente.getDocExistentesPK());
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
