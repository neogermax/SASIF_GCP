/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import jpa.valores.Componentes;

/**
 *
 * @author analista02
 */
public class SelectComp {
    private boolean select;
    private Componentes componente;
    
    public SelectComp(boolean select, Componentes componente) {
        this.select = select;
        this.componente = componente;
    }
    
    public boolean isSelect() {
        return select;
    }
    
    public void setSelect(boolean select) {
        this.select = select;
    }
    
    public Componentes getComponente() {
        return componente;
    }
}
