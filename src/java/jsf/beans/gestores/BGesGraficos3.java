package jsf.beans.gestores;

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
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;



@ManagedBean(name = "bgesGraficos3")
@SessionScoped
public class BGesGraficos3 implements Serializable{
    private StreamedContent chart;
    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    private File chartFile;
    final CategoryDataset dataset = createDataset();
 
    public BGesGraficos3() {
    }
         
    public StreamedContent getChart() {
        try {
            JFreeChart jfreechart = ChartFactory.createBarChart3D(bgesReportes.getParametria().getParNombreRep(),bgesReportes.getParametria().getParArgDz(), bgesReportes.getParametria().getParArgCol(), createDataset(), PlotOrientation.VERTICAL,true,true,false);
            chartFile = new File("dynamichart3.png");
            List<String> filas2 = bgesReportes.getFilas();
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
        final JFreeChart chart = ChartFactory.createBarChart3D(
            "3D Bar Chart Demo",      // chart title
            "Category",               // domain axis label
            "Value",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
        );
        
        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        final BarRenderer r = (BarRenderer) renderer;
        r.setMaximumBarWidth(0.05);
        
        return chart;


        
    }
    
}