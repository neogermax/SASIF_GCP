/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.DocExistentes;
import jpa.valores.DocExistentesPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdDocExistentesLocal {

    List<DocExistentes> encontrarTodos();

    void insertar(DocExistentes docExistentes) throws Exception;

    void actualizar(DocExistentes docExistentes);

    void eliminar(DocExistentesPK docExistentesPk);

    DocExistentes encontrar(DocExistentesPK docExistentesPK);
    
    Long secuencia(String codAplOr, String tipoDoc, Long ideApli, String nomDoc);
    
}
