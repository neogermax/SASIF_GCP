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
import jpa.controlador.MbdProyActsLocal;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.ProyActs;
import jpa.valores.ProyActsPK;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;

/**
 *
 * @author analista02
 */
public class PtdProyActs {
    MbdProyActsLocal mbdProyActs = lookupMbdProyActsLocal();
    
    private MbdProyActsLocal lookupMbdProyActsLocal() {
        try {
            Context c = new InitialContext();
            return (MbdProyActsLocal) c.lookup("java:comp/env/MbdProyActs");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<ProyActs> encontrarTodos() {
        return mbdProyActs.encontrarTodos();
    }

    public ProyActs encontrar(ProyActsPK proyActsPk) {
        return mbdProyActs.encontrar(proyActsPk);
    }

    public void insertar(ProyActs proyActs) {
        mbdProyActs.insertar(proyActs);
    }

    public void actualizar(ProyActs proyActs) {
        mbdProyActs.actualizar(proyActs);
    }
    
    public void actualizar(Proyectos proyecto) {
        mbdProyActs.actualizar(proyecto);
    }
    
    public void actualizar(List<ProyActs> proyActs) {
        mbdProyActs.actualizar(proyActs);
    }

    public void eliminar(ProyActsPK proyActsPk) {
        mbdProyActs.eliminar(proyActsPk);
    }
    
    public List<ProyActs> encontrarNoTerminadas(Proyectos proyecto) {
        return mbdProyActs.encontrarNoTerminadas(proyecto);
    }
    
    public List<ProyActs> encontrarActDisp() {
        return mbdProyActs.encontrarActDisp();
    }
    
    public List<ProyActs> encontrarActDisp(Proyectos proyecto) {
        return mbdProyActs.encontrarActDisp(proyecto);
    }
    
    public List<ProyActs> encontrarActDisp(Clases clase, Etapas etapa, Actividades actividad) {
        return mbdProyActs.encontrarActDisp(clase, etapa, actividad);
    }
    
    public Long encontrarCountAct(Proyectos proyecto, Actividades actividad) {
        return mbdProyActs.encontrarCountAct(proyecto, actividad);
    }
    
    public List<ProyActs> encontrarActsComp(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return mbdProyActs.encontrarActsComp(proyecto, clase, etapa, actividad);
    }
    
    public void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<ProyActs> proyActs) {
        mbdProyActs.insertar(proyecto, relaciones, proyActs);
    }
    
    public List<ProyActs> encontrarProyComp(Proyectos proyecto) {
        return mbdProyActs.encontrarProyComp(proyecto);
    }
    
    public List<ProyActs> encontrarProyComp(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return mbdProyActs.encontrarProyComp(proyecto, clase, etapa, actividad);
    }
    
    public List<ProyActs> encontrarCompPar() {
        return mbdProyActs.encontrarCompPar();
    }
    
    public List<ProyActs> encontrarPorProy(Integer proCodFk) {
        return mbdProyActs.encontrarPorProy(proCodFk);
    }
    
    public List<ProyActs> encontrarPorProyCod(Integer proCodFk) {
        return mbdProyActs.encontrarPorProyCod(proCodFk);
    }

    public List<ProyActs> encontrarPorProyDescrip(String proDescrip) {
        return mbdProyActs.encontrarPorProyDescrip(proDescrip);
    }

    public List<ProyActs> encontrarPorProyCodDes(Integer proCodFk, String proDescrip) {
        return mbdProyActs.encontrarPorProyCodDes(proCodFk, proDescrip);
    }
   
    public List<ProyActs> encontrarPorRelacion(Integer proCodFk) {
        return mbdProyActs.encontrarPorRelacion(proCodFk);
    }
    public List<ProyActs> encontrarUno(Integer proCodFk) {
        return mbdProyActs.encontrarUno(proCodFk);
    }
}
