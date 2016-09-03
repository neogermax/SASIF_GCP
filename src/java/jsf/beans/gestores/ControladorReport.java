/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

/**
 *
 * @author analista04
 */
interface ControladorReport {
    
    public void setOpcion(String opcion);
    
    public void setCodcronoproy(int codproyecto);
    
    public String actionOpcion(String opcion);
    
    public void cargardatos();
}
