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

import jpa.valores.Reportes;
import jpa.valores.ReportesPK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvReportes")
public class BConvReportes implements Converter {

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
            
            return new Reportes(new ReportesPK(Integer.valueOf(keys[0]),Integer.valueOf(keys[1]),keys[2],keys[3]));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            ReportesPK c = ((Reportes)value).getReportesPK();
            return "" + c.getRepCodRepFk() + "," + c.getRepCarSecFk() + "," + c.getRepNomFil() + "," + c.getRepNomCol();
        }
    }
    
}
