/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import jpa.valores.OpcionRoles;
import jpa.valores.OpcionRolesPK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvOpcionRoles")
public class BConvOpcionRoles implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            return new OpcionRoles(new OpcionRolesPK(value,(short)1));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            return ((OpcionRoles)value).getOpcionRolesPK().toString();
        }
    }
    
}
