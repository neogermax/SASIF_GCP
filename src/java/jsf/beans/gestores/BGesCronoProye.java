/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import jpa.valores.CronoProyePK;
import jpa.valores.Proyectos;
import jpa.valores.Etapas;
import jpa.valores.Clases;
import jpa.valores.ProyActs;

import jpa.valores.AsignActs;
import jpa.valores.CronoProye;
import jpa.valores.Paises;
import jpa.valores.Paralelas;
import jpa.valores.Relaciones;

import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdCronoProye;
import jsf.controlador.PtdProyectos;
import jsf.controlador.PtdEtapas;
import jsf.controlador.PtdClases;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.CalculoTime;
import jsf.controlador.PtdAsignActs;
import jsf.controlador.PtdPaises;
import jsf.controlador.PtdParalelas;
import jsf.controlador.PtdProyActs;

/**
 *
 * @author analista02
 */
@ManagedBean(name = "bgesCronoProye")
@SessionScoped
public class BGesCronoProye implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    
    
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private PtdProyectos ptdProyectos = new PtdProyectos();
    private PtdEtapas ptdEtapas = new PtdEtapas();
    private PtdClases ptdClases = new PtdClases();
    private PtdAsignActs ptdAsignActs = new PtdAsignActs();
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private PtdParalelas ptdParalelas = new PtdParalelas();
    private PtdPaises ptdPaises = new PtdPaises();
    private CronoProye cronoProy;
    private Proyectos proyecto;
    private CronogramaProyecto cronogramaProyecto;
    
    private CronoProye cCronoProy = new CronoProye(new CronoProyePK());
    private List<CronoProye> cronoProye;
    private List<CronogramaProyecto> cronogramaProyect;
    private List<Proyectos> proyectos;
    private List<Etapas> etapas;
    private List<Clases> clases;
    private List<Relaciones> relaciones;
    private List<String> actividades;
    private List<CronoProye> cronogramas;
    private String croproUsuCod;
    private UIInput inputCodigo;
    private List<String> columnas;
    private List<Integer> asignados;
    private List<Paises> paises;
    private List<CronoProye> cronoProyee;
    
    public BGesCronoProye() {
        croproUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        cronoProye = ptdCronoProye.encontrarTodos();
        if(!cronoProye.isEmpty()) {
            cronoProy = cronoProye.get(0);
        }
        
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
        columnas.add("7");
        columnas.add("8");
        columnas.add("9");
        columnas.add("10");
        columnas.add("11");
        columnas.add("12");
        columnas.add("13");
        columnas.add("14");
        columnas.add("15");
        columnas.add("16");
        columnas.add("17");
        
    }
    
    private Paises obtenerPais(Integer codPais) {
        Paises p = new Paises(codPais);
        int index = paises.indexOf(p);
        if(index == -1) {
            p = ptdPaises.encontrar(codPais);
            paises.add(p);
            return p;
        } else {
            return paises.get(index);
        }
    }
    
    public CronoProye getCronoProy() {
        return cronoProy;
        
    }
    
    public void setCronoProy(CronoProye cronoProy) {
        this.cronoProy = cronoProy;
    }
    
    public CronoProye getCCronoProy() {
        return cCronoProy;
    }
    
    public void setCCronoProy(CronoProye cCronoProy) {
        this.cCronoProy = cCronoProy;
    }
    
    public List<CronoProye> getCronoProye() {
        cronoProye = ptdCronoProye.encontrarTodos();
        selectCronoProy();
        return cronoProye;
    }
    
    public List<CronoProye> getCronogramas() {
        return cronogramas;
    }
    
    public List<CronogramaProyecto> getCronogramaProyect() {
        return cronogramaProyect;
    }
    
    private void selectCronoProy() {
        if(cronoProy == null && !cronoProye.isEmpty()) {
            cronoProy = cronoProye.get(0);
        } else if (!cronoProye.isEmpty()) {
            int index = cronoProye.indexOf(cronoProy);
            if(index == -1) {
                cronoProy = cronoProye.get(0);
            } else {
                cronoProy = cronoProye.get(index);
            }
        }
    }
    
    public List<Proyectos> getProyectos() {
        proyectos = ptdProyectos.encontrarTodos();
        return proyectos;
    }
    
    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        return clases;
    }
    
    public List<Etapas> getEtapas() {
        etapas = ptdEtapas.encontrarTodos();
        return etapas;
    }
    
    public List<String> getColumnas() {
        return columnas;
    }
    
    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }
    
    public UIInput getInputCodigo() {
        return inputCodigo;
    }
    
    public void setInputCodigo(UIInput inputCodigo) {
        this.inputCodigo = inputCodigo;
    }
    
    public String crear() throws Exception {
            ptdCronoProye.insertar(proyecto, relaciones,  cronoProye);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             
        
        return null;
    }

    public String actualizar() {
        ptdCronoProye.actualizar(cronoProy);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        
        return null;
    }

    public String eliminar() {
        try {
        ptdCronoProye.eliminar(cronoProy.getCronoProyePK());
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
    } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    
    public void init(Proyectos proyecto, List<Relaciones> relaciones, Relaciones relacion) {
        this.proyecto = proyecto;
        
        int index = relaciones.indexOf(relacion);
        String asign = relacion.getRelActCodFk().getActCrono();
        
        actividades = new ArrayList<String>();
        this.cronogramas = new ArrayList<CronoProye>();
        cronogramaProyect = new ArrayList<CronogramaProyecto>();
        
        asignados = new ArrayList<Integer>();
        this.relaciones = new ArrayList<Relaciones>();
        paises = new ArrayList<Paises>();
        
        if(asign.equals("S")) {
            Relaciones r;
            do {
                r = relaciones.get(++index);
            } while(index < relaciones.size() && r.getRelActCodFk().getActCrono2().equals("N"));
            if(index != relaciones.size()) {
                this.relaciones.add(r);
                componentes(r);
                for(Paralelas p : ptdParalelas.encontrar(r.getClases(), r.getRelEtpCodFk(), r.getRelActCodFk())) {
                    if(p.getActividades1().getActCrono2().equals("S")) {
                        Relaciones rel = new Relaciones();
                        rel.setClases(p.getClases1());
                        rel.setRelEtpCodFk(p.getEtapas1());
                        rel.setRelActCodFk(p.getActividades1());
                        this.relaciones.add(rel);
                        componentes(rel);
                    }
                }
            }
        } else if(asign.equals("T")) {
            for(int i = index + 1; i<relaciones.size(); i++) {
                Relaciones r = relaciones.get(i);
                if(r.getRelActCodFk().getActCrono2().equals("S")) {
                    componentes(r);
                    this.relaciones.add(r);
                }
            }
        } else {
            List<AsignActs> asignActs = ptdAsignActs.encontrarCronograma(relacion.getClases(), 
            relacion.getRelEtpCodFk(), relacion.getRelActCodFk());
            for(AsignActs a : asignActs) {
                if(a.getActividades1().getActCrono2().equals("S")) {
                    Relaciones r = new Relaciones();
                    r.setClases(a.getClases1());
                    r.setRelEtpCodFk(a.getEtapas1());
                    r.setRelActCodFk(a.getActividades1());
                    componentes(r);
                    this.relaciones.add(r);
                }
            }
        }
   }
        
   private void componentes(Relaciones r) {
        List<ProyActs> proyActs = ptdProyActs.encontrarActsComp(proyecto, r.getClases(), r.getRelEtpCodFk(), r.getRelActCodFk());
        cronoProyee = ptdCronoProye.encontrarPorClase(proyecto,
                r.getClases(), r.getRelEtpCodFk(), r.getRelActCodFk());
        
        
        if(proyActs.isEmpty()) {
               
                relacionar(r, " ", Integer.valueOf(0));
                
                actividades.add(r.getRelActCodFk().getActDescrip());
                asignados.add(Integer.valueOf(0));
        } else {
            for(ProyActs p : proyActs) {
                relacionar(r, p.getProyActsPK().getPryComNomFk(),
                            p.getProyActsPK().getPryComTipFk());
                
                actividades.add(r.getRelActCodFk().getActDescrip()+ " " + p.getProyActsPK().getPryComNomFk());
                asignados.add(Integer.valueOf(0));
                
            }
        }
    }
   
   
   private boolean pasar() {
       for(CronogramaProyecto cr : cronogramaProyect) {
           CronoProye c = new CronoProye(cr.getCroproProCodFk(), cr.getCroproClsCodFk(),
                   cr.getCroproEtpCodFk(), cr.getCroproActCodFk(), cr.getCroproComNomFk(),
                   cr.getCroproTipCodFk());
           if(cr.getCroproFeiPla() == null || cr.getCroproFeiPla().equals("") || cr.getCroproFefPla() == null || cr.getCroproFefPla().equals("") ){
               return false;
           }
           c.setCroproFeiPla(cr.getCroproFeiPla());
           c.setCroproFefPla(cr.getCroproFefPla());
           c.setCroproTiePla(cr.getCroproTiePla());
           c.setCroproFeiRep(cr.getCroproFeiRep());
           c.setCroproFefRep(cr.getCroproFefRep());
           c.setCroproVahPla(cr.getCroproVahPla());
           c.setCroproCosPla(cr.getCroproCosPla());
           c.setCroproTieRea(new Long(0));
           c.setCroproPorRea(new BigDecimal(0));
           c.setCroproTieAtr(new Long(0));
           c.setCroproPorCumpl(new BigDecimal(0));
           c.setCroproCosRea(new Long(0));
           
           c.setProyectos(proyecto);
           c.setClases(cr.getClases());
           c.setEtapas(cr.getEtapas());
           c.setActividades(cr.getActividades());
           
           cronogramas.add(c);
       }
        return true;
       
   }
   
    
    private void relacionar(Relaciones r, String comNom, Integer comTip) {
        CronoProye crp = new CronoProye(proyecto.getProCodPk(), r.getClases().getClsCodPk(),
                   r.getRelEtpCodFk().getEtpCodPk(), r.getRelActCodFk().getActCodPk(), comNom,
                   comTip);
        
        Paises p = obtenerPais(r.getRelActCodFk().getActCodPaiFk());
        CronogramaProyecto cpt = new CronogramaProyecto(p);
        cpt.setCroproProCodFk(proyecto.getProCodPk());
        
        cpt.setCroproClsCodFk(r.getClases().getClsCodPk());
        cpt.setCroproEtpCodFk(r.getRelEtpCodFk().getEtpCodPk());
        cpt.setCroproActCodFk(r.getRelActCodFk().getActCodPk());
        cpt.setCroproComNomFk(comNom);
        cpt.setCroproTipCodFk(comTip);
        
        cpt.setProyectos(proyecto);
        cpt.setClases(r.getClases());
        cpt.setEtapas(r.getRelEtpCodFk());
        cpt.setActividades(r.getRelActCodFk());
        
        existentes(crp, cpt);
                
        this.cronogramaProyect.add(cpt);
        
        
        
        
    }
    
    
    private void existentes(CronoProye crp,CronogramaProyecto ctp ) {
        
            
            
            int index = cronoProyee.indexOf(crp);
            System.out.println("Cantidad: " + cronoProyee.size());
            if(index != -1) {
                crp = cronoProyee.get(index);
                 
                ctp.setCroproFeiPla(crp.getCroproFeiPla());
                ctp.setCroproFefPla(crp.getCroproFefPla());
                ctp.setCroproTiePla(crp.getCroproTiePla());
                ctp.setCroproFeiRep(crp.getCroproFeiRep());
                ctp.setCroproFefRep(crp.getCroproFefRep());
                ctp.setCroproVahPla(crp.getCroproVahPla());
                ctp.setCroproCosPla(crp.getCroproCosPla());
            
        }
    }
    
    public Boolean action() {
        
        if (!pasar()) {
            return false;
        } else {
            ptdCronoProye.insertar(proyecto, relaciones, cronogramas);
            return true;
        }
    }
    
}
