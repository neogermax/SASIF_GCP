/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.InfoDocumentos;
import jpa.valores.InfoDocumentosPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdInfoDocumentosLocal {

    List<InfoDocumentos> encontrarTodos();

    void insertar(InfoDocumentos infoDocumentos) throws Exception;

    void actualizar(InfoDocumentos infoDocumentos);

    void eliminar(InfoDocumentosPK infoDocumentosPk);
    
}
