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
import jpa.valores.Numericas;
import jpa.valores.NumericasPK;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdNumericas;



@ManagedBean(name = "bgesNumericas")
@SessionScoped
public class BGesNumericas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdNumericas ptdNumericas = new PtdNumericas();
    private MapaRelacion cMapa = new MapaRelacion();
    private MapaRelacion mapa;
    private Numericas numerica;
    private Numericas uNumerica;
    private Numericas cNumerica = new Numericas(new NumericasPK());
    private List<Numericas> numericas;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesNumericas() {
        init();
        
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
        columnas.add("13");
    }
    
    private void init() {
        cNumerica.setNumCorreo("N");
        cNumerica.setNumMensajes("N");
        cNumerica.setNumIndDudas("N");
        cNumerica.setNumAutoriza(" ");
    }
    
    public Numericas getNumerica() {
        return numerica;
    }
    
    public void setNumerica(Numericas numerica) {
        this.numerica = numerica;
    }
    
    public Numericas getUNumerica() {
        return uNumerica;
    }
    
    public void setUNumerica(Numericas uNumerica) {
        this.uNumerica = uNumerica;
    }
    
    public Numericas getCNumerica() {
        return cNumerica;
    }
    
    public void setCNumerica(Numericas cNumerica) {
        this.cNumerica = cNumerica;
    }
    
    public List<Integer> getNumericasCode() {
        return ptdNumericas.encontrarCodigos();
    }
    
    public List<Numericas> getNumericas() {
        numericas = ptdNumericas.encontrarTodos();
        selectNumerica();
        return numericas;
    }
    
    private void selectNumerica() {
        if(numerica == null && !numericas.isEmpty()) {
            numerica = numericas.get(0);
        } else if (!numericas.isEmpty()) {
            int index = numericas.indexOf(numerica);
            if(index == -1) {
                numerica = numericas.get(0);
            } else {
                numerica = numericas.get(index);
            }
        }
    }
    
    public MapaRelacion getCMapaRelacion() {
        return cMapa;
    }
    
    public MapaRelacion getMapaRelacion() {
        return mapa;
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
            cNumerica.setNumClsCodFk(cMapa.getClase());
            cNumerica.setNumEtpCodFk(cMapa.getEtapa());
            cNumerica.setNumActCodFk(cMapa.getActividad());
            ptdNumericas.insertar(cNumerica);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             numerica = cNumerica;
             cNumerica = new Numericas(new NumericasPK());
             cMapa = new MapaRelacion();
             init();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
            e.printStackTrace();
        }
        return null;
    }

    public String actualizar() {
        uNumerica.setNumClsCodFk(mapa.getClase());
        uNumerica.setNumEtpCodFk(mapa.getEtapa());
        uNumerica.setNumActCodFk(mapa.getActividad());
        ptdNumericas.actualizar(uNumerica);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        numerica = uNumerica;
        return null;
    }

    public String eliminar() {
        try {
        ptdNumericas.eliminar(numerica.getNumericasPK());
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
    
    public void mostrar() {
        uNumerica = numerica;
        if(uNumerica.getNumClsCodFk() == null) {
            mapa = new MapaRelacion();
        } else {
            mapa = new MapaRelacion(uNumerica.getNumClsCodFk(), uNumerica.getNumEtpCodFk(),
                uNumerica.getNumActCodFk());
        }
    }
}
