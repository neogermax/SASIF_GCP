/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.AccesoRepUsu;
import jpa.valores.AccesoRepUsuPK;

@FacesConverter(value = "jsf.beans.BConvAccesoRepUsu")
public class BConvAccesoRepUsu implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new AccesoRepUsu(new AccesoRepUsuPK(keys[0],Integer.valueOf(keys[1]), Integer.valueOf(keys[2])));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            AccesoRepUsuPK a = ((AccesoRepUsu)value).getAccesoRepUsuPK();
            return "" + a.getAruUsuCodFk() + "," + a.getAruCodRepFk()+ "," + a.getAruGrpCodFk();
        }
    }
    
}
