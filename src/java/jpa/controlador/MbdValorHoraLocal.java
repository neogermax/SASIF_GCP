/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.ValorHora;
import jpa.valores.ValorHoraPK;

/**
 *
 * @author analista02
 */
@Local
public interface MbdValorHoraLocal {

    List<ValorHora> encontrarTodos();

    void insertar(ValorHora valorHora) throws Exception;

    void actualizar(ValorHora valorHora);

    void eliminar(ValorHoraPK valorHoraPk);
    
}
