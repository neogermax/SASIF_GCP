/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Relaciones;
import jsf.controlador.PtdRelaciones;

/**
 *
 * @author SAFLAP
 */
public class MapaRel {
    private PtdRelaciones ptdRelaciones = new PtdRelaciones();
    private List<ClaseEtps> clases;
    private List<EtapaActs> etapas;
    private List<Actividades> actividades;
    private ClaseEtps clase;
    private EtapaActs etapa;
    private Actividades actividad;
    
    public MapaRel() {
        List<Relaciones> relaciones = ptdRelaciones.encontrarTodos();
        clases = new ArrayList<ClaseEtps>();
        etapas = new ArrayList<EtapaActs>();
        actividades = new ArrayList<Actividades>();
        ClaseEtps cls = new ClaseEtps();
        EtapaActs etp = new EtapaActs();
        for(Relaciones rel : relaciones) {
            if(!rel.getClases().equals(cls.getClase())) {
                cls = new ClaseEtps(rel.getClases());
                etapas = cls.getEtapas();
                clases.add(cls);
            }
            if(rel.getRelEtpCodFk() != null && !rel.getRelEtpCodFk().equals(etp.getEtapa())) {
                etp = new EtapaActs(rel.getRelEtpCodFk());
                actividades = etp.getActividades();
                etapas.add(etp);
            }
            if(rel.getRelActCodFk() != null) {
                actividades.add(rel.getRelActCodFk());
            }
        }
    }
    
    private void selectClase() {
        if(clase == null) {
            setClase(clases.get(0));
        } else {
            int index = clases.indexOf(clase);
            if(index == -1) {
                setClase(clases.get(0));
            } else {
                setClase(clases.get(index));
            }
        }
    }
    
    private void selectEtapa() {
        if(etapa == null) {
            setEtapa(etapas.get(0));
        } else {
            int index = etapas.indexOf(etapa);
            if(index == -1) {
                setEtapa(etapas.get(0));
            } else {
                setEtapa(etapas.get(index));
            }
        }
    }
    
    private void selectActividad() {
        if(actividad == null) {
            setActividad(actividades.get(0));
        } else {
            int index = actividades.indexOf(actividad);
            if(index == -1) {
                setActividad(actividades.get(0));
            } else {
                setActividad(actividades.get(index));
            }
        }
    }
    
    public List<ClaseEtps> getClases() {
        if(!clases.isEmpty()) {
            selectClase();
        }
        return clases;
    }
    
    public List<EtapaActs> getEtapas() {
        if(!etapas.isEmpty()) {
            selectEtapa();
        }
        return etapas;
    }
    
    public List<Actividades> getActividades() {
        if(!actividades.isEmpty()) {
            selectActividad();
        }
        return actividades;
    }
    
    private ClaseEtps selectClase(ClaseEtps clase) {
        int index = clases.indexOf(clase);
        return clases.get(index);
    }
    
    private EtapaActs selectEtapa(EtapaActs etapa) {
        int index = etapas.indexOf(etapa);
        return etapas.get(index);
    }
    
    private Actividades selectActividad(Actividades actividad) {
        int index = actividades.indexOf(actividad);
        return actividades.get(index);
    }
    
    public ClaseEtps getClase() {
        return clase;
    }
    
    public void setClase(ClaseEtps clase) {
        if(clase != null) {
            this.clase = selectClase(clase);
            etapas = this.clase.getEtapas();
        } else {
            this.clase = null;
        }
    }
    
    public EtapaActs getEtapa() {
        return etapa;
    }
    
    public void setEtapa(EtapaActs etapa) {
        if(etapa != null) {
            this.etapa = selectEtapa(etapa);
            actividades = this.etapa.getActividades();
        } else {
            this.etapas = null;
            actividades = new ArrayList<Actividades>();
        }
    }
    
    public Actividades getActividad() {
        return actividad;
    }
    
    public void setActividad(Actividades actividad) {
        this.actividad = selectActividad(actividad);
    }
}
