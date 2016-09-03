/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import jpa.valores.Empleados;
import jpa.valores.Usuarios;
import jpa.valores.PoliticaGrupos;
import jsf.beans.generales.Encriptacion;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdEmpleados;
import jsf.controlador.PtdUsuarios;
import jsf.controlador.PtdPoliticaGrupos;
import jsf.beans.generales.BGenErrores;

@ManagedBean(name = "bgesUsuarios")
@SessionScoped
public class BGesUsuarios implements Serializable {
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private PtdPoliticaGrupos ptdPoliticaGrupos = new PtdPoliticaGrupos();
    private PtdEmpleados ptdEmpleados = new PtdEmpleados();
    private Usuarios usuario;
    private Usuarios uUsuario;
    private Usuarios cUsuario = new Usuarios();
    private List<Usuarios> usuarios;
    private List<PoliticaGrupos> politicas;
    private List<Empleados> empleados;
    private String usuUsuCod;
    private UIInput inputCodigo;
    private String opcion = "1";
    private List<String> columnas;
    
    public BGesUsuarios() {
        init();
        usuUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
        usuarios = ptdUsuarios.encontrarTodos();
        if(!usuarios.isEmpty()) {
            usuario = usuarios.get(0);
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
        columnas.add("18");
        columnas.add("19");
        columnas.add("20");
        cUsuario.setUsuEstado("A");
        cUsuario.setUsuNumIntent(new Short("0"));
    }
    
    
    private void init() {
        cUsuario.setUsuIndGes("S");
        cUsuario.setUsuIndAut("N");
        cUsuario.setUsuIndCons("N");
        cUsuario.setUsuAccRep("N");
        cUsuario.setUsuTipAccAct("N");
        cUsuario.setUsuTipAccCon("N");
        
    }
    
    public Usuarios getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
    public Usuarios getUUsuario() {
        return uUsuario;
    }
    
    public void setUUsuario(Usuarios uUsuario) {
        this.uUsuario = uUsuario;
    }
    
    public Usuarios getCUsuario() {
        return cUsuario;
    }
    
    public void setCUsuario(Usuarios cUsuario) {
        this.cUsuario = cUsuario;
    }
    
    public List<Usuarios> getUsuarios() {
        usuarios = ptdUsuarios.encontrarTodos();
        selectUsuario();
        return usuarios;
    }
    
    private void selectUsuario() {
        if(usuario == null && !usuarios.isEmpty()) {
            usuario = usuarios.get(0);
        } else if (!usuarios.isEmpty()) {
            int index = usuarios.indexOf(usuario);
            if(index == -1) {
                usuario = usuarios.get(0);
            } else {
                usuario = usuarios.get(index);
            }
        }
    }
    
    public List<PoliticaGrupos> getPoliticaGrupos() {
        politicas = ptdPoliticaGrupos.encontrarPoliticaGrupos();
        return politicas;
    }
    
    public List<Empleados> getEmpleados() {
        empleados = ptdEmpleados.encontrarNoUsuarios();
        return empleados;
    }
    
    public String getOpcion() {
        return opcion;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
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
    
    public String crear() {
        try {
            Date d = new Date(0);
            cUsuario.setUsuFechaClave(d);
            cUsuario.setUsuClaveEncrip(Encriptacion.md5(cUsuario.getUsuCodPk()));
            ptdUsuarios.insertar(cUsuario);
             UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(102),
                     FacesMessage.SEVERITY_INFO);
             usuario = cUsuario;
             cUsuario = new Usuarios();
             init();
             cUsuario.setUsuEstado("A");
             cUsuario.setUsuNumIntent(Short.valueOf("0"));
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, 
                   bgenErrores.obtenerError(105), FacesMessage.SEVERITY_FATAL);
            e.printStackTrace();
        }
        return null;
    }

    public String actualizar() {
        
        validar();
        
        ptdUsuarios.actualizarUsuario(uUsuario);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(103),
                     FacesMessage.SEVERITY_INFO);
        usuario.setUsuPolGrupFk(seleccionarPoliticas(usuario.getUsuPolGrupFk()));
        System.out.println(" politica grupo" + usuario.getUsuPolGrupFk() );
        usuario = uUsuario;
        System.out.println(" usuario " + usuario );
        return null;
                
    }

    public String eliminar() {
        try {
        usuario.setUsuEstado("E");
        ptdUsuarios.actualizarUsuario(usuario);
        UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(104),
                     FacesMessage.SEVERITY_INFO);
        } catch(Exception e) {
            UtileriaHTTP.addMessage(null, bgenErrores.obtenerError(106),
                     FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }
    
    private PoliticaGrupos seleccionarPoliticas(PoliticaGrupos p) {
        System.out.println(" politica" + p);
        int index = politicas.indexOf(p);
        System.out.println(" politicaindex" + index);
        return politicas.get(index);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        return null;
    }
    
        
    private void validar() {
        
        
        Usuarios u = ptdUsuarios.validarUsuario(uUsuario.getUsuCodPk());
       
        if((u.getUsuEstado().equals("I") || u.getUsuEstado().equals("B")) &&
                uUsuario.getUsuEstado().equals("A")) {
            
            uUsuario.setUsuFechaClave(new Date(0));
            uUsuario.setUsuClaveEncrip(Encriptacion.md5(uUsuario.getUsuCodPk()));
        }
        if(!u.getUsuPolGrupFk().equals(uUsuario.getUsuPolGrupFk())) {
            
            uUsuario.setUsuFechaClave(new Date(0));
            uUsuario.setUsuClaveEncrip(Encriptacion.md5(uUsuario.getUsuCodPk()));
        }
    }
    
    public void mostrar() {
        uUsuario = usuario;
        
    }
}
