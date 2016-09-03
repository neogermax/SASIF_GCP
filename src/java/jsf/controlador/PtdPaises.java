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
import jpa.controlador.MbdPaisesLocal;
import jpa.valores.Paises;

/**
 *
 * @author analista02
 */
public class PtdPaises {
    MbdPaisesLocal mbdPaises = lookupMbdPaisesLocal();

    private MbdPaisesLocal lookupMbdPaisesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdPaisesLocal) c.lookup("java:comp/env/MbdPaises");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Paises> encontrarTodos() {
        return mbdPaises.encontrarTodos();
    }
    
    public Paises encontrar(Integer paiCodPk) {
        return mbdPaises.encontrar(paiCodPk);
    }

    public void insertar(Paises paises) throws Exception {
        mbdPaises.insertar(paises);
    }

    public void actualizar(Paises paises) {
        mbdPaises.actualizar(paises);
    }

    public void eliminar(Integer paiCodPk) {
        mbdPaises.eliminar(paiCodPk);
    }
}
