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
import jpa.controlador.MbdCargosLocal;
import jpa.valores.Cargos;

/**
 *
 * @author analista02
 */
public class PtdCargos {
    MbdCargosLocal mbdCargos = lookupMbdCargosLocal();

    private MbdCargosLocal lookupMbdCargosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdCargosLocal) c.lookup("java:comp/env/MbdCargos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Cargos> encontrarTodos() {
        return mbdCargos.encontrarTodos();
    }

     public Cargos encontrar(Integer carCodigoPk) {
        return mbdCargos.encontrar(carCodigoPk);
    }
     
    public void actualizar(Cargos cargos) {
        mbdCargos.actualizar(cargos);
    }

    public void insertar(Cargos cargos) throws Exception {
        mbdCargos.insertar(cargos);
    }
    
    public void eliminar(Integer carCodigoPk) {
        mbdCargos.eliminar(carCodigoPk);
    }
    
}
