/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.PoliticaGrupos;

@FacesConverter(value = "jsf.beans.BConvPoliticaGrupos")
public class BConvPoliticaGrupos implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            return new PoliticaGrupos(Integer.valueOf(value));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            return ((PoliticaGrupos)value).getPolCodPk().toString();
        }
    }
    
}
