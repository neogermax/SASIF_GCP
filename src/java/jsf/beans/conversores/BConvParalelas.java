/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import jpa.valores.Paralelas;
import jpa.valores.ParalelasPK;


/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvParalelas")
public class BConvParalelas implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Paralelas(new ParalelasPK(Integer.valueOf(keys[0]), Integer.valueOf(keys[1]), Integer.valueOf(keys[2]), Integer.valueOf(keys[3]), Integer.valueOf(keys[4]), Integer.valueOf(keys[5])));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            ParalelasPK a = ((Paralelas)value).getParalelasPK();
            return "" + a.getParClsCodFk() + "," + a.getParEtpCodFk() + "," + a.getParActCodFk() + "," + a.getParClsCod()+  "," + a.getParEtpCod() + "," + a.getParActCod();
        }
    }
    
}
