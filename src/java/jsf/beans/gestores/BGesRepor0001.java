/*
 * BGesRrepor0001: Se realiza el paso de informacion desde la tabla de cronoproyec a la de reportes
 *                 para presentar su respectivo grafico. Esto para el reporte numero (90000).
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jpa.valores.Actividades;
import jpa.valores.Caracteristicas;
import jpa.valores.CronoProye;
import jpa.valores.Paises;
import jpa.valores.Parametrias;
import jpa.valores.Relaciones;
import jpa.valores.Reportes;
import jsf.beans.generales.CalculoTime2;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdActividades;
import jsf.controlador.PtdCaracteristicas;
import jsf.controlador.PtdCronoProye;
import jsf.controlador.PtdPaises;
import jsf.controlador.PtdReportes;


public class BGesRepor0001 implements Serializable, ControladorReport {
    private String repUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();

    private BGesNavegacion bgesNavegacion = (BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion");
    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    
    private PtdCaracteristicas ptdCaracteristicas = new PtdCaracteristicas();
    private PtdReportes ptdReportes = new PtdReportes();
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private PtdActividades ptdActividades = new PtdActividades();
    private PtdPaises ptdPaises = new PtdPaises();
    private Paises paises;
    private Actividades actividades;
    private Parametrias parametria;
    private List<CronoProye> cronoProye;
    private int codcronoproy;
    private String opcion="1";
    private String VectorText[]={"1. FECHA INICIAL (PLAN.)","2. FECHA FINAL (PLAN.)","3. FECHA INICIAL (REAL)","4. FECHA FINAL (REAL)","5. FECHA INICIAL (RE. PROY.)","6. FECHA FINAL (RE. PROY)","7. FEC. INI. AVANCE REAL","8. FEC. FIN. AVANCE REAL"};
    private String VectorAlfa[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    private SimpleDateFormat df =  (SimpleDateFormat) DateFormat.getDateInstance();
    private Date now = new Date();
    
    @Override
    public void cargardatos() {
        bgesReportes.caracteristica = ptdCaracteristicas.encontrarSecuencia(repUsuCod, bgesReportes.getVari());

        // Caracteristicas de reporte (Actualizar o crear)
        if (bgesReportes.caracteristica != null) { // Si hay un reporte 90000, Actualizar Secuencia
            bgesReportes.caracteristica.setCarFecHor(now);
            ptdCaracteristicas.actualizar(bgesReportes.caracteristica);
            bgesReportes.NumMax = bgesReportes.caracteristica.getCaracteristicasPK().getCarSecuPk();
        } else {
            // Si no se crea
            try {
                bgesReportes.NumMax = ptdCaracteristicas.encontrarSecuCons(bgesReportes.getVari());
                if (bgesReportes.NumMax == null) {// si no hay consecutivo se crea 
                    bgesReportes.NumMax = 1;
                } else { // si se encuentra consecutivo del reporte 90000 se suma uno
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
        int vectorData[] = new int[8];
        int tiempoAvance=0;
        Date fechaProyecta;
        double vardouble;
        List<Reportes> vectRepor = new ArrayList<Reportes>();
        bgesReportes.parametria = new Parametrias();
        bgesReportes.parametria.setParCodRepPk(bgesReportes.vari);
        df.applyPattern("yyyyMMdd");
        String var = df.format(now);
        
        cronoProye = ptdCronoProye.encontrarProyCro(codcronoproy);
        
        
    
        List<String> siglas = new ArrayList<String>();
        List<Relaciones> relaciones = bgesNavegacion.getRelaciones();

        for (Relaciones r : relaciones) {
            siglas.add(r.getRelActCodFk().getActSigla());
        }

        int index;
        String letra;
        int contletra = 0;

        for (CronoProye cr : cronoProye) {
            actividades=ptdActividades.encontrar(cr.getCronoProyePK().getCroproActCodFk());
            paises = ptdPaises.encontrar(actividades.getActCodPaiFk());
            
           
            if (cr.getCroproFeiPla()!=null && cr.getCroproFefPla()!= null){
            // Planeados
               vectorData[0] = Integer.parseInt("" + df.format(cr.getCroproFeiPla()));
               vectorData[1] = Integer.parseInt("" + df.format(cr.getCroproFefPla()));
            }
           
           if (cr.getCroproFeiRea()!=null && cr.getCroproFefRea()!= null){
            // Reales
               vectorData[2] = Integer.parseInt("" + df.format(cr.getCroproFeiRea()));
               vectorData[3] = Integer.parseInt("" + df.format(cr.getCroproFefRea()));
           }else{
            // Reales proyectados
               vectorData[2] = Integer.parseInt("" + df.format(cr.getCroproFeiRep()));
               vectorData[3] = Integer.parseInt("" + df.format(cr.getCroproFefRep()));
           }
            
           if (cr.getCroproFeiRea()!=null && cr.getCroproFefRea()== null) {
            // Avance esperado 
               if(Integer.parseInt(""+df.format(cr.getCroproFeiRea())) < Integer.parseInt(var)){
                 vectorData[4] = Integer.parseInt("" + df.format(cr.getCroproFeiRea()));
                 vectorData[5] = Integer.parseInt(var);
               }
           }
           
           vectorData[6] = vectorData[2];
           vectorData[7] = Integer.parseInt(var);
           
          
           if (cr.getCroproFeiRea()!=null && cr.getCroproFefRea()== null){
           // Avance Real
            //  tiempo planeado * porcentaje de avance real =  tiempo avance 
                vardouble = (Double.parseDouble(""+cr.getCroproPorRea())/100);
                tiempoAvance = (int) (Integer.parseInt(""+cr.getCroproTiePla()) * vardouble);
                fechaProyecta = CalculoTime2.getTimeFechas(actividades.getActFes(),paises, cr.getCroproFeiRea(), tiempoAvance);         
                vectorData[6] = Integer.parseInt("" + df.format(cr.getCroproFeiRea()));
                vectorData[7] = Integer.parseInt("" + df.format(fechaProyecta));
           }
         
       
            for (int a = 0; a <= 7; a++) {
                bgesReportes.reporte = new Reportes(0, 0, "", "");
                bgesReportes.reporte.getReportesPK().setRepCodRepFk(bgesReportes.vari);
                bgesReportes.reporte.getReportesPK().setRepCarSecFk(bgesReportes.NumMax);
                index = siglas.indexOf(actividades.getActSigla());
                
                if (index > 26) {
                    contletra++;
                    letra = VectorAlfa[index] + VectorAlfa[contletra];
                } else {
                    letra = VectorAlfa[index];
                }
               
                bgesReportes.reporte.getReportesPK().setRepNomFil(letra + ". " + actividades.getActSigla() + " - " + cr.getCronoProyePK().getCroproComNomFk());
                bgesReportes.reporte.getReportesPK().setRepNomCol(VectorText[a]);
                bgesReportes.reporte.setRepValor(vectorData[a]);
                vectRepor.add(bgesReportes.reporte);
            }
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
