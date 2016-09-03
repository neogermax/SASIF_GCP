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
import jpa.controlador.MbdGrupoTrabajosLocal;
import jpa.valores.GrupoTrabajos;

/**
 *
 * @author analista02
 */
public class PtdGrupoTrabajos {
    MbdGrupoTrabajosLocal mbdGrupoTrabajos = lookupMbdGrupoTrabajosLocal();

    private MbdGrupoTrabajosLocal lookupMbdGrupoTrabajosLocal() {
        try {
            Context c = new InitialContext();
            return (MbdGrupoTrabajosLocal) c.lookup("java:comp/env/MbdGrupoTrabajos");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public GrupoTrabajos encontrar(Integer grpCodPk) {
        return mbdGrupoTrabajos.encontrar(grpCodPk);
    }

    public List<GrupoTrabajos> encontrarTodos() {
        return mbdGrupoTrabajos.encontrarTodos();
    }

    public void insertar(GrupoTrabajos grupoTrabajo) throws Exception {
        mbdGrupoTrabajos.insertar(grupoTrabajo);
    }

    public void actualizar(GrupoTrabajos grupoTrabajo) {
        mbdGrupoTrabajos.actualizar(grupoTrabajo);
    }

    public void eliminar(Integer grpCodPk) {
        mbdGrupoTrabajos.eliminar(grpCodPk);
    }
    
}
