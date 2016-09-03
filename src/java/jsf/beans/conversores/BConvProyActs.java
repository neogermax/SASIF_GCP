/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.ProyActs;
import jpa.valores.ProyActsPK;

@FacesConverter(value = "jsf.beans.BConvProyActs")
public class BConvProyActs implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new ProyActs(Integer.valueOf(keys[0]),Integer.valueOf(keys[1]),
                    Integer.valueOf(keys[2]), Integer.valueOf(keys[3]), keys[4], Integer.valueOf(keys[5]));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            ProyActsPK p = ((ProyActs)value).getProyActsPK();
            return "" + p.getPryProCodFk() + "," + p.getPryClsCodFk() + "," + p.getPryEtpCodFk() + ","
                    + p.getPryActCodFk() + "," + p.getPryComNomFk() + "," + p.getPryComTipFk();
        }
    }
    
}
