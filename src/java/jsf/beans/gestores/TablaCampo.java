/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author analista03
 */
public class TablaCampo {
    private String nombre;
    private List<String> campos = new ArrayList<String>();
    
    public TablaCampo() {
    }
    
    public TablaCampo(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void addCampo(String campo) {
        campos.add(campo);
    }
    
    public List<String> getCampos() {
        return campos;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TablaCampo)) {
            return false;
        }
        TablaCampo other = (TablaCampo) obj;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        return hash;
    }
}
