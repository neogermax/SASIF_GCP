/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.ProyActs;
import jpa.valores.Responsables;
import jpa.valores.Usuarios;
import jsf.controlador.PtdResponsables;
import jsf.controlador.PtdUsuarios;

@ManagedBean(name = "bgesAutorizaciones")
@SessionScoped
public class BGesAutorizaciones implements Serializable {
    private PtdResponsables ptdResponsables = new PtdResponsables();
    private PtdUsuarios ptdUsuarios = new PtdUsuarios();
    private List<ResponsableUsuario> responsables;
    private ProyActs proyAct;
    
    public void init(ProyActs proyAct) {
        this.proyAct = proyAct;
    }
    
    private String nombre(String nombre) {
        return (nombre == null)?"":nombre;
    }
    
    public List<ResponsableUsuario> getResponsables() {
        List<Responsables> responsables = ptdResponsables.encontrarPorClase(proyAct.getProyectos(), 
                proyAct.getClases(), proyAct.getEtapas(), proyAct.getActividades());
        List<Usuarios> usuarios = ptdUsuarios.encontrarTodos();
        this.responsables = new ArrayList<ResponsableUsuario>();
        for(Responsables r : responsables) {
            ResponsableUsuario ru = new ResponsableUsuario();
            ru.setUsuario(r.getResponsablesPK().getResUsuCodFk());
            ru.setAutoriza(r.getResAutoriz());
            Usuarios u = new Usuarios(r.getResponsablesPK().getResUsuCodFk());
            int index = usuarios.indexOf(u);
            if(index != -1) {
                u = usuarios.get(index);
                ru.setEmpleado(u.getEmpleados().getEmplNombre1() + " " + 
                        nombre(u.getEmpleados().getEmplNombre2()) + " " +
                        u.getEmpleados().getEmplApellido1() + " " +
                        nombre(u.getEmpleados().getEmplApellido2()));
                this.responsables.add(ru);
            }
        }
        return this.responsables;
    }
}
