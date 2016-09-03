/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import jpa.controlador.MbdCaracteristicasLocal;

import jpa.valores.Caracteristicas;
import jpa.valores.CaracteristicasPK;
import jpa.valores.Parametrias;


/**
 *
 * @author analista02
 */
public class PtdCaracteristicas {
    MbdCaracteristicasLocal mbdCaracteristicas = lookupCaracteristicasLocal();

    private MbdCaracteristicasLocal lookupCaracteristicasLocal() {
        try {
            Context c = new InitialContext();
            return (MbdCaracteristicasLocal) c.lookup("java:comp/env/MbdCaracteristicas");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public List<Caracteristicas> encontrarHistorico(String usuCod, Parametrias parametria) {
        return mbdCaracteristicas.encontrarHistorico(usuCod, parametria);
    }
    
    public Caracteristicas encontrarUltimo(String usuCod, Integer carCodRepFk) {
        return mbdCaracteristicas.encontrarUltimo(usuCod, carCodRepFk);
    }
    
    public Caracteristicas encontrarSecuencia(String usuCod, Integer carCodRepFk) {
        return mbdCaracteristicas.encontrarSecuencia(usuCod, carCodRepFk);
    }
    public Integer encontrarSecuCons(Integer carCodRepFk) {
        return mbdCaracteristicas.encontrarSecCons(carCodRepFk);
    }
    public Integer encontrarMaxSec(String usuCod, Integer carCodRepFk) {
        return mbdCaracteristicas.encontrarMaxSecu(usuCod,carCodRepFk);
    }
    
    public List<Caracteristicas> encontrarOpcion() {
        return mbdCaracteristicas.encontrarOpcion();
    }
    
    public void insertar(Caracteristicas caracteristicas) throws Exception {
        this.mbdCaracteristicas.insertar(caracteristicas);
    }

    public void actualizar(Caracteristicas caracteristicas) {
        this.mbdCaracteristicas.actualizar(caracteristicas);
    }

    public void eliminar(CaracteristicasPK caracteristicasPK) {
        mbdCaracteristicas.eliminar(caracteristicasPK);
    }
    
    public List<Caracteristicas> encontrarTodos(Parametrias parametria) {
        return mbdCaracteristicas.encontrarTodos(parametria);
    }

    public Caracteristicas encontrarUltimo2(Integer carCodRepFk) {
        return mbdCaracteristicas.encontrarUltimo2(carCodRepFk);
    }
    
}
