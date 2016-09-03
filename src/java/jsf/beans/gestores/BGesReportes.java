package jsf.beans.gestores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Caracteristicas;
import jpa.valores.CronoProye;
import jpa.valores.Parametrias;
import jpa.valores.Reportes;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdCaracteristicas;
import jsf.controlador.PtdParametrias;
import jsf.controlador.PtdReportes;

@ManagedBean(name = "bgesReportes")
@SessionScoped
public class BGesReportes implements Serializable {
    private String repUsuCod = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuario();
    
    private PtdParametrias ptdParametrias = new PtdParametrias();
    private PtdCaracteristicas ptdCaracteristicas = new PtdCaracteristicas();
    private PtdReportes ptdReportes = new PtdReportes();

    protected List<CronoProye> cronoProye;
    private List<Reportes> reportess;
    private List<Parametrias> parametrias;
    private List<Caracteristicas> caracteristicas;
    private List<String[]> reportes;
    private List<String> columnas = new ArrayList<String>();
    private List<String> filas = new ArrayList<String>();
    private List<String> columns;
    private List<String> fils;
    private List<String> columns1;
    private List<String> fils1;
    private List<String> columns2;
    private List<String> fils2;
    
    protected Caracteristicas caracteristica;
    protected Parametrias parametria;
    protected Reportes reporte;
    
    private String fecha = "S";
    private String fila = "T";
    private String columna = "T";
    private String opcion = "1";
    private String opcion2 = "1";
    private String opcion3 = "0";
    private String column1;
    private String column2;
    private String fil1;
    private String fil2;
    private int parametro;
    private int parametro2;
    private boolean flag = true;
    private int auxint=0;
    protected int vari;
    protected Integer NumMax;
    
 // CONSTRUCTOR  
    public BGesReportes() {
        reportess = ptdReportes.encontrarOpcion();
        reporte = reportess.get(0);
    }

/* -------------> INICIO - FUNCIONES <------------ */ 
    public void actionParametro(int p, int r) {
        opcion = "1";
        parametro = p;
        parametro2 = r;

        if (parametro == 0 && parametro2 != 0) {
            flag = false;
            parametria = ptdParametrias.encontrar(Integer.valueOf(parametro2));
            caracteristicas = ptdCaracteristicas.encontrarTodos(parametria);
        }
        if (parametro == 1 && parametro2 != 0) {
            flag = false;
            parametria = ptdParametrias.encontrar(Integer.valueOf(parametro2));
            caracteristicas = ptdCaracteristicas.encontrarHistorico(repUsuCod, parametria);
        }
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
        if (fecha.equals("N")) {
            selectCaracteristica2();
        }
    }
    
    public void setFil1(String fil1) {
        int index = fils.indexOf(fil1) + 1;
        ordenarLista2(fils, fils2, index);
        fil2 = fils2.get(0);
        this.fil1 = fil1;
    }
    
    public void setColumn1(String column1) {
        int index = columns.indexOf(column1) + 1;
        ordenarLista2(columns, columns2, index);
        column2 = columns2.get(0);
        this.column1 = column1;
    }
    
    private void selectParametria() {
        if (parametrias != null && !parametrias.isEmpty()) {
            parametria = parametrias.get(0);
            selectCaracteristica();
            fila = "T";
            columna = "T";
        }
    }
    
    private Parametrias selectParametria(Parametrias p) {
        int index = parametrias.indexOf(p);
        fila = "T";
        columna = "T";
        return (index == -1) ? null : parametrias.get(index);
    }
    
    public List<Parametrias> getParametrias() {
        parametrias = ptdParametrias.encontrarSint();
        selectParametria();
        return parametrias;
    }
   
    public void setParametria(Parametrias parametria) {
        this.parametria = selectParametria(parametria);
        caracteristicas = ptdCaracteristicas.encontrarHistorico(repUsuCod, parametria);
        selectCaracteristica();
    }
    
    public boolean isHistorico() {
        return caracteristicas != null && caracteristicas.size() > 1;
    }

    public List<Caracteristicas> getCaracterisiticas() {
        selectCaracteristica();
        return caracteristicas;
    }
    
    public void selectCaracteristica() {
        if (caracteristicas != null && !caracteristicas.isEmpty()) {
            caracteristica = caracteristicas.get(0);
            obtenerColumnas();
            obtenerFilas();
        } else {
            caracteristica = null;
            columnas.clear();
            filas.clear();
        }
        selectCaracteristicas();
    }
        
    public void selectCaracteristicas() {
        if (parametro == 0 && parametro2 == 0) {
            flag = true;
            caracteristicas = ptdCaracteristicas.encontrarTodos(parametria);
        }
        if (parametro == 1 && parametro2 == 0) {
            flag = true;
            caracteristicas = ptdCaracteristicas.encontrarHistorico(repUsuCod, parametria);
        }
    }
        
    public void asignarCaracteristica2() {
        if (parametro == 0) {
            caracteristica = ptdCaracteristicas.encontrarUltimo2(parametria.getParCodRepPk());
        } else {
            caracteristica = ptdCaracteristicas.encontrarUltimo(repUsuCod, parametria.getParCodRepPk());
        }
    }
    
    public void selectCaracteristica2() {
        asignarCaracteristica2();
        if (caracteristica == null) {
            columnas.clear();
            filas.clear();
        } else {
            obtenerColumnas();
            obtenerFilas();
        }
    }
    
    private Caracteristicas selectCaracteristica(Caracteristicas c) {
        int index = caracteristicas.indexOf(c);
        selectCaracteristica();
        return (index == -1) ? null : caracteristicas.get(index);
    }
    
    public void setCaracteristica(Caracteristicas caracteristica) {
        this.caracteristica = selectCaracteristica(caracteristica);
        obtenerColumnas();
        obtenerFilas();
    }
    
    private void ordenarLista(List<String> l, List<String> l1, List<String> l2, int index) {
        l1.addAll(l.subList(0, l.size() - 1));
        l2.addAll(l.subList(index + 1, l.size()));
    }
    
    private void ordenarLista2(List<String> l, List<String> l1, int index) {
        l1.clear();
        l1.addAll(l.subList(index, l.size()));
    }
    
    protected void obtenerColumnas() {
        columnas = ptdReportes.encontrarColumnas(caracteristica);
        if (columnas.size() > 1) {
            columns = new ArrayList<String>(columnas);
            ordenarLista(columns, columns1 = new ArrayList<String>(), columns2 = new ArrayList<String>(), 0);
            column1 = columns.get(0);
            column2 = columns.get(1);
        }
    }
    
    protected void obtenerFilas() {
        filas = ptdReportes.encontrarFilas(caracteristica);
        if (filas.size() > 1) {
            fils = new ArrayList<String>(filas);
            ordenarLista(fils, fils1 = new ArrayList<String>(), fils2 = new ArrayList<String>(), 0);
            fil1 = fils.get(0);
            fil2 = fils.get(1);
        }
    }
    
    private void procesarTabla() {
        List<Reportes> reporte = ptdReportes.encontrarCaracteristica(caracteristica, filas, columnas);
        reportes = new ArrayList<String[]>();
        List<String> rep = null;
        String fil = null;
        int jj = 0;

        for (Reportes r : reporte) {
            String f = r.getReportesPK().getRepNomFil();
            if (!f.equals(fil)) {
                if (rep != null) {
                    if (jj < columnas.size()) {
                        for (int i = jj; jj < columnas.size(); jj++) {
                            rep.add("0");
                        }
                    }
                    reportes.add(rep.toArray(new String[rep.size()]));
                }
                rep = new ArrayList<String>();
                rep.add(f);
                fil = f;
                jj = 0;
            }

            String g = r.getReportesPK().getRepNomCol();

            for (int i = jj; jj < columnas.size(); jj++) {
                if (g.equals(columnas.get(jj))) {
                    rep.add(r.getRepValor().toString());
                    jj++;
                    break;
                } else {
                    rep.add("0");
                }
            }
        }
        reportes.add(rep.toArray(new String[rep.size()]));
        columnas.add(0, parametria.getParArgFil());
    }
    
    public String action() {
        if (caracteristica == null) {
            UtileriaHTTP.addMessage(null, "Reporte no existente, o no permitido",
                    FacesMessage.SEVERITY_ERROR);
            return null;
        }
        if (fila.equals("R")) {
            filas = rangos(filas, fil1, fil2);
        }
        if (columna.equals("R")) {
            columnas = rangos(columnas, column1, column2);
        }
        if (filas.isEmpty()) {
            UtileriaHTTP.addMessage(null, "Debe escoger al menos una fila",
                    FacesMessage.SEVERITY_ERROR);
            return null;
        }
        if (columnas.isEmpty()) {
            UtileriaHTTP.addMessage(null, "Debe escoger al menos una columna",
                    FacesMessage.SEVERITY_ERROR);
            return null;
        }
        auxint = parametria.getParCodRepPk();
        
        switch (auxint) {
            case 90000: opcion2 = "4"; opcion3 = "1";
                        break;
            case 90001: opcion2 = "5"; opcion3 = "1";
                        break;
            case 90002: opcion2 = "1"; opcion3 = "0";
                        break;
            case 90003: opcion2 = "1"; opcion3 = "0";
                        break;
            case 90004: opcion2 = "1"; opcion3 = "0";
                        break;
            case 90005: opcion2 = "1"; opcion3 = "0";
                        break;
            case 90006: opcion2 = "1"; opcion3 = "0";
                        break;
            case 90007: opcion2 = "1"; opcion3 = "0";
                        break;
            case 90008: opcion2 = "1"; opcion3 = "0";
                        break;
            default:    opcion2 = "1"; opcion3 = "0";
                        break;
        }
        procesarTabla();
        opcion = "2";
        return null;
    }
    
    private List<String> rangos(List<String> l, String rango1, String rango2) {
        int i1 = l.indexOf(rango1);
        int i2 = l.indexOf(rango2) + 1;
        return l.subList(i1, i2);
    }
    
    public String actionOpcion() {
        opcion = UtileriaHTTP.getParameter("opcion");
        selectParametria();
        setFlag(true);
        return null;
    }
    
    public String obtenerFecha(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a");
        String date1 = sdf.format(date);
        return date1;

    }
    
    public String actionOpcion2() {
        opcion2 = UtileriaHTTP.getParameter("opcion2");
        return null;
    }
/* -------------> FINAL - FUNCIONES <------------ */ 

/* -----> INICIO - GET Y SET DE VARIABLES <-----  */

    public int getVari() {
        return vari;
    }

    public void setVari(int vari) {
        this.vari = vari;
    }
    
    public boolean isFlag() {
        return flag;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getParametro() {
        return parametro;
    }

    public void setParametro(int parametro) {
        this.parametro = parametro;
    }

    public int getParametro2() {
        return parametro2;
    }

    public void setParametro2(int parametro2) {
        this.parametro2 = parametro2;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
 public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getFecha() {
        return fecha;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getFil1() {
        return fil1;
    }

    public String getFil2() {
        return fil2;
    }

    public void setFil2(String fil2) {
        this.fil2 = fil2;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

    public String getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public Parametrias getParametria() {
        return parametria;
    }

    public Caracteristicas getCaracteristica() {
        return caracteristica;
    }

    public List<String> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }

    public List<String> getColumns1() {
        return columns1;
    }

    public void setColumns1(List<String> columns1) {
        this.columns1 = columns1;
    }

    public List<String> getColumns2() {
        return columns2;
    }

    public void setColumns2(List<String> columns2) {
        this.columns2 = columns2;
    }

    public List<String> getFilas() {
        return filas;
    }

    public void setFilas(List<String> filas) {
        this.filas = filas;
    }

    public List<String> getFils1() {
        return fils1;
    }

    public void setFils1(List<String> fils1) {
        this.fils1 = fils1;
    }

    public List<String> getFils2() {
        return fils2;
    }

    public void setFils2(List<String> fils2) {
        this.fils2 = fils2;
    }

    public List<String[]> getReportes() {
        return reportes;
    }
/*-----> FINAL - GET Y SET DE VARIABLES <-----  */
}
