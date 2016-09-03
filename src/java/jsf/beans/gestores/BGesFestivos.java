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
import jpa.valores.Festivos;
import jpa.valores.FestivosPK;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdFestivos;


@ManagedBean(name = "bgesFestivos")
@SessionScoped
public class BGesFestivos implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdFestivos ptdFestivos = new PtdFestivos();
    private Festivos festivo;
    private Festivos cFestivo = new Festivos(new FestivosPK());
    private List<Festivos> festivos;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesFestivos() {
        festivos = ptdFestivos.encontrarTodos();
        if(!festivos.isEmpty()) {
            festivo = festivos.get(0);
        }
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        
    }
    
    public Festivos getFestivo() {
        return festivo;
    }
    
    public void setFestivo(Festivos festivo) {
        this.festivo = festivo;
    }
    
    public Festivos getCFestivo() {
        return cFestivo;
    }
    
    public void setCFestivo(Festivos cFestivo) {
        this.cFestivo = cFestivo;
    }
    
    public List<Festivos> getFestivos() {
        festivos = ptdFestivos.encontrarTodos();
        selectFestivo();
        return festivos;
    }
    
    private void selectFestivo() 
    {
        if(festivo == null && !festivos.isEmpty()) 
            {
            festivo = festivos.get(0);
            } 
        else 
            if(!festivos.isEmpty()) 
                {
                int index = festivos.indexOf(festivo);
                if(index == -1) 
                     {
                    festivo = festivos.get(0);
                     }  
                else 
                    {
                    festivo = festivos.get(index);
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
            cFestivo.getFestivosPK().setFesCodPk(cFestivo.getPaises().getPaiCodPk());
             ptdFestivos.insertar(cFestivo);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             festivo = cFestivo;
             cFestivo = new Festivos(new FestivosPK());
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String eliminar() {
        ptdFestivos.eliminar(festivo.getFestivosPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}
