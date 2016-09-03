/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Componentes;
import jpa.valores.ComponentesPK;
import jpa.valores.ProyActs;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;
import jpa.valores.TipoComps;
import jsf.controlador.PtdComponentes;
import jsf.controlador.PtdProyActs;
import jsf.controlador.PtdTipoComps;

@ManagedBean(name = "bgesComponentes")
@SessionScoped
public class BGesComponentes implements Serializable {
    private PtdComponentes ptdComponentes = new PtdComponentes();
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private PtdTipoComps ptdTipoComps = new PtdTipoComps();
    private Componentes componente = new Componentes(new ComponentesPK());
    private List<TipoComps> tipoComps;
    private List<Relaciones> relaciones;
    private List<ActividadComponente> actComps;
    private List<ActividadComponente> selectedActComps;
    private List<Componentes> componentes;
    private List<Integer> comps;
    private List<String> actividadComps;
    private ActividadComponente actComp;
    private Proyectos proyecto;
    private String comNom;
    
    private void selectedComps() {
        List<ProyActs> proyActs = ptdProyActs.encontrarProyComp(proyecto);
        selectedActComps = new ArrayList<ActividadComponente>();
        tipoComps = ptdTipoComps.encontrarTodos();
        for(ProyActs p : proyActs) {
            Relaciones r = new Relaciones();
            r.setClases(p.getClases());
            r.setRelEtpCodFk(p.getEtapas());
            r.setRelActCodFk(p.getActividades());
            Componentes comp = new Componentes(proyecto.getProCodPk(),
                    p.getProyActsPK().getPryComTipFk(),
                     p.getProyActsPK().getPryComNomFk());
            comp.setProyectos(proyecto);
            comp.setTipoComps(seleccionarTipoComps(new TipoComps(p.getProyActsPK().getPryComTipFk())));
            ActividadComponente act = new ActividadComponente();
            act.setRelacion(r);
            act.setComponente(comp);
            selectedActComps.add(act);
            actComps.add(act);
        }
    }
    
    public void init(Proyectos proyecto, List<Relaciones> relaciones, Relaciones relacion) {
        this.proyecto = proyecto;
        int index = relaciones.indexOf(relacion) + 1;
        actComps = new ArrayList<ActividadComponente>();
        this.relaciones = new ArrayList<Relaciones>();
        comps = new ArrayList<Integer>();
        for(int i = index; i<relaciones.size(); i++) {
            Relaciones r = relaciones.get(i);
            if(r.getRelActCodFk().getActComp().equals("S")) {
                this.relaciones.add(r);
                comps.add(Integer.valueOf(0));
            }
        }
        selectedComps();
    }
    
    public List<ActividadComponente> getActComps() {
        return actComps;
    }
    
    public List<ActividadComponente> getSelectedActComps() {
        return selectedActComps;
    }
    
    public void setSelectedActComps(List<ActividadComponente> selectedActComps) {
        this.selectedActComps = selectedActComps;
    }
    
    public ActividadComponente getActividadComponente() {
        return actComp;
    }
    
    public void setActividadComponente(ActividadComponente actComp) {
        this.actComp = actComp;
    }
    
    public Componentes getComponente() {
        return componente;
    }
    
    public void setComponente(Componentes componente) {
        this.componente = componente;
    }
    
    public String getComNom() {
        return comNom;
    }
    
    public void setComNom(String comNom) {
        this.comNom = comNom;
    }
    
    public List<TipoComps> getTipoComps() {
        return tipoComps;
    }
    
    private TipoComps seleccionarTipoComps(TipoComps p) {
        int index = tipoComps.indexOf(p);
        return tipoComps.get(index);
    }
    
    public String addComponente() {
        if(!comNom.isEmpty()) {
            componente.getComponentesPK().setComNomPk(comNom);
            componente.setTipoComps(seleccionarTipoComps(componente.getTipoComps()));
            componente.setProyectos(proyecto);
            componente.getComponentesPK().setComProCodFk(proyecto.getProCodPk());
            componente.getComponentesPK().setComTipCodFk(componente.getTipoComps().getTipCodPk());
            for(Relaciones r : relaciones) {
                ActividadComponente act = new ActividadComponente();
                act.setRelacion(r);
                act.setComponente(componente);
                if(!actComps.contains(act)) {
                    actComps.add(act);
                }
            }
            componente = new Componentes(new ComponentesPK());
        }
        return null;
    }
    
    public String delComponente() {
        actComps.removeAll(selectedActComps);
        return null;
    }
    
    public List<String> getActividadComponentes() {
        actividadComps = new ArrayList<String>();
        for(int i=0; i<comps.size(); i++) {
            if(comps.get(i).intValue() == 0) {
                actividadComps.add(relaciones.get(i).getRelActCodFk().getActDescrip());
            }
        }
        return actividadComps;
    }
    
    private void validarComponente(Relaciones relacion) {
        int index = relaciones.indexOf(relacion);
        int i = comps.get(index).intValue() + 1;
        comps.set(index, Integer.valueOf(i));
    }
    
    public void action() {
        List<Componentes> componentes = new ArrayList<Componentes>();
        List<ProyActs> proyActs = new ArrayList<ProyActs>();
        this.componentes = ptdComponentes.encontrarPorProyecto(proyecto);
        actividadComps = new ArrayList<String>();
        for(ActividadComponente act : selectedActComps) {
            if(!componentes.contains(act.getComponente()) && !this.componentes.contains(act.getComponente())) {
                componentes.add(act.getComponente());
            }
            ProyActs proyAct = new ProyActs(proyecto.getProCodPk(),
                    act.getRelacion().getClases().getClsCodPk(),
                    act.getRelacion().getRelEtpCodFk().getEtpCodPk(),
                    act.getRelacion().getRelActCodFk().getActCodPk(),
                    act.getComponente().getComponentesPK().getComNomPk(),
                    act.getComponente().getComponentesPK().getComTipCodFk());
            proyAct.setProyectos(proyecto);
            proyAct.setClases(act.getRelacion().getClases());
            proyAct.setEtapas(act.getRelacion().getRelEtpCodFk());
            proyAct.setActividades(act.getRelacion().getRelActCodFk());
            proyAct.setPryEstado("E");
            proyActs.add(proyAct);
            validarComponente(act.getRelacion());
        }
        ptdComponentes.insertar(componentes);
        ptdProyActs.insertar(proyecto, relaciones, proyActs);
    }
}
