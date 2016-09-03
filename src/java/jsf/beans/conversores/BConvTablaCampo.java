/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jsf.beans.gestores.TablaCampo;

/**
 *
 * @author analista03
 */
@FacesConverter(value = "jsf.beans.BConvTablaCampo")
public class BConvTablaCampo implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()) {
            return null;
        } else {
            return new TablaCampo(value);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return "";
        } else {
            return ((TablaCampo)value).getNombre();
        }
    }
    
}
