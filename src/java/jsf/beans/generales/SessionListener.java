/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import jsf.beans.gestores.BGesNavegacion;

/**
 *
 * @author Analista02
 */
public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        try {
            ((BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion")).actualizarProceso3();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            UtileriaHTTP.refresh();
        }
    }
    
}
