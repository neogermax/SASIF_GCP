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
import jpa.controlador.MbdParalelasLocal;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Paralelas;
import jpa.valores.ParalelasPK;

/**
 *
 * @author analista02
 */
public class PtdParalelas {
    MbdParalelasLocal mbdParalelas = lookupMbdParalelasLocal();

    private MbdParalelasLocal lookupMbdParalelasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdParalelasLocal) c.lookup("java:comp/env/MbdParalelas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Paralelas> encontrarTodos() {
        return mbdParalelas.encontrarTodos();
    }

    public List<Paralelas> encontrarPorCodigo(Integer parClsCodFk) {
        return mbdParalelas.encontrarPorCodigo(parClsCodFk);
    }

    public void insertar(Paralelas paralelas) throws Exception {
        mbdParalelas.insetar(paralelas);
    }

    public void actualizar(Paralelas paralelas) {
        mbdParalelas.actualizar(paralelas);
    }

    public void eliminar(ParalelasPK paralelasPK) {
        mbdParalelas.eliminar(paralelasPK);
    }
    
    public Paralelas encontrar(ParalelasPK paralelasPk) {
        return mbdParalelas.encontrar(paralelasPk);
    }
    
    public void insertar(List<Paralelas> paralelas) {
        mbdParalelas.insertar(paralelas);
    }
    
    public List<Paralelas> encontrar(Clases clase, Etapas etapa, Actividades actividad) {
        return mbdParalelas.encontrar(clase, etapa, actividad);
    }
}
