/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Relaciones;
import jsf.controlador.PtdClases;

public class MapaRelacion implements Serializable {
    protected PtdClases ptdClases = new PtdClases();
    protected List<Clases> clases;
    protected Map<Etapas, List<Actividades>> etapas;
    protected List<Actividades> actividades;
    protected Clases clase;
    protected Etapas etapa;
    protected Actividades actividad;
    
    public MapaRelacion() {
    }
    
    public MapaRelacion(Clases clase, Etapas etapa, Actividades actividad) {
        clases = ptdClases.encontrarTodos();
        setClase(clase);
        setEtapa(etapa);
        setActividad(actividad);
    }
    
    private void primeraEtapa() {
        Iterator<Etapas> it = etapas.keySet().iterator();
        if(it.hasNext()) {
            setEtapa(it.next());
        }
    }
    
    private void primeraActividad() {
        if(actividades != null && !actividades.isEmpty()) {
            setActividad(actividades.get(0));
        }
    }
    
    private void organizar() {
        List<Relaciones> rs = clase.getRelacionesList();
        etapas = new HashMap<Etapas, List<Actividades>>();
        List<Actividades> acts = null;
        Etapas etp = null;
        for(Relaciones r : rs) {
            if(!r.getRelEtpCodFk().equals(etp)) {
                acts = new ArrayList<Actividades>();
                etapas.put(r.getRelEtpCodFk(), acts);
                etp = r.getRelEtpCodFk();
            }
            acts.add(r.getRelActCodFk());
        }
    }
    
    private Clases selectClase(Clases clase) {
        int index = clases.indexOf(clase);
        return clases.get(index);
    }
    
    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        return clases;
    }
    
    public Set<Etapas> getEtapas() {
        if(etapas == null) {
            return null;
        } else {
            return etapas.keySet();
        }
    }
    
    public List<Actividades> getActividades() {
        return actividades;
    }
    
    public Clases getClase() {
        return clase;
    }
    
    public void setClase(Clases clase) {
        if(clase == null) {
            this.clase = null;
            setEtapa(null);
            etapas = null;
        } else {
            this.clase = selectClase(clase);
            organizar();
            primeraEtapa();
        }
    }
    
    public Etapas getEtapa() {
        return etapa;
    }
    
    public void setEtapa(Etapas etapa) {
        this.etapa = etapa;
        if(etapa == null) {
            setActividad(null);
            actividades = null;
        } else {
            actividades = etapas.get(etapa);
            primeraActividad();
        }
    }
    
    public Actividades getActividad() {
        return actividad;
    }
    
    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }
}
