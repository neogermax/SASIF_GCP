/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documentos.plantillas;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author analista03
 */
public class ProcessorPDFText extends ProcessorText {
    @Override
    public void mercheDoc(Map<String, String> items, String rorg, String rdes) throws FileNotFoundException, IOException {
        try {
            this.items = items;
            File archivoDoc = new File(rorg);
            InputStream entradaArch = new FileInputStream(archivoDoc);
            XWPFDocument document = new XWPFDocument(entradaArch);
            Document pdf = new Document();
            PdfWriter.getInstance(pdf, new FileOutputStream(rdes));
            pdf.open();
            for(XWPFParagraph p : document.getParagraphs()) {
                Paragraph pd = new Paragraph();
                for(XWPFRun r : p.getRuns()) {
                    analizar(r);
                    pd.add(new Chunk(r.getText(0)));
                }
                pdf.add(pd);
            }
            pdf.close();
            entradaArch.close();
        } catch (DocumentException ex) {
        }
    }
}
