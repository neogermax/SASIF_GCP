/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import jpa.valores.Permisos;
import jpa.valores.PermisosPK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvPermisos")
public class BConvPermisos implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            
            
            String[] keys = value.split(",");
            
            /*Date d = null;
            DateFormat df = DateFormat.getDateInstance();
            try {
            d = df.parse(keys[2]);
            }
            catch(ParseException e) {
            e.printStackTrace();
            }
            */
            
            return new Permisos(new PermisosPK(keys[0],Integer.valueOf(keys[1]),Integer.valueOf(keys[2]),Integer.valueOf(keys[3])));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            PermisosPK c = ((Permisos)value).getPermisosPK();
            return "" + c.getPerUsuFk() + "," + c.getPerClsCodFk() + "," + c.getPerEtpCodFk() + "," + c.getPerActCodFk();
        }
    }
    
}
