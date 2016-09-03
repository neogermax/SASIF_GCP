/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import jsf.controlador.PtdCronoProye;

/**
 *
 * @author analista03
 */
class Repeticion {
    private List<Class> classs = new ArrayList<Class>();
    private List<String> clases = new ArrayList<String>();
    private List<List> consultas = new ArrayList<List>();
    private List consulta;
    private Map<Short, TablaCampo> secuencias;
    private Map<Short, Map<Short, TablaCampo>> tablas = new TreeMap<Short, Map<Short, TablaCampo>>();
    private Integer proyCodPk;
    private PtdCronoProye ptdCronoProye = new PtdCronoProye();
    private Class clas;
    private TablaCampo tb;
    
    public Repeticion(Integer proyCodPk) {
        this.proyCodPk = proyCodPk;
    }
    
    private void processClass(String tabla) {
        try {
            clas = Class.forName("jpa.valores." + tabla);
            classs.add(clas);
        } catch (Exception ex) {
        }
    }
    
    private void consultas(String tabla) {
        if(tabla.equals("CronoProye")) {
            consulta = ptdCronoProye.encontrarProyecto(proyCodPk);
        } else if(tabla.equals("CronoProyePK")) {
            consulta = ptdCronoProye.encontrarProyect(proyCodPk);
        }
        consultas.add(consulta);
        processClass(tabla);
    }
    
    private Object getCampo(Class c, Object obj, String campo) {
        try {
            StringBuilder sb = new StringBuilder(campo);
            sb.setCharAt(0, ("" + sb.charAt(0)).toUpperCase().charAt(0));
            sb.insert(0, "get");
            Method m = c.getMethod(sb.toString());
            return m.invoke(obj);
        } catch (Exception ex) {
            return null;
        }
    }
    
    private void llenarValores(String campo) {
        for(Object obj : consulta) {
            String s = getCampo(clas, obj, campo).toString();
            tb.addCampo(s);
        }
    }
    
    public void addElemento(String label, Short repeticion, Short secuencia, String tabla, String campo) {
        int index = clases.indexOf(tabla);
        if(index == -1) {
            clases.add(tabla);
            consultas(tabla);
        } else {
            consulta = consultas.get(index);
            clas = classs.get(index);
        }
        
        if(tablas.containsKey(repeticion)) {
            secuencias = tablas.get(repeticion);
            if(!secuencias.containsKey(secuencia)) {
                tb = new TablaCampo(label);
                llenarValores(campo);
                secuencias.put(secuencia, tb);
            }
        } else {
            tb = new TablaCampo(label);
            llenarValores(campo);
            secuencias = new TreeMap<Short, TablaCampo>();
            secuencias.put(secuencia, tb);
            tablas.put(repeticion, secuencias);
        }
    }
    
    public Map<Short, Map<Short, TablaCampo>> getTablas() {
        return tablas;
    }
}
