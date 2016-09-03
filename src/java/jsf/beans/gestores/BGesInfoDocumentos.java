/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import jpa.valores.InfoDocumentos;
import jpa.valores.InfoDocumentosPK;
import jpa.valores.Pdocumentos;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdInfoDocumentos;
import jsf.controlador.PtdPdocumentos;

/**
 *
 * @author analista02
 */
@ManagedBean(name = "bgesInfoDocumentos")
@SessionScoped
public class BGesInfoDocumentos implements Serializable {
    private List<TablaCampo> tablas = new ArrayList<TablaCampo>();
    
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdInfoDocumentos ptdInfoDocumentos = new PtdInfoDocumentos();
    
    private PtdPdocumentos ptdPdocumentos = new PtdPdocumentos();
    private InfoDocumentos infoDocumento;
    private InfoDocumentos cInfoDocumento = new InfoDocumentos(new InfoDocumentosPK());
    private InfoDocumentos uInfoDocumento;
    private List<InfoDocumentos> InfoDocumentos;
    
    private List<Pdocumentos> pdocumentos;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    private List<String> cCampos;
    private List<String> uCampos;
    private TablaCampo cTabla;
    private TablaCampo uTabla;
    
    public BGesInfoDocumentos() {
        init();
        InfoDocumentos = ptdInfoDocumentos.encontrarTodos();
        if(!InfoDocumentos.isEmpty()) {
            infoDocumento = InfoDocumentos.get(0);
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
        columnas.add("14");
        columnas.add("15");
        columnas.add("16");
        columnas.add("17");
        
        for(TablaCampo t : new TablaCampo[]{new TablaCampo("CronoProye"),
                                            new TablaCampo("CronoProyePK")}) {
            try {
                Class c = Class.forName("jpa.valores." + t.getNombre());
                for(Method m : c.getMethods()) {
                    String s = m.getName();
                    if(s.startsWith("get") && !s.equals("getClass")) {
                        StringBuilder sb = new StringBuilder(s);
                        sb.delete(0, 3);
                        sb.setCharAt(0, ("" + sb.charAt(0)).toLowerCase().charAt(0));
                        t.addCampo(sb.toString());
                    }
                }
                tablas.add(t);
            } catch (Exception ex) {
            }
        }
    }
    
    private void init() {
        cInfoDocumento.setIdocIdeDato("1");
        cInfoDocumento.setIdocTipoDato("N");
        cCampos = new ArrayList<String>();
        cTabla = null;
    }
    
    public InfoDocumentos getInfoDocumento() {
        return infoDocumento;
    }
    
    public void setInfoDocumento(InfoDocumentos infoDocumento) {
        this.infoDocumento = infoDocumento;
    }
    
    public InfoDocumentos getCInfoDocumento() {
        return cInfoDocumento;
    }
    
    public void setCInfoDocumento(InfoDocumentos cInfoDocumento) {
        this.cInfoDocumento = cInfoDocumento;
    }
    
    public InfoDocumentos getUInfoDocumento() {
        return uInfoDocumento;
    }
    
    public void setUInfoDocumento(InfoDocumentos uInfoDocumento) {
        this.uInfoDocumento = uInfoDocumento;
    }
    
    public List<InfoDocumentos> getInfoDocumentos() {
        InfoDocumentos = ptdInfoDocumentos.encontrarTodos();
        selectInfoDocumento();
        return InfoDocumentos;
    }
    
    private void selectInfoDocumento() {
        if(infoDocumento == null && !InfoDocumentos.isEmpty()) {
            infoDocumento = InfoDocumentos.get(0);
        } else if (!InfoDocumentos.isEmpty()) {
            int index = InfoDocumentos.indexOf(infoDocumento);
            if(index == -1) {
                infoDocumento = InfoDocumentos.get(0);
            } else {
                infoDocumento = InfoDocumentos.get(index);
            }
        }
    }
    
    public List<Pdocumentos> getPdocumentos() {
        pdocumentos = ptdPdocumentos.encontrarTodos();
        return pdocumentos;
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
    
    public TablaCampo getCTabla() {
        return cTabla;
    }
    
    public void setCTabla(TablaCampo cTabla) {
        this.cTabla = cTabla;
        if(cTabla == null) {
            cCampos = new ArrayList<String>();
        } else {
            int index = tablas.indexOf(cTabla);
            cTabla = tablas.get(index);
            cCampos = cTabla.getCampos();
        }
    }
    
    public TablaCampo getUTabla() {
        return uTabla;
    }
    
    public void setUTabla(TablaCampo uTabla) {
        this.uTabla = uTabla;
        if(uTabla == null) {
            uCampos = new ArrayList<String>();
        } else {
            int index = tablas.indexOf(uTabla);
            uTabla = tablas.get(index);
            uCampos = uTabla.getCampos();
        }
    }
    
    public List<TablaCampo> getTablas() {
        return tablas;
    }
    
    public List<String> getCCampos() {
        return cCampos;
    }
    
    public List<String> getUCampos() {
        return uCampos;
    }
    
    public String crear() {
        try {
            if(cTabla != null) {
                cInfoDocumento.setIdocTabla(cTabla.getNombre());
            }
            Pdocumentos p = seleccionarPdocumentos(cInfoDocumento.getPdocumentos());
            cInfoDocumento.setPdocumentos(p);
            cInfoDocumento.getInfoDocumentosPK().setIdocCodDocFk(p.getPdoDocumentoPk());
            p.getInfoDocumentosList().add(cInfoDocumento);
            ptdPdocumentos.actualizar(p);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             infoDocumento = cInfoDocumento;
             cInfoDocumento = new InfoDocumentos(new InfoDocumentosPK());
             init();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }

    public String actualizar() {
        if(uInfoDocumento.getIdocIdeDato().equals("1")){
            uInfoDocumento.setIdocNumVarSesion(null);
            uInfoDocumento.setIdocNomTabla(null);
            uInfoDocumento.setIdocNomCampo(null);
            uInfoDocumento.setIdocNumCons(null);
        }else if(uInfoDocumento.getIdocIdeDato().equals("2")){
            uInfoDocumento.setIdocCodItem(null);
            uInfoDocumento.setIdocNomTabla(null);
            uInfoDocumento.setIdocNomCampo(null);
            uInfoDocumento.setIdocNumCons(null);
        }else if(uInfoDocumento.getIdocIdeDato().equals("3")){
            uInfoDocumento.setIdocCodItem(null);
            uInfoDocumento.setIdocNumVarSesion(null);
            uInfoDocumento.setIdocNumCons(null);
        }else if(uInfoDocumento.getIdocIdeDato().equals("4")){
            uInfoDocumento.setIdocCodItem(null);
            uInfoDocumento.setIdocNumVarSesion(null);
            uInfoDocumento.setIdocNomTabla(null);
            uInfoDocumento.setIdocNomCampo(null); 
        }
        
        if(uInfoDocumento.getIdocTipoDato().equals("A")) {
            uInfoDocumento.setIdocFormato(null);
        }
        
        if(uTabla != null) {
            uInfoDocumento.setIdocTabla(uTabla.getNombre());
        }
        
        infoDocumento = uInfoDocumento;
        ptdInfoDocumentos.actualizar(infoDocumento);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdInfoDocumentos.eliminar(infoDocumento.getInfoDocumentosPK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    public void mostrar() {
        uInfoDocumento = infoDocumento;
        if(uInfoDocumento.getIdocTabla() == null) {
            uTabla = null;
            uCampos = new ArrayList<String>();
        } else {
            int index = tablas.indexOf(new TablaCampo(uInfoDocumento.getIdocTabla()));
            uTabla = tablas.get(index);
            uCampos = uTabla.getCampos();
        }
    }
    
    private Pdocumentos seleccionarPdocumentos(Pdocumentos pdoc) {
        int index = pdocumentos.indexOf(pdoc);
        return pdocumentos.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
}