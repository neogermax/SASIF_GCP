/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import java.math.BigDecimal;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import jpa.valores.Numericas;
import jpa.valores.NumericasPK;


/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvNumericas")
public class BConvNumericas implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Numericas(Integer.valueOf(keys[0]), new BigDecimal(keys[1]));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            NumericasPK n = ((Numericas)value).getNumericasPK();
            return "" + n.getNumCodPk() + "," + n.getNumValor();
        }
    }
    
}
