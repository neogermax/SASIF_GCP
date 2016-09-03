/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.ValorHora;
import jpa.valores.ValorHoraPK;

@FacesConverter(value = "jsf.beans.BConvValorHora")
public class BConvValorHora implements Converter {
    Date date = new Date();
    DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            
            String[] keys = value.split(",");
            try {
             date = formatter.parse(keys[0]);   
            } catch(Exception e) {
                
            }
            
            return new ValorHora(new ValorHoraPK(date,Integer.valueOf(keys[1]), keys[2]));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            ValorHoraPK a = ((ValorHora)value).getValorHoraPK();
            return "" + a.getValhoFecha() + "," + a.getValhoActCodFk()+ "," + a.getValhoUsuCod();
        }
    }
    
}
