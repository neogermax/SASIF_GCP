/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Paralelas;
import jpa.valores.Relaciones;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdParalelas;
import jsf.controlador.PtdRelaciones;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 *
 * @author Analista02
 */
public class MapaNavegacion {
    private PtdRelaciones ptdRelaciones = new PtdRelaciones();
    private PtdClases ptdClases = new PtdClases();
    private PtdParalelas ptdParalelas = new PtdParalelas();
    private List<ClaseEtapas> clases;
    private List<EtapaActividades> etapas;
    private List<ActividadOpciones> actividades;
    private List<Paralelas> paralelas = new ArrayList<Paralelas>();
    private List<Paralelas> itPar;
    private Paralelas paralela;
    private ClaseEtapas clase;
    private EtapaActividades etapa;
    private ActividadOpciones actividad;
    
    public MapaNavegacion() {
        inicio();
    }
    
    private void obtenerOpcion(ActividadOpciones actOp, Clases clase, Etapas etapa, Actividades actividad) {
        if(paralela != null) {
            paralela.getParalelasPK().setParClsCod(clase.getClsCodPk());
            paralela.getParalelasPK().setParEtpCod(etapa.getEtpCodPk());
            paralela.getParalelasPK().setParActCod(actividad.getActCodPk());
            paralela = ptdParalelas.encontrar(paralela.getParalelasPK());
        }
        if(paralela == null) {
            itPar = ptdParalelas.encontrar(clase, etapa, actividad);
            if(itPar.isEmpty()) {
                actOp.setOpcion("N");
            } else {
                paralela = new Paralelas(clase.getClsCodPk(), etapa.getEtpCodPk(),
                        actividad.getActCodPk(), null, null, null);
                actOp.setOpcion("O");
            }
        } else {
            actOp.setOpcion("P");
            actOp.setEnlace(paralela.getParComp());
        }
    }
    
    protected void inicio() {
        List<Relaciones> relaciones = ptdRelaciones.encontrarTodos();
        clases = new ArrayList<ClaseEtapas>();
        etapas = new ArrayList<EtapaActividades>();
        actividades = new ArrayList<ActividadOpciones>();
        ClaseEtapas cls = new ClaseEtapas();
        EtapaActividades etp = new EtapaActividades();
        for(Relaciones rel : relaciones) {
            if(!rel.getClases().equals(cls.getClase())) {
                TreeNode node = new DefaultTreeNode(rel.getClases().getClsDescrip(), null);
                node.setExpanded(true);
                cls = new ClaseEtapas(rel.getClases(), node);
                etapas = cls.getEtapas();
                clases.add(cls);
            }
            if(rel.getRelEtpCodFk() != null && !rel.getRelEtpCodFk().equals(etp.getEtapa())) {
                TreeNode node = new DefaultTreeNode(rel.getRelEtpCodFk().getEtpDescrip(), null);
                node.setExpanded(true);
                cls.getNode().getChildren().add(node);
                etp = new EtapaActividades(rel.getRelEtpCodFk(), node);
                actividades = etp.getActividades();
                etapas.add(etp);
            }
            if(rel.getRelActCodFk() != null) {
                TreeNode node = new DefaultTreeNode(rel.getRelActCodFk().getActDescrip(), null);
                node.setExpanded(true);
                etp.getNode().getChildren().add(node);
                ActividadOpciones actOp = new ActividadOpciones(rel.getRelActCodFk(),node);
                obtenerOpcion(actOp, rel.getClases(), rel.getRelEtpCodFk(), rel.getRelActCodFk());
                actividades.add(actOp);
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
    
    public List<ClaseEtapas> getClases() {
        if(!clases.isEmpty()) {
            selectClase();
        }
        return clases;
    }
    
    public List<EtapaActividades> getEtapas() {
        if(!etapas.isEmpty()) {
            selectEtapa();
        }
        return etapas;
    }
    
    public List<ActividadOpciones> getActividades() {
        if(!actividades.isEmpty()) {
            selectActividad();
        }
        return actividades;
    }
    
    public ClaseEtapas getClase() {
        return clase;
    }
    
    public void setClase(ClaseEtapas clase) {
        this.clase = clase;
        if(this.clase != null) {
            etapas = this.clase.getEtapas();
        }
    }
    
    public EtapaActividades getEtapa() {
        return etapa;
    }
    
    public void setEtapa(EtapaActividades etapa) {
        this.etapa = etapa;
        if(this.etapa != null) {
            actividades = etapa.getActividades();
        } else {
            actividades = new ArrayList<ActividadOpciones>();
        }
    }
    
    public ActividadOpciones getActividad() {
        return actividad;
    }
    
    public void setActividad(ActividadOpciones actividad) {
        this.actividad = actividad;
    }
    
    protected void addClase(Clases clase) {
        TreeNode node = new DefaultTreeNode(clase.getClsDescrip(), null);
        node.setExpanded(true);
        ClaseEtapas cls = new ClaseEtapas(clase, node);
        if(clases.contains(cls)) {
            UtileriaHTTP.addMessage(null, 
                   clase.getClsDescrip() + ", ya fue incluida", FacesMessage.SEVERITY_ERROR);
            return;
        }
        int index = clases.indexOf(this.clase)+1;
        this.clase = cls;
        clases.add(index, this.clase);
        etapas = this.clase.getEtapas();
        setEtapa(null);
        setActividad(null);
    }
    
    protected void removeClase() {
        clases.remove(clase);
    }
    
    protected void addEtapa(Etapas etapa) {
        TreeNode node = new DefaultTreeNode(etapa.getEtpDescrip(), null);
        node.setExpanded(true);
        EtapaActividades etp = new EtapaActividades(etapa, node);
        if(etapas.contains(etp)) {
            UtileriaHTTP.addMessage(null, 
                   etapa.getEtpDescrip() + ", ya fue incluida", FacesMessage.SEVERITY_ERROR);
            return;
        }
        int index = etapas.indexOf(this.etapa)+1;
        this.etapa = etp;
        etapas.add(index, this.etapa);
        clase.getNode().getChildren().add(index, node);
        setActividad(null);
    }
    
    protected void removeEtapa() {
        etapas.remove(etapa);
        clase.getNode().getChildren().remove(etapa.getNode());
    }
    
    protected void addActividad(Actividades actividad) {
        if(etapa == null) {
            UtileriaHTTP.addMessage(null, 
                   "No hay etapas incluidas", FacesMessage.SEVERITY_ERROR);
            return;
        }
        TreeNode node = new DefaultTreeNode(actividad.getActDescrip(), null);
        node.setExpanded(true);
        ActividadOpciones act = new ActividadOpciones(actividad, node);
        if(actividades.contains(act)) {
            UtileriaHTTP.addMessage(null, 
                   actividad.getActDescrip() + ", ya fue incluida", FacesMessage.SEVERITY_ERROR);
            return;
        }
        int index = actividades.indexOf(this.actividad)+1;
        this.actividad = act;
        actividades.add(index, this.actividad);
        etapa.getNode().getChildren().add(index, node);
    }
    
    protected void removeActividad() {
        actividades.remove(actividad);
        etapa.getNode().getChildren().remove(actividad.getNode());
    }
    
    protected void actualizar() {
        List<Clases> upclases = new ArrayList<Clases>();
        List<Relaciones> relaciones = new ArrayList<Relaciones>();
        for(ClaseEtapas cls : clases) {
            cls.getClase().getRelacionesList().clear();
            int sec = 1;
            for(EtapaActividades etp : cls.getEtapas()) {
                int subSec = 1;
                for(ActividadOpciones act : etp.getActividades()) {
                    Relaciones r = new Relaciones(cls.getClase().getClsCodPk(),
                            Integer.valueOf(sec), Integer.valueOf(subSec));
                    r.setClases(cls.getClase());
                    r.setRelEtpCodFk(etp.getEtapa());
                    r.setRelActCodFk(act.getActividad());
                    cls.getClase().getRelacionesList().add(r);
                    relaciones.add(r);
                    paralelas(r.getClases(), r.getRelEtpCodFk(), act);
                    subSec++;
                }
                if(etp.getActividades().isEmpty()) {
                    Relaciones r = new Relaciones(cls.getClase().getClsCodPk(),
                            Integer.valueOf(sec), Integer.valueOf(subSec));
                    r.setClases(cls.getClase());
                    r.setRelEtpCodFk(etp.getEtapa());
                    cls.getClase().getRelacionesList().add(r);
                    relaciones.add(r);
                }
                sec++;
            }
            if(cls.getEtapas().isEmpty()) {
                Relaciones r = new Relaciones(cls.getClase().getClsCodPk(),
                            Integer.valueOf(sec), Integer.valueOf(1));
                r.setClases(cls.getClase());
                cls.getClase().getRelacionesList().add(r);
                relaciones.add(r);
            }
            upclases.add(cls.getClase());
        }
        ptdRelaciones.insertar(relaciones);
        ptdParalelas.insertar(paralelas);
        paralelas.clear();
        ptdClases.actualizar(upclases);
        paralela = null;
    }
    
    private void paralelas(Clases clase, Etapas etapa, ActividadOpciones actividad) {
        if(actividad.getOpcion().equals("O")) {
            paralela = new Paralelas();
            paralela.setClases(clase);
            paralela.setEtapas(etapa);
            paralela.setActividades(actividad.getActividad());
        } else if(actividad.getOpcion().equals("P") && paralela != null) {
            Paralelas p = new Paralelas(paralela.getClases().getClsCodPk(),
                    paralela.getEtapas().getEtpCodPk(),
                    paralela.getActividades().getActCodPk(),
                    clase.getClsCodPk(), etapa.getEtpCodPk(),
                    actividad.getActividad().getActCodPk());
            p.setClases(paralela.getClases());
            p.setClases1(clase);
            p.setEtapas(paralela.getEtapas());
            p.setEtapas1(etapa);
            p.setActividades(paralela.getActividades());
            p.setActividades1(actividad.getActividad());
            p.setParComp(actividad.getEnlace());
            paralelas.add(p);
        } else {
            paralela = null;
        }
    }
}
