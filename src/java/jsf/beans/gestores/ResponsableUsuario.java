/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

/**
 *
 * @author Analista02
 */
public class ResponsableUsuario {
    private String usuario;
    private String empleado;
    private String autoriza;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getEmpleado() {
        return empleado;
    }
    
    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
    
    public String getAutoriza() {
        if(autoriza.equals("S")) {
            return "Si";
        } else if(autoriza.equals("N")) {
            return "No";
        } else {
            return "";
        }
    }
    
    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }
}
