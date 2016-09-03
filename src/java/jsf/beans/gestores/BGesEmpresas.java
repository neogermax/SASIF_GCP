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
import jpa.valores.Empresas;
import jpa.valores.PoliticaGrupos;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdEmpresas;
import jsf.controlador.PtdPoliticaGrupos;
import jsf.beans.generales.BGenErrores;

@ManagedBean(name = "bgesEmpresas")
@SessionScoped
public class BGesEmpresas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdEmpresas ptdEmpresas = new PtdEmpresas();
    private PtdPoliticaGrupos ptdPoliticaGrupos = new PtdPoliticaGrupos();
    private Empresas empresa;
    private Empresas cEmpresa = new Empresas();
    private List<Empresas> empresas;
    private List<PoliticaGrupos> politicas;
    private String emprUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesEmpresas() {
        emprUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        empresas = ptdEmpresas.encontrarTodos();
        if(!empresas.isEmpty()) {
            empresa = empresas.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
    }
    
    public Empresas getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
    
    public Empresas getCEmpresa() {
        return cEmpresa;
    }
    
    public void setCEmpresa(Empresas cEmpresa) {
        this.cEmpresa = cEmpresa;
    }
    
    public List<Empresas> getEmpresas() {
        empresas = ptdEmpresas.encontrarTodos();
        selectEmpresa();
        return empresas;
    }
    
    private void selectEmpresa() {
        if(empresa == null && !empresas.isEmpty()) {
            empresa = empresas.get(0);
        } else if (!empresas.isEmpty()) {
            int index = empresas.indexOf(empresa);
            if(index == -1) {
                empresa = empresas.get(0);
            } else {
                empresa = empresas.get(index);
            }
        }
    }
    
    public List<PoliticaGrupos> getPoliticaGrupos() {
        politicas = ptdPoliticaGrupos.encontrarPoliticaGrupos();
        return politicas;
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
            ptdEmpresas.insertar(cEmpresa);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             empresa = cEmpresa;
             cEmpresa = new Empresas();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdEmpresas.actualizar(empresa);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        empresa.setEmprGrupPolFk(seleccionarPoliticas(empresa.getEmprGrupPolFk()));
        return null;
    }

    public String eliminar() {
        try {
        ptdEmpresas.eliminar(empresa.getEmprCodigoPk());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
      } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private PoliticaGrupos seleccionarPoliticas(PoliticaGrupos p) {
        int index = politicas.indexOf(p);
        return politicas.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
