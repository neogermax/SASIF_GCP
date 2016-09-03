/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.documentos.tramas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author analista02
 */
public class TablaTrama {
    private CampoTrama cabecera = new CampoTrama();
    private List<CampoTrama> filas = new ArrayList<CampoTrama>();
    private int index;
    
    public TablaTrama(int index, int index2) {
        cabecera.setIndex(index);
        this.index = index + index2;
    }
    
    public CampoTrama getCabecera() {
        return cabecera;
    }
    
    public void addCampoTrama(CampoTrama fila) {
        filas.add(fila);
    }
    
    public List<CampoTrama> getFilas() {
        return filas;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex(int index) {
        this.index += index;
    }
}
