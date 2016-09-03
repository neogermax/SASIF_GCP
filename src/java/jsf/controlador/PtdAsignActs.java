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
import jpa.controlador.MbdAsignActsLocal;
import jpa.valores.Actividades;

import jpa.valores.AsignActs;
import jpa.valores.AsignActsPK;
import jpa.valores.Clases;
import jpa.valores.Etapas;


/**
 *
 * @author analista02
 */
public class PtdAsignActs {
    MbdAsignActsLocal mbdAsignActs = lookupAsignActsLocal();

    private MbdAsignActsLocal lookupAsignActsLocal() {
        try {
            Context c = new InitialContext();
            return (MbdAsignActsLocal) c.lookup("java:comp/env/MbdAsignActs");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    
    public List<AsignActs> encontrarOpcion() {
        return mbdAsignActs.encontrarOpcion();
    }
    
    public void insertar(AsignActs asignacts) throws Exception {
        this.mbdAsignActs.insertar(asignacts);
    }

    public void actualizar(AsignActs asignact) {
        this.mbdAsignActs.actualizar(asignact);
    }

    public void eliminar(AsignActsPK asignactsPK) {
        mbdAsignActs.eliminar(asignactsPK);
    }
    
    public List<AsignActs> encontrarAsignaciones(Clases clase, Etapas etapa, Actividades actividad) {
        return mbdAsignActs.encontrarAsignaciones(clase, etapa, actividad);
    }

    public List<AsignActs> encontrarCronograma(Clases clase, Etapas etapa, Actividades actividad) {
        return mbdAsignActs.encontrarCronograma(clase, etapa, actividad);
    }
    
}
