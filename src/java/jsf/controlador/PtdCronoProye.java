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
import jpa.controlador.MbdCronoProyeLocal;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.CronoProye;
import jpa.valores.CronoProyePK;
import jpa.valores.Etapas;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;


public class PtdCronoProye {
    MbdCronoProyeLocal mbdCronoProye = lookupMbdCronoProyeLocal();

    private MbdCronoProyeLocal lookupMbdCronoProyeLocal() {
        try {
            Context c = new InitialContext();
            return (MbdCronoProyeLocal) c.lookup("java:comp/env/MbdCronoProye");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<CronoProye> encontrarTodos() {
        return mbdCronoProye.encontrarTodos();
    }

    public CronoProye encontrar(CronoProyePK cronoProyePK) {
        return mbdCronoProye.encontrar(cronoProyePK);
    }
    
    public List<CronoProye> encontrarProy(Integer cronoProyPK) {
        return mbdCronoProye.encontrarProy(cronoProyPK);
    }
    
    public List<CronoProye> encontrarProyecto(Integer CronoProyPK) {
       return mbdCronoProye.encontrarProyecto(CronoProyPK);
    }
    
    public List<CronoProye> encontrarProyCro(Integer cronoProyePK) {
        return mbdCronoProye.encontrarProyCron(cronoProyePK);
    }
    
    public List<CronoProyePK> encontrarProyect(Integer CronoProyPK) {
       return mbdCronoProye.encontrarProyect(CronoProyPK);
    }

    public void insertar(CronoProye cronoProy) throws Exception {
        mbdCronoProye.insertar(cronoProy);
    }

    public void actualizar(CronoProye cronoProy) {
        mbdCronoProye.actualizar(cronoProy);
    }

    public void eliminar(CronoProyePK cronoProyePK) {
        mbdCronoProye.eliminar(cronoProyePK);
    }
    
    public void insertar(Proyectos proyecto, List<Relaciones> relaciones, List<CronoProye> cronoProye) {
        mbdCronoProye.insertar(proyecto, relaciones, cronoProye);
    }
    
    public List<CronoProye> encontrarPorClase(Proyectos proyecto, Clases clase, Etapas etapa, Actividades actividad) {
        return mbdCronoProye.encontrarPorClase(proyecto, clase, etapa, actividad);
    }
    
    public List<CronoProye> encontrarDisp() {
        return mbdCronoProye.encontrarDisp();
    }
    
    public List<Object[]> fechMinMax(Integer proyecto) {
        return mbdCronoProye.fechMinMax(proyecto);
    }
    
    public List<Object[]> fechMinMax() {
        return mbdCronoProye.fechMinMax();
    }
    
    public List<CronoProye> encontrarProyecto(Object[] parametros) {
        return mbdCronoProye.encontrarProyecto(parametros);
    }
    
}
