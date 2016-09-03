/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controlador;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.controlador.MbdProyectosLocal;
import jpa.valores.Proyectos;

/**
 *
 * @author analista02
 */
public class PtdProyectos {
    MbdProyectosLocal mbdProyectos = lookupMbdProyectosLocal();

    private MbdProyectosLocal lookupMbdProyectosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdProyectosLocal) c.lookup("java:comp/env/MbdProyectos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public void insertar(Proyectos proyectos) throws Exception {
        mbdProyectos.insertar(proyectos);
    }

    public void actualizar(Proyectos proyectos) {
        mbdProyectos.actualizar(proyectos);
    }

    public void eliminar(Integer proCodPk) {
        mbdProyectos.eliminar(proCodPk);
    }
    
    public List<Proyectos> encontrarTodos() {
        return mbdProyectos.encontrarTodos();
    }

    public Proyectos encontrar(Integer proCodPk) {
        return mbdProyectos.encontrar(proCodPk);
    }
    
//    public List<Proyectos> consultaGerencia1(String filEstado) {
//        return mbdProyectos.consultaGerencia1(filEstado);
//    }

    public List<Proyectos> consultaGerencia1(String filEstado, int filClase, boolean varClas, Date fecMin, Date fecMac) {
        return mbdProyectos.consultaGerencia1(filEstado, filClase, varClas, fecMin, fecMac);
    }

}
