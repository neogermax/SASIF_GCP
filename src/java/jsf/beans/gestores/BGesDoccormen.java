/*
 * BGesDoccormen: Se trata y presenta tabla con la informacion de documentos existentes.
 */
package jsf.beans.gestores;

import documentos.utilerias.UtileriasDocumentos;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.DocExistentes;
import jpa.valores.Pdocumentos;
import jpa.valores.PermisosDocUsu;
import jpa.valores.Usuarios;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdDocExistentes;
import jsf.controlador.PtdPdocumentos;
import jsf.controlador.PtdPermisosDocUsu;
import jsf.controlador.PtdUsuarios;


@ManagedBean(name = "bgesDoccormen")
@SessionScoped
public class BGesDoccormen implements Serializable {
    private List<String> columnas;
    private List<String> fileTemps = new ArrayList<String>();
    private Usuarios usuario = ((BGesLogin) UtileriaHTTP.getBean("bgesLogin")).getUsuarios();
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private PtdPermisosDocUsu ptdPermisosDocUsu = new PtdPermisosDocUsu();
    private PtdDocExistentes ptdDocExistentes = new PtdDocExistentes();
    private PtdPdocumentos ptdPdocumentos = new PtdPdocumentos();
    private DocExistentes docExistente;
    private List<DocExistentes> vectorDocExi;
    private List<DocExistentes> docExistentes;
    private String opcion = "1";
    private String opcionCarac = "";
    private String proyecto = "";
    private ArrayList<String> vectorTipo;
    private ArrayList<String> digitalizados;
    private ArrayList<String> docs;
    private String URL = "";
    private String fileTemp;
    private String rutaserv = "http://www.sistemassasif.com/archivo/";
    private boolean pdf;
    private boolean img;
    private boolean doc;
    
    
    
    /*-----> INICIO - CREADO ANALISTA 04 - 001 <-----  */

    public BGesDoccormen() {
        columnas = new ArrayList<String>();
        columnas.add("1");
        columnas.add("2");
        columnas.add("3");
        columnas.add("4");
        
        digitalizados = new ArrayList<String>();
        digitalizados.add("pdf");
        digitalizados.add("gif");
        digitalizados.add("jpg");
        digitalizados.add("bmp");
        digitalizados.add("png");
        
        docs = new ArrayList<String>();
        docs.add("doc");
        docs.add("docx");
        docs.add("xls");
        docs.add("xlsx");
        docs.add("ppt");
    }

    public void action() {
        this.opcionCarac = UtileriaHTTP.getParameter("valor");
        this.proyecto = UtileriaHTTP.getParameter("proyecto");
        opcion = "2";
        LlenaTipoDoc();
        permiso();
    }

    public void permiso() {
        List<Pdocumentos> pdocumentoses = ptdPdocumentos.encontrarTodos();
        List<PermisosDocUsu> permisosDocUsus = ptdPermisosDocUsu.encontrarTodos();
        List<DocExistentes> docExistenteses = ptdDocExistentes.encontrarTodos();
        ArrayList<ArrayList<String>> vectorDoc = new ArrayList<ArrayList<String>>();
        vectorDocExi = new ArrayList<DocExistentes>();
        
        if (usuario.getUsuAccDoc() == 1) {
            for (Pdocumentos pd : pdocumentoses) {
                ArrayList<String> vdoc = new ArrayList<String>();
                vdoc.add(pd.getPdoDocumentoPk());
                vdoc.add("P");
                vdoc.add("S");
                vdoc.add("N");
                vectorDoc.add(vdoc);
            }
        } else {
            switch (usuario.getUsuAccIdo()) {
                case 1: vectorDoc = informacionTodos(permisosDocUsus, vectorDoc);
                        break;
                case 2: vectorDoc = informacionPropios(permisosDocUsus, vectorDoc, usuario);
                        break;
                case 3: vectorDoc = informacionArea(permisosDocUsus, vectorDoc, docExistenteses, usuario);
                        break;
                case 4: vectorDoc = informacionEmpresa(permisosDocUsus, vectorDoc, docExistenteses, usuario);
                        break;
            }
        }
        
        for(ArrayList<String> vdoc : vectorDoc) {
            for(DocExistentes de : docExistenteses) {
                for(String s : vectorTipo) {
                    if(vdoc.get(2).equals("S") &&
                            vdoc.get(0).equals(de.getDocExistentesPK().getDoexNomDoc()) &&
                            (Integer.parseInt(proyecto)) == de.getDocExistentesPK().getDoexIdeApli() &&
                            de.getDocExistentesPK().getDoexTipoDoc().equals(s)) {
                        vectorDocExi.add(de);
                    }
                }
            }
        }
        
    }

    private ArrayList<ArrayList<String>> informacionTodos(List<PermisosDocUsu> permisosDocUsus, ArrayList<ArrayList<String>> vectorDoc) {
        int cont = 0;
        for (PermisosDocUsu pdu : permisosDocUsus) {
            if (!validaRepetido(pdu.getPermisosDocUsuPK().getPdouDocCodFk(), vectorDoc)) {
                vectorDoc.add(new ArrayList<String>());
                vectorDoc.get(cont).add(pdu.getPermisosDocUsuPK().getPdouDocCodFk());
                vectorDoc.get(cont).add(pdu.getPdouAccIdo().toString());
                vectorDoc.get(cont).add(pdu.getPdouTipAccCon());
                vectorDoc.get(cont).add(pdu.getPdouTipAccAct());
                cont++;
            }
        }
        return vectorDoc;
    }

    private ArrayList<ArrayList<String>> informacionPropios(List<PermisosDocUsu> permisosDocUsus, ArrayList<ArrayList<String>> vectorDoc, Usuarios u) {
        int cont = 0;
        for (PermisosDocUsu pdu : permisosDocUsus) {
            if (u.getUsuCodPk().equals(pdu.getPermisosDocUsuPK().getPdouUsuCodFk())) {
                if (!validaRepetido(pdu.getPermisosDocUsuPK().getPdouDocCodFk(), vectorDoc)) {
                    vectorDoc.add(new ArrayList<String>());
                    vectorDoc.get(cont).add(pdu.getPermisosDocUsuPK().getPdouDocCodFk());
                    vectorDoc.get(cont).add(pdu.getPdouAccIdo().toString());
                    vectorDoc.get(cont).add(pdu.getPdouTipAccCon());
                    vectorDoc.get(cont).add(pdu.getPdouTipAccAct());
                    cont++;
                }
            }
        }
        return vectorDoc;
    }

    private ArrayList<ArrayList<String>> informacionArea(List<PermisosDocUsu> permisosDocUsus, ArrayList<ArrayList<String>> vectorDoc, List<DocExistentes> docExistenteses, Usuarios u) {
        List<Usuarios> usuariosArea = ptdUsuarios.encontrarPorArea(u.getEmpleados().getAreas());
        int cont = 0;
        for (Usuarios usa : usuariosArea) {
            for (PermisosDocUsu pdu : permisosDocUsus) {
                if (usa.getUsuCodPk().equals(pdu.getPermisosDocUsuPK().getPdouUsuCodFk())) {
                    if (!validaRepetido(pdu.getPermisosDocUsuPK().getPdouDocCodFk(), vectorDoc)) {
                        vectorDoc.add(new ArrayList<String>());
                        vectorDoc.get(cont).add(pdu.getPermisosDocUsuPK().getPdouDocCodFk());
                        vectorDoc.get(cont).add(pdu.getPdouAccIdo().toString());
                        vectorDoc.get(cont).add(pdu.getPdouTipAccCon());
                        vectorDoc.get(cont).add(pdu.getPdouTipAccAct());
                        cont++;
                    }
                }
            }
        }
        return vectorDoc;
    }

    private ArrayList<ArrayList<String>> informacionEmpresa(List<PermisosDocUsu> permisosDocUsus, ArrayList<ArrayList<String>> vectorDoc, List<DocExistentes> docExistenteses, Usuarios u) {
        List<Usuarios> usuariosEmpresa = ptdUsuarios.encontrarPorEmpresa(u.getEmpleados().getAreas().getEmpresas());
        int cont = 0;
        for (Usuarios usa : usuariosEmpresa) {
            for (PermisosDocUsu pdu : permisosDocUsus) {
                if (usa.getUsuCodPk().equals(pdu.getPermisosDocUsuPK().getPdouUsuCodFk())) {
                    if (!validaRepetido(pdu.getPermisosDocUsuPK().getPdouDocCodFk(), vectorDoc)) {
                        vectorDoc.add(new ArrayList<String>());
                        vectorDoc.get(cont).add(pdu.getPermisosDocUsuPK().getPdouDocCodFk());
                        vectorDoc.get(cont).add(pdu.getPdouAccIdo().toString());
                        vectorDoc.get(cont).add(pdu.getPdouTipAccCon());
                        vectorDoc.get(cont).add(pdu.getPdouTipAccAct());
                        cont++;
                    }
                }
            }
        }
        return vectorDoc;
    }

    private boolean validaRepetido(String dato, ArrayList<ArrayList<String>> vectorDoc) {
        for(ArrayList<String> vdoc : vectorDoc) {
            if(dato.equals(vdoc.get(0))) {
                return true;
            }
        }
        return false;
    }
   
    private void LlenaTipoDoc() {
        vectorTipo = new ArrayList<String>();
        switch(opcionCarac.charAt(0)){
            case 'D':
                vectorTipo.addAll(digitalizados);
                vectorTipo.addAll(docs);
                break;
            case 'C':
                vectorTipo.add("email");
                break;
            case 'M':
                vectorTipo.add("msn");
                break;
        }
    }
    
    public void obtenerURL() throws InterruptedException, SocketException, IOException{
        String ruta = UtileriaHTTP.getParameter("ruta");
        fileTemp = usuario.getUsuCodPk() + "_" + UtileriaHTTP.getParameter("doc");
        doc = pdf = img = false;
        if(!fileTemps.contains(fileTemp)) {
            UtileriasDocumentos.copyFTP(ruta, fileTemp);
            fileTemps.add(fileTemp);
        }
        if(fileTemp.endsWith("pdf")) {
            URL = "http://docs.google.com/viewer?url=" + rutaserv + fileTemp + "&embedded=true";
            pdf = true;
        } else {
            URL = rutaserv + fileTemp;
            img = true;
        }
    }
    
    public void exit() {
        UtileriasDocumentos.deleteDocument(fileTemp);
        doc = false;
        URL = "";
    }
    
    public void descarga() throws SocketException, IOException {
        String ruta = UtileriaHTTP.getParameter("ruta");
        fileTemp = usuario.getUsuCodPk() + "_" + UtileriaHTTP.getParameter("doc");
        if(!fileTemps.contains(fileTemp)) {
            UtileriasDocumentos.copyFTP(ruta, fileTemp);
            fileTemps.add(fileTemp);
        }
        URL = rutaserv + fileTemp;
        pdf = img = false;
        doc = true;
    }
    
    /*-----> FINAL - CREADO ANALISTA 04 - 001 <------  */

    /*-----> INICIO - GET Y SET DE VARIABLES <-----  */
    public String getOpcion() {
        return opcion;
    }

    public String actionOpcion() {
        this.opcion = UtileriaHTTP.getParameter("opcion");
        UtileriasDocumentos.deleteDocument(fileTemps);
        fileTemps.clear();
        opcionCarac = "";
        doc = false;
        return null;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getOpcionCarac() {
        return opcionCarac;
    }

    public void setOpcionCarac(String opcionCarac) {
        this.opcionCarac = opcionCarac;
    }

    public List<DocExistentes> getVectorDocExi() {
        return vectorDocExi;
    }

    public void setVectorDocExi(List<DocExistentes> vectorDocExi) {
        this.vectorDocExi = vectorDocExi;
    }

    public List<String> getColumnas() {
        return columnas;
    }

    public void setColumnas(List<String> columnas) {
        this.columnas = columnas;
    }

    public List<DocExistentes> getDocExistentes() {
        docExistentes = ptdDocExistentes.encontrarTodos();
        selectDocExistente();
        return docExistentes;
    }

    private void selectDocExistente() {
        if (docExistente == null && !docExistentes.isEmpty()) {
            docExistente = docExistentes.get(0);
        } else if (!docExistentes.isEmpty()) {
            int index = docExistentes.indexOf(docExistente);
            if (index == -1) {
                docExistente = docExistentes.get(0);
            } else {
                docExistente = docExistentes.get(index);
            }
        }
    }
    
    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
    public List<String> getDigitalizados() {
        return digitalizados;
    }
    
    public List<String> getDocs() {
        return docs;
    }
    
    public boolean isPdf() {
        return pdf;
    }
    
    public boolean isImg() {
        return img;
    }
    
    public boolean isDoc() {
        return doc;
    }
    
    /*-----> FINAL - GET Y SET DE VARIABLES <-----  */

    
}
