/*
 * BGesRrepor0005: Se realiza el paso de informacion desde la tabla de cronoproyec a la de reportes
 *                 para presentar su respectivo grafico. Esto para el reporte numero (90004).
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Caracteristicas;
import jpa.valores.CronoProye;
import jpa.valores.Parametrias;
import jpa.valores.Reportes;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdCaracteristicas;
import jsf.controlador.PtdCronoProye;
import jsf.controlador.PtdReportes;

public class BGesRepor0005 implements Serializable, ControladorReport {

    private String repUsuCod = ((BGesLogin) UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    private BGesReportes bgesReportes = (BGesReportes) UtileriaHTTP.getBean("bgesReportes");
    private BGesNavegacion bgesNavegacion = (BGesNavegacion) UtileriaHTTP.getBean("bgesNavegacion");
    private PtdCaracteristicas ptdCaracteristicas = new PtdCaracteristicas();
    private PtdReportes ptdReportes = new PtdReportes();
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private Parametrias parametria;
    private List<CronoProye> cronoProye;
    private int codcronoproy;
    private String opcion = "1";
    private String VectorText[] = {"1. TIEMPO"};
    private String VectorFilas[] = {"A. Tiempo total actividad","B. Tiempo esperado de avance","C. Tiempo real de avance"};
    private Date now = new Date();
    long suma=0;
    
    @Override
    public void cargardatos() {
        bgesReportes.caracteristica = ptdCaracteristicas.encontrarSecuencia(repUsuCod, bgesReportes.getVari());

        // Caracteristicas de reporte (Actualizar o crear)
        if (bgesReportes.caracteristica != null) { // Si hay un reporte 90004, Actualizar Secuencia
            bgesReportes.caracteristica.setCarFecHor(now);
            ptdCaracteristicas.actualizar(bgesReportes.caracteristica);
            bgesReportes.NumMax = bgesReportes.caracteristica.getCaracteristicasPK().getCarSecuPk();
        } else {
            // Si no se crea
            try {
                bgesReportes.NumMax = ptdCaracteristicas.encontrarSecuCons(bgesReportes.getVari());
                if (bgesReportes.NumMax == null) {// si no hay consecutivo se crea 
                    bgesReportes.NumMax = 1;
                } else { // si se encuentra consecutivo del reporte 90004 se suma uno
                    bgesReportes.NumMax += 1;
                }
                bgesReportes.caracteristica = new Caracteristicas(bgesReportes.NumMax, bgesReportes.getVari());
                bgesReportes.caracteristica.getCaracteristicasPK().setCarSecuPk(bgesReportes.NumMax);
                bgesReportes.caracteristica.setCarFecHor(now);
                bgesReportes.caracteristica.setCarUsuGen(repUsuCod);
                bgesReportes.caracteristica.getCaracteristicasPK().setCarCodRepFk(bgesReportes.getVari());
                bgesReportes.caracteristica.setParametrias(parametria);
                ptdCaracteristicas.insertar(bgesReportes.caracteristica);
            } catch (Exception e) {
            }
        }
        buscardata();
    }
    /*-----> FINAL - CREADO ANALISTA 04 - 001 <-----  */

    /*-----> INICIO - CREADO ANALISTA 04 - 001 <-----  */
    public void buscardata() {
        System.out.println("buscar datos");
        int vectorData[] = new int[3];
        List<Reportes> vectRepor = new ArrayList<Reportes>();
        bgesReportes.parametria = new Parametrias();
        bgesReportes.parametria.setParCodRepPk(bgesReportes.vari);
        double auxvalor;
        double  auxvalor1;
        cronoProye = ptdCronoProye.encontrarProyCro(codcronoproy);
  
   
        /*for (CronoProye cr : cronoProye) {
            
              if (cr.getCroproFefRea() == null && cr.getCroproFeiRea() != null) {*/
                CronoProye cr = bgesNavegacion.getCronoProye();
                vectorData[0] = Integer.parseInt("" + cr.getCroproTiePla());
                vectorData[1] = Integer.parseInt(""+diferencia(cr.getCroproFeiRea().getTime(),now.getTime()));
                auxvalor = Double.parseDouble(""+Integer.parseInt(""+cr.getCroproPorRea()))/100;
                auxvalor1 =Double.parseDouble(""+Integer.parseInt("" + cr.getCroproTiePla()))*auxvalor;
                vectorData[2] =(int) auxvalor1;
           
                for (int a = 0; a < 3; a++) {
                    bgesReportes.reporte = new Reportes(0, 0, "", "");
                    bgesReportes.reporte.getReportesPK().setRepCodRepFk(bgesReportes.vari);
                    bgesReportes.reporte.getReportesPK().setRepCarSecFk(bgesReportes.NumMax);
                    bgesReportes.reporte.getReportesPK().setRepNomFil(VectorFilas[a]);
                    bgesReportes.reporte.getReportesPK().setRepNomCol(VectorText[0]);
                    bgesReportes.reporte.setRepValor(vectorData[a]);
                    vectRepor.add(bgesReportes.reporte);
                }
            //}
        //}
       
        ptdReportes.insertar(bgesReportes.vari, bgesReportes.NumMax, vectRepor);

        //caracteristica = new Caracteristicas();
        bgesReportes.caracteristica = new Caracteristicas(bgesReportes.NumMax, bgesReportes.vari);

        //selectParametria();
        bgesReportes.obtenerFilas();
        bgesReportes.obtenerColumnas();
        bgesReportes.actionParametro(0, bgesReportes.vari);
        bgesReportes.action();
    }
    /*-----> FINAL - CREADO ANALISTA 04 - 001 <-----  */

    private long diferencia(long d1, long d2) {
        suma=0;
        long dif = d1-d2;
        String formato = (dif < 0) ? "Atrasado " : "Faltan ";
        dif = Math.abs(dif);
        StringBuilder sb = new StringBuilder(formato);
        long d = dif/86400000;
        suma +=((d*8)*60);
        sb.append(d).append(" dias, ");
        dif -= (d*86400000);
        d = dif/3600000;
        suma += (d*60);
        sb.append(d).append(" horas, ");
        dif -= (d*3600000);
        d = dif/60000;
        suma+=d;
        sb.append(d).append(" minutos");
        return suma;
    }
    
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
