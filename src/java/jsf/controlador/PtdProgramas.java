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
import jpa.controlador.MbdProgramasLocal;
import jpa.valores.Programas;

/**
 *
 * @author analista02
 */
public class PtdProgramas {
    MbdProgramasLocal mbdProgramas = lookupMbdProgramasLocal();

    private MbdProgramasLocal lookupMbdProgramasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdProgramasLocal) c.lookup("java:comp/env/MbdProgramas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Programas> encontrarTodos() {
        return mbdProgramas.encontrarTodos();
    }

    public Programas encontrar(String progNomPk) {
        return mbdProgramas.encontrar(progNomPk);
    }

    public void actualizar(Programas programas) {
        mbdProgramas.actualizar(programas);
    }

    public void insertar(Programas programas) throws Exception {
        mbdProgramas.insertar(programas);
    }

    public void eliminar(String progNomPk) {
        mbdProgramas.eliminar(progNomPk);
    }
}
