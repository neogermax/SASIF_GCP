package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import jpa.valores.Clases;
import jpa.valores.Contactos;
import jpa.valores.CronoProye;
import jpa.valores.EmpleadosPK;
import jpa.valores.ProyActs;
import jpa.valores.ProyItems;
import jpa.valores.Proyectos;
import jpa.valores.Responsables;
import jpa.valores.Usuarios;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdClases;
import jsf.controlador.PtdContactos;
import jsf.controlador.PtdCronoProye;
import jsf.controlador.PtdProyActs;
import jsf.controlador.PtdProyItems;
import jsf.controlador.PtdProyectos;
import jsf.controlador.PtdResponsables;
import jsf.controlador.PtdUsuarios;

/**
 *
 * @author analista03
 */
@ManagedBean(name = "bgesConsultGerencia")
@SessionScoped
public class BGesConsultaGerencia implements Serializable {

    private BGesNavegacion bgesNavegacion = ((BGesNavegacion) UtileriaHTTP.getBean("bgesNavegacion"));
    private PtdProyectos ptdProyectos = new PtdProyectos();
    private PtdProyItems ptdProyItems = new PtdProyItems();
    private PtdProyActs ptdProyActs = new PtdProyActs();
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private PtdResponsables ptdResponsables = new PtdResponsables();
    private PtdContactos ptdContactos = new PtdContactos();
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private List<Proyectos> proyectos;
    private List<Usuarios> usuarios;
    private List<Responsables> responsables;
    private Proyectos proyecto;
    private List<Clases> clases;
    private Clases clase;
    private Clases clas;
    private List<Contactos> contactos;
    private PtdClases ptdClases = new PtdClases();
    private List<String> columnas = new ArrayList<String>();
    private Date fecMac = new Date();
    private Date fecMin = new Date();
    private String filEstado;
    private String filtroSt;
    private boolean varClas;
    private int filClase;
    private String detalle = "verPagPrincipal";
    private List<ProyItems> items;
    private ProyItems item;
    private List<ProyActs> proyActs;
    private ProyActs proyAct;
    private List<ProyItems> pagItems;
    private List<CronoProye> listRespnsbls;
    private String proyFormato;

    public List<Contactos> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contactos> contactos) {
        this.contactos = contactos;
    }

    public String getProyFormato() {
        return proyFormato;
    }

    public void setProyFormato(String proyFormato) {
        this.proyFormato = proyFormato;
    }

    public List<ProyActs> getProyActs() {
        return proyActs;
    }

    public void setProyActs(List<ProyActs> proyActs) {
        this.proyActs = proyActs;
    }

    public List<ProyItems> getPagItems() {
        return pagItems;
    }

    public void setPagItems(List<ProyItems> pagItems) {
        this.pagItems = pagItems;
    }

    public List<ProyItems> getItems() {
        return items;
    }

    public ProyActs getProyAct() {
        return proyAct;
    }

    public void setProyAct(ProyActs proyAct) {
        this.proyAct = proyAct;
    }

    public void setItems(List<ProyItems> items) {
        this.items = items;
    }

    public ProyItems getItem() {
        return item;
    }

    public void setItem(ProyItems item) {
        this.item = item;
    }

    private Clases selectClas(Clases clase) {
        filClase = clase.getClsCodPk();
        return clase;
    }

    public Clases getClas() {
        return clas;
    }

    public void setClas(Clases clas) {
        this.clas = selectClas(clas);
    }

    public boolean isVarClas() {
        return varClas;
    }

    public void setVarClas(boolean varClas) {
        this.varClas = varClas;
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        int index = clases.indexOf(clase);
        this.clase = clases.get(index);
    }

    public List<Clases> getClases() {
        clases = ptdClases.encontrarTodos();
        selectClase();
        return clases;
    }

    private void selectClase() {
        if (clase == null) {
            clase = clases.get(0);
        }
        if (!clase.getProyectosList().isEmpty()) {
            proyecto = clase.getProyectosList().get(0);
        }
    }

    public void setClases(List<Clases> clases) {
        this.clases = clases;
    }

    public String getFiltroSt() {
        return filtroSt;
    }

    public void setFiltroSt(String filtroSt) {
        this.filtroSt = filtroSt;
    }

    public String getFilEstado() {
        return filEstado;
    }

    public void setFilEstado(String filEstado) {
        this.filEstado = filEstado;
    }

    public Date getFecMac() {
        return fecMac;
    }

    public void setFecMac(Date fecMac) {
        this.fecMac = fecMac;
    }

    public Date getFecMin() {
        return fecMin;
    }

    public void setFecMin(Date fecMin) {
        this.fecMin = fecMin;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BGesConsultaGerencia() {
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        columnas.add("5");
        columnas.add("6");
    }

    public List<String> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }

    public List<Proyectos> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<Proyectos> proyectos) {
        this.proyectos = proyectos;
    }

    public Proyectos getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyectos proyecto) {
        this.proyecto = proyecto;
    }
    private boolean value2;

    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

    public void acFilClas() {
        String summary = value2 ? "Checked" : "Unchecked";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }

    public void consultar() {
        proyectos = ptdProyectos.consultaGerencia1(filEstado, filClase, varClas, fecMin, fecMac);
    }

    public void seleccionar() {
        if (UtileriaHTTP.getParameter("detalle") != null) {
            detalle = UtileriaHTTP.getParameter("detalle");
        }

        if (detalle.equals("verActividades")) {
            String proy = UtileriaHTTP.getParameter("proyecto");//obtiene el id del proyecto
            Integer proCod = Integer.valueOf(proy);//le asigna el id a un integer
            Proyectos proyect = new Proyectos(proCod);//crea un objeto lista de proyectos con el id
            int index = proyectos.indexOf(proyect);//toma la posición del objeto que necesitamos
            if (index != -1) { //si el objeto existe
                proyecto = proyectos.get(index);//cree el objeto con todos sus respectivas variables
            }
            proyActs = ptdProyActs.encontrarPorRelacion(proCod);
            pagItems = new ArrayList<ProyItems>();
            for (ProyActs p : proyActs) {
                bgesNavegacion.traerEstado(p);
            }
        } else if (detalle.equals("verResponsables")) {
            String proy = UtileriaHTTP.getParameter("proyecto");//obtiene el id del proyecto
            Integer proCod = Integer.valueOf(proy);//le asigna el id a un integer
            Proyectos proyect = new Proyectos(proCod);//crea un objeto lista de proyectos con el id
            int index = proyectos.indexOf(proyect);//toma la posición del objeto que necesitamos
            if (index != -1) { //si el objeto existe
                proyecto = proyectos.get(index);//cree el objeto con todos sus respectivas variables
            }
            proyActs = ptdProyActs.encontrarPorRelacion(proCod);
            pagItems = new ArrayList<ProyItems>();
            for (ProyActs p : proyActs) {
                bgesNavegacion.traerEstado(p);
            }
        }
    }

    public List<ProyItems> itemPag(ProyActs proyAct) {
        Integer p = proyAct.getActividades().getActCodPk();
        pagItems = ptdProyItems.encontrarPorActItems(p, proyecto);
        return pagItems;
    }

    public List<CronoProye> lisTiempos() {
        Integer p = proyecto.getProCodPk();
        listRespnsbls = ptdCronoProye.encontrarProyecto(p);
        return listRespnsbls;
    }

    public String semaforoMini(Integer proy) {
        String url = "generales/images/semve.gif";
        proyFormato = "no hay información.";
        List<ProyActs> proyActi;
        ProyActs proyAc = new ProyActs();
        proyActi = ptdProyActs.encontrarUno(proy);
        for (ProyActs pa : proyActi) {
            proyAc = pa;
        }
        if (proyAc.getProyActsPK() != null) {
            bgesNavegacion.traerEstado(proyAc);
            if (bgesNavegacion.isProAmarillo()) {
                url = "generales/images/semam.gif";
            } else if (bgesNavegacion.isProRojo()) {
                url = "generales/images/semro.gif";
            } else {
                url = "generales/images/semve.gif";
            }
            proyFormato = bgesNavegacion.getProyFormato();
        }
        return url;
    }

    public String semaforoAct(CronoProye cronoProye) {
        String url;
        proyFormato = "no hay información.";
        bgesNavegacion.traerEstadoAct(cronoProye);
        if (bgesNavegacion.isActAmarillo()) {
            url = "generales/images/semam.gif";
        } else if (bgesNavegacion.isActRojo()) {
            url = "generales/images/semro.gif";
        } else {
            url = "generales/images/semve.gif";
        }
        proyFormato = bgesNavegacion.getActFormato();
        return url;
    }
    
    
    public List<Usuarios> traeResponsbls(CronoProye cronoProye){
        responsables = ptdResponsables.encontrarPorClase(cronoProye.getProyectos(), cronoProye.getClases(), cronoProye.getEtapas(), cronoProye.getActividades());
        usuarios = new ArrayList<Usuarios>();
        for(Responsables r : responsables){
            usuarios.add(ptdUsuarios.encontrarPorCod(r.getResponsablesPK().getResUsuCodFk()));
//            usuario = ptdUsuarios.encontrarPorCod(r.getResponsablesPK().getResUsuCodFk());
//            EmpleadosPK empleadoPK;
//            empleadoPK = usuario.getEmpleados().getEmpleadosPK();
//            contactos = ptdContactos.encontrarUno(empleadoPK);
        }
        return usuarios;
    }
    
    public List<Contactos> traerContactos(EmpleadosPK empleadoPK){
        contactos = ptdContactos.encontrarUno(empleadoPK);
        return contactos;
    }
}
