/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Actividades;
import jpa.valores.Relaciones;
import jsf.beans.gestores.ActividadProyActs;

@FacesConverter(value = "jsf.beans.BConvActividadProyActs")
public class BConvActividadProyActs implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            ActividadProyActs a = new ActividadProyActs(new Relaciones());
            a.setActividad(new Actividades(Integer.valueOf(value)));
            return a;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            return ((ActividadProyActs)value).getActividad().getActCodPk().toString();
        }
    }
    
}
