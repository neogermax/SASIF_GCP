/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("tamanoValidator")
public class BGesValTamano implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String input = value.toString();
        String atributo = ((Integer)component.getAttributes().get("tamano")).toString();
        int tam = Integer.parseInt(atributo);
        if(input.length() > tam) {
            throw new ValidatorException(new FacesMessage("Maximo requerido " + tam));
        }
    }
    
}
