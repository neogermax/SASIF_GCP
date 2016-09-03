/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.ActItems;
import jpa.valores.Actividades;
import jpa.valores.Alfanumericas;
import jpa.valores.AlfanumericasPK;
import jpa.valores.Clases;
import jpa.valores.Componentes;
import jpa.valores.CronoProye;
import jpa.valores.CronoProyePK;
import jpa.valores.Etapas;
import jpa.valores.Items;
import jpa.valores.Numericas;
import jpa.valores.NumericasPK;
import jpa.valores.Paises;
import jpa.valores.Paralelas;
import jpa.valores.ProyActs;
import jpa.valores.ProyActsPK;
import jpa.valores.ProyItems;
import jpa.valores.ProyItemsPK;
import jpa.valores.Proyectos;
import jpa.valores.Relaciones;
import jpa.valores.RelacionesPK;
import jpa.valores.Responsables;
import jpa.valores.ResponsablesPK;
import jpa.valores.ValorHora;
import jsf.beans.generales.CalculoTime;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdAlfanumericas;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdComponentes;
import jsf.controlador.PtdConsecutivos;
import jsf.controlador.PtdCronoProye;
import jsf.controlador.PtdNumericas;
import jsf.controlador.PtdPaises;
import jsf.controlador.PtdParalelas;
import jsf.controlador.PtdProyActs;
import jsf.controlador.PtdProyItems;
import jsf.controlador.PtdProyectos;
import jsf.controlador.PtdResponsables;
import jsf.controlador.PtdValorHora;
import org.primefaces.event.SlideEndEvent;


@ManagedBean(name = "bgesNavegacion")
@SessionScoped
public class BGesNavegacion implements Serializable {
    private BGesComponentes bgesComponentes = (BGesComponentes)UtileriaHTTP.getBean("bgesComponentes");
    private BGesAsignacion bgesAsignacion = (BGesAsignacion)UtileriaHTTP.getBean("bgesAsignacion");
    private BGesCronoProye bgesCronoProye = (BGesCronoProye)UtileriaHTTP.getBean("bgesCronoProye");
    private BGesDocumentos bgesDocumentos = (BGesDocumentos)UtileriaHTTP.getBean("bgesDocumentos");
    private PtdConsecutivos ptdConsecutivos = new PtdConsecutivos();
    private PtdAlfanumericas ptdAlfanumericas = new PtdAlfanumericas();
    private PtdNumericas ptdNumericas = new PtdNumericas();
    private PtdProyItems ptdProyItems = new PtdProyItems();
    private PtdActividades ptdActividades = new PtdActividades();
    private PtdProyectos ptdProyectos = new PtdProyectos();
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private PtdResponsables ptdResponsables = new PtdResponsables();
    private PtdClases ptdClases = new PtdClases();
    private PtdParalelas ptdParalelas = new PtdParalelas();
    private PtdComponentes ptdComponentes = new PtdComponentes();
    private PtdPaises ptdPaises = new PtdPaises();
    private PtdValorHora ptdValorHora = new PtdValorHora();
    private List<Clases> clases;
    private List<SelectComp> selectComps;
    private List<ProyActs> proyActs;
    private Clases clase;
    private Etapas etapa;
    private Actividades actividad;
    private Actividades actComp;
    private Iterator<Secuencia> secuencias;
    private List<Relaciones> relaciones;
    private Iterator<Relaciones> iteratorRel;
    private List<ItemValues> itemValues;
    private List<Paises> paises;
    private List<ValorHora> valorHoras;
    private Relaciones relacion;
    private Proyectos proyecto;
    private ProyActs proyAct;
    private CronoProye cronoProye;
    private Paises pais;
    private String proUsuCod;
    private String doc;
    private boolean jump;
    private boolean flag;
    private boolean continua;
    private boolean termino;
    private boolean tempTermino;
    private boolean flagSig;
    private int parametro;
    private String opcion;
    private String tipo;
    private String contenido;
    private String tempTipo;
    private String proyFormato;
    private String actFormato;
    private CompPar compPar;
    private boolean actRojo;
    private boolean actAmarillo;
    private boolean actVerde;
    private boolean proRojo;
    private boolean proAmarillo;
    private boolean proVerde;
    private Integer actCodPk;
    private Clases clsCodFk;
    private Etapas etpCodFk;
    
    
    public BGesNavegacion() {
        proUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        paises = new ArrayList<Paises>();
        valorHoras = ptdValorHora.encontrarTodos();
    }
    
    public void actionParametro(int parametro, String opcion) {
        bgesAsignacion.cancel();
        actualizarProceso3();
        this.parametro = parametro;
        this.opcion = opcion;
        contenido = tipo = null;
        flag = false;
        clase = ptdClases.encontrar(parametro);
        if(parametro != 0) {
            action();
        }
    }
    
    public boolean isInicio() {
        if(!flag && parametro != 0) {
            return false;
        }
        if(flag) {
            return false;
        }
        return true;
    }
    
    public boolean isTermino() {
        return termino;
    }
    
    public boolean isActRojo() {
        return actRojo;
    }
    
    public boolean isActAmarillo() {
        return actAmarillo;
    }
    
    public boolean isActVerde() {
        return actVerde;
    }
    
    public boolean isProRojo() {
        return proRojo;
    }
    
    public boolean isProAmarillo() {
        return proAmarillo;
    }
    
    public boolean isProVerde() {
        return proVerde;
    }
    
    public List<ProyActs> getProyActs() {
        selectProyAct();
        return proyActs;
    }
    
    private void selectProyAct() {
        if(proyActs != null && !proyActs.isEmpty()) {
            proyAct = proyActs.get(0);
        }
    }
    
    private ProyActs selectProyAct(ProyActs proyAct) {
        int index = proyActs.indexOf(proyAct);
        if(index == -1) {
            return null;
        } else {
            return proyActs.get(index);
        }
    }
    
    public ProyActs getProyAct() {
        return proyAct;
    }
    
    public void setProyAct(ProyActs proyAct) {
        this.proyAct = selectProyAct(proyAct);
    }
    
    public CronoProye getCronoProye() {
        return cronoProye;
    }
    
    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        selectClase();
        return clases;
    }
    
    private void selectClase() {
        if(clase == null) {
            clase = clases.get(0);
        }
        if(!clase.getProyectosList().isEmpty()) {
            proyecto = clase.getProyectosList().get(0);
        }
    }
    
    public List<Proyectos> getProyectos() {
        return clase.getProyectosList();
    }
    
    public void setProyecto(Proyectos proyecto) {
        this.proyecto = proyecto;
    }
    
    public Proyectos getProyecto() {
        return proyecto;
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
    
    public Actividades getActComp() {
        return actComp;
    }
    
    public List<SelectComp> getSelectComps() {
        selectComps = new ArrayList<SelectComp>();
        List<Componentes> componentes = ptdComponentes.encontrarPorProyecto(proyecto);
        for(Componentes c : componentes) {
            selectComps.add(new SelectComp(true, c));
        }
        return selectComps;
    }
    
    private void crearProyecto() {
        proyecto = null;
        proyAct = null;
        compPar = null;
        iteratorRel = relaciones.iterator();
        if(iteratorRel.hasNext()) {
            relacion = iteratorRel.next();
            procesarActividad();
            siguienteSecuencia();
        }
    }
    //David 02/10/2015
    
    public void traerEstado(ProyActs proyAct){
        cronoProye = getCronoProye(proyAct.getProyActsPK());
        trabajarProyecto(proyAct);
    }
    
    public void traerEstadoAct(CronoProye cronoProye){
        this.cronoProye = cronoProye;
        actualizarProceso5();
    }
    
    
    protected void trabajarProyecto(ProyActs proyAct) {
        this.proyAct = proyAct;
        proyecto = proyAct.getProyectos();
        relaciones = proyAct.getClases().getRelacionesList();
        if(compPar == null) {
            List<ProyActs> pryComp = ptdProyActs.encontrarCompPar();
            compPar = new CompPar(pryComp, relaciones, ptdProyActs);
        }
        irActividad(proyAct.getClases(), proyAct.getEtapas(), proyAct.getActividades());
        siguienteSecuencia();
        flag = true;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public String getOpcion() {
        return opcion;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getContenido() {
        return contenido;
    }
    
    public String getDoc() {
        return doc;
    }
    
    public void setDoc(String doc) {
        this.doc = doc;
    }
    
    
    
    public String action() {
        relaciones = clase.getRelacionesList();
        if(!relaciones.isEmpty()) {
            crearProyecto();
            flag = true;
        } else {
            UtileriaHTTP.addMessage(null, "No existen actividades para trabajar.",
                    FacesMessage.SEVERITY_INFO);
        }
        return null;
    }
    
    private String opcion(char c) {
        switch(c) {
            case 'C': return "2";
            case 'R':
            case 'W':
            case 'Z':
                return "5";
            case 'G': return "6";
            default: return null;
        }
    }
    
    private void filtrar(List<ProyActs> prs) {
        PermisosAct permiso = new PermisosAct();
        for(ProyActs p : prs) {
            if(permiso.permiso(p, proUsuCod)) {
                proyActs.add(p);
            }
        }
    }
    
    private void ingresar() {
        proyActs = new ArrayList<ProyActs>();
        List<ProyActs> prs = ptdProyActs.encontrarActDisp(proyecto);
        filtrar(prs);
        if(proyActs.size() == 1) {
            proyAct = proyActs.get(0);
        } else if(!proyActs.isEmpty()) {
            tipo = "4";
            return;
        } else {
            UtileriaHTTP.addMessage(null, "Acceso denegado, no tiene permiso para trabajar la actividad",
                     FacesMessage.SEVERITY_ERROR);
            return;
        }
        irActividad(proyAct.getClases(), proyAct.getEtapas(), proyAct.getActividades());
        siguienteSecuencia();
    }
    
    private void procesarActividad() {
        clase = relacion.getClases();
        etapa = relacion.getRelEtpCodFk();
        actividad = relacion.getRelActCodFk();
        pais = obtenerPais(actividad.getActCodPaiFk());
        if(proyAct != null) {
            actualizarProceso1();
        }
        List<Secuencia> secuencias = new ArrayList<Secuencia>();
        Secuencia secuencia = null;
        Iterator<ActItems> items = actividad.getActItemsList().iterator();
        ActItems actItem;
        while(items.hasNext()) {
            actItem = items.next();
            ItemValues iv = new ItemValues(actItem, getProyItems(actItem.getAcitmItmCodFk()));
            if(actItem.getAcitmItmCodFk().getItmConten().equals("C")
                    || actItem.getAcitmItmCodFk().getItmConten().equals("R")
                    || actItem.getAcitmItmCodFk().getItmConten().equals("W")
                    || actItem.getAcitmItmCodFk().getItmConten().equals("Z")
                    || actItem.getAcitmItmCodFk().getItmConten().equals("G")) {
                if(actItem.getAcitmItmCodFk().getItmCodTab() != null) {
                    if(secuencia == null) {
                        secuencia = new Secuencia("1", actItem.getAcitmItmCodFk().getItmConten());
                    }
                    secuencia.getItemValues().add(iv);
                }
                if(secuencia != null) {
                    secuencias.add(secuencia);
                }
                secuencia = new Secuencia(opcion(actItem.getAcitmItmCodFk().getItmConten().charAt(0)),
                        actItem.getAcitmItmCodFk().getItmConten());
                secuencia.getItemValues().add(iv);
                secuencias.add(secuencia);
                secuencia = null;
                continue;
            }
            if(secuencia == null) {
                secuencia = new Secuencia("1", actItem.getAcitmItmCodFk().getItmConten());
            }
            secuencia.getItemValues().add(iv);
            if(actItem.getAcitmItmCodFk().getItmDesc().equals("S")) {
                secuencias.add(secuencia);
                secuencia = null;
            }
        }
        if(secuencia != null) {
            secuencias.add(secuencia);
        }
        this.secuencias = secuencias.iterator();
    }
    
    public Actividades getActividad() {
        return actividad;
    }
    
    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    } 
    
    public Clases getClase() {
        return clase;
    }
    
    public void setClase(Clases clase) {
        int index = clases.indexOf(clase);
        this.clase = clases.get(index);
    }
    
    public Etapas getEtapa() {
        return etapa;
    }
    
    public void setEtapa(Etapas etapa) {
        this.etapa = etapa;
    }
    
    public List<ItemValues> getItemsValues() {
        return itemValues;
    }
    
    public List<Alfanumericas> obtenerTablasAlfa(Integer alfCodPk) {
        return ptdAlfanumericas.encontrarPorCodigo(alfCodPk);
    }
    
    public List<Numericas> obtenerTablasNum(Integer numCodPk) {
        return ptdNumericas.encontrarPorCodigo(numCodPk);
    }
    
    private String resActividades(List<String> actividades) {
        StringBuilder sb = new StringBuilder();
        for(String act : actividades) {
            sb.append(act);
            sb.append(", ");
        }
        return sb.toString();
    }
    
    public String iconos() {
        if(tempTipo == null) {
            tempTermino = termino;
            termino = false;
            tempTipo = tipo;
        }
        tipo = UtileriaHTTP.getParameter("tipo");
        return null;
    }
    
    public String iconos(String tipo) {
        if(tempTipo == null) {
            tempTermino = termino;
            termino = false;
            tempTipo = this.tipo;
        }
        this.tipo = tipo;
        return null;
    }
    
    private void volver() {
        if(tipo.equals("2")) {
            bgesComponentes.action();
            List<String> acts = bgesComponentes.getActividadComponentes();
            if(!acts.isEmpty()) {
                UtileriaHTTP.addMessage(null, "Las actividades " + resActividades(acts)
                          + "no se le asignaron componentes",
                          FacesMessage.SEVERITY_ERROR);
                return;
            }
        }
        termino = tempTermino;
        tipo = tempTipo;
        tempTipo = null;
    }
    
    public String continuar() {
        boolean conti = true;
        if(tempTipo != null) {
            volver();
            return null;
        }
        try {
            if(proyecto == null) {
                crearProyecto(itemValues.get(0).getProyItem().getPryValorNum().intValue(),
                    itemValues.get(1).getProyItem().getPryValorAlfa());
            }
            if(tipo.equals("1")) {
                guardarItems(true);
            } else if(tipo.equals("2")) {
                bgesComponentes.action();
                List<String> acts = bgesComponentes.getActividadComponentes();
                if(!acts.isEmpty()) {
                    UtileriaHTTP.addMessage(null, "Las actividades " + resActividades(acts)
                            + "no se le asignaron componentes",
                            FacesMessage.SEVERITY_ERROR);
                    return null;
                }
            } else if(tipo.equals("4")) {
                int index = proyActs.indexOf(proyAct);
                proyAct = proyActs.get(index);
                irActividad(proyAct.getClases(), proyAct.getEtapas(), proyAct.getActividades());
            } else if(tipo.equals("5")) {
                bgesAsignacion.action();
                List<String> acts = bgesAsignacion.getAsignados();
                if(!acts.isEmpty()) {
                    UtileriaHTTP.addMessage(null, "Las actividades " + resActividades(acts)
                            + "no se le asignaron responsables",
                            FacesMessage.SEVERITY_ERROR);
                    return null;
                }
            } else if(tipo.equals("6")) {
                if (!bgesCronoProye.action() ) {
                    UtileriaHTTP.addMessage(null, "Debe seleccionar fecha inicio y fecha final",
                            FacesMessage.SEVERITY_ERROR);
                    conti = false;
                    
                }
            } else if(tipo.equals("7")) {
                if(!bgesDocumentos.action()) {
                    UtileriaHTTP.addMessage(null, "Debe escoger un archivo digitalizado",
                            FacesMessage.SEVERITY_ERROR);
                    return null;
                } else if(actCodPk != null && clsCodFk != null && etpCodFk != null) {
                    irActividad();
                    actCodPk = null;
                    clsCodFk = null;
                    etpCodFk = null;
                }
            }
            if(conti){
                siguienteSecuencia();
            }
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, "Error al intentar actualizar actividad",
                     FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean isRetornar() {
        return cronoProye == null || tempTipo != null;
    }
    
    public void onSlideEnd(SlideEndEvent event) {
        cronoProye.setCroproPorRea(new BigDecimal(event.getValue()));
    }
    
    public String progreso() {
        ptdCronoProye.actualizar(cronoProye);
        actualizarProceso4();
        actualizarProceso5();
        return null;
    }
    
    public String cancelar() {
        if(cronoProye != null) {
            progreso();
        }
        if(tempTipo != null) {
            tipo = tempTipo;
            tempTipo = null;
        } else {
            if(tipo.equals("7")) {
                bgesDocumentos.borrarTemporal();
                actCodPk = null;
                clsCodFk = null;
                etpCodFk = null;
            }
            actionParametro(parametro, opcion);
        }
        return null;
    }
    
    public void close() {
        if(tipo != null && tipo.equals("7")) {
            bgesDocumentos.borrarTemporal();
            actCodPk = null;
            clsCodFk = null;
            etpCodFk = null;
        }
        actionParametro(parametro, opcion);
    }
    
    private void siguienteSecuencia() {
        if(doc != null) {
            tipo = "7";
            return;
        }
        if(secuencias.hasNext()) {
            Secuencia s = secuencias.next();
            termino = !secuencias.hasNext();
            if(jump) {
                jump = false;
                siguienteSecuencia();
            } else {
                tipo = s.getTipo();
                contenido = s.getContenido();
                itemValues = s.getItemValues();
            }
            if(cronoProye != null) {
                actualizarProceso4();
                actualizarProceso5();
            }
        }
    }
    
    private boolean autorizaciones() {
        Long l = ptdResponsables.encontrarCantidadAutoriz(proyecto, clase, etapa, actividad);
        if(actividad.getActAutorizar() <= l.longValue()) {
            return true;
        } else {
            return false;
        }
    }
    
    public String terminar() {
        try {
            if(proyecto == null) {
                crearProyecto(itemValues.get(0).getProyItem().getPryValorNum().intValue(),
                    itemValues.get(1).getProyItem().getPryValorAlfa());
            }
            if(tipo.equals("1")) {
                guardarItems(true);
            } else if(tipo.equals("2")) {
                bgesComponentes.action();
                List<String> acts = bgesComponentes.getActividadComponentes();
                if(!acts.isEmpty()) {
                    UtileriaHTTP.addMessage(null, "Las actividades " + resActividades(acts)
                            + "no se le asignaron componentes",
                            FacesMessage.SEVERITY_ERROR);
                    return null;
                }
            } else if(tipo.equals("5")) {
                bgesAsignacion.action();
                List<String> actividades = bgesAsignacion.getAsignados();
                if(!actividades.isEmpty()) {
                    UtileriaHTTP.addMessage(null, "Las actividades " + resActividades(actividades)
                            + "no se le asignaron responsables",
                            FacesMessage.SEVERITY_ERROR);
                    return null;
                }
            } else if(tipo.equals("6")) {
                bgesCronoProye.action();
            } else if(tipo.equals("7")) {
                bgesDocumentos.borrarTemporal();
                actCodPk = null;
                clsCodFk = null;
                etpCodFk = null;
            }
            if(doc != null) {
                tipo = "7";
            } else if (flagSig) {
                flagSig = false;
                siguienteSecuencia();
            } else if(autorizaciones()) {
                    siguienteActividad();
            } else {
                UtileriaHTTP.addMessage(null, "Faltan autorizaciones",
                     FacesMessage.SEVERITY_ERROR);
                actionParametro(parametro, opcion);
            }
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, "Error al intentar actualizar actividad",
                     FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        }
        
        return null;
    }
    
    public String noTerminar() {
        try {
            if(proyecto == null) {
                crearProyecto(itemValues.get(0).getProyItem().getPryValorNum().intValue(),
                    itemValues.get(1).getProyItem().getPryValorAlfa());
            }
            if(tipo.equals("2")) {
                bgesComponentes.action();
            } else if(tipo != null && tipo.equals("3")) {
                if(!crearComponentes()) {
                    UtileriaHTTP.addMessage(null, "Debe seleccionar al menos un componente",
                     FacesMessage.SEVERITY_ERROR);
                }
            } else if(tipo.equals("5")) {
                bgesAsignacion.action();
            } else if(tipo.equals("6")) {
                bgesCronoProye.action();
            } else if(tipo.equals("7")) {
                bgesDocumentos.borrarTemporal();
                actCodPk = null;
                clsCodFk = null;
                etpCodFk = null;
            } else {
                guardarItems(false);
            }
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, "Error al intentar actualizar actividad",
                     FacesMessage.SEVERITY_ERROR);
            e.printStackTrace();
        } 
        actionParametro(parametro, opcion);
        return null;
    }
    
    private CronoProye getCronoProye(ProyActsPK ppk) {
        CronoProyePK cpk = new CronoProyePK(ppk.getPryProCodFk(), ppk.getPryClsCodFk(),
                ppk.getPryEtpCodFk(), ppk.getPryActCodFk(), ppk.getPryComNomFk(),
                ppk.getPryComTipFk());
        return ptdCronoProye.encontrar(cpk);
    }
    
    private int getPorcentaje(long h1, long h2) {
        return (int)Math.round((double)h1*100.0/(double)h2);
    }
    
    private ValorHora obtenerValorHora(Date d) {
        ValorHora vHora = null;
        for(ValorHora vh: valorHoras) {
            if(vh.getActividades().equals(actividad) && (vh.getValorHoraPK().getValhoUsuCod().equals(proUsuCod)
                    || vh.getValorHoraPK().getValhoUsuCod().equals(" "))) {
                if(vHora == null || (vHora.getValorHoraPK().getValhoUsuCod().equals(" ") && vh.getValorHoraPK().getValhoUsuCod().equals(proUsuCod))) {
                    vHora = vh;
                } else if((vHora.getValorHoraPK().getValhoUsuCod().equals(" ") && vh.getValorHoraPK().getValhoUsuCod().equals(" "))
                        || (vHora.getValorHoraPK().getValhoUsuCod().equals(proUsuCod) && vh.getValorHoraPK().getValhoUsuCod().equals(proUsuCod))) {
                    vHora = (vh.getValorHoraPK().getValhoFecha().after(vHora.getValorHoraPK().getValhoFecha())
                            && vh.getValorHoraPK().getValhoFecha().compareTo(d) <= 0) ? vh : vHora;
                }
            }
        }
        return vHora;
    }
    
    private void actualizarProceso(List<ProyActs> proys) {
        for(ProyActs p : proys) {
            p.setPryEstado("R");
        }
        ptdProyActs.actualizar(proys);
    }
    
    private void actualizarProceso(Date d) {
        cronoProye.setCroproFefRea(d);
        long t = CalculoTime.getTimeMinutos(pais, cronoProye.getCroproFeiRea(), d, actividad.getActFes().equals("S"));
        long t2 = CalculoTime.getTimeMinutos(pais, cronoProye.getCroproFeiPla(), cronoProye.getCroproFefPla(), actividad.getActFes().equals("S"));
        cronoProye.setCroproTieAtr(new Long(t-t2));
        cronoProye.setCroproTieRea(new Long(t));
        cronoProye.setCroproPorRea(new BigDecimal(100));
        int porcentaje = getPorcentaje(t, t2);
        cronoProye.setCroproPorCumpl(new BigDecimal(porcentaje));
        if(cronoProye.getCroproVahPla() != null) {
            long c = (long)((double)cronoProye.getCroproVahPla()*(double)t/60.0);
            cronoProye.setCroproCosRea(new Long(c));
        }
        ptdCronoProye.actualizar(cronoProye);
    }
    
    private void actualizarProceso1() {
        if(proyAct.getPryEstado().equals("D")) {
            proyAct.setPryEstado("P");
            cronoProye = getCronoProye(proyAct.getProyActsPK());
            if(proyAct.getPryEntrada() == null) {
                Date d = new Date();
                proyAct.setPryEntrada(d);
                proyAct.setPryUsuEnt(proUsuCod);
                if(cronoProye != null) {
                    cronoProye.setCroproFeiRea(d);
                    cronoProye.setCroproPorRea(new BigDecimal(0));
                    cronoProye.setCroproFefRea(null);
                    ValorHora v = obtenerValorHora(d);
                    if(v != null) {
                        cronoProye.setCroproVahPla(v.getValhoValor());
                        long c = (long)((double)cronoProye.getCroproVahPla()*(double)cronoProye.getCroproTiePla()/60.0);
                        cronoProye.setCroproCosPla(new Long(c));
                    }
                    ptdCronoProye.actualizar(cronoProye);
                }
            }
            if(cronoProye != null) {
                actualizarProceso4();
                actualizarProceso5();
            }
            ptdProyActs.actualizar(proyAct);
        }
    }
    
    private void actualizarProceso2() {
        doc = null;
        if(proyAct != null) {
            proyAct.setPryEstado("T");
            Date d = new Date();
            proyAct.setPrySalida(d);
            proyAct.setPryUsuSal(proUsuCod);
            ptdProyActs.actualizar(proyAct);
            if(cronoProye != null) {
                actualizarProceso(d);
                cronoProye = null;
                proRojo = proAmarillo = proVerde = actRojo = actAmarillo = actVerde = false;
            }
        }
    }
    
    public void actualizarProceso3() {
        if(proyAct != null && proyAct.getPryEstado().equals("P")) {
            contenido = tipo = null;
            proyAct.setPryEstado("D");
            ptdProyActs.actualizar(proyAct);
            proyAct = null;
            cronoProye = null;
            proRojo = proAmarillo = proVerde = actRojo = actAmarillo = actVerde = false;
        }
    }
    
    private void actualizarProceso4() {
        proRojo = proAmarillo = proVerde = false;
        Date d = new Date();
        long p = CalculoTime.getTimeMinutos(pais, cronoProye.getCroproFeiPla(), cronoProye.getCroproFefPla(), actividad.getActFes().equals("S"));
        long r = CalculoTime.getTimeMinutos(pais, cronoProye.getCroproFeiPla(), new Date(), actividad.getActFes().equals("S"));
        int porcentaje = getPorcentaje(r, p);
        int res = cronoProye.getCroproPorRea().compareTo(new BigDecimal(porcentaje));
        proyFormato = diferencia(cronoProye.getCroproFefPla().getTime()-cronoProye.getCroproFeiPla().getTime(),
                d.getTime()-cronoProye.getCroproFeiPla().getTime());
        if(res == -1) {
            proRojo = true;
        } else if(res == 0) {
            proAmarillo = true;
        } else {
            proVerde = true;
        }
    }
    
    private void actualizarProceso5() {
        actRojo = actAmarillo = actVerde = false;
        Date d = new Date();
        long p = CalculoTime.getTimeMinutos(pais, cronoProye.getCroproFeiPla(), cronoProye.getCroproFefPla(), actividad.getActFes().equals("S"));
        long r = CalculoTime.getTimeMinutos(pais, cronoProye.getCroproFeiRea(), d, actividad.getActFes().equals("S"));
        int porcentaje = getPorcentaje(r, p);
        actFormato = diferencia(cronoProye.getCroproFefPla().getTime()-cronoProye.getCroproFeiPla().getTime(),
                d.getTime()-cronoProye.getCroproFeiRea().getTime());
        if(cronoProye.getCroproPorRea().compareTo(new BigDecimal(porcentaje)) == -1) {
            actRojo = true;
        } else if(porcentaje >= actividad.getActPorAlert()) {
            actAmarillo = true;
        } else {
            actVerde = true;
        }
    }
    
    private void actualizarProceso6() {
        List<ProyActs> prys = ptdProyActs.encontrarPorRelacion(proyecto.getProCodPk());
        
        if(prys != null && !prys.isEmpty()) {
            String e = prys.get(0).getPryEstado();
            
            for(int i=1; i<prys.size(); i++) {
                ProyActs p = prys.get(i);
                if(e.equals("D") && p.getPryEstado().equals("T")) {
                    ptdProyActs.eliminar(p.getProyActsPK());
                } else {
                    e = p.getPryEstado();
                }
            }
            
        }
        
    }
    
    private String diferencia(long d1, long d2) {
        long dif = d1-d2;
        String formato = (dif < 0) ? "Atrasado " : "Faltan ";
        dif = Math.abs(dif);
        StringBuilder sb = new StringBuilder(formato);
        long d = dif/86400000;
        sb.append(d).append(" dias, ");
        dif -= (d*86400000);
        d = dif/3600000;
        sb.append(d).append(" horas, ");
        dif -= (d*3600000);
        d = dif/60000;
        sb.append(d).append(" minutos");
        return sb.toString();
    }
    
    public String getProyFormato() {
        return proyFormato;
    }
    
    public String getActFormato() {
        return actFormato;
    }
    
    
    
    private String paralelas() {
        StringBuilder sb = new StringBuilder();
        List<ProyActs> prs = ptdProyActs.encontrarNoTerminadas(proyecto);
        for(ProyActs p : prs) {
            sb.append(p.getActividades().getActDescrip());
            if(!p.getProyActsPK().getPryComNomFk().equals(" ")) {
                sb.append(" ").append(p.getProyActsPK().getPryComNomFk());
            }
            sb.append(", ");
        }
        return sb.toString();
    }
    
    private ProyActs crearProyAct(Clases cls, Etapas etp, Actividades act, String nom, Integer tip) {
        ProyActs p = new ProyActs(proyecto.getProCodPk(), cls.getClsCodPk(), etp.getEtpCodPk(),
                act.getActCodPk(), nom, tip);
        p.setProyectos(proyecto);
        p.setClases(cls);
        p.setEtapas(etp);
        p.setActividades(act);
        p.setPryEstado("D");
        return p;
    }
    
    private void crearProyAct() {
        proyAct = new ProyActs(proyecto.getProCodPk(), proyecto.getProClsCodFk().getClsCodPk(), proyecto.getProEtpCodFk().getEtpCodPk(),
                               proyecto.getProActCodFk().getActCodPk(), " ", 0);
        proyAct.setProyectos(proyecto);
        proyAct.setClases(proyecto.getProClsCodFk());
        proyAct.setEtapas(proyecto.getProEtpCodFk());
        proyAct.setActividades(proyecto.getProActCodFk());
        proyAct.setPryEstado("P");
        ptdProyActs.insertar(proyAct);
    }
    
    private void crearComponentes(List<ProyActs> proyActs) {
        for(ProyActs p : proyActs) {
            p.setPryEstado("D");
        }
    }
    
    private boolean crearComponentes() {
        boolean fg = false;
        for(SelectComp sc : selectComps) {
            if(sc.isSelect()) {
                crearProyAct(relacion.getClases(), relacion.getRelEtpCodFk(), actComp, sc.getComponente().getComponentesPK().getComNomPk(),
                        sc.getComponente().getComponentesPK().getComTipCodFk());
                fg = true;
            }
        }
        return fg;
    }
    
    private void crearSiguiente(Clases cls, Etapas etp, Actividades act) {
        List<ProyActs> prys = new ArrayList<ProyActs>();
        List<ProyActs> pryComp = new ArrayList<ProyActs>();
        if(act.getActComp().equals("N")) {
            prys.add(crearProyAct(cls, etp, act, " ", Integer.valueOf(0)));
        } else {
            List<ProyActs> prs = ptdProyActs.encontrarProyComp(proyecto, cls, etp, act);
            pryComp.addAll(prs);
        }
        for(Paralelas p : ptdParalelas.encontrar(cls, etp, act)) {
            if(p.getActividades().getActComp().equals("N")) {
                prys.add(crearProyAct(p.getClases1(), p.getEtapas1(), p.getActividades1(), " ", Integer.valueOf(0)));
            } else {
                List<ProyActs> prs = ptdProyActs.encontrarProyComp(proyecto, p.getClases1(), p.getEtapas1(), p.getActividades1());
                if(p.getParComp().equals("S")) {
                    pryComp.addAll(prs);
                } else {
                    crearComponentes(prs);
                    prys.addAll(prs);
                }
            }
        }
        if(!prys.isEmpty()) {
            ptdProyActs.actualizar(prys);
        }
        if(!pryComp.isEmpty()) {
            actualizarProceso(pryComp);
            compPar = new CompPar(pryComp, relaciones, ptdProyActs);
            compPar.activar();
        }
        
    }
    
    private boolean isContinua() {
        while(iteratorRel.hasNext()) {
            relacion = iteratorRel.next();
            Actividades act = relacion.getRelActCodFk();
            Long n = ptdProyActs.encontrarCountAct(proyecto, act);
            if(n > 0) {
                continue;
            }
            crearSiguiente(relacion.getClases(), relacion.getRelEtpCodFk(), act);
            if(act.getActEnlace().equals("C")) {
                relacion.setRelActCodFk(act);
                return true;
            } else {
                break;
            }
        }
        return false;
    }
    
    private void siguienteActividad() {
        termino = false;
        if(proyAct != null) {
            actualizarProceso2();
        }
        if(compPar != null) {
            compPar.activar(proyAct);
        }
        String par = paralelas();
        if(!par.isEmpty()) {
            UtileriaHTTP.addMessage(null, "Las actividades " + par + "no han terminado",
                    FacesMessage.SEVERITY_INFO);
            actionParametro(parametro, opcion);
            return;
        }
        
        Relaciones rel = new Relaciones(new RelacionesPK());
        rel.setClases(clase);
        rel.setRelEtpCodFk(etapa);
        rel.setRelActCodFk(actividad);
        
        int index = relaciones.indexOf(rel);
        Actividades act = relaciones.get(index+1).getRelActCodFk();
        
        if(act.getActEstado().equals("S")) {
            ptdProyActs.actualizar(proyecto);
            ptdResponsables.actualizar(proyecto);
            continua = false;
        } else {
            if(proyAct != null) {
                ptdResponsables.actualizar(proyecto, proyAct.getClases(), proyAct.getEtapas(), proyAct.getActividades(), proyAct.getProyActsPK().getPryComNomFk(), proyAct.getProyActsPK().getPryComTipFk());
                proyAct = null;
            }
            continua = isContinua();
        }
        if(continua) {
            ingresar();
        } else {
            UtileriaHTTP.addMessage(null, "Actividad " + actividad.getActDescrip() + " finalizada.",
                        FacesMessage.SEVERITY_INFO);
            actionParametro(parametro, opcion);
        }
    }
    
    private void irActividad(Clases clase, Etapas etapa, Actividades actividad) {
        actualizarProceso6();
        Relaciones rel = new Relaciones(new RelacionesPK());
        rel.setClases(clase);
        rel.setRelEtpCodFk(etapa);
        rel.setRelActCodFk(actividad);
        int index = relaciones.indexOf(rel);
        iteratorRel = relaciones.subList(index, relaciones.size()).iterator();
        if(iteratorRel.hasNext()) {
            relacion = iteratorRel.next();
            procesarActividad();
        }
    }
    
    private void crearProyecto(Integer proCodPk, String descrip) throws Exception {
        proyecto = new Proyectos();
        proyecto.setProActCodFk(actividad);
        proyecto.setProClsCodFk(clase);
        proyecto.setProCodPk(proCodPk);
        proyecto.setProDescrip(descrip);
        proyecto.setProEtpCodFk(etapa);
        Date fecha = new Date();
        proyecto.setProFechaHora(fecha);
        proyecto.setProUsuCodFk(proUsuCod);
        proyecto.setProEstado("V");
        ptdProyectos.insertar(proyecto);
        crearProyAct();
    }
    
    private ProyItems getProyItems(Items item) {
        ProyItems p = new ProyItems(new ProyItemsPK());
        p.getProyItemsPK().setPryItmCodFk(item.getItmCodPk());
        if(proyAct != null) {
            p.getProyItemsPK().setPryProCodFk(proyAct.getProyectos().getProCodPk());
            p.getProyItemsPK().setPryComNomFk(proyAct.getProyActsPK().getPryComNomFk());
            p.getProyItemsPK().setPryComTipFk(proyAct.getProyActsPK().getPryComTipFk());
            ProyItems pitm = ptdProyItems.encontrar(p.getProyItemsPK());
            if(pitm != null) {
                p = pitm;
            } else {
                p.getProyItemsPK().setPryComNomFk(" ");
                p.getProyItemsPK().setPryComTipFk(0);
                pitm = ptdProyItems.encontrar(p.getProyItemsPK());
                if(pitm != null) {
                    p = pitm;
                    p.getProyItemsPK().setPryComNomFk(proyAct.getProyActsPK().getPryComNomFk());
                    p.getProyItemsPK().setPryComTipFk(proyAct.getProyActsPK().getPryComTipFk());
                }
            }
        } else {
            p.getProyItemsPK().setPryComNomFk(" ");
            p.getProyItemsPK().setPryComTipFk(0);
        }
        if(item.getItmConsecCodFk() != null) {
            int c = item.getItmConsecCodFk().getConsecValor().intValue();
            p.setPryValorNum(new BigDecimal(c));
            item.getItmConsecCodFk().setConsecValor(BigInteger.valueOf(++c));
            ptdConsecutivos.actualizar(item.getItmConsecCodFk());
        }
        return p;
    }
    
    private void guardarItems(boolean flag) {
        ItemValues itemVal = null;
        List<ProyItems> proyItems = new ArrayList<ProyItems>();
        for(ItemValues itemValue : itemValues) {
            if(itemValue.getActItem().getAcitmItmCodFk().getItmCodTab() != null) {
                itemVal = itemValue;
            }
            ProyItems p = itemValue.getProyItem();
            p.getProyItemsPK().setPryProCodFk(proyecto.getProCodPk());
            p.setProyectos(proyecto);
            p.setItems(itemValue.getActItem().getAcitmItmCodFk());
            proyItems.add(p);
        }
        if(!proyItems.isEmpty()) {
            ptdProyItems.actualizar(proyItems);
        }
        if(itemVal != null && flag) {
            if(itemVal.getActItem().getAcitmItmCodFk().getItmDato().equals("N")) {
                irRelacion(itemVal.getActItem().getAcitmItmCodFk(),
                        itemVal.getProyItem().getPryValorNum());
            } else if(itemVal.getActItem().getAcitmItmCodFk().getItmDato().equals("V")) {
                irRelacion(itemVal.getActItem().getAcitmItmCodFk(),
                        itemVal.getProyItem().getPryValorAlfa());
            }
        }
    }
    
    private void autorizar(String autoriza) {
        ResponsablesPK pk = new ResponsablesPK(proyAct.getProyectos().getProCodPk(),
                proyAct.getClases().getClsCodPk(),
                proyAct.getEtapas().getEtpCodPk(),
                proyAct.getActividades().getActCodPk(),
                proUsuCod, proyAct.getProyActsPK().getPryComNomFk(),
                proyAct.getProyActsPK().getPryComTipFk());
        Responsables resp = ptdResponsables.encontrar(pk);
        if(resp != null) {
            resp.setResAutoriz(autoriza);
            ptdResponsables.actualizar(resp);
        }
    }
    
    private void irRelacion(Items item, BigDecimal numValor) {
        Numericas n = ptdNumericas.encontrar(new NumericasPK(item.getItmCodTab(), numValor));
        doc = n.getNumDocumentoFk();
        if(!n.getNumAutoriza().equals(" ")) {
            autorizar(n.getNumAutoriza());
        }
        if(n.getNumActCodFk() != null && n.getNumClsCodFk() != null && n.getNumEtpCodFk() != null) {
            actCodPk = n.getNumActCodFk().getActCodPk();
            clsCodFk = n.getNumClsCodFk();
            etpCodFk = n.getNumEtpCodFk();
            
            if(doc == null) {
                irActividad();
                actCodPk = null;
                clsCodFk = null;
                etpCodFk = null;
            } else {
                siguienteSecuencia();
            }
        } else if(!item.getItmConten().equals("T") && n.getNumConten() == null) {
            jump = true;
        }
    }
    
    private void irRelacion(Items item, String alfValor) {
        Alfanumericas alf = ptdAlfanumericas.encontrar(new AlfanumericasPK(item.getItmCodTab(), alfValor));
        doc = alf.getAlfDocumentoFk();
        if(!alf.getAlfAutoriza().equals(" ")) {
            autorizar(alf.getAlfAutoriza());
        }
        if(alf.getAlfActCodFk() != null && alf.getAlfClsCodFk() != null && alf.getAlfEtpCodFk() != null) {
            actCodPk = alf.getAlfActCodFk().getActCodPk();
            clsCodFk = alf.getAlfClsCodFk();
            etpCodFk = alf.getAlfEtpCodFk();
            
            if(doc == null) {
                irActividad();
                actCodPk = null;
                clsCodFk = null;
                etpCodFk = null;
            } else {
                siguienteSecuencia();
            }
        } else if(!item.getItmConten().equals("T") && alf.getAlfConten() == null) {
            jump = true;
        }
    }
    
    private void irActividad() {
        flagSig = true;
        actualizarProceso2();
        Actividades act = ptdActividades.encontrar(actCodPk);
        crearSiguiente(clsCodFk, etpCodFk, act);
        if(act.getActEnlace().equals("C")) {
            continua = true;
            proyAct = ptdProyActs.encontrar(new ProyActsPK(this.proyecto.getProCodPk(),
                                                           clsCodFk.getClsCodPk(),
                                                           etpCodFk.getEtpCodPk(),
                                                           act.getActCodPk(),
                                                           " ", 0));
            irActividad(clsCodFk, etpCodFk, act);
        } else {
            continua = false;
            actionParametro(parametro, opcion);
            UtileriaHTTP.addMessage(null, "Actividad " + actividad.getActDescrip() + " finalizada.",
                FacesMessage.SEVERITY_INFO);
        }
    }
    
    public List<Relaciones> getRelaciones() {
        return relaciones;
    }
    
    public Relaciones getRelacion() {
        return relacion;
    }
    
    public int getWidth(int tam) {
        int s = tam*8;
        if(s > 328) {
            return 328;
        } else {
            return s;
        }
    }
    
    public Long getAutorizadas() {
        return ptdResponsables.encontrarCantidadAutoriz(proyecto, clase, etapa, actividad);
    }
    
    public Long getNoAutorizadas() {
        return ptdResponsables.encontrarCantidadNoAutoriz(proyecto, clase, etapa, actividad);
    }

    void verProyect(Proyectos proyecto) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
