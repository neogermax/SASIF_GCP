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

import jpa.valores.AsignActs;
import jpa.valores.AsignActsPK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvAsignActs")
public class BConvAsignActs implements Converter {

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
            
            return new AsignActs(new AsignActsPK(Integer.valueOf(keys[0]),Integer.valueOf(keys[1]),Integer.valueOf(keys[2]),Integer.valueOf(keys[3]),Integer.valueOf(keys[4]),Integer.valueOf(keys[5])));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            AsignActsPK c = ((AsignActs)value).getAsignActsPK();
            return "" + c.getAsignOrgClsFk() + "," + c.getAsignOrgEtpFk() + "," + c.getAsignOrgActFk() + "," + c.getAsignDesClsFk()+ "," + c.getAsignDesEtpFk()+ "," + c.getAsignDesActFk();
        }
    }
    
}
