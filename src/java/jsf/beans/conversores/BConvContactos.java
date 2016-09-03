/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Contactos;
import jpa.valores.ContactosPK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvContactos")
public class BConvContactos implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Contactos(new Long(keys[0]), Integer.valueOf(keys[1]), keys[2]);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            ContactosPK pk = ((Contactos)value).getContactosPK();
            
            return "" + pk.getConEmplIdPk().toString() + "," + pk.getConConsecPk().toString() + "," + pk.getConEmplTipPk();
            
        }
    }
    
}
