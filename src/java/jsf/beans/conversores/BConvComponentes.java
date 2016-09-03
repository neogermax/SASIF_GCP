/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import jpa.valores.Componentes;
import jpa.valores.ComponentesPK;

@FacesConverter(value = "jsf.beans.BConvComponentes")
public class BConvComponentes implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new Componentes(new ComponentesPK(Integer.valueOf(keys[0]),
                    Integer.valueOf(keys[1]), keys[2]));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            ComponentesPK c = ((Componentes)value).getComponentesPK();
            return "" + c.getComProCodFk() + "," + c.getComTipCodFk() + "," + c.getComNomPk();
        }
    }
    
}
