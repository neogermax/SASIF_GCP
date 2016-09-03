/*
 * BGesRrepor0001: Se realiza el paso de informacion desde la tabla de cronoproyec a la de reportes
 *                 para presentar su respectivo grafico. Esto para el reporte numero (90000).
 */
package jsf.beans.gestores;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.beans.generales.UtileriaHTTP;

@ManagedBean(name = "bgesTodoReporte")
@SessionScoped
public class BGesTodoReporte implements Serializable {
    //private String repUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    //private BGesNavegacion bgesNavegacion = (BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion");
    //private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    private ControladorReport crtReport;
        
    private String opcion="1";
    private String opcionCarac="";
    private int codcronoproy;
    
    public void actionReporte(String reporte) {
        try {
            crtReport = (ControladorReport)(Class.forName(reporte).newInstance());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
        
    public ControladorReport getCrtReport() {
        return crtReport;
    }
    
    public void setOpcion(String opcion) {
        this.opcion = opcion;
        if(crtReport != null) {
            crtReport.setOpcion(opcion);
        }
    }
    
    public String getOpcion() {
        return opcion;
    }
    
    
    public void setCodcronoproy(int codproyecto) {
        crtReport.setCodcronoproy(codproyecto);
    }
    
    public String actionOpcion() {
        this.opcion = UtileriaHTTP.getParameter("opcion");
        crtReport.actionOpcion(UtileriaHTTP.getParameter("opcion"));
        return null;
    }
    
    public void cargarDatos() {
        crtReport.cargardatos();
    }
    
    //bgesRepor0001.setOpcion("2");
    //bgesRepor0001.setOpcionCarac("CRGP");
    //bgesRepor0001.setCodcronoproy((int)proyecto.getProCodPk());
    //bgesRepor0001.cargardatos();
}

