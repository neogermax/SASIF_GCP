/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Areas;
import jpa.valores.AsignActs;
import jpa.valores.CronoProye;
import jpa.valores.Empleados;
import jpa.valores.GrupoTrabajos;
import jpa.valores.GrupoUsuarios;
import jpa.valores.Paralelas;
import jpa.valores.Permisos;
import jpa.valores.ProyActs;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;
import jpa.valores.Responsables;
import jpa.valores.ResponsablesPK;
import jpa.valores.Usuarios;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAreas;
import jsf.controlador.PtdAsignActs;
import jsf.controlador.PtdCronoProye;
import jsf.controlador.PtdGrupoTrabajos;
import jsf.controlador.PtdParalelas;
import jsf.controlador.PtdPermisos;
import jsf.controlador.PtdProyActs;
import jsf.controlador.PtdResponsables;
import jsf.controlador.PtdUsuarios;

@ManagedBean(name = "bgesAsignacion")
@SessionScoped
public class BGesAsignacion implements Serializable {
    private BGesTrabajo bgesTrabajo = (BGesTrabajo)UtileriaHTTP.getBean("bgesTrabajo");
    private Empleados emp = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getEmpleado();
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private PtdPermisos ptdPermisos = new PtdPermisos();
    private PtdAsignActs ptdAsignActs = new PtdAsignActs();
    private PtdAreas ptdAreas = new PtdAreas();
    private PtdGrupoTrabajos ptdGrupoTrabajos = new PtdGrupoTrabajos();
    private PtdResponsables ptdResponsables = new PtdResponsables();
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private PtdParalelas ptdParalelas = new PtdParalelas();
    private List<Relaciones> relaciones;
    private List<Responsables> responsables;
    private List<PermisoUsuario> usuarios;
    private List<PermisoUsuario> selectedUsuarios;
    private Proyectos proyecto;
    private List<String> actividades;
    private List<Integer> asignados;
    private boolean flag;
    
    public void init(Proyectos proyecto, List<Relaciones> relaciones, Relaciones relacion, String contenido) {
        if(flag) {
            return;
        }
        this.proyecto = proyecto;
        int index = relaciones.indexOf(relacion);
        String asign = relacion.getRelActCodFk().getActAsign();
        List<Usuarios> usuarios = encontrarUsuarios(contenido);
        List<Areas> areas = ptdAreas.encontrarTodos();
        List<GrupoTrabajos> grupoTrabajos = ptdGrupoTrabajos.encontrarTodos();
        this.relaciones = new ArrayList<Relaciones>();
        this.usuarios = new ArrayList<PermisoUsuario>();
        selectedUsuarios = new ArrayList<PermisoUsuario>();
        actividades = new ArrayList<String>();
        asignados = new ArrayList<Integer>();
        if(asign.equals("S")) {
            Relaciones r;
            do {
                r = relaciones.get(++index);
            } while(index < relaciones.size() && r.getRelActCodFk().getActAsign2().equals("N"));
            if(index != relaciones.size()) {
                this.relaciones.add(r);
                componentes(r, usuarios, areas, grupoTrabajos);
                for(Paralelas p : ptdParalelas.encontrar(r.getClases(), r.getRelEtpCodFk(), r.getRelActCodFk())) {
                    if(p.getActividades1().getActAsign2().equals("S")) {
                        Relaciones rel = new Relaciones();
                        rel.setClases(p.getClases1());
                        rel.setRelEtpCodFk(p.getEtapas1());
                        rel.setRelActCodFk(p.getActividades1());
                        this.relaciones.add(rel);
                        componentes(r, usuarios, areas, grupoTrabajos);
                    }
                }
            }
        } else if(asign.equals("T")) {
            for(int i = index + 1; i<relaciones.size(); i++) {
                Relaciones r = relaciones.get(i);
                if(r.getRelActCodFk().getActAsign2().equals("S")) {
                    componentes(r, usuarios, areas, grupoTrabajos);
                    this.relaciones.add(r);
                }
            }
        } else {
            List<AsignActs> asignActs = ptdAsignActs.encontrarAsignaciones(relacion.getClases(), 
                    relacion.getRelEtpCodFk(), relacion.getRelActCodFk());
            for(AsignActs a : asignActs) {
                if(a.getActividades1().getActAsign2().equals("S")) {
                    Relaciones r = new Relaciones();
                    r.setClases(a.getClases1());
                    r.setRelEtpCodFk(a.getEtapas1());
                    r.setRelActCodFk(a.getActividades1());
                    componentes(r, usuarios, areas, grupoTrabajos);
                    this.relaciones.add(r);
                }
            }
        }
        List<Responsables> responsables = ptdResponsables.encontrarActivos();
        List<CronoProye> cronoProyes = ptdCronoProye.encontrarDisp();
        List<Object[]> fechas = ptdCronoProye.fechMinMax();
        Date d1 = null, d2 = null;
        if(!fechas.isEmpty()) {
            Object[] fchs = fechas.get(0);
            d1 = (Date)fchs[0];
            d2 = (Date)fchs[1];
        }
        bgesTrabajo.init(usuarios, responsables, cronoProyes, d1, d2);
        flag = true;
    }
    
    private List<Usuarios> encontrarUsuarios(String contenido) {
        if(contenido.equals("R")) {
            return ptdUsuarios.encontrarTodos();
        } else if(contenido.equals("W")) {
            return ptdUsuarios.encontrarPorArea(emp.getAreas());
        } else {
            return ptdUsuarios.encontrarPorEmpresa(emp.getAreas().getEmpresas());
        }
    }
    
    private List<String> filtro(List<Usuarios> usuarios, List<Permisos> permisos, Integer perClsCodFk, Integer perEtpCodFk, Integer perActCodFk) {
        List<String> filtros = new ArrayList<String>();
        for(Usuarios u : usuarios) {
            if(u.getUsuAccAct() == 1) {
                filtros.add(u.getUsuCodPk());
            } else {
                Permisos permiso = new Permisos(u.getUsuCodPk(), perClsCodFk, perEtpCodFk, perActCodFk);
                if(permisos.contains(permiso)) {
                    filtros.add(u.getUsuCodPk());
                }
            }
        } 
        return filtros;
    }
    
    private void componentes(Relaciones r, List<Usuarios> usuarios, List<Areas> areas, List<GrupoTrabajos> grupoTrabajos) {
        List<ProyActs> proyActs = ptdProyActs.encontrarActsComp(proyecto, r.getClases(), r.getRelEtpCodFk(), r.getRelActCodFk());
        
        List<Permisos> permisos = ptdPermisos.encontrarPorActividad(r.getClases(),
                r.getRelEtpCodFk(), r.getRelActCodFk());
        List<Responsables> responsables = ptdResponsables.encontrarPorClase(proyecto,
                r.getClases(), r.getRelEtpCodFk(), r.getRelActCodFk());
        List<String> filtros = filtro(usuarios, permisos, r.getClases().getClsCodPk(),
                r.getRelEtpCodFk().getEtpCodPk(), r.getRelActCodFk().getActCodPk());
        if(proyActs.isEmpty()) {
                relacionar(responsables, r, filtros, areas, grupoTrabajos ," ", Integer.valueOf(0));
                actividades.add(r.getRelActCodFk().getActDescrip());
                asignados.add(Integer.valueOf(0));
        } else {
            for(ProyActs p : proyActs) {
                relacionar(responsables, r, filtros, areas, grupoTrabajos, p.getProyActsPK().getPryComNomFk(),
                            p.getProyActsPK().getPryComTipFk());
                actividades.add(r.getRelActCodFk().getActDescrip()+ " - " + p.getProyActsPK().getPryComNomFk());
                asignados.add(Integer.valueOf(0));
            }
        }
    }
    
    private void relacionar(List<Responsables> responsables, Relaciones relacion, List<String> usuarios, List<Areas> areas, List<GrupoTrabajos> grupoTrabajos, String comNom, Integer comTip) {
        areas(usuarios, areas, relacion, comNom, comTip);
        grupos(relacion.getRelActCodFk().getActDescrip() + ((comNom.equals(" "))?"":(" - " + comNom)), grupoTrabajos);
        existentes(responsables);
    }
    
    private String nombre(String nombre) {
        return (nombre == null)?"":nombre;
    }
    
    private void areas(List<String> usuarios, List<Areas> areas, Relaciones relacion,
            String comNom, Integer comTip) {
        for(Areas a : areas) {
            for(Empleados em : a.getEmpleadosList()) {
                if(!em.getUsuariosList().isEmpty()) {
                    Usuarios u = em.getUsuariosList().get(0);
                    if(usuarios.contains(u.getUsuCodPk())) {
                        PermisoUsuario p = new PermisoUsuario();
                        p.setUsuario(u.getUsuCodPk());
                        p.setActividad(relacion.getRelActCodFk().getActDescrip() + ((comNom.equals(" "))?"":(" - " + comNom)));
                        p.setRelacion(relacion);
                        p.setComNom(comNom);
                        p.setComTip(comTip);
                        p.setEmpleado(em.getEmplNombre1() + " " + nombre(em.getEmplNombre2()) + " " +
                                em.getEmplApellido1() + " " + nombre(em.getEmplApellido2()));
                        p.setEmpresaArea(a.getEmpresas().getEmprNombre() + " - " + a.getAreNombre()
                                + " " + em.getEmplCodCargoFk().getCarDescrip());
                        p.setPorcentaje(100);
                        this.usuarios.add(p);
                    }
                }
            }
        }
    }
    
    private void grupos(String actividad, List<GrupoTrabajos> grupoTrabajos) {
        for(GrupoTrabajos gt : grupoTrabajos) {
            for(GrupoUsuarios gu : gt.getGrupoUsuariosList()) {
                String usuario = gu.getGrupoUsuariosPK().getGrpUsuCodPk();
                PermisoUsuario p = new PermisoUsuario();
                p.setActividad(actividad);
                p.setUsuario(usuario);
                int index = usuarios.indexOf(p);
                if(index != -1) {
                    p = this.usuarios.get(index);
                    p.setGrupo(gt.getGrpDescrip());
                }
            }
        }
    }
    
    private void existentes(List<Responsables> responsables) {
        for(Responsables r : responsables) {
            PermisoUsuario p = new PermisoUsuario();
            p.setActividad(r.getActividades().getActDescrip() + ((r.getResponsablesPK().getResCompPk().equals(" "))?"":(" - " + r.getResponsablesPK().getResCompPk())));
            p.setUsuario(r.getResponsablesPK().getResUsuCodFk());
            int index = usuarios.indexOf(p);
            if(index != -1) {
                selectedUsuarios.add(this.usuarios.get(index));
            }
        }
    }
    
    public List<String> getAsignados() {
        List<String> asgns = new ArrayList<String>();
        for(int i=0; i<asignados.size(); i++) {
            if(asignados.get(i).intValue() == 0) {
                asgns.add(actividades.get(i));
            }
        }
        return asgns;
    }
    
    public List<PermisoUsuario> getPermisoUsuarios() {
        return usuarios;
    }
    
    public List<PermisoUsuario> getSelectedUsuarios() {
        return selectedUsuarios;
    }
    
    public void setSelectedUsuarios(List<PermisoUsuario> selectedUsuarios) {
        this.selectedUsuarios = selectedUsuarios;
    }
    
    private void asignado(String actividad) {
        int index = actividades.indexOf(actividad);
        int i = asignados.get(index).intValue() + 1;
        asignados.set(index, Integer.valueOf(i));
    }
    
    protected void cancel() {
        flag = false;
    }
    
    public void action() {
        responsables = new ArrayList<Responsables>();
        for(PermisoUsuario p : selectedUsuarios) {
            ResponsablesPK pk = new ResponsablesPK(proyecto.getProCodPk(),
                        p.getRelacion().getClases().getClsCodPk(),
                        p.getRelacion().getRelEtpCodFk().getEtpCodPk(),
                        p.getRelacion().getRelActCodFk().getActCodPk(),
                        p.getUsuario(), p.getComNom(), p.getComTip());
            Responsables resp = new Responsables(pk, "G", " ", new Short("" + p.getPorcentaje()), null);
            resp.setProyectos(proyecto);
            resp.setClases(p.getRelacion().getClases());
            resp.setEtapas(p.getRelacion().getRelEtpCodFk());
            resp.setActividades(p.getRelacion().getRelActCodFk());
            responsables.add(resp);
            asignado(p.getActividad());
        }
        flag = false;
        try {
            ptdResponsables.insertar(proyecto, relaciones, responsables);
        } catch(Exception e) {
        }
    }
}
