/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Festivos;
import jpa.valores.FestivosPK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvFestivos")
public class BConvFestivos implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Festivos(Short.valueOf(keys[0]), Short.valueOf(keys[1]), Integer.valueOf(keys[2]));
            
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            
        }
                   FestivosPK n = ((Festivos)value).getFestivosPK();
                   return "" + n.getFesAnoPk() + "," + n.getFesMesdiaPk()+ "," + n.getFesCodPk();
    }
    
}
