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
import jpa.controlador.MbdResponsablesLocal;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;
import jpa.valores.Responsables;
import jpa.valores.ResponsablesPK;

public class PtdResponsables {
    MbdResponsablesLocal mbdResponsables = lookupMbdResponsablesLocal();

    private MbdResponsablesLocal lookupMbdResponsablesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdResponsablesLocal) c.lookup("java:comp/env/MbdResponsables");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<Responsables> encontrarTodos() {
        return mbdResponsables.encontrarTodos();
    }

    public void insertar(Responsables responsables) throws Exception {
        mbdResponsables.insertar(responsables);
    }

    public void actualizar(Responsables responsables) {
        mbdResponsables.actualizar(responsables);
    }
    
    public void actualizar(Proyectos proyecto) {
        mbdResponsables.actualizar(proyecto);
    }
    
    public void actualizar(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad, String comp, Integer tipComp) {
        mbdResponsables.actualizar(proyecto, clase, etapa, actividad, comp, tipComp);
    }

    public void eliminar(ResponsablesPK responsablesPk) {
        mbdResponsables.eliminar(responsablesPk);
    }
    
    public void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<Responsables> responsables) {
        mbdResponsables.insertar(proyecto, relaciones, responsables);
    }
    
    public List<Responsables> encontrarPorClase(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return mbdResponsables.encontrarPorClase(proyecto, clase, etapa, actividad);
    }
    
    public Responsables encontrar(ResponsablesPK responsablesPk) {
        return mbdResponsables.encontrar(responsablesPk);
    }
    
    public Long encontrarCantidadAutoriz(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return mbdResponsables.encontrarCantidadAutoriz(proyecto, clase, etapa, actividad);
    }
    
    public Long encontrarCantidadNoAutoriz(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return mbdResponsables.encontrarCantidadNoAutoriz(proyecto, clase, etapa, actividad);
    }
    
    public List<Responsables> encontrarActivos() {
        return mbdResponsables.encontrarActivos();
    }
    
    public List<Responsables> encontrarActivos(Proyectos proyecto) {
        return mbdResponsables.encontrarActivos(proyecto);
    }
}
