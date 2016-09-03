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
import jpa.controlador.MbdNumericasLocal;
import jpa.valores.Numericas;
import jpa.valores.NumericasPK;

/**
 *
 * @author analista02
 */
public class PtdNumericas {
    MbdNumericasLocal mbdNumericas = lookupMbdNumericasLocal();

    private MbdNumericasLocal lookupMbdNumericasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdNumericasLocal) c.lookup("java:comp/env/MbdNumericas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Numericas> encontrarTodos() {
        return mbdNumericas.encontrarTodos();
    }

    public List<Numericas> encontrarPorCodigo(Integer numCodPk) {
        return mbdNumericas.encontrarPorCodigo(numCodPk);
    }

    public void insertar(Numericas numericas) throws Exception {
        mbdNumericas.insertar(numericas);
    }

    public void actualizar(Numericas numericas) {
        mbdNumericas.actualizar(numericas);
    }

    public void eliminar(NumericasPK numericasPK) {
        mbdNumericas.eliminar(numericasPK);
    }
    
    public Numericas encontrar(NumericasPK numericasPk) {
        return mbdNumericas.encontrar(numericasPk);
    }

    public List<Integer> encontrarCodigos() {
        return mbdNumericas.encontrarCodigos();
    }
}
