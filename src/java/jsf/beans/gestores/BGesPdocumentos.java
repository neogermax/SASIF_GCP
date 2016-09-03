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
import jpa.valores.Pdocumentos;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdPdocumentos;

@ManagedBean(name = "bgesPdocumentos")
@SessionScoped
public class BGesPdocumentos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdPdocumentos ptdPdocumentos = new PtdPdocumentos();
    private Pdocumentos cPdocumento;
    private Pdocumentos pdocumento;
    private Pdocumentos aPdocumento;
    private List<Pdocumentos> pdocumentos;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesPdocumentos() {
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
        
        init();
    }
    
    private void init() {
        cPdocumento = new Pdocumentos();
        cPdocumento.setPdoTipoc("D");
        cPdocumento.setPdoTipod("pdf");
        cPdocumento.setPdoVersion("U");
    }
    
    public Pdocumentos getCPdocumento() {
        return cPdocumento;
    }
    
    public void setCPdocumento(Pdocumentos cPdocumento) {
        this.cPdocumento = cPdocumento;
    }
    
    public Pdocumentos getPdocumento() {
        return pdocumento;
    }
    
    public void setPdocumento(Pdocumentos pdocumento) {
        this.pdocumento = pdocumento;
    }
    
    public Pdocumentos getAPdocumento() {
        return aPdocumento;
    }
    
    public void setAPdocumento(Pdocumentos aPdocumento) {
        this.aPdocumento = aPdocumento;
    }
    
    private void selectPdocumento() {
        if(pdocumento == null && !pdocumentos.isEmpty()) {
            pdocumento = pdocumentos.get(0);
        } else if(!pdocumentos.isEmpty()) {
            int index = pdocumentos.indexOf(pdocumento);
            if(index == -1) {
                pdocumento = pdocumentos.get(0);
            } else {
                pdocumento = pdocumentos.get(index);
            }
        }
    }
    
    public List<Pdocumentos> getPdocumentos() {
        pdocumentos = ptdPdocumentos.encontrarTodos();
        selectPdocumento();
        return pdocumentos;
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
            ptdPdocumentos.insertar(cPdocumento);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             pdocumento = cPdocumento;
             init();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdPdocumentos.actualizar(aPdocumento);
        pdocumento = aPdocumento;
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        ptdPdocumentos.eliminar(pdocumento.getPdoDocumentoPk());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
    
    public void mostrar() {
        aPdocumento = pdocumento;
    }
}
