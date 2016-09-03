/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documentos.plantillas;

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
 * @author analista02
 */
public class ProcessorText implements DocProcesor {
    private boolean begin;
    private StringBuilder token = new StringBuilder();
    protected Map<String, String> items;
    
    private void adicionar(String text) {
        int ini, fin;
        ini = (text.startsWith("<")) ? 1 : 0;
        fin = (text.endsWith(">")) ? text.length()-1 : text.length();
        token.append(text.substring(ini, fin));
    }
    
    private String reemplazar(String text) {
        adicionar(text);
        String t = items.get(token.toString());
        token.delete(0, token.length());
        return t;
    }
    
    protected void analizar(XWPFRun r) {
        String text = r.getText(0);
        if(text == null)
            return;
        StringBuilder sb = new StringBuilder(text);
        int index, inicio = 0;
        do {
            index = (begin)? sb.indexOf(">", inicio) : sb.indexOf("<", inicio);
            if(index != -1) {
                if(begin) {
                    index++;
                    String asign = reemplazar(sb.substring(inicio, index));
                    if(asign != null) {
                        sb.replace(inicio, index, asign);
                        inicio += asign.length();
                    } else {
                        inicio = index;
                    }
                    begin = false;
                } else {
                    inicio = index;
                    begin = true;
                }
            } else if(begin) {
                adicionar(sb.substring(inicio, sb.length()));
                sb.replace(inicio, sb.length(), "");
            }
        } while(index != -1 && inicio < sb.length());
        r.setText(sb.toString(), 0);
    }
    
    private void actualizar(String filename, XWPFDocument document) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(new File(filename));
        document.write(fos);
        fos.close();
    }

    @Override
    public void mercheDoc(Map<String, String> items, String rorg, String rdes) throws FileNotFoundException, IOException {
        this.items = items;
        File archivoDoc = new File(rorg);
        InputStream entradaArch = new FileInputStream(archivoDoc);
        XWPFDocument document = new XWPFDocument(entradaArch);
        for(XWPFParagraph p : document.getParagraphs()) {
            for(XWPFRun r : p.getRuns()) {
                analizar(r);
            }
        }
        entradaArch.close();
        actualizar(rdes, document);
    }
    
}
