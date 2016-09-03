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
import jpa.controlador.MbdPermisosLocal;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;

import jpa.valores.Permisos;
import jpa.valores.PermisosPK;


/**
 *
 * @author analista02
 */
public class PtdPermisos {
    MbdPermisosLocal mbdPermisos = lookupPermisosLocal();

    private MbdPermisosLocal lookupPermisosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdPermisosLocal) c.lookup("java:comp/env/MbdPermisos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
    
    public List<Permisos> encontrarOpcion() {
        return mbdPermisos.encontrarOpcion();
    }
    
    public void insertar(Permisos permisos) throws Exception {
        this.mbdPermisos.insertar(permisos);
    }

    public void actualizar(Permisos permiso) {
        this.mbdPermisos.actualizar(permiso);
    }

    public void eliminar(PermisosPK permisosPK) {
        mbdPermisos.eliminar(permisosPK);
    }
    
    public List<Permisos> encontrarPorActividad(Clases clase, Etapas etapa, Actividades actividad) {
        return mbdPermisos.encontrarPorActividad(clase, etapa, actividad);
    }
    
    public Permisos encontrar(PermisosPK permisosPK) {
        return mbdPermisos.encontrar(permisosPK);
    }
    
}
