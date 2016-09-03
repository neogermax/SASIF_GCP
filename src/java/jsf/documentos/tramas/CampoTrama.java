/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.documentos.tramas;

/**
 *
 * @author analista02
 */
public class CampoTrama {
    private int index;
    private int cant;
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index += index;
    }
    
    public int getCant() {
        return cant;
    }
    
    public void incCant() {
        cant++;
    }
}
