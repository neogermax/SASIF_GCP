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

import jpa.valores.PermisosDocUsu;
import jpa.valores.PermisosDocUsuPK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvPermisosDocUsu")
public class BConvPermisosDocUsu implements Converter {

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
            
            return new PermisosDocUsu(new PermisosDocUsuPK(keys[0],keys[1]));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            PermisosDocUsuPK c = ((PermisosDocUsu)value).getPermisosDocUsuPK();
            return "" + c.getPdouUsuCodFk() + "," + c.getPdouDocCodFk() ;
        }
    }
    
}
