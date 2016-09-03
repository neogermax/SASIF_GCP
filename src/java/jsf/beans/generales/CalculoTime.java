/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import java.util.Calendar;
import java.util.Date;
import jpa.valores.Festivos;
import jpa.valores.Paises;

/**
 *
 * @author analista02
 */
public class CalculoTime {
    
    private static long getMinutos(Date d1, Date d2) {
        long dif = d2.getTime() - d1.getTime();
        return (long)Math.ceil((double)dif /60000d); 
    }
    
    private static Date getDateIni(Date ini, Date d) {
        if(ini == null) {
            return null;
        }
        if(d == null) {
            return ini;
        }
        return (ini.before(d))?d:ini;
    }
    
    private static Date getDateFin(Date fin, Date d) {
        if(fin == null) {
            return null;
        }
        if(d == null) {
            return fin;
        }
        return (fin.after(d))?d:fin;
    }
    
    private static long getDiaMinutos(Date ini, Date fin, Date... dates) {
        long dm = 0;
        for(int i=0; i<dates.length; i+=2) {
            Date d1 = getDateIni(dates[i], ini);
            Date d2 = getDateFin(dates[i+1], fin);
            
            if(d1 != null && d2 != null && d1.before(d2)) {
                dm += getMinutos(d1, d2);
            }
        }
        return dm;
    }
    
    private static long getDiaMunutos(int dia, Paises pais, Date ini, Date fin) {
        switch(dia) {
            case Calendar.SUNDAY: return getDiaMinutos(ini, fin, pais.getPaiHoi1Dom(), pais.getPaiHof1Dom(),
                    pais.getPaiHoi2Dom(), pais.getPaiHof2Dom(), pais.getPaiHoi3Dom(),
                    pais.getPaiHof3Dom(), pais.getPaiHoi4Dom(), pais.getPaiHof4Dom());
            
            case Calendar.MONDAY: return getDiaMinutos(ini, fin, pais.getPaiHoi1Lun(), pais.getPaiHof1Lun(),
                    pais.getPaiHoi2Lun(), pais.getPaiHof2Lun(), pais.getPaiHoi3Lun(),
                    pais.getPaiHof3Lun(), pais.getPaiHoi4Lun(), pais.getPaiHof4Lun());
                
            case Calendar.TUESDAY: return getDiaMinutos(ini, fin, pais.getPaiHoi1Mar(), pais.getPaiHof1Mar(),
                    pais.getPaiHoi2Mar(), pais.getPaiHof2Mar(), pais.getPaiHoi3Mar(),
                    pais.getPaiHof3Mar(), pais.getPaiHoi4Mar(), pais.getPaiHof4Mar());
                
            case Calendar.WEDNESDAY: return getDiaMinutos(ini, fin, pais.getPaiHoi1Mie(), pais.getPaiHof1Mie(),
                    pais.getPaiHoi2Mie(), pais.getPaiHof2Mie(), pais.getPaiHoi3Mie(),
                    pais.getPaiHof3Mie(), pais.getPaiHoi4Mie(), pais.getPaiHof4Mie());
                
            case Calendar.THURSDAY: return getDiaMinutos(ini, fin, pais.getPaiHoi1Jue(), pais.getPaiHof1Jue(),
                    pais.getPaiHoi2Jue(), pais.getPaiHof2Jue(), pais.getPaiHoi3Jue(),
                    pais.getPaiHof3Jue(), pais.getPaiHoi4Jue(), pais.getPaiHof4Jue());
                
            case Calendar.FRIDAY: return getDiaMinutos(ini, fin, pais.getPaiHoi1Vie(), pais.getPaiHof1Vie(),
                    pais.getPaiHoi2Vie(), pais.getPaiHof2Vie(), pais.getPaiHoi3Vie(),
                    pais.getPaiHof3Vie(), pais.getPaiHoi4Vie(), pais.getPaiHof4Vie());
                
            case Calendar.SATURDAY: return getDiaMinutos(ini, fin, pais.getPaiHoi1Sab(), pais.getPaiHof1Sab(),
                    pais.getPaiHoi2Sab(), pais.getPaiHof2Sab(), pais.getPaiHoi3Sab(),
                    pais.getPaiHof3Sab(), pais.getPaiHoi4Sab(), pais.getPaiHof4Sab());
            default: return 0;    
        }
    }
    
    private static boolean isLaboral(int dw, Paises pais, Calendar cal, boolean actFes) {
        switch(dw) {
            case Calendar.SUNDAY: return pais.getPaiEstDom().equals("L") && !isFestivo(pais, cal, actFes);
            case Calendar.MONDAY: return pais.getPaiEstLun().equals("L") && !isFestivo(pais, cal, actFes);
            case Calendar.TUESDAY: return pais.getPaiEstMar().equals("L") && !isFestivo(pais, cal, actFes);
            case Calendar.WEDNESDAY: return pais.getPaiEstMie().equals("L") && !isFestivo(pais, cal, actFes);
            case Calendar.THURSDAY: return pais.getPaiEstJue().equals("L") && !isFestivo(pais, cal, actFes);
            case Calendar.FRIDAY: return pais.getPaiEstVie().equals("L") && !isFestivo(pais, cal, actFes);
            case Calendar.SATURDAY: return pais.getPaiEstSab().equals("L") && !isFestivo(pais, cal, actFes);
            default: return false;
        }
    }
    
    private static boolean isFestivo(Paises pais, Calendar cal, boolean actFes) {
        if(!actFes) {
            return false;
        }
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
    
    public static long getTimeMinutos(Paises pais, Date ini, Date fin, boolean actFes) {
        
        
        Calendar cal = Calendar.getInstance();
        cal.setTime(ini);
        Calendar cal1 = Calendar.getInstance();
        cal1.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.setTime(fin);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        
        int p = -1, u = -1;
        boolean primero = true;
        int[] dias = new int[7];
        
        while(cal1.before(cal2)) {
            int dw = cal1.get(Calendar.DAY_OF_WEEK);
            if(isLaboral(dw, pais, cal1, actFes)) {
                if(primero) {
                    primero = false;
                    p = dw;
                } else {
                    dias[dw]++;
                    u = dw;
                }
            }
            cal1.add(Calendar.DAY_OF_YEAR, 1);
        }
        
        
        long m = 0;
        if(p != -1) {
            Date d1 = getHora(ini);
            Date d2 = getHora(fin);
            if(u == -1) {
                m = getDiaMunutos(p, pais, d1, d2);
            } else {
                m = getDiaMunutos(p, pais, d1, null);
                m += getDiaMunutos(u, pais, null, d2);
                dias[u]--;
                for(int i=0; i<dias.length; i++) {
                    if(dias[i] != 0) {
                        m += (dias[i] * getDiaMunutos(i, pais, null, null));
                    }
                }
            }
        }
        
        return m;
    }
}
