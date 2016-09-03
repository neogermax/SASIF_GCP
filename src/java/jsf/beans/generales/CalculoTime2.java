/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import jpa.valores.Festivos;
import jpa.valores.Paises;
import jpa.valores.Actividades;

/**
 *
 * @author analista02
 */
public class CalculoTime2 {
    static Date wHora = new Date();
    static Calendar wFecha2 = Calendar.getInstance();
    static String diasFes[] = new String[8];
    static int diaInicial = 0;
    static int diaInicial2 = 0;
    static Date diaFinal[] = new Date[8];
    
    private static long getMinutos(Date d1, Date d2) {
        long dif = d2.getTime() - d1.getTime();
        return (long)Math.ceil((double)dif /60000d); 
    }
   
    
    private static boolean isFestivo(Paises pais, Calendar cal) {
        short diames = (short)(cal.get(Calendar.MONTH) * 100 + cal.get(Calendar.DAY_OF_MONTH));
        Festivos fes = new Festivos(new Short((short)cal.get(Calendar.YEAR)),
                new Short(diames), pais.getPaiCodPk());
        return pais.getFestivosList().contains(fes);
    }
    
    private static Date getHora(Date d) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(1970, 0, 1);
        return c.getTime();
    }
    
    
    public static Date getTimeFechas(String activi, Paises pais, Date ini, long pla) {
        
        Date fechaHora = new Date();
        int i =0 ;
        diaInicial = 0;
        diaInicial2 = 0;
        
        paisFest(pais);
        
        int wDia  = 0;
        Calendar cal = Calendar.getInstance();
        cal.setTime(ini);
        
        
        Calendar wFecha = Calendar.getInstance();
        Calendar wFecha3 = Calendar.getInstance();
        wFecha.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
        wFecha3.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND));
        wHora = getHora(ini);
        
        
        while((pla > 0)  && (i < 50000)){
            
            wDia =wFecha.get(Calendar.DAY_OF_WEEK); 
            
            if(diasFes[wDia].equals("L")){
                
                
                
                if (activi.equals("S") || !isFestivo(pais, wFecha)){
                    
                    if(paisRangos(wDia, pais, ini)!= 0){
                        
                        pla = pla - paisRangos(wDia, pais, ini);
                        
                    }
                }else if(activi.equals("N")){
                    pla = pla - paisRangos(wDia, pais, ini);
                }       
            }
            
            
            
        if(pla<0 && wFecha.after(wFecha3)){
        pla = pla*(-1);
        int dr =0;
        wFecha.add(Calendar.DAY_OF_YEAR, 1);
        for (int k = 0; k < diaFinal.length;  k+= 2) {
            Date d11 = getDateIni2(diaFinal[k],wDia);
            Date d22 = getDateFin2(diaFinal[k + 1]);
        
            if (d11 != null && d22 != null && d11.before(d22)) {

                
                    
                    dr += getMinutos(d11, d22);
                    pla = pla - dr;
                    if(pla <0){
                        
                        Calendar calpla=Calendar.getInstance();
                        calpla.setTime(d22);
                        wFecha.set(wFecha.get(Calendar.YEAR), wFecha.get(Calendar.MONTH), wFecha.get(Calendar.DAY_OF_MONTH),calpla.get(Calendar.HOUR_OF_DAY),calpla.get(Calendar.MINUTE),calpla.get(Calendar.SECOND));
                    }
                    
             
            }
        }
        pla=-1;
        }
        
        
        if(pla >= 0){
            wFecha.add(Calendar.DAY_OF_YEAR, 1);
           
            wHora.setDate(1);
            wHora.setHours(0);
            wHora.setMinutes(0);
            wHora.setMonth(1);
            wHora.setSeconds(0);
            wHora.setYear(1970);
            wHora.setMinutes(0);
            
        }
        
      
        i++;
    
    }
        if(wFecha.equals(wFecha3)){
            System.out.println("entro calculo");
            wFecha.add(Calendar.HOUR_OF_DAY, 24);
        }
        return wFecha.getTime();
    }
    
    
    public static void paisFest(Paises pais){
        diasFes[Calendar.MONDAY] = pais.getPaiEstLun();
        diasFes[Calendar.TUESDAY] = pais.getPaiEstMar();
        diasFes[Calendar.WEDNESDAY] = pais.getPaiEstMie();
        diasFes[Calendar.THURSDAY] = pais.getPaiEstJue();
        diasFes[Calendar.FRIDAY] = pais.getPaiEstVie();
        diasFes[Calendar.SATURDAY] = pais.getPaiEstSab();
        diasFes[Calendar.SUNDAY] = pais.getPaiEstDom();
        
    }
    
    
    
    private static long paisRangos(int dia, Paises pais, Date ini) {
        
       switch(dia) {
            case Calendar.SUNDAY: return getResta(ini,dia, pais.getPaiHoi1Dom(), pais.getPaiHof1Dom(),
                    pais.getPaiHoi2Dom(), pais.getPaiHof2Dom(), pais.getPaiHoi3Dom(),
                    pais.getPaiHof3Dom(), pais.getPaiHoi4Dom(), pais.getPaiHof4Dom());
           
            case Calendar.MONDAY: return getResta(ini,dia, pais.getPaiHoi1Lun(), pais.getPaiHof1Lun(),
                    pais.getPaiHoi2Lun(), pais.getPaiHof2Lun(), pais.getPaiHoi3Lun(),
                    pais.getPaiHof3Lun(), pais.getPaiHoi4Lun(), pais.getPaiHof4Lun());
                
            case Calendar.TUESDAY: return getResta(ini,dia, pais.getPaiHoi1Mar(), pais.getPaiHof1Mar(),
                    pais.getPaiHoi2Mar(), pais.getPaiHof2Mar(), pais.getPaiHoi3Mar(),
                    pais.getPaiHof3Mar(), pais.getPaiHoi4Mar(), pais.getPaiHof4Mar());
                
            case Calendar.WEDNESDAY: return getResta(ini,dia, pais.getPaiHoi1Mie(), pais.getPaiHof1Mie(),
                    pais.getPaiHoi2Mie(), pais.getPaiHof2Mie(), pais.getPaiHoi3Mie(),
                    pais.getPaiHof3Mie(), pais.getPaiHoi4Mie(), pais.getPaiHof4Mie());
                
            case Calendar.THURSDAY: return getResta(ini,dia, pais.getPaiHoi1Jue(), pais.getPaiHof1Jue(),
                    pais.getPaiHoi2Jue(), pais.getPaiHof2Jue(), pais.getPaiHoi3Jue(),
                    pais.getPaiHof3Jue(), pais.getPaiHoi4Jue(), pais.getPaiHof4Jue());
                
            case Calendar.FRIDAY: return getResta(ini,dia, pais.getPaiHoi1Vie(), pais.getPaiHof1Vie(),
                    pais.getPaiHoi2Vie(), pais.getPaiHof2Vie(), pais.getPaiHoi3Vie(),
                    pais.getPaiHof3Vie(), pais.getPaiHoi4Vie(), pais.getPaiHof4Vie());
               
            case Calendar.SATURDAY: return getResta(ini,dia, pais.getPaiHoi1Sab(), pais.getPaiHof1Sab(),
                    pais.getPaiHoi2Sab(), pais.getPaiHof2Sab(), pais.getPaiHoi3Sab(),
                    pais.getPaiHof3Sab(), pais.getPaiHoi4Sab(), pais.getPaiHof4Sab());
            default: return 0;    
        }
    }
    
    private static long getResta(Date ini, int dia, Date... dates) {
        long dm = 0;


        for (int i = 0; i < dates.length; i += 2) {

            Date d1 = getDateIni2(dates[i],dia);
            Date d2 = getDateFin2(dates[i + 1]);
            diaFinal[i] = getDateIni2(dates[i],dia);
            diaFinal[i+1] = getDateFin2(dates[i + 1]);
            if (d1 != null && d2 != null && d1.before(d2)) {

                
                    
                    dm += getMinutos(d1, d2);
                                               
             
            }
        }

        
        return dm;
    }
    
    private static Date getDateIni2(Date d,int dia) {
        if(d == null) {
            return null;
        }
        if(wFecha2.get(Calendar.DAY_OF_WEEK)==dia && d.before(wHora) && diaInicial==0 ){
            return null;
            
        }else if(wFecha2.get(Calendar.DAY_OF_WEEK)==dia && d.after(wHora) && diaInicial==0){
            diaInicial =1;
            return wHora;      
        }
        
        return (d);
    }
   
    
    private static Date getDateFin2(Date d) {
        
        if(d == null) {
            return null;
        }
        
        return (d);
    }
    
 
     
}

  
            


 
       
