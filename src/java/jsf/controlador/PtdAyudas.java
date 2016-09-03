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
import jpa.controlador.MbdAyudasLocal;
import jpa.valores.Ayudas;

/**
 *
 * @author analista02
 */
public class PtdAyudas {
    MbdAyudasLocal mbdAyudas = lookupMbdAyudasLocal();

    private MbdAyudasLocal lookupMbdAyudasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdAyudasLocal) c.lookup("java:comp/env/MbdAyudas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Ayudas> encontrarTodos() {
        return mbdAyudas.encontrarTodos();
    }

    public Ayudas encontrar(Integer aydCodPk) {
        return mbdAyudas.encontrar(aydCodPk);
    }

    public void actualizar(Ayudas ayudas) {
        mbdAyudas.actualizar(ayudas);
    }

    public void insertar(Ayudas ayudas) throws Exception {
        mbdAyudas.insertar(ayudas);
    }

    public void eliminar(Integer aydCodPk) {
        mbdAyudas.eliminar(aydCodPk);
    }
}
