/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.beans.generales.UtileriaHTTP;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
 

@ManagedBean(name = "bgesGraficos2")
@SessionScoped
public class BGesGraficos2 implements Serializable{
    private StreamedContent chart;
    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    private File chartFile;
    private int fill = 0;
    final CategoryDataset dataset = createDataset();
 
    public BGesGraficos2() {
    }
         
    public StreamedContent getChart() {
        try {
            JFreeChart jfreechart = ChartFactory.createLineChart(bgesReportes.getParametria().getParNombreRep(),bgesReportes.getParametria().getParArgDz(), bgesReportes.getParametria().getParArgCol(), createDataset(), PlotOrientation.VERTICAL,true,true,false);
            
            chartFile = new File("dynamichart2.png");
            List<String> filas2 = bgesReportes.getFilas();
            fill = filas2.size()* 100;
            ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 680, 380);
            chart = new DefaultStreamedContent(new FileInputStream(chartFile), "image/png");
        } catch(Exception e) {
        }
        return chart;
    }
    
    private CategoryDataset createDataset() {
        // create the dataset...
        final DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        
        List<String[]> reportes = bgesReportes.getReportes();
        List<String> columnas = bgesReportes.getColumnas();
        List<String> filas = bgesReportes.getFilas();
        int i=0;
        for(String fila : filas) {
            String[] valores = reportes.get(i);
            for(int j=1; j<columnas.size(); j++) {
                dataset1.addValue(Double.valueOf(valores[j]), columnas.get(j), fila);
            }
            i++;
        }
        return dataset1;
    }
    
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart1 = ChartFactory.createBarChart(
            "Bar Chart Demo",         // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart1.setBackgroundPaint(Color.white);

        final CategoryPlot plot = (CategoryPlot) chart1.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);

        // customise the range axis...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        // ****************************************************************************
        // * JFREECHART DEVELOPER GUIDE                                               *
        // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
        // * to purchase from Object Refinery Limited:                                *
        // *                                                                          *
        // * http://www.object-refinery.com/jfreechart/guide.html                     *
        // *                                                                          *
        // * Sales are used to provide funding for the JFreeChart project - please    * 
        // * support us so that we can continue developing free software.             *
        // ****************************************************************************
        
        // customise the renderer...
        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
//        renderer.setDrawShapes(true);

        renderer.setSeriesStroke(
            0, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            1, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {6.0f, 6.0f}, 0.0f
            )
        );
        renderer.setSeriesStroke(
            2, new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {2.0f, 6.0f}, 0.0f
            )
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart1;

        
    }
    
}