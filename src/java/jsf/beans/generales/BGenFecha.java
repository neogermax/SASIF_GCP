/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "bgenFecha")
@SessionScoped
public class BGenFecha implements Serializable {
    private DateFormat date = new SimpleDateFormat("yyyy/MM/dd");
    
    public String getFechaActual() {
        return date.format(new Date());
    }
}