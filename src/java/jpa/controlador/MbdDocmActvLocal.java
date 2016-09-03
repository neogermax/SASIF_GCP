/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.DocmActv;
import jpa.valores.DocmActvPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdDocmActvLocal {

    List<DocmActv> encontrarOpcion();

    void insertar(DocmActv docmactv) throws Exception;

    void actualizar(DocmActv docmactv);

    void eliminar (DocmActvPK docmactvPK);
    
}
