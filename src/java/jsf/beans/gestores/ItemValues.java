/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import jpa.valores.ActItems;
import jpa.valores.ProyItems;

/**
 *
 * @author analista02
 */
public class ItemValues {
    private ActItems actItem;
    private ProyItems proyItem;
    
    public ItemValues() {
    }
    
    public ItemValues(ActItems actItem, ProyItems proyItem) {
        this.actItem = actItem;
        this.proyItem = proyItem;
    }

    public ActItems getActItem() {
        return actItem;
    }

    public void setActItem(ActItems actItem) {
        this.actItem = actItem;
    }

    public ProyItems getProyItem() {
        return proyItem;
    }

    public void setProyItem(ProyItems proyItem) {
        this.proyItem = proyItem;
    }
    
}
