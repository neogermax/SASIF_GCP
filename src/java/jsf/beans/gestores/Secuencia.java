/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Analista02
 */
class Secuencia {
    private String tipo;
    private String contenido;
    private List<ItemValues> itemValues = new ArrayList<ItemValues>();
    
    public Secuencia(String tipo, String contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public List<ItemValues> getItemValues() {
        return itemValues;
    }
    
    public String getContenido() {
        return contenido;
    }
}
