/*
 * BGesRrepor0012: Se realiza la consulta de usuarios por empresa para visualizar su carga de trabajo (90011).
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jpa.valores.CronoProye;
import jpa.valores.Empleados;
import jpa.valores.Responsables;
import jpa.valores.Usuarios;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdCronoProye;
import jsf.controlador.PtdEmpleados;
import jsf.controlador.PtdResponsables;
import jsf.controlador.PtdUsuarios;


public class BGesRepor0012 implements Serializable, ControladorReport {
    private BGesTrabajo bgesTrabajo = (BGesTrabajo)UtileriaHTTP.getBean("bgesTrabajo");
    private BGesNavegacion bgesNavegacion = (BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion");
    private String repUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();

    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private PtdEmpleados ptdEmpleados = new PtdEmpleados();
    private PtdResponsables ptdResponsables = new PtdResponsables();
    
    private List<Usuarios> usuarios;
    private List<CronoProye> cronoProye;
    private List<Object[]> cronoProMinMax;
       
    private Usuarios usuario;
    private Empleados empleados;
    
    private int codcronoproy;
    private String opcion="1";
        
    
    @Override
    public void cargardatos() {
        List<CronoProye> vectCrono = new ArrayList<CronoProye>();
        
        cronoProye = ptdCronoProye.encontrarProyCro(codcronoproy);
        cronoProMinMax = ptdCronoProye.fechMinMax(codcronoproy);
        usuario = ptdUsuarios.validarUsuario(repUsuCod);
       usuarios = new ArrayList<Usuarios>();
        usuarios.add(usuario);
        
         for (CronoProye cr : cronoProye) {
            if(cr.getCroproFefRea()==null && cr.getCroproFeiRea() !=null){
                vectCrono.add(cr);
            }
        }
         Date d1 = null, d2 = null;
        if(!cronoProMinMax.isEmpty()) {
            Object[] fchs = cronoProMinMax.get(0);
            d1 = (Date)fchs[0];
            d2 = (Date)fchs[1];
        }
        List<Responsables> responsables = ptdResponsables.encontrarActivos(bgesNavegacion.getProyecto());
         bgesTrabajo.init(usuarios, responsables, vectCrono, d1, d2);
     }
/*-----> FINAL - CREADO ANALISTA 04 - 001 <-----  */ 
    
    
    
   @Override 
   public String actionOpcion(String opcion) {
        this.opcion = opcion;//UtileriaHTTP.getParameter("opcion");
         bgesReportes.setFlag(true);
        return null;
    }
    
    
    
/*-----> INICIO - GET Y SET DE VARIABLES <-----  */
    public String getOpcion() {
        return opcion;
    }
    
    @Override
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public int getCodcronoproy() {
        return codcronoproy;
    }

    @Override
    public void setCodcronoproy(int codcronoproy) {
        this.codcronoproy = codcronoproy;
    }
    
/*-----> FINAL - GET Y SET DE VARIABLES <-----  */

}

