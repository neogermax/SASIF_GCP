/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documentos;

import documentos.plantillas.DocProcesor;
import documentos.plantillas.ProcessorPDFText;
import documentos.plantillas.ProcessorText;
import documentos.tramas.Trama;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import jpa.valores.DocExistentes;
import jpa.valores.DocExistentesPK;
import jsf.controlador.PtdDocExistentes;

/**
 *
 * @author analista02
 */
@Stateless
public class Documentos implements DocumentosLocal {
    private PtdDocExistentes ptdDocExistentes = new PtdDocExistentes();
    
    @Override
    public void processDigitalizado(String trama) {
        try {
            Trama tr = new Trama(trama);
            String[] cabecera = tr.getCabecera();
            
            guardarDocumento(trama, cabecera);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void processDocument(String trama) {
        try {
            Trama tr = new Trama(trama);
            String[] cabecera = tr.getCabecera();
             
            if(guardarDocumento(trama, cabecera)) {
                String rdes = cabecera[11]+ cabecera[2] + cabecera[7] + cabecera[3] + cabecera[8] + "." + cabecera[9];
                merche(tr.getCampos(), cabecera[9], cabecera[12], rdes);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean guardarDocumento(String trama, String[] cabecera) throws Exception {
        DocExistentesPK pk = new DocExistentesPK(cabecera[2],
                                                 cabecera[9],
                                                 new Long(cabecera[8]).longValue(),
                                                 new Long(cabecera[3]).longValue(),
                                                 cabecera[7]);
        
        DocExistentes docEx = ptdDocExistentes.encontrar(pk);
            
        if(docEx == null) {
            docEx = new DocExistentes(pk);
            docEx.setDoexCodAreOri(Integer.valueOf(cabecera[5]));
            docEx.setDoexCodEmpOri(Integer.valueOf(cabecera[4]));
            docEx.setDoexCodUsuOri(cabecera[6]);
            docEx.setDoexFechaCreo(new Date());
            docEx.setDoexRutaAlma(cabecera[11]);
            docEx.setDoexTramaEnv(trama);
            ptdDocExistentes.insertar(docEx);
            return true;
        } else {
            docEx.setDoexUsuMod(cabecera[6]);
            docEx.setDoexFechaMod(new Date());
            docEx.setDoexTramaEnv(trama);
            ptdDocExistentes.actualizar(docEx);
            return false;
        }
    }
    
    private DocProcesor getProcess(String plantilla, String ext) {
        if(ext.equals("doc") || ext.equals("docx")) {
            return new ProcessorText();
        } else if(ext.equals("pdf")) {
            if(plantilla.endsWith(".doc") || plantilla.endsWith(".docx")) {
                return new ProcessorPDFText();
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
    
    private void merche(List<String[]> campos, String tipo, String rorg, String rdes) throws FileNotFoundException, IOException {
        Map<String, String> cms = new HashMap<String, String>();
        for(String[] camps : campos) {
            cms.put(camps[0], camps[1]);
        }
        DocProcesor doc = getProcess(rorg, tipo);
        if(doc == null)
            throw new RuntimeException();
        doc.mercheDoc(cms, rorg, rdes);
    }
}
