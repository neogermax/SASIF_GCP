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
import jpa.valores.Paises;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdPaises;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesPaises")
@SessionScoped
public class BGesPaises implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdPaises ptdPaises = new PtdPaises();
    private Paises pais;
    private Paises cPais = new Paises();
    private List<Paises> paises;
    private String paiUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesPaises() {
        
        paiUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        paises = ptdPaises.encontrarTodos();
        if(!paises.isEmpty()) {
         pais = paises.get(0);
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
        
    }
    
    public Paises getPais() {
        return pais;
    }
    
    public void setPais(Paises pais) {
        this.pais = pais;
    }
    
    public Paises getCPais() {
        return cPais;
    }
    
    public void setCPais(Paises cPais) {
        this.cPais = cPais;
    }
    
    public List<Paises> getPaises() {
        paises = ptdPaises.encontrarTodos();
        selectPais();
        return paises;
    }
    
    private void selectPais() {
        if(pais == null && !paises.isEmpty()) 
        {
            pais = paises.get(0);
        } 
            else 
                if(!paises.isEmpty()) 
                {
                    int index = paises.indexOf(pais);
                    if(index == -1)
                        {
                        pais = paises.get(0);
                        } 
                    else 
                       {
                        pais = paises.get(index);
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
             ptdPaises.insertar(cPais);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             pais = cPais;
             cPais = new Paises ();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
   
    }

    public String actualizar() {
         ptdPaises.actualizar(pais);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
        
    }
    public String eliminar() {
        try {
        ptdPaises.eliminar(pais.getPaiCodPk());
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
