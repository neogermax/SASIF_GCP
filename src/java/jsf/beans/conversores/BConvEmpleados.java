/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Empleados;
import jpa.valores.EmpleadosPK;

/**
 *
 * @author analista03
 */
@FacesConverter(value = "jsf.beans.BConvEmpleados")
public class BConvEmpleados implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Empleados(new Long(keys[0]), keys[1]);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            EmpleadosPK pk = ((Empleados)value).getEmpleadosPK();
            return "" + pk.getEmplId() + "," + pk.getEmplTipoId();
        }
    }
    
}
