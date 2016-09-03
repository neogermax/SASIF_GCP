/*
 * BGesRrepor0004: Se realiza el paso de informacion desde la tabla de cronoproyec a la de reportes
 *                 para presentar su respectivo grafico. Esto para el reporte numero (90003).
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

public class BGesRepor0004 implements Serializable, ControladorReport {

    private String repUsuCod = ((BGesLogin) UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    private BGesReportes bgesReportes = (BGesReportes) UtileriaHTTP.getBean("bgesReportes");
    private PtdCaracteristicas ptdCaracteristicas = new PtdCaracteristicas();
    private PtdReportes ptdReportes = new PtdReportes();
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private Parametrias parametria;
    private List<CronoProye> cronoProye;
    private int codcronoproy;
    private String opcion = "1";
    private String VectorText[] = {"1. TIEMPO PLANEADO", "2. TIEMPO REAL"};
    private Date now = new Date();

    @Override
    public void cargardatos() {
        bgesReportes.caracteristica = ptdCaracteristicas.encontrarSecuencia(repUsuCod, bgesReportes.getVari());

        // Caracteristicas de reporte (Actualizar o crear)
        if (bgesReportes.caracteristica != null) { // Si hay un reporte 90003, Actualizar Secuencia
            bgesReportes.caracteristica.setCarFecHor(now);
            ptdCaracteristicas.actualizar(bgesReportes.caracteristica);
            bgesReportes.NumMax = bgesReportes.caracteristica.getCaracteristicasPK().getCarSecuPk();
        } else {
            // Si no se crea
            try {
                bgesReportes.NumMax = ptdCaracteristicas.encontrarSecuCons(bgesReportes.getVari());
                if (bgesReportes.NumMax == null) {// si no hay consecutivo se crea 
                    bgesReportes.NumMax = 1;
                } else { // si se encuentra consecutivo del reporte 90003 se suma uno
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
        int vectorData[] = new int[3];
        int sumaPlaneados = 0;
        int sumaReal = 0;
        List<Reportes> vectRepor = new ArrayList<Reportes>();
        bgesReportes.parametria = new Parametrias();
        bgesReportes.parametria.setParCodRepPk(bgesReportes.vari);
      
        cronoProye = ptdCronoProye.encontrarProyCro(codcronoproy);

        for (CronoProye cr : cronoProye) {
            vectorData[0] = Integer.parseInt("" + cr.getCroproTiePla());
            vectorData[1] = Integer.parseInt("" + cr.getCroproTieRea());
           if (cr.getCroproFefRea() != null && cr.getCroproFeiRea() != null)  
           {
            
                sumaPlaneados += Integer.parseInt("" + cr.getCroproTiePla()); //sumatoria planeado.
                sumaReal += Integer.parseInt("" + cr.getCroproTieRea()); //sumatoria Real
            }
            vectorData[0] = sumaPlaneados;
            vectorData[1] = sumaReal;
        }
        for (int a = 0; a < 2; a++) {
            bgesReportes.reporte = new Reportes(0, 0, "", "");
            bgesReportes.reporte.getReportesPK().setRepCodRepFk(bgesReportes.vari);
            bgesReportes.reporte.getReportesPK().setRepCarSecFk(bgesReportes.NumMax);
            bgesReportes.reporte.getReportesPK().setRepNomFil("A.PROYECTO " + codcronoproy + " - SUMATORIA");
            bgesReportes.reporte.getReportesPK().setRepNomCol(VectorText[a]);
            bgesReportes.reporte.setRepValor(vectorData[a]);
            vectRepor.add(bgesReportes.reporte);
        }

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
