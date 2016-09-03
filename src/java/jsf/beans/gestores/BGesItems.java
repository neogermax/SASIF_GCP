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
import jpa.valores.Items;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdItems;

@ManagedBean(name = "bgesItems")
@SessionScoped
public class BGesItems implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdItems ptdItems = new PtdItems();
    private Items item;
    private Items cItem = new Items();
    private Items aItem;
    private List<Items> items;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesItems() {
        init();
        items = ptdItems.encontrarTodos();
        if(!items.isEmpty()) {
            item = items.get(0);
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
        columnas.add("18");
        columnas.add("19");
        columnas.add("20");
        columnas.add("21");
        columnas.add("22");
        columnas.add("23");
        
    }
    
    private void init() {
        cItem.setItmDato("N");
        cItem.setItmConten("U");
        cItem.setItmValEstand("S");
        cItem.setItmSession("U");
        cItem.setItmSeg("N");
        cItem.setItmDesc("N");
        cItem.setItmCorreo("A");
        cItem.setItmMensajes("M");
        cItem.setItmIndDudas("N");
        
    }
    
    private void validar(Items i) {
        if(!i.getItmConten().equals("T")) {
            i.setItmCodTab(null);
        }
        if(!i.getItmConten().equals("S")) {
            i.setItmSession(null);
        }
        if(!i.getItmConten().equals("K")) {
            i.setItmConsCodFk(null);
        }
        if(!i.getItmConten().equals("E")) {
            i.setItmConsecCodFk(null);
        }
        if(!i.getItmConten().equals("F")) {
            i.setItmForCodFk(null);
        }
        if(!i.getItmConten().equals("P")) {
            i.setItmProgNomFk(null);
        }
    }
    
    public Items getItem() {
        return item;
    }
    
    public void setItem(Items item) {
        this.item = item;
    }
    
    public Items getAItem() {
        return aItem;
    }
    
    public void setAItem(Items aItem) {
        this.aItem = aItem;
    }
    
    public Items getCItem() {
        return cItem;
    }
    
    public void setCItem(Items cItem) {
        this.cItem = cItem;
    }
    
    private void selectItem() {
        if(item == null && !items.isEmpty()) {
            item = items.get(0);
        } else if(!items.isEmpty()) {
            int index = items.indexOf(item);
            if(index == -1) {
                item = items.get(0);
            } else {
                item = items.get(index);
            }
        }
    }
    
    public List<Items> getItems() {
        items = ptdItems.encontrarTodos();
        selectItem();
        return items;
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
            validar(cItem);
            ptdItems.insertar(cItem);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             item = cItem;
             cItem = new Items();
             init();
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
        }
        return null;
    }
    
    public String actualizar() {
        validar(aItem);
        ptdItems.actualizar(aItem);
        item = aItem;
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        return null;
    }
    
    public String eliminar() {
        try {
            ptdItems.eliminar(item.getItmCodPk());
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
        aItem = item;
    }
}
