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
import jpa.valores.ActItems;
import jpa.valores.Actividades;
import jpa.valores.Items;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdActItems;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdItems;

@ManagedBean(name = "bgesActItems")
@SessionScoped
public class BGesActItems implements Serializable {
    private PtdActItems ptdActItems = new PtdActItems();
    private PtdActividades ptdActividades = new PtdActividades();
    private PtdItems ptdItems = new PtdItems();
    private List<Actividades> actividades;
    private List<Items> items;
    private List<ActItems> actItems;
    private Actividades actividad;
    private Items item;
    private ActItems actItem;
    
    public BGesActItems() {
        init();
    }
    
    protected void init() {
        actItems = new ArrayList<ActItems>();
        actividades = ptdActividades.encontrarTodos();
        for(Actividades act : actividades) {
            actItems.addAll(act.getActItemsList());
        }
        items = ptdItems.encontrarTodos();
    }
    
    private void selectActividad() {
        if(actividad == null && !actividades.isEmpty()) {
            actividad = actividades.get(0);
        } else if(!actividades.isEmpty()) {
            int index = actividades.indexOf(actividad);
            if(index == -1) {
                actividad = actividades.get(0);
            } else {
                actividad = actividades.get(index);
            }
        }
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
    
    private void selectActItem() {
        if(actItem == null && actividad != null && !actividad.getActItemsList().isEmpty()) {
            actItem = actividad.getActItemsList().get(actividad.getActItemsList().size()-1);
        } else if(actividad != null && !actividad.getActItemsList().isEmpty()) {
            int index = actividad.getActItemsList().indexOf(actItem);
            if(index == -1) {
                actItem = actividad.getActItemsList().get(actividad.getActItemsList().size()-1);
            } else {
                actItem = actividad.getActItemsList().get(index);
            }
        }
    }
    
    public List<Actividades> getActividades() {
        selectActividad();
        selectActItem();
        return actividades;
    }
    
    public List<Items> getItems() {
        selectItem();
        return items;
    }
    
    private Actividades selectActividad(Actividades actividad) {
        int index = actividades.indexOf(actividad);
        return actividades.get(index);
    }
    
     private Items selectItem(Items item) {
         int index = items.indexOf(item);
         return items.get(index);
     }
     
     public Actividades getActividad() {
         return actividad;
     }
     
     public void setActividad(Actividades actividad) {
        this.actividad = selectActividad(actividad);
     }
     
     public Items getItem() {
         return item;
     }
     
     public void setItem(Items item) {
         this.item = selectItem(item);
     }
     
     public ActItems getActItem() {
         return actItem;
     }
     
     public void setActItem(ActItems actItem) {
         this.actItem = actItem;
     }
     
     public String addItem() {
         int index = actividad.getActItemsList().indexOf(actItem) + 1;
         ActItems a = new ActItems(actividad.getActCodPk(), 0);
         a.setActividades(actividad);
         a.setAcitmItmCodFk(item);
         a.setAcitmProteg("N");
         actividad.getActItemsList().add(index, a);
         organizar();
         actItems.add(a);
         actItem = a;
         return null;
     }
     
     public String removeItem() {
         actividad.getActItemsList().remove(actItem);
         actItems.remove(actItem);
         organizar();
         selectActItem();
         return null;
     }
     
     private void organizar() {
         int i=1;
         for(ActItems a : actividad.getActItemsList()) {
             a.getActItemsPK().setAcitmSec(Integer.valueOf(i++));
         }
     }
     
     public String crear() {
        ptdActItems.insertar(actItems);
        ptdActividades.actualizar();
        init();
        UtileriaHTTP.addMessage(null, "Actualizacion exitosa", FacesMessage.SEVERITY_INFO);
        return null;
     }
     
     public String cancelar() {
         init();
         return null;
     }
}
