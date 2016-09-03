/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Etapas;
import jsf.beans.gestores.EtapaActs;

@FacesConverter(value = "jsf.beans.BConvEtapaActs")
public class BConvEtapaActs implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            return new EtapaActs(new Etapas(Integer.valueOf(value)));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            return ((EtapaActs)value).getEtapa().getEtpCodPk().toString();
        }
    }
    
}
