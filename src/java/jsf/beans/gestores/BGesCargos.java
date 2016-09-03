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
import jpa.valores.Cargos;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdCargos;
import jsf.beans.generales.BGenErrores;

@ManagedBean(name = "bgesCargos")
@SessionScoped
public class BGesCargos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdCargos ptdCargos = new PtdCargos();
    private Cargos cargo;
    private Cargos cCargo = new Cargos();
    private List<Cargos> cargos;
    private String carUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesCargos() {
        carUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        cargos = ptdCargos.encontrarTodos();
        if(!cargos.isEmpty()) {
            cargo = cargos.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
    }
    
    public Cargos getCargo() {
        return cargo;
    }
    
    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }
    
    public Cargos getCCargo() {
        return cCargo;
    }
    
    public void setCCargo(Cargos cCargo) {
        this.cCargo = cCargo;
    }
    
    public List<Cargos> getCargos() {
        cargos = ptdCargos.encontrarTodos();
        selectCargo();
        return cargos;
    }
    
    private void selectCargo() {
        if(cargo == null && !cargos.isEmpty()) {
            cargo = cargos.get(0);
        } else if (!cargos.isEmpty()) {
            int index = cargos.indexOf(cargo);
            if(index == -1) {
                cargo = cargos.get(0);
            } else {
                cargo = cargos.get(index);
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
            ptdCargos.insertar(cCargo);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             cargo = cCargo;
             cCargo = new Cargos();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdCargos.actualizar(cargo);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdCargos.eliminar(cargo.getCarCodigoPk());
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
