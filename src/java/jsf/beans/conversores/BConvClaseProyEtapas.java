/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Clases;
import jsf.beans.gestores.ClaseProyEtapas;

@FacesConverter(value = "jsf.beans.BConvClaseProyEtapas")
public class BConvClaseProyEtapas implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            ClaseProyEtapas c = new ClaseProyEtapas();
            c.setClase(new Clases(Integer.valueOf(value)));
            return c;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            return ((ClaseProyEtapas)value).getClase().getClsCodPk().toString();
        }
    }
    
}
