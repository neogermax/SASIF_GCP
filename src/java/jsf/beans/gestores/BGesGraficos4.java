package jsf.beans.gestores;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.beans.generales.UtileriaHTTP;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;



@ManagedBean(name = "bgesGraficos4")
@SessionScoped
public class BGesGraficos4 implements Serializable{
    private StreamedContent chart;
    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    private File chartFile;
    private String vectTitulo[]={"Planeado","Real","Avance esperado","Avance real"};
    private int IndSuperior;
    private int IndInferior;

    final IntervalCategoryDataset dataset = createDataset();
     
    public BGesGraficos4() {
    }
        
    public StreamedContent getChart() {
        try {
            JFreeChart jfreechart = ChartFactory.createGanttChart(bgesReportes.getParametria().getParNombreRep(), bgesReportes.getParametria().getParArgDz(), bgesReportes.getParametria().getParArgCol(), createDataset(), true, true, false);
            chartFile = new File("dynamichart4.png");
            ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 680, 380);
            chart = new DefaultStreamedContent(new FileInputStream(chartFile), "image/png");
        } catch (Exception e) {
        }
        return chart;
    }

    private IntervalCategoryDataset createDataset() {

        TaskSeries s[] = new TaskSeries[4];
        TaskSeriesCollection collection = new TaskSeriesCollection();
        List<String[]> reportes = bgesReportes.getReportes();
        List<String> columnas = bgesReportes.getColumnas();
        List<String> filas = bgesReportes.getFilas();
        Date varDateIni;
        Date varDateFin;
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getDateInstance();
        Date now = new Date();
        df.applyPattern("yyyyMMdd");
        String var = df.format(now);
        int i = 0;
        int longitud = (columnas.size() - 1) / 2;

        for (int b = 0; b < longitud; b++) {
            s[b] = new TaskSeries(vectTitulo[b]);
        }

        for (String fila : filas) {
            String[] valores = reportes.get(i);
            IndSuperior = 0;
            IndInferior = -1;

            for (int wLineas = 0; wLineas < longitud; wLineas++) {
                IndInferior = 2 + IndInferior;
                IndSuperior = 2 + IndSuperior;

                if (Integer.parseInt(valores[IndInferior]) > 0 && Integer.parseInt(valores[IndSuperior]) > 0 && (Integer.parseInt(valores[IndInferior]) < Integer.parseInt(valores[IndSuperior]))) {
                    varDateIni = date(Integer.parseInt(valores[IndInferior].substring(6, 8)), Integer.parseInt(valores[IndInferior].substring(4, 6)) - 1, Integer.parseInt(valores[IndInferior].substring(0, 4)));
                    varDateFin = date(Integer.parseInt(valores[IndSuperior].substring(6, 8)), Integer.parseInt(valores[IndSuperior].substring(4, 6)) - 1, Integer.parseInt(valores[IndSuperior].substring(0, 4)));

                    s[wLineas].add(new Task(fila, varDateIni, varDateFin));
                }
            }
            i++;
        }
       
        for (int a = 0; a < longitud; a++) {
            collection.add(s[a]);
        }
        
        return collection;
    }
    
    private static Date date(final int day, final int month, final int year) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        final Date result = calendar.getTime();
        
        return result;
    }
    
   private JFreeChart createChart(final IntervalCategoryDataset dataset) {
        
         JFreeChart chart1 = ChartFactory.createGanttChart(
            "Gantt Chart Demo",  // chart title
            "Task",              // domain axis label
            "Date",              // range axis label
            dataset,             // data
            true,                // include legend
            true,                // tooltips
            false                // urls
        );    

        return chart1;
     }
    
}