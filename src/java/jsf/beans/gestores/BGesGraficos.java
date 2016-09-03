/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

 
import java.awt.Color;
import java.awt.GradientPaint;
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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "bgesGraficos")
@SessionScoped
public class BGesGraficos implements Serializable{
    private StreamedContent chart;
    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    private File chartFile;
    
    final CategoryDataset dataset = createDataset();
    private int fill = 0;
    public BGesGraficos() {
    }
     
    
         
    public StreamedContent getChart() {
        try {
            JFreeChart jfreechart = ChartFactory.createBarChart(bgesReportes.getParametria().getParNombreRep(),bgesReportes.getParametria().getParArgDz(), bgesReportes.getParametria().getParArgCol(), createDataset(), PlotOrientation.VERTICAL,true,true,false);
            chartFile = new File("dynamichart.png");
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
        chart1.setBackgroundPaint(Color.gray);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart1.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart1;
        
    }
    
}