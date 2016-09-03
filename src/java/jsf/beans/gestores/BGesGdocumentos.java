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
import jpa.valores.Gdocumentos;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdGdocumentos;

@ManagedBean(name = "bgesGdocumentos")
@SessionScoped
public class BGesGdocumentos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdGdocumentos ptdGdocumentos = new PtdGdocumentos();
    private Gdocumentos gdocumento;
    private Gdocumentos cGdocumento = new Gdocumentos();
    private List<Gdocumentos> gdocumentos;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesGdocumentos() {
        
        gdocumentos = ptdGdocumentos.encontrarTodos();
        if(!gdocumentos.isEmpty()) {
            gdocumento = gdocumentos.get(0);
        }
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
    }
    
    public Gdocumentos getGdocumento() {
        return gdocumento;
    }
    
    public void setGdocumento(Gdocumentos gdocumento) {
        this.gdocumento = gdocumento;
    }
    
    public Gdocumentos getCGdocumento() {
        return cGdocumento;
    }
    
    public void setCGdocumento(Gdocumentos cGdocumento) {
        this.cGdocumento = cGdocumento;
    }
    
    private void selectGdocumento() {
        if(gdocumento == null && !gdocumentos.isEmpty()) {
            gdocumento = gdocumentos.get(0);
        } else if(!gdocumentos.isEmpty()) {
            int index = gdocumentos.indexOf(gdocumento);
            if(index == -1) {
                gdocumento = gdocumentos.get(0);
            } else {
                gdocumento = gdocumentos.get(index);
            }
        }
    }
    
    public List<Gdocumentos> getGdocumentos() {
        gdocumentos = ptdGdocumentos.encontrarTodos();
        selectGdocumento();
        return gdocumentos;
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
            ptdGdocumentos.insertar(cGdocumento);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             gdocumento = cGdocumento;
             cGdocumento = new Gdocumentos();
        } catch(Exception e) {
            e.printStackTrace();
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdGdocumentos.actualizar(gdocumento);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdGdocumentos.eliminar(gdocumento.getGdoGrupoPk());
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
