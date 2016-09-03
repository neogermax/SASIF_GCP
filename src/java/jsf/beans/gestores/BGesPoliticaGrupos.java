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
import jpa.valores.PoliticaGrupos;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdPoliticaGrupos;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesPoliticaGrupos")
@SessionScoped
public class BGesPoliticaGrupos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdPoliticaGrupos ptdPoliticaGrupos = new PtdPoliticaGrupos();
    private PoliticaGrupos politicagrupo;
    private PoliticaGrupos cPoliticaGrupo = new PoliticaGrupos();
    private List<PoliticaGrupos> politicagrupos;
    private String politicagrupoUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesPoliticaGrupos() {
        politicagrupoUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        politicagrupos = ptdPoliticaGrupos.encontrarPoliticaGrupos();
        if(!politicagrupos.isEmpty()) {
            politicagrupo = politicagrupos.get(0);
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
        
    }
    
    public PoliticaGrupos getPoliticaGrupo() {
        return politicagrupo;
    }
    
    public void setPoliticaGrupo(PoliticaGrupos politicagrupo) {
        this.politicagrupo = politicagrupo;
    }
    
    public PoliticaGrupos getCPoliticaGrupo() {
        return cPoliticaGrupo;
    }
    
    public void setCPoliticaGrupo(PoliticaGrupos cPoliticaGrupo) {
        this.cPoliticaGrupo = cPoliticaGrupo;
    }
    
    public List<PoliticaGrupos> getPoliticaGrupos() {
        politicagrupos = ptdPoliticaGrupos.encontrarPoliticaGrupos();
        selectPoliticaGrupo();
        return politicagrupos;
    }
    
    private void selectPoliticaGrupo() {
        if(politicagrupo == null && !politicagrupos.isEmpty()) {
            politicagrupo = politicagrupos.get(0);
        } else if (!politicagrupos.isEmpty()){
            int index = politicagrupos.indexOf(politicagrupo);
            if(index == -1) {
                politicagrupo = politicagrupos.get(0);
            } else {
                politicagrupo = politicagrupos.get(index);
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
            ptdPoliticaGrupos.insertar(cPoliticaGrupo);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             politicagrupo = cPoliticaGrupo;
             cPoliticaGrupo = new PoliticaGrupos();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdPoliticaGrupos.actualizar(politicagrupo);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
     try {
            ptdPoliticaGrupos.eliminar(politicagrupo.getPolCodPk());
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
