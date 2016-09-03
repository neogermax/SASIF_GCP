/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documentos;

import javax.ejb.Local;

/**
 *
 * @author analista02
 */
@Local
public interface DocumentosLocal {
    void processDigitalizado(String trama);
    
    void processDocument(String trama);
}
