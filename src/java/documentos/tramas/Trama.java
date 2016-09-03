/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documentos.tramas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author analista02
 */
public class Trama {
    private final static String INITCAB = "RI&1";
    private final static String FINALCAB = "RF&1";
    private final static String INITCORREO = "RI&2";
    private final static String FINALCORREO = "RF&2";
    private final static String INITBODY = "RI&3";
    private final static String FINALBODY = "RF&3";
    private final static String INITCAMPO = "RRI&CAMPO";
    private final static String FINALCAMPO = "RRF&CAMPO";
    private final static String INITTAB = "RRI&TABLA";
    private final static String FINALTAB = "RRF&TABLA";
    private final static String INITTABCAB = "RRI&TABCAB";
    private final static String FINALTABCAB = "RRF&TABCAB";
    private final static String INITTABROW = "RRI&TABROW";
    private final static String FINALTABROW = "RRF&TABROW";
    private final static String SEPARADOR = "/-;/";
    private List<String[]> campos = new ArrayList<String[]>();
    private List<String[]> tabCabs = new ArrayList<String[]>();
    private List<List<String[]>> tablas = new ArrayList<List<String[]>>();
    private String[] cabecera;
    private String[] correos;
    
    public Trama(String t) {
        int index = t.indexOf(INITCAB);
        int index2 = t.indexOf(INITCORREO, index);
        cabecera = tokenizer(t.substring(index+INITCAB.length(), index2));
        index = t.indexOf(FINALCAB, index2);
        correos = tokenizer(t.substring(index2+INITCORREO.length(), index-FINALCORREO.length()));
        index = t.indexOf(INITBODY, index);
        index2 = t.indexOf(FINALBODY, index);
        t = t.substring(index+INITBODY.length(), index2);
        index = processCampos(t);
        processTablas(t.substring(index));
    }
    
    private int processCampos(String s) {
        int index, index2, resultado = 0;
        do {
            index = s.indexOf(INITCAMPO, resultado);
            index2 = s.indexOf(FINALCAMPO, index);
            if(index != -1 && index2 != -1) {
                campos.add(tokenizer(s.substring(index+INITCAMPO.length(), index2)));
                resultado = index2 + FINALCAMPO.length();
            }
        } while(index != -1 && index2 != -1);
        return resultado;
    }
    
    private void processTabla(String s) {
        int index = s.indexOf(INITTABCAB);
        int index2 = s.indexOf(FINALTABCAB, index);
        tabCabs.add(tokenizer(s.substring(index+INITTABCAB.length(), index2)));
        List<String[]> filas = new ArrayList<String[]>();
        tablas.add(filas);
        do {
            index = s.indexOf(INITTABROW, index);
            index2 = s.indexOf(FINALTABROW, index);
            if(index != -1 && index2 != -1) {
                filas.add(tokenizer(s.substring(index+INITTABROW.length(), index2)));
                index = index2 + FINALTABCAB.length();
            }
        } while(index != -1 && index2 != -1);
    }
    
    private void processTablas(String s) {
        int index = 0, index2;
        do {
            index = s.indexOf(INITTAB, index);
            index2 = s.indexOf(FINALTAB, index);
            if(index != -1 && index2 != -1) {
                processTabla(s.substring(index+INITTAB.length(), index2));
                index = index2 + FINALTAB.length();
            }
        } while(index != -1 && index2 != -1);
    }
    
    private String[] tokenizer(String s) {
        return s.split(SEPARADOR);
    }
    
    public String[] getCabecera() {
        return cabecera;
    }
    
    public String[] getCorreos() {
        return correos;
    }
    
    public List<String[]> getCampos() {
        return campos;
    }
    
    public List<String[]> getTabCabs() {
        return tabCabs;
    }
    
    public List<List<String[]>> getTablas() {
        return tablas;
    }
}
