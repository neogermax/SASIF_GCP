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
import jpa.controlador.MbdGrupoReportesLocal;
import jpa.valores.GrupoReportes;

/**
 *
 * @author analista02
 */
public class PtdGrupoReportes {
    MbdGrupoReportesLocal mbdGrupoReportes = lookupMbdGrupoReportesLocal();

    private MbdGrupoReportesLocal lookupMbdGrupoReportesLocal() {
        try {
            Context c = new InitialContext();
            return (MbdGrupoReportesLocal) c.lookup("java:comp/env/MbdGrupoReportes");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<GrupoReportes> encontrarTodos() {
        return mbdGrupoReportes.encontrarTodos();
    }

    public GrupoReportes encontrar(Integer grpCodPk) {
        return mbdGrupoReportes.encontrar(grpCodPk);
    }

    public void actualizar(GrupoReportes grupoReportes) {
        mbdGrupoReportes.actualizar(grupoReportes);
    }

    public void insertar(GrupoReportes grupoReportes) throws Exception {
        mbdGrupoReportes.insertar(grupoReportes);
    }

    public void eliminar(Integer grpCodPk) {
        mbdGrupoReportes.eliminar(grpCodPk);
    }
}
