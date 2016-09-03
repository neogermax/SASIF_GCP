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
import jsf.beans.gestores.EtapaProyActividades;

@FacesConverter(value = "jsf.beans.BConvEtapaProyActividades")
public class BConvEtapaProyActividades implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            EtapaProyActividades e = new EtapaProyActividades();
            e.setEtapa(new Etapas(Integer.valueOf(value)));
            return e;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            return ((EtapaProyActividades)value).getEtapa().getEtpCodPk().toString();
        }
    }
    
}
