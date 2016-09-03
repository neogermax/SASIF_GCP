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
import jpa.valores.Rutas;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdRutas;
import jsf.beans.generales.BGenErrores;

@ManagedBean(name = "bgesRutas")
@SessionScoped
public class BGesRutas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdRutas ptdRutas = new PtdRutas();
    private Rutas ruta;
    private Rutas cRuta = new Rutas();
    private List<Rutas> rutas;
    
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesRutas() {
        
        rutas = ptdRutas.encontrarTodos();
        if(!rutas.isEmpty()) {
            ruta = rutas.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
    }
    
    public Rutas getRuta() {
        return ruta;
    }
    
    public void setRuta(Rutas ruta) {
        this.ruta = ruta;
    }
    
    public Rutas getCRuta() {
        return cRuta;
    }
    
    public void setCRuta(Rutas cRuta) {
        this.cRuta = cRuta;
    }
    
    public List<Rutas> getRutas() {
        rutas = ptdRutas.encontrarTodos();
        selectRuta();
        return rutas;
    }
    
    private void selectRuta() {
        if(ruta == null && !rutas.isEmpty()) {
            
            ruta = rutas.get(0);
            
        } else if(!rutas.isEmpty()) {
            int index = rutas.indexOf(ruta);
            if(index == -1) {
                ruta = rutas.get(0);
            } else {
                ruta = rutas.get(index);
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
            ptdRutas.insertar(cRuta);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             ruta = cRuta;
             cRuta = new Rutas();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        ptdRutas.actualizar(ruta);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }

    public String eliminar() {
        try {
        ptdRutas.eliminar(ruta.getRutCodigoPk());
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
