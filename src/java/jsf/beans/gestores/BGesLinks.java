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
import jpa.valores.Links;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdLinks;


@ManagedBean(name = "bgesLinks")
@SessionScoped
public class BGesLinks implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdLinks ptdLinks = new PtdLinks();
    private Links link;
    private Links cLink = new Links();
    private List<Links> links;
    private String linkUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesLinks() {
        linkUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        links = ptdLinks.encontrarTodos();
        if(!links.isEmpty()) {
            link = links.get(0);
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
    }
    
    public Links getLink() {
        return link;
    }
    
    public void setLink(Links link) {
        this.link = link;
    }
    
    public Links getCLink() {
        return cLink;
    }
    
    public void setCLink(Links cLink) {
        this.cLink = cLink;
    }
    
    public List<Links> getLinks() {
        links = ptdLinks.encontrarTodos();
        selectLink();
        return links;
    }
    
    private void selectLink() {
        if(link == null && !links.isEmpty()) {
            link = links.get(0);
        } else if (!links.isEmpty()) {
            int index = links.indexOf(link);
            if(index == -1) {
                link = links.get(0);
            } else {
                link = links.get(index);
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
            ptdLinks.insertar(cLink);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             link = cLink;
             cLink = new Links();
        } catch(Exception l) {
            UtileriaHTTP.addMessage(inputCodigo.getClientId(), 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdLinks.actualizar(link);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
      return null;
    }

    public String eliminar() {
        
    try {
            ptdLinks.eliminar(link.getLinkCodPk());
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
