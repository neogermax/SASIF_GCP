/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.List;
import jpa.valores.Permisos;
import jpa.valores.PermisosPK;
import jpa.valores.ProyActs;
import jpa.valores.Responsables;
import jpa.valores.Usuarios;
import jsf.controlador.PtdPermisos;
import jsf.controlador.PtdResponsables;
import jsf.controlador.PtdUsuarios;

/**
 *
 * @author Analista02
 */
class PermisosAct {
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private PtdResponsables ptdResponsables = new PtdResponsables();
    private PtdPermisos ptdPermisos = new PtdPermisos();
    
    PermisosAct() {
    }
    
    boolean permiso(ProyActs p, String usuario) {
        Usuarios u = ptdUsuarios.validarUsuario(usuario);
        List<Responsables> resp = ptdResponsables.encontrarPorClase(p.getProyectos(),
                p.getClases(), p.getEtapas(), p.getActividades());
        if(u.getUsuAccAct() == 1) {
            return isAcceso(u, p, resp, u.getUsuAccIac());
        } else {
            PermisosPK pk = new PermisosPK(usuario, p.getClases().getClsCodPk(), p.getEtapas().getEtpCodPk(),
                    p.getActividades().getActCodPk());
            Permisos per = ptdPermisos.encontrar(pk);
            return (per != null) ? isAcceso(u, p, resp, per.getPerAccProy().charAt(0)): false;
        }
    }
    
    private boolean isAcceso(Usuarios u, ProyActs p, List<Responsables> resp, short s) {
        switch(s) {
            case 1: return true;
            case 2: return validar(p, u.getUsuCodPk(), resp);
            case 3: List<Usuarios> usuarios = ptdUsuarios.encontrarPorArea(u.getEmpleados().getAreas());
                return validar(usuarios, resp);
            case 4: usuarios = ptdUsuarios.encontrarPorEmpresa(u.getEmpleados().getAreas().getEmpresas());
                return validar(usuarios, resp);
            default: return false;
        }
    }
    
    private boolean isAcceso(Usuarios u, ProyActs p, List<Responsables> resp, char c) {
        switch(c) {
            case 'T': return true;
            case 'P': return validar(p, u.getUsuCodPk(), resp);
            case 'A': List<Usuarios> usuarios = ptdUsuarios.encontrarPorArea(u.getEmpleados().getAreas());
                return validar(usuarios, resp);
            case 'E': usuarios = ptdUsuarios.encontrarPorEmpresa(u.getEmpleados().getAreas().getEmpresas());
                return validar(usuarios, resp);
            default: return false;
        }
    }
    
    private boolean validar(ProyActs p, String usuario, List<Responsables> responsables) {
        Responsables r = new Responsables(p.getProyectos().getProCodPk(),
                p.getClases().getClsCodPk(), p.getEtapas().getEtpCodPk(),
                p.getActividades().getActCodPk(), usuario, p.getProyActsPK().getPryComNomFk(),
                p.getProyActsPK().getPryComTipFk());
        return responsables.contains(r);
    }
    
    private boolean validar(List<Usuarios> usuarios, List<Responsables> responsables) {
        for(Responsables r : responsables) {
            Usuarios u = new Usuarios(r.getResponsablesPK().getResUsuCodFk());
            if(usuarios.contains(u)) {
                return true;
            }
        }
        return false;
    }
}
