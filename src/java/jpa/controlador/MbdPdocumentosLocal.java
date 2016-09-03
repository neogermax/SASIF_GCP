/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Pdocumentos;

/**
 *
 * @author Analista02
 */
@Local
public interface MbdPdocumentosLocal {

    List<Pdocumentos> encontrarTodos();

    Pdocumentos encontrar(String pdoDocumentoPk);

    void insertar(Pdocumentos pdocumento) throws Exception;

    void actualizar(Pdocumentos pdocumentos);

    void eliminar(String pdoDocumentoPk);
    
}
