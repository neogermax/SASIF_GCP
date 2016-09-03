/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.controlador.MbdContactosLocal;
import jpa.valores.Contactos;
import jpa.valores.ContactosPK;
import jpa.valores.EmpleadosPK;

/**
 *
 * @author analista02
 */
public class PtdContactos {
    MbdContactosLocal mbdContactos = lookupContactoLocal();

    private MbdContactosLocal lookupContactoLocal() {
        try {
            Context c = new InitialContext();
            return (MbdContactosLocal) c.lookup("java:comp/env/MbdContactos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Contactos> encontrarTodos() {
        return mbdContactos.encontrarTodos();
    }
    
    public void insertar(Contactos contacto) throws Exception {
        this.mbdContactos.insertar(contacto);
    }

    public void actualizar(Contactos contacto) {
        this.mbdContactos.actualizar(contacto);
    }

    public void eliminar(ContactosPK  contactosPK) {
        mbdContactos.eliminar(contactosPK);
    }

    public List<Contactos> encontrarUno(EmpleadosPK empleadosPK) {
        return mbdContactos.encontrarUno(empleadosPK);
    }

}
