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
import jpa.valores.Paralelas;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.ParalelasPK;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdParalelas;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdEtapas;
import jsf.beans.generales.BGenErrores;



@ManagedBean(name = "bgesParalelas")
@SessionScoped
public class BGesParalelas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdParalelas ptdParalelas = new PtdParalelas();
    private PtdActividades ptdActividades = new PtdActividades();
    private PtdClases ptdClases = new PtdClases();
    private PtdEtapas ptdEtapas = new PtdEtapas();
    private Paralelas paralela;
    private Paralelas cParalela = new Paralelas(new ParalelasPK());
    private List<Paralelas> paralelas;
    private List<Actividades> actividades;
    private List<Clases> clases;
    private List<Etapas> etapas;
    private String parUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesParalelas() {
        parUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        paralelas = ptdParalelas.encontrarTodos();
        if(!paralelas.isEmpty()) {
            paralela = paralelas.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
        columnas.add("7");
        
    }
    
    public Paralelas getParalela() {
        return paralela;
    }
    
    public void setParalela(Paralelas paralela) {
        this.paralela = paralela;
    }
    
    public Paralelas getCParalela() {
        return cParalela;
    }
    
    public void setCParalela(Paralelas cParalela) {
        this.cParalela = cParalela;
    }
    
    public List<Paralelas> getParalelas() {
        paralelas = ptdParalelas.encontrarTodos();
        selectAlfanumerica();
        return paralelas;
    }
    
    private void selectAlfanumerica() {
        if(paralela == null && !paralelas.isEmpty()) {
            paralela = paralelas.get(0);
        } else if (!paralelas.isEmpty()) {
            int index = paralelas.indexOf(paralela);
            if(index == -1) {
                paralela = paralelas.get(0);
            } else {
                paralela = paralelas.get(index);
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
            System.out.println("crear");
            ptdParalelas.insertar(cParalela);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             paralela = cParalela;
             cParalela = new Paralelas(new ParalelasPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
            e.printStackTrace();
        }
        return null;
    }

    public String actualizar() {
        ptdParalelas.actualizar(paralela);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdParalelas.eliminar(paralela.getParalelasPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                FacesMessage.SEVERITY_ERROR);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private Actividades seleccionarActividades(Actividades a) {
        int index = actividades.indexOf(a);
        return actividades.get(index);
    }
    
    private Clases seleccionarClases(Clases c) {
        int index = clases.indexOf(c);
        return clases.get(index);
    }
    
    private Etapas seleccionarEtapas(Etapas e) {
        int index = etapas.indexOf(e);
        return etapas.get(index);
    }
    
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
