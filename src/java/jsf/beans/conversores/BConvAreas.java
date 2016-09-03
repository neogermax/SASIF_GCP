/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Areas;
import jpa.valores.AreasPK;

@FacesConverter(value = "jsf.beans.BConvAreas")
public class BConvAreas implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Areas(new AreasPK(Integer.valueOf(keys[0]), Integer.valueOf(keys[1])));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            AreasPK a = ((Areas)value).getAreasPK();
            return "" + a.getAreCodEmpFk() + "," + a.getAreCodigoPk();
        }
    }
    
}
