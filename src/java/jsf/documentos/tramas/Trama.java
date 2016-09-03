/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.documentos.tramas;

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
    private List<CampoTrama> campos = new ArrayList<CampoTrama>();
    private List<TablaTrama> tablas = new ArrayList<TablaTrama>();
    private StringBuilder trama = new StringBuilder();
    private int indexCab;
    private int cantCab;
    private int indexCor;
    private int cantCor;
    private int indexCamp;
    private int indexTab;
    
    public Trama() {
        trama.append(INITCAB);
        indexCab = INITCAB.length();
        trama.append(INITCORREO);
        indexCor = indexCab + INITCORREO.length();
        trama.append(FINALCORREO);
        trama.append(FINALCAB);
        trama.append(INITBODY);
        indexTab = indexCamp = indexCor + FINALCORREO.length() + FINALCAB.length() + INITBODY.length();
        trama.append(FINALBODY);
    }
    
    private int addElement(String element, int cantType, int index) {
        int cant = element.length();
        if(cantType != 0) {
            trama.insert(index, SEPARADOR);
            index += SEPARADOR.length();
            cant += SEPARADOR.length();
        }
        trama.insert(index, element);
        return cant;
    }
    
    public void addCabecera(String element) {
        int cant = addElement(element, cantCab, indexCab);
        indexCab += cant;
        indexCor += cant;
        indexCamp += cant;
        indexTab += cant;
        cantCab++;
        if(!campos.isEmpty()) {
            actualizar(0, cant);
        }
        if(!tablas.isEmpty()) {
            actualizar2(0, cant);
        }
    }
    
    public void addCorreo(String element) {
        int cant = addElement(element, cantCor, indexCor);
        indexCor += cant;
        indexCamp += cant;
        indexTab += cant;
        cantCor++;
        if(!campos.isEmpty()) {
            actualizar(0, cant);
        }
        if(!tablas.isEmpty()) {
            actualizar2(0, cant);
        }
    }
    
    private void actualizar(int index, int inc) {
        for(int i = index; i<campos.size(); i++) {
            CampoTrama tb = campos.get(i);
            tb.setIndex(inc);
        }
    }
    
    private CampoTrama getCampo(int index) {
        if(index > campos.size()) {
            throw new RuntimeException("indice incorrecto");
        } else if(index == campos.size()) {
            return crearCampo();
        } else {
            return campos.get(index);
        }
    }
    
    public void addElementCampo(int index, String element) {
        CampoTrama tb = getCampo(index);
        int cant = addElement(element, tb.getCant(), tb.getIndex());
        indexCamp += cant;
        indexTab += cant;
        tb.incCant();
        actualizar(index, cant);
        if(!tablas.isEmpty()) {
            actualizar2(0, cant);
        }
    }
    
    private CampoTrama crearCampo() {
        CampoTrama tb = new CampoTrama();
        campos.add(tb);
        trama.insert(indexCamp, INITCAMPO);
        indexCamp += INITCAMPO.length();
        indexTab += INITCAMPO.length();
        tb.setIndex(indexCamp);
        trama.insert(indexCamp, FINALCAMPO);
        indexCamp += FINALCAMPO.length();
        indexTab += FINALCAMPO.length();
        if(!tablas.isEmpty()) {
            actualizar2(0, INITCAMPO.length() + FINALCAMPO.length());
        }
        return tb;
    }
    
    private TablaTrama crearTabla() {
        String s = INITTAB + INITTABCAB;
        trama.insert(indexTab, s);
        indexTab += s.length();
        TablaTrama tb = new TablaTrama(indexTab, FINALTABCAB.length());
        tablas.add(tb);
        s = FINALTABCAB + FINALTAB;
        trama.insert(indexTab, s);
        indexTab += s.length();
        return tb;
    }
    
    private TablaTrama getTabla(int index) {
        if(index > tablas.size()) {
            throw new RuntimeException("indice incorrecto");
        } else if(index == tablas.size()) {
            return crearTabla();
        } else {
            return tablas.get(index);
        }
    }
    
    private void actualizar2(int index, int inc) {
        indexTab += inc;
        for(int i=index; i<tablas.size(); i++) {
            TablaTrama tb = tablas.get(i);
            tb.setIndex(inc);
            CampoTrama ct = tb.getCabecera();
            ct.setIndex(inc);
            for(CampoTrama ctt : tb.getFilas()) {
                ctt.setIndex(inc);
            }
        }
    }
    
    private void actualizar(int index, int index2, int inc) {
        TablaTrama tb = tablas.get(index);
        tb.setIndex(inc);
        for(int i = index2; i<tb.getFilas().size(); i++) {
            CampoTrama ct = tb.getFilas().get(i);
            ct.setIndex(inc);
        }
        actualizar2(index + 1, inc);
    }
    
    public void addCabTabla(int index, String element) {
        TablaTrama tb = getTabla(index);
        CampoTrama ct = tb.getCabecera();
        int cant = addElement(element, ct.getCant(), ct.getIndex());
        ct.incCant();
        actualizar2(index, cant);
    }
    
    private CampoTrama crearFila(TablaTrama tabla) {
        CampoTrama cr = new CampoTrama();
        tabla.addCampoTrama(cr);
        trama.insert(tabla.getIndex(), INITTABROW);
        tabla.setIndex(INITTABROW.length());
        indexTab += INITTABROW.length();
        cr.setIndex(tabla.getIndex());
        trama.insert(tabla.getIndex(), FINALTABROW);
        tabla.setIndex(FINALTABROW.length());
        indexTab += FINALTABROW.length();
        return cr;
    }
    
    private CampoTrama getFila(int index, TablaTrama tabla) {
        if(index > tabla.getFilas().size()) {
            throw new RuntimeException("indice incorrecto");
        } else if(index == tabla.getFilas().size()) {
            return crearFila(tabla);
        } else {
            return tabla.getFilas().get(index);
        }
    }
    
    public void addElementTabla(int index, int index2, String element) {
        TablaTrama tb = getTabla(index);
        CampoTrama cr = getFila(index2, tb);
        int cant = addElement(element, cr.getCant(), cr.getIndex());
        cr.incCant();
        actualizar(index, index2, cant);
    }
    
    @Override
    public String toString() {
        return trama.toString();
    }
}
