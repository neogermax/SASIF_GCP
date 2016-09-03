/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documentos.plantillas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 *
 * @author analista02
 */
public interface DocProcesor {
    void mercheDoc(Map<String, String> items, String rorg, String rdes) throws FileNotFoundException, IOException;
}
