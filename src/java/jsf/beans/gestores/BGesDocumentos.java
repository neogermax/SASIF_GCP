/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import documentos.utilerias.UtileriasDocumentos;
import java.io.InputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Constantes;
import jpa.valores.Empleados;
import jpa.valores.InfoDocumentos;
import jpa.valores.Pdocumentos;
import jpa.valores.ProyItems;
import jpa.valores.ProyItemsPK;
import jpa.valores.Usuarios;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdConstantes;
import jsf.controlador.PtdDocExistentes;
import jsf.controlador.PtdPdocumentos;
import jsf.controlador.PtdProyItems;
import jsf.documentos.DocumentosDelegate;
import jsf.documentos.tramas.Trama;
import org.primefaces.event.FileUploadEvent;

@ManagedBean(name = "bgesDocumentos")
@SessionScoped
public class BGesDocumentos implements Serializable {
    private BGesLogin bgesLogin = (BGesLogin)UtileriaHTTP.getBean("bgesLogin");
    private BGesNavegacion bgesNavegacion;
    private DocumentosDelegate documentosDelegate = new DocumentosDelegate();
    private PtdPdocumentos ptdPdocumentos = new PtdPdocumentos();
    private PtdDocExistentes ptdDocExistentes = new PtdDocExistentes();
    private PtdProyItems ptdProyItems = new PtdProyItems();
    private PtdConstantes ptdConstantes = new PtdConstantes();
    private Pdocumentos pdocumento;
    
    private DateFormat date = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    private String rutaserv = "http://www.sistemassasif.com/archivo/";
    private String rutaalm;
    private String fileTemp;
    private String url;
    private Long codProy;
    private Long doexSecDpc;
    
    private boolean arbol;
    private boolean file;
    private boolean visor;
    private boolean upload;
    
    public void init() {
        if(!(arbol || file || visor)) {
            bgesNavegacion = (BGesNavegacion) UtileriaHTTP.getBean("bgesNavegacion");
            pdocumento = ptdPdocumentos.encontrar(bgesNavegacion.getDoc());
            codProy = new Long(bgesNavegacion.getProyecto().getProCodPk().longValue());
            
            if(pdocumento.getPdoVersion().equals("H")) {
                doexSecDpc = ptdDocExistentes.secuencia("A01", 
                                                        pdocumento.getPdoTipod(),
                                                        codProy,
                                                        pdocumento.getPdoDocumentoPk());
                doexSecDpc = new Long(doexSecDpc + 1);
            } else {
                doexSecDpc = new Long(1);
            }
            
            rutaalm = pdocumento.getPdoCodRutaFk().getRutRuta()+ "A01" + pdocumento.getPdoDocumentoPk() +
                    codProy + doexSecDpc + "." + pdocumento.getPdoTipod();
            
            fileTemp =  bgesLogin.getUsuario() + "_" + date.format(new Date()) + "_" +  pdocumento.getPdoDocumentoPk() + "." + pdocumento.getPdoTipod();
            
            switch(pdocumento.getPdoTipoc().charAt(0)) {
                case 'D': arbol = visor = true;
                    break;
                case 'N': file = true;
                    merche();
                    break;
                case 'M': upload = file = true;
                    merche();
                    break;
            }
        }
    }
    
    private void merche() {
        try {
            if(pdocumento.getPdoVersion().equals("H") || doexSecDpc == 1) {
                Trama trama = new Trama();
                processTrama(trama);
                processInfo(trama);
                documentosDelegate.processDocument(trama.toString());
                url = rutaserv + fileTemp;
            }
            UtileriasDocumentos.copyFTP(rutaalm, fileTemp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void processTrama(Trama trama) {
        trama.addCabecera(UtileriaHTTP.getSession(false).getId()); //identificador de session
        trama.addCabecera("C"); //operacion
        trama.addCabecera("A01"); //aplicativo origen
        trama.addCabecera("" + codProy); //Identificador 1 (proyecto)
        Usuarios usuario = bgesLogin.getUsuarios();
        trama.addCabecera("" + usuario.getEmpleados().getAreas().getEmpresas().getEmprCodigoPk()); //empresa que origino
        trama.addCabecera("" + usuario.getEmpleados().getAreas().getAreasPK().getAreCodigoPk()); //Area que origino
        trama.addCabecera(usuario.getUsuCodPk()); //Usuario que origino
        trama.addCabecera(pdocumento.getPdoDocumentoPk()); //nombre del documento
        trama.addCabecera("" + doexSecDpc); //consecutivo del documento
        trama.addCabecera(pdocumento.getPdoTipod().toLowerCase()); //tipo de documento
        trama.addCabecera(pdocumento.getPdoTipoc()); //tipo de contenido
        trama.addCabecera(pdocumento.getPdoCodRutaFk().getRutRuta()); //ruta almacenamiento
        trama.addCabecera(pdocumento.getPdoRutaPla()); //ruta plantilla
        
    }
    
    private String valorNumerico(double numero, String formato) {
        try {
            DecimalFormat decimal = new DecimalFormat(formato);
            return decimal.format(numero);
        } catch(Exception e) {
            return null;
        }
    }
    
    private String valorFecha(Date fecha, String formato) {
        try {
            DateFormat date = new SimpleDateFormat(formato);
            return date.format(fecha);
        } catch(Exception e) {
            return null;
        }
    }
    
    private String valorEmpleado(Empleados emp) {
        if(emp == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(emp.getEmplNombre1());
        if(emp.getEmplNombre2() != null) {
            sb.append(" ").append(emp.getEmplNombre2());
        }
        sb.append(" ").append(emp.getEmplApellido1());
        if(emp.getEmplApellido2() != null) {
            sb.append(" ").append(emp.getEmplApellido2());
        }
        return sb.toString();
    }
    
    private String items(Integer itmCod, String formato) {
        ProyItems p = ptdProyItems.encontrar(
                new ProyItemsPK(Integer.valueOf(codProy.intValue()), itmCod, " ", Integer.valueOf(0)));
        if(p == null) {
            return null;
        }
        if(p.getPryValorAlfa() != null) {
            return p.getPryValorAlfa();
        } else if(p.getPryValorFecha() != null) {
            return valorFecha(p.getPryValorFecha(), formato);
        } else if(p.getPryValorNum() != null) {
            return valorNumerico(p.getPryValorNum().doubleValue(), formato);
        } else {
            return null;
        }
    }
    
    private String varSession(int numSession, String formato) {
        switch(numSession) {
            case 1:
                return bgesLogin.getUsuario();
            case 2:
                return valorEmpleado(bgesLogin.getEmpleado());
            case 3:
                return bgesLogin.getEmpleado().getAreas().getEmpresas().getEmprNombre();
            case 4:
                return bgesLogin.getEmpleado().getAreas().getAreNombre();
            case 5:
                return bgesLogin.getEmpleado().getEmplCodCargoFk().getCarDescrip();
            case 6:
                return valorEmpleado(bgesLogin.getEmpleado().getEmpleados());
            case 7:
                return valorFecha(new Date(), formato);
            default:
                return null;
        }
    }
    
    private String constantes(Integer consCod, String formato) {
        Constantes cons = ptdConstantes.encontrar(consCod);
        if(cons == null) {
            return null;
        }
        if(cons.getConsValorAlf() != null) {
            return cons.getConsValorAlf();
        } else if(cons.getConsValorNum() != null) {
            return valorNumerico(cons.getConsValorNum().doubleValue(), formato);
        } else {
            return null;
        }
    }
    
    private String valorInfo(InfoDocumentos inf) {
        switch(inf.getIdocIdeDato().charAt(0)) {
            case '1':
                return items(inf.getIdocCodItem(), inf.getIdocFormato());
            case '2':
                return varSession(inf.getIdocNumVarSesion().intValue(), inf.getIdocFormato());
            case '4':
                return constantes(inf.getIdocNumCons(), inf.getIdocFormato());
            default:
                return null;
        }
    }
    
    private void processInfo(Trama trama) {
        int index = 0;
        Repeticion rep = null;
        for(InfoDocumentos inf : pdocumento.getInfoDocumentosList()) {
            if(inf.getIdocSecuencia() != null && inf.getIdocRepeticion() != null) {
                if(rep == null) {
                    rep = new Repeticion(codProy.intValue());
                }
                rep.addElemento("Item" + inf.getInfoDocumentosPK().getIdocSec(), inf.getIdocRepeticion(), inf.getIdocSecuencia(), inf.getIdocTabla(), inf.getIdocCampo());
            } else {
                String val = valorInfo(inf);
                if(val != null) {
                    trama.addElementCampo(index, "Item" + inf.getInfoDocumentosPK().getIdocSec());
                    trama.addElementCampo(index++, val);
                }
            }
        }
        
        if(rep != null) {
            Map<Short, Map<Short, TablaCampo>> tablas = rep.getTablas();
            
            int i=0;
            for(Short s : tablas.keySet()) {
                Map<Short, TablaCampo> secuencias = tablas.get(s);
                int j=0;
                for(Short jndex : secuencias.keySet()) {
                    TablaCampo tb = secuencias.get(jndex);
                    trama.addCabTabla(i, tb.getNombre());
                    for(String valor : tb.getCampos()) {
                        trama.addElementTabla(i, j, valor);
                    }
                    j++;
                }
                i++;
            }
        }
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        try {
            InputStream input = event.getFile().getInputstream();
            UtileriasDocumentos.copyFile(input, rutaalm);
            if(pdocumento.getPdoTipoc().equals("D")) {
                if(url != null) {
                    UtileriasDocumentos.deleteDocument(fileTemp);
                }
                UtileriasDocumentos.copyFTP(rutaalm, fileTemp);
                if(pdocumento.getPdoTipod().equals("pdf")) {
                    url = "http://docs.google.com/viewer?url=" + rutaserv + fileTemp + "&embedded=true";
                } else {
                    url = rutaserv + fileTemp;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void borrarTemporal() {
        if(url != null) {
            UtileriasDocumentos.deleteDocument(fileTemp);
        }
        url = fileTemp = null;
        arbol = visor = file = upload = false;
        bgesNavegacion.setDoc(null);
    }
    
    public boolean action() {
        if(pdocumento.getPdoTipoc().equals("D")) {
            if(url != null) {
                Trama trama = new Trama();
                processTrama(trama);
                documentosDelegate.processDigitalizado(trama.toString());
                borrarTemporal();
                return true;
            }
            return false;
        } else {
            borrarTemporal();
            return true;
        }
    }
    
    public String getURL() {
        return url;
    }
    
    public String getExt() {
        return pdocumento.getPdoTipod();
    }
    
    public boolean isArbol() {
        return arbol;
    }
    
    public boolean isVisor() {
        return visor;
    }
    
    public boolean isFile() {
        return file;
    }
    
    public boolean isUpload() {
        return upload;
    }
    
}
