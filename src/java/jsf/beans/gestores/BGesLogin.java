/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import jpa.valores.Empleados;
import jpa.valores.HistoricoClaves;
import jpa.valores.Usuarios;
import jsf.beans.generales.BGenErrores;
import jsf.beans.generales.Encriptacion;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdUsuarios;

@ManagedBean(name = "bgesLogin")
@SessionScoped
public class BGesLogin implements Serializable {
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private BGenErrores bgenErrores = (BGenErrores)UtileriaHTTP.getBean("bgenErrores");
    private Usuarios usuarios;
    private Empleados empleado;
    private UIInput inputLogin;
    private UIInput inputPassword1;
    private String usuario; 
    private String password; 
    private String password1; 
    private String password2; 
    private String pagina = UtileriaHTTP.getProperty("pag", "login");
    private boolean autenticado;
    private List<HistoricoClaves> historicos;
    
    public Usuarios getUsuarios() {
        return usuarios;
    }
    
    public Empleados getEmpleado() {
        return empleado;
    }
    
    public boolean isAutenticado() {
        return autenticado;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String accionLogin()
    {
       usuarios = ptdUsuarios.validarUsuario(usuario);
       String msg;
       if(usuarios == null) {
           UtileriaHTTP.addMessage(inputLogin.getClientId(), 
                   bgenErrores.obtenerError(7), FacesMessage.SEVERITY_FATAL);
       } else if(!(msg = estado(usuarios.getUsuEstado().charAt(0))).equals("A")) {
           UtileriaHTTP.addMessage(inputLogin.getClientId(), msg, FacesMessage.SEVERITY_FATAL);
       } else if(!usuarios.getUsuClaveEncrip().equals(Encriptacion.md5(password))) {
           UtileriaHTTP.addMessage(inputLogin.getClientId(), 
                   intentos(), FacesMessage.SEVERITY_FATAL);
       } else if(validarVigencia(usuarios.getUsuFechaClave(), usuarios.getUsuPolGrupFk().getPolDiasVig())) {
           pagina = UtileriaHTTP.getProperty("pag", "cambio_claves");
           historicos = ptdUsuarios.encontrarHistoricos(usuario);
           autenticado = true;
           ingreso();
           UtileriaHTTP.refresh();
       } else {
           pagina = UtileriaHTTP.getProperty("pag", "inicio");
           ingreso();
           UtileriaHTTP.refresh();
       }
        return null; 
    }
    
    private boolean validarVigencia(Date d, Short v) {
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        c.add(Calendar.DATE, v);
        Calendar c1 = new GregorianCalendar();
        c1.setTime(new Date());
        return c.before(c1);
    }
    
    private String estado(char opc) {
        switch(opc) {
            case 'A': return "A";
            case 'I': return bgenErrores.obtenerError(8);
            case 'E': return bgenErrores.obtenerError(9);
            case 'B': return bgenErrores.obtenerError(10);
            default: return null;
        }
    }
    
    private String intentos() {
        int intento = usuarios.getUsuNumIntent() + 1;
        String msg;
        if(intento == usuarios.getUsuPolGrupFk().getPolIntentos()) {
            usuarios.setUsuNumIntent((short)0);
            usuarios.setUsuEstado("B");
            msg = bgenErrores.obtenerError(10);
        } else {
            usuarios.setUsuNumIntent((short)intento);
            msg = bgenErrores.obtenerError(11);
        }
        ptdUsuarios.actualizarUsuario(usuarios);
        return msg;
    }
    
    public void ingreso() {
        if(usuarios.getUsuNumIntent() > 0) {
            usuarios.setUsuNumIntent((short)0);
            ptdUsuarios.actualizarUsuario(usuarios);
        }
        empleado = usuarios.getEmpleados();
    }
    
    public String accionLogout() {
        HttpSession session = UtileriaHTTP.getSession(false);
        session.invalidate();
        return null;
    }
    
    public String cambiarContraseña() {
        String password = Encriptacion.md5(password1);
        if(validateCantidad()) {
            UtileriaHTTP.addMessage(inputPassword1.getClientId(), 
                   "Se permite minimo " + usuarios.getUsuPolGrupFk().getPolCanNum() + " numeros y " +
                   usuarios.getUsuPolGrupFk().getPolCanLet() + " letras"
                    , FacesMessage.SEVERITY_FATAL);
         } else if(validateRepetidos()) {
             UtileriaHTTP.addMessage(inputPassword1.getClientId(), 
                   bgenErrores.obtenerError(12), FacesMessage.SEVERITY_FATAL);
         } else if(validateHistoricos(password)) {
            UtileriaHTTP.addMessage(inputPassword1.getClientId(), 
                   bgenErrores.obtenerError(13), FacesMessage.SEVERITY_FATAL);
        } else {
            usuarios.setUsuClaveEncrip(password);
            ptdUsuarios.cambiarContraseña(usuarios);
            pagina = UtileriaHTTP.getProperty("pag", "inicio");
            autenticado = false;
            UtileriaHTTP.refresh();
        }
        return null;
    }

    /**
     * @return the pagina
     */
    public String getPagina() {
        return pagina;
    }

    /**
     * @return the inputLogin
     */
    public UIInput getInputLogin() {
        return inputLogin;
    }

    /**
     * @param inputLogin the inputLogin to set
     */
    public void setInputLogin(UIInput inputLogin) {
        this.inputLogin = inputLogin;
    }

    /**
     * @return the inputPassword1
     */
    public UIInput getInputPassword1() {
        return inputPassword1;
    }

    /**
     * @param inputPassword1 the inputPassword1 to set
     */
    public void setInputPassword1(UIInput inputPassword1) {
        this.inputPassword1 = inputPassword1;
    }

    /**
     * @return the password1
     */
    public String getPassword1() {
        return password1;
    }

    /**
     * @param password1 the password1 to set
     */
    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    /**
     * @return the password2
     */
    public String getPassword2() {
        return password2;
    }

    /**
     * @param password2 the password2 to set
     */
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    
    public void validatePassword(FacesContext context, UIComponent toValidate, Object value) {
        String confirm = (String)value;
        String password = (String)inputPassword1.getValue();
        if(password != null && !password.equals(confirm)) {
            FacesMessage message = new FacesMessage();
            throw new ValidatorException(message);
        }
    }
    
    private boolean validateHistoricos(String value) {
        HistoricoClaves h = new HistoricoClaves();
        h.setHisClave(value);
        return historicos.contains(h);
    }
    
    private boolean validateCantidad() {
        int n=0,c=0;
        for(int i=0; i<password1.length(); i++) {
            char cr = password1.charAt(i);
            if((cr >= 'a' && cr <= 'z') || (cr >= 'A' && cr <= 'Z')) {
                c++;
            } else if(cr >= '0' && cr <= '9') {
                n++;
            }
        }
        return (n < usuarios.getUsuPolGrupFk().getPolCanNum() ||
                c < usuarios.getUsuPolGrupFk().getPolCanLet());
    }
    
    private boolean validateRepetidos() {
        if(usuarios.getUsuPolGrupFk().getPolRepCar().charAt(0) == 'S') {
            for(int i=0; i<password1.length(); i++) {
                char c = password1.charAt(i);
                for(int j=i+1; j<password1.length(); j++) {
                    if(password1.charAt(j) == c) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
