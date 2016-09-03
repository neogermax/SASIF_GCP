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
import jpa.controlador.MbdComponentesLocal;
import jpa.valores.Componentes;
import jpa.valores.ComponentesPK;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;

/**
 *
 * @author Analista02
 */
public class PtdComponentes {
    MbdComponentesLocal mbdComponentes = lookupMbdComponentesLocal();

    private MbdComponentesLocal lookupMbdComponentesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdComponentesLocal) c.lookup("java:comp/env/MbdComponentes");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public Componentes encontrar(ComponentesPK componentesPK) {
        return mbdComponentes.encontrar(componentesPK);
    }

    public List<Componentes> encontrarTodos() {
        return mbdComponentes.encontrarTodos();
    }

    public void insertar(Componentes componentes) throws Exception {
        mbdComponentes.insertar(componentes);
    }

    public void actualizar(Componentes componentes) {
        mbdComponentes.actualizar(componentes);
    }

    public void eliminar(ComponentesPK componentesPK) {
        mbdComponentes.eliminar(componentesPK);
    }
    
    public List<Componentes> encontrarPorProyecto(Proyectos proyecto) {
        return mbdComponentes.encontrarPorProyecto(proyecto);
    }
    
    public void insertar(List<Componentes> componentes) {
        mbdComponentes.insertar(componentes);
    }
}
