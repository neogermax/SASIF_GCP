/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.conversores;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import jpa.valores.CronoProye;
import jpa.valores.CronoProyePK;

/**
 *
 * @author analista02
 */
@FacesConverter(value = "jsf.beans.BConvCronoProye")
public class BConvCronoProye implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value.isEmpty()) {
            return null;
        } else {
            String[] keys = value.split(",");
            return new CronoProye(new CronoProyePK(Integer.valueOf(keys[0]),Integer.valueOf(keys[1]),Integer.valueOf(keys[2]),Integer.valueOf(keys[3]),keys[4], Integer.valueOf(keys[5])));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) {
            return null;
        } else {
            CronoProyePK c = ((CronoProye)value).getCronoProyePK();
            return "" + c.getCroproProCodFk() + "," + c.getCroproClsCodFk() + "," + c.getCroproEtpCodFk() + "," + c.getCroproActCodFk()+ "," + c.getCroproComNomFk() + "," + c.getCroproTipCodFk();
        }
    }
    
}
