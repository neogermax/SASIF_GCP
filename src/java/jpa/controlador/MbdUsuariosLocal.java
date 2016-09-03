/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.List;
import javax.ejb.Local;
import jpa.valores.Areas;
import jpa.valores.Empresas;
import jpa.valores.HistoricoClaves;
import jpa.valores.Usuarios;

/**
 *
 * @author saflap
 */
@Local
public interface MbdUsuariosLocal {

    Usuarios validarUsuario(String usuario);

    void actualizarUsuario(Usuarios usuario);

    List<HistoricoClaves> encontrarHistoricos(String usuario);

    void cambiarContraseña(Usuarios usuario);

    List<Usuarios> encontrarTodos();

    void insertar(Usuarios usuarios) throws Exception;

    void eliminar(String usuCodPk);

    List<Usuarios> encontrarPorEmpresa(Empresas empresa);

    List<Usuarios> encontrarPorArea(Areas area);
    
    Usuarios encontrarPorCod(String cod);
    
}
