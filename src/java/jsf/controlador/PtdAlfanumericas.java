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
import jpa.controlador.MbdAlfanumericasLocal;
import jpa.valores.Alfanumericas;
import jpa.valores.AlfanumericasPK;

/**
 *
 * @author analista02
 */
public class PtdAlfanumericas {
    MbdAlfanumericasLocal mbdAlfanumericas = lookupMbdAlfanumericasLocal();

    private MbdAlfanumericasLocal lookupMbdAlfanumericasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdAlfanumericasLocal) c.lookup("java:comp/env/MbdAlfanumericas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Alfanumericas> encontrarTodos() {
        return mbdAlfanumericas.encontrarTodos();
    }

    public List<Alfanumericas> encontrarPorCodigo(Integer alfCodPk) {
        return mbdAlfanumericas.encontrarPorCodigo(alfCodPk);
    }

    public void insertar(Alfanumericas alfanumericas) throws Exception {
        mbdAlfanumericas.insetar(alfanumericas);
    }

    public void actualizar(Alfanumericas alfanumericas) {
        mbdAlfanumericas.actualizar(alfanumericas);
    }

    public void eliminar(AlfanumericasPK alfanumericasPK) {
        mbdAlfanumericas.eliminar(alfanumericasPK);
    }
    
    public Alfanumericas encontrar(AlfanumericasPK alfanumericasPk) {
        return mbdAlfanumericas.encontrar(alfanumericasPk);
    }

    public List<Integer> encontrarCodigos() {
        return mbdAlfanumericas.encontrarCodigos();
    }
}
