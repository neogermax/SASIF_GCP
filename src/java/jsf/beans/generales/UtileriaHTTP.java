/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author saflap
 */
public class UtileriaHTTP {
    public static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest)getContext().getExternalContext().getRequest();
    }
    
    public static HttpServletResponse getResponse() {
        return (HttpServletResponse)getContext().getExternalContext().getResponse();
    }
    
    public static HttpSession getSession(boolean create) {
        return (HttpSession)getContext().getExternalContext().getSession(create);
    }
    
    public static void addMessage(String clientId, String msg, Severity severety) {
        FacesMessage message = new FacesMessage(msg);
        message.setSeverity(severety);
        getContext().addMessage(clientId, message);
    }
    
    public static String getParameter(String name) {
        return getContext().getExternalContext().getRequestParameterMap().get(name);
    }
    
    public static Object getBean(String name) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getELContext().getELResolver().getValue(
                context.getELContext(), null, name);
    }
    
    public static List<FacesMessage> getMessages() {
        return FacesContext.getCurrentInstance().getMessageList();
    }
    
    public static List<FacesMessage> getMessages(String clientId) {
        return FacesContext.getCurrentInstance().getMessageList(clientId);
    }
    
    public static String getProperty(String bundleName, String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        return context.getApplication().getResourceBundle(context, bundleName)
                .getString(key);
    }
    
    public static void redirect(String url) {
        try {
            getContext().getExternalContext().redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(UtileriaHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String baseURL() {
        try {
            HttpServletRequest request = getRequest();
            return new URL(request.getScheme(),
                request.getServerName(),
                request.getServerPort(),
                request.getContextPath()).toString();
        } catch (MalformedURLException ex) {
            Logger.getLogger(UtileriaHTTP.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void refresh() {
        redirect(baseURL());
    }
}
