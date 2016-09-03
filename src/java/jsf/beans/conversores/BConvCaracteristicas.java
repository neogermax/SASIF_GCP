/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Caracteristicas;
import jpa.valores.CaracteristicasPK;

@FacesConverter(value = "jsf.beans.BConvCaracteristicas")
public class BConvCaracteristicas implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            
            return new Caracteristicas(new CaracteristicasPK(Integer.valueOf(keys[0]),Integer.valueOf(keys[1])));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            CaracteristicasPK c = ((Caracteristicas)value).getCaracteristicasPK();
            return "" + c.getCarSecuPk() + "," + c.getCarCodRepFk();
        }
    }
    
}
