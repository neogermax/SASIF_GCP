/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import jpa.valores.Alfanumericas;
import jpa.valores.AlfanumericasPK;


/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvAlfanumericas")
public class BConvAlfanumericas implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Alfanumericas(Integer.valueOf(keys[0]), keys[1]);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            AlfanumericasPK a = ((Alfanumericas)value).getAlfanumericasPK();
            return "" + a.getAlfCodPk() + "," + a.getAlfValor();
        }
    }
    
}
