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
import jpa.valores.Formulas;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdFormulas;
import jsf.beans.generales.BGenErrores;


@ManagedBean(name = "bgesFormulas")
@SessionScoped
public class BGesFormulas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdFormulas ptdFormulas = new PtdFormulas();
    private Formulas formula;
    private Formulas cFormula = new Formulas();
    private List<Formulas> formulas;
    private String forUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesFormulas() {
        forUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        formulas = ptdFormulas.encontrarTodos();
        if(!formulas.isEmpty()) {
            formula = formulas.get(0);
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
    
    public Formulas getFormula() {
        return formula;
    }
    
    public void setFormula(Formulas formula) {
        this.formula = formula;
    }
    
    public Formulas getCFormula() {
        return cFormula;
    }
    
    public void setCFormula(Formulas cFormula) {
        this.cFormula = cFormula;
    }
    
    public List<Formulas> getFormulas() {
        formulas = ptdFormulas.encontrarTodos();
        selectFormula();
        return formulas;
    }
    
    private void selectFormula() {
        if(formula == null && !formulas.isEmpty()) {
            formula = formulas.get(0);
        } else if (!formulas.isEmpty()) {
            int index = formulas.indexOf(formula);
            if(index == -1) {
                formula = formulas.get(0);
            } else {
                formula = formulas.get(index);
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
            cFormula.setForModif(new Date());
            cFormula.setForUsuCod(forUsuCod);
            ptdFormulas.insertar(cFormula);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             formula = cFormula;
             cFormula = new Formulas();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        formula.setForModif(new Date());
        formula.setForUsuCod(forUsuCod);
        ptdFormulas.actualizar(formula);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdFormulas.eliminar(formula.getForCodPk());
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
