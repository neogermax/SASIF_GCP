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
import jpa.controlador.MbdValorHoraLocal;
import jpa.valores.ValorHora;
import jpa.valores.ValorHoraPK;

/**
 *
 * @author analista02
 */
public class PtdValorHora {
        MbdValorHoraLocal mbdValorHora = lookupMbdValorHoraLocal();

    private MbdValorHoraLocal lookupMbdValorHoraLocal() {
        try {
            Context c = new InitialContext();
            return (MbdValorHoraLocal) c.lookup("java:comp/env/MbdValorHora");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    public List<ValorHora> encontrarTodos() {
        return mbdValorHora.encontrarTodos();
    }

    public void insertar(ValorHora valorHora) throws Exception {
        mbdValorHora.insertar(valorHora);
    }

    public void actualizar(ValorHora valorHora) {
        mbdValorHora.actualizar(valorHora);
    }

    public void eliminar(ValorHoraPK valorHoraPk) {
        mbdValorHora.eliminar(valorHoraPk);
    }
}

  