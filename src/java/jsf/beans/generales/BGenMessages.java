/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "bgenMessages")
@ApplicationScoped
public class BGenMessages implements Serializable {
    public String message(String clientId) {
        StringBuilder s = new StringBuilder();
        for(FacesMessage fm : UtileriaHTTP.getMessages(clientId)) {
            s.append(fm.getSummary());
        }
        return s.toString();
    }
    
    public String message(String c1, String c2, String c3) {
        return message(c1 + c2 + c3);
    }
}
