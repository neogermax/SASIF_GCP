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
import jpa.valores.Alfanumericas;
import jpa.valores.AlfanumericasPK;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAlfanumericas;



@ManagedBean(name = "bgesAlfanumericas")
@SessionScoped
public class BGesAlfanumericas implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdAlfanumericas ptdAlfanumericas = new PtdAlfanumericas();
    private MapaRelacion cMapa = new MapaRelacion();
    private MapaRelacion mapa;
    private Alfanumericas alfanumerica;
    private Alfanumericas uAlfanumerica;
    private Alfanumericas cAlfanumerica = new Alfanumericas(new AlfanumericasPK());
    private List<Alfanumericas> alfanumericas;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesAlfanumericas() {
        init();
        alfanumericas = ptdAlfanumericas.encontrarTodos();
        if(!alfanumericas.isEmpty()) {
            alfanumerica = alfanumericas.get(0);
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
        columnas.add("13");
    }
    
    private void init() {
        cAlfanumerica.setAlfCorreo("N");
        cAlfanumerica.setAlfMensajes("N");
        cAlfanumerica.setAlfIndDudas("N");
        cAlfanumerica.setAlfAutoriza(" ");
    }
    
    public Alfanumericas getAlfanumerica() {
        return alfanumerica;
    }
    
    public void setAlfanumerica(Alfanumericas alfanumerica) {
        this.alfanumerica = alfanumerica;
    }
    
    public Alfanumericas getUAlfanumerica() {
        return uAlfanumerica;
    }
    
    public void setUAlfanumerica(Alfanumericas uAlfanumerica) {
        this.uAlfanumerica = uAlfanumerica;
    }
    
    public Alfanumericas getCAlfanumerica() {
        return cAlfanumerica;
    }
    
    public void setCAlfanumerica(Alfanumericas cAlfanumerica) {
        this.cAlfanumerica = cAlfanumerica;
    }
    
    public List<Integer> getAlfanumericasCode() {
        return ptdAlfanumericas.encontrarCodigos();
    }
    
    public List<Alfanumericas> getAlfanumericas() {
        alfanumericas = ptdAlfanumericas.encontrarTodos();
        selectAlfanumerica();
        return alfanumericas;
    }
    
    private void selectAlfanumerica() {
        if(alfanumerica == null && !alfanumericas.isEmpty()) {
            alfanumerica = alfanumericas.get(0);
        } else if(!alfanumericas.isEmpty()) {
            int index = alfanumericas.indexOf(alfanumerica);
            if(index == -1) {
                alfanumerica = alfanumericas.get(0);
            } else {
                alfanumerica = alfanumericas.get(index);
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
            cAlfanumerica.setAlfClsCodFk(cMapa.getClase());
            cAlfanumerica.setAlfEtpCodFk(cMapa.getEtapa());
            cAlfanumerica.setAlfActCodFk(cMapa.getActividad());
            ptdAlfanumericas.insertar(cAlfanumerica);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             alfanumerica = cAlfanumerica;
             cAlfanumerica = new Alfanumericas(new AlfanumericasPK());
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
        uAlfanumerica.setAlfClsCodFk(mapa.getClase());
        uAlfanumerica.setAlfEtpCodFk(mapa.getEtapa());
        uAlfanumerica.setAlfActCodFk(mapa.getActividad());
        ptdAlfanumericas.actualizar(uAlfanumerica);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        alfanumerica = uAlfanumerica;
        return null;
    }

    public String eliminar() {
        try {
        ptdAlfanumericas.eliminar(alfanumerica.getAlfanumericasPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
            }catch(Exception e) {
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
        uAlfanumerica = alfanumerica;
        if(uAlfanumerica.getAlfClsCodFk() == null) {
            mapa = new MapaRelacion();
        } else {
            mapa = new MapaRelacion(uAlfanumerica.getAlfClsCodFk(), uAlfanumerica.getAlfEtpCodFk(),
                uAlfanumerica.getAlfActCodFk());
        }
    }
}
