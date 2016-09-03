/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Caracteristicas;
import jpa.valores.CaracteristicasPK;
import jpa.valores.Parametrias;

/**
 *
 * @author analista02
 */
@Local
public interface MbdCaracteristicasLocal {

    List<Caracteristicas> encontrarOpcion();
    
    List<Caracteristicas> encontrarHistorico(String usuCod, Parametrias parametria);
    
    Caracteristicas encontrarUltimo(String usuCod, Integer carCodRepFk);
    
    Caracteristicas encontrarSecuencia(String usuCod, Integer carCodRepFk);
    
    Integer encontrarSecCons(Integer carCodRepFk);
    
    Integer encontrarMaxSecu(String usuCod, Integer carCodRepFk);

    void insertar(Caracteristicas caracteristicas) throws Exception;

    void actualizar(Caracteristicas caracteristicas);

    void eliminar(CaracteristicasPK caracteristicasPK);

    List<Caracteristicas> encontrarTodos(Parametrias parametria);

    Caracteristicas encontrarUltimo2(Integer carCodRepFk);
    
}
