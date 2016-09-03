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
import jpa.valores.DocmActv;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.DocmActvPK;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdDocmActv;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdEtapas;
import jsf.beans.generales.BGenErrores;



@ManagedBean(name = "bgesDocmActv")
@SessionScoped
public class BGesDocmActv implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");

    private PtdDocmActv ptdDocmActv = new PtdDocmActv();
    private PtdActividades ptdActividades = new PtdActividades();
    private PtdClases ptdClases = new PtdClases();
    private PtdEtapas ptdEtapas = new PtdEtapas();
    private DocmActv docmact;
    private DocmActv uDocmAct;
    private DocmActv cDocmAct = new DocmActv(new DocmActvPK());
    private List<DocmActv> docmactv;
    private List<Actividades> actividades;
    private List<Clases> clases;
    private List<Etapas> etapas;
    private MapaRel cMapa = new MapaRel();
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesDocmActv() {
        init();
        docmactv = ptdDocmActv.encontrarOpcion();
        if(!docmactv.isEmpty()) {
            docmact = docmactv.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
        
        
    }
    
    private void init() {
        cDocmAct.setDoaIndObl("N");
        cDocmAct.setDoaRest("N");
    }
    
    
    
    
    public DocmActv getDocmAct() {
        return docmact;
    }
    
    public void setDocmAct(DocmActv docmact) {
        this.docmact = docmact;
    }
    
    public DocmActv getCDocmAct() {
        return cDocmAct;
    }
    
    public void setCDocmAct(DocmActv cDocmAct) {
        this.cDocmAct = cDocmAct;
    }
    
    
    public DocmActv getUDocmAct() {
        return uDocmAct;
    }
    
    public void setUDocmAct(DocmActv uDocmAct) {
        this.uDocmAct = uDocmAct;
    }
    
    public List<DocmActv> getDocmActv() {
        docmactv = ptdDocmActv.encontrarOpcion();
        selectDocmAct();
        return docmactv;
    }
    
    
    public MapaRel getCMapaRelacion() {
        return cMapa;
    }
    
    private void selectDocmAct() {
        if(docmact == null && !docmactv.isEmpty()) {
            
            docmact = docmactv.get(0);
            
        } else if(!docmactv.isEmpty()) {
            
            int index = docmactv.indexOf(docmact);
            
            if(index == -1) {
                
                docmact = docmactv.get(0);
                
            } else {
                
                docmact = docmactv.get(index);
            }
        }
    }
    
    public List<Actividades> getActividades() {
        actividades = ptdActividades.encontrarTodos();
        return actividades;
    }
    
    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        return clases;
    }
    
    public List<Etapas> getEtapas() {
        etapas = ptdEtapas.encontrarTodos();
        return etapas;
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
            
            cDocmAct.setClases(cMapa.getClase().getClase());
            cDocmAct.setEtapas(cMapa.getEtapa().getEtapa());
            cDocmAct.setActividades(cMapa.getActividad());
                    
            cDocmAct.getDocmActvPK().setDoaClsCodFk(cMapa.getClase().getClase().getClsCodPk());
            cDocmAct.getDocmActvPK().setDoaEtpCodFk(cMapa.getEtapa().getEtapa().getEtpCodPk());
            cDocmAct.getDocmActvPK().setDoaActCodFk(cMapa.getActividad().getActCodPk());
            
            
                       
            ptdDocmActv.insertar(cDocmAct);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             docmact = cDocmAct;
             cDocmAct = new DocmActv(new DocmActvPK());
             init();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
            e.printStackTrace();
        }
        return null;
    }

    public String actualizar() {
        
        
        ptdDocmActv.actualizar(docmact);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdDocmActv.eliminar(docmact.getDocmActvPK());
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
