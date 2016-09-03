/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Gdocumentos;

/**
 *
 * @author Analista02
 */
@Local
public interface MbdGdocumentosLocal {

    List<Gdocumentos> encontrarTodos();

    Gdocumentos encontrar(Integer gdoGrupoPk);

    void insertar(Gdocumentos gdocumento) throws Exception;

    void actualizar(Gdocumentos gdocumento);

    void eliminar(Integer gdoGrupoPk);
    
}
