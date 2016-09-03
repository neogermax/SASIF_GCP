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
import jpa.controlador.MbdParametriasLocal;
import jpa.valores.Parametrias;

/**
 *
 * @author analista02
 */
public class PtdParametrias {
    MbdParametriasLocal mbdParametrias = lookupMbdParametriasLocal();

    private MbdParametriasLocal lookupMbdParametriasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdParametriasLocal) c.lookup("java:comp/env/MbdParametrias");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Parametrias> encontrarTodos() {
        return mbdParametrias.encontrarTodos();
    }
    public List<Parametrias> encontrarSint() {
        return mbdParametrias.encontrarSint();
    }
    
    public Parametrias encontrar(Integer parCodRepPk) {
        return mbdParametrias.encontrar(parCodRepPk);
    }

    public void actualizar(Parametrias parametrias) {
        mbdParametrias.actualizar(parametrias);
    }

    public void insertar(Parametrias parametrias) throws Exception {
        mbdParametrias.insertar(parametrias);
    }

    public void eliminar(Integer parCodRepPk) {
        mbdParametrias.eliminar(parCodRepPk);
    }
    
    public List<Parametrias> encontrarPorTipo(String tipo) {
        return mbdParametrias.encontrarPorTipo(tipo);
    }

    public List<Parametrias> encontrarPorGrupo(String tipo, Integer grupo) {
        return mbdParametrias.encontrarPorGrupo(tipo, grupo);
    }
    
    public List<Parametrias> encontrarPorAcceso(String tipo, List<Integer> reportes, List<Integer> grupos) {
        return mbdParametrias.encontrarPorAcceso(tipo, reportes, grupos);
    }
}
