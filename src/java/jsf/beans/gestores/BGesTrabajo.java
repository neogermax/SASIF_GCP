/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.CronoProye;
import jpa.valores.Proyectos;
import jpa.valores.Responsables;
import jpa.valores.ResponsablesPK;
import jpa.valores.Usuarios;

@ManagedBean(name = "bgesTrabajo")
@SessionScoped
public class BGesTrabajo implements Serializable {
    private List<TrabajoUsuario> trabUsuarios;
    private List<ProyectoActividades> proyectoActividades;
    private List<String> fechas;
    private List<FechaAño> fechaAños;
    
    public void init(List<Usuarios> usuarios, List<Responsables> responsables, List<CronoProye> cronoProyes, Date d1, Date d2) {
        fechaAños = new ArrayList<FechaAño>();
        fechas = new ArrayList<String>();
        if(d1 != null && d2 != null) {
            ingresarFechas(d1, d2);
        }
        ingresarUsuarios(usuarios);
        ingresarResponsables(responsables, cronoProyes);
    }
    
    private void ingresarFechas(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);
        c2.add(Calendar.DAY_OF_YEAR, 1);
        DateFormat date = new SimpleDateFormat("MM/dd");
        int i = 0, año = 0;
        FechaAño fa = null;
        while(c1.before(c2)) {
            fechas.add(date.format(c1.getTime()));
            int y = c1.get(Calendar.YEAR);
            if(año != y) {
                año = y;
                i = 1;
                fa = new FechaAño();
                fa.setAño("" + año);
                fechaAños.add(fa);
            }
            fa.setCantidad(i);
            c1.add(Calendar.DAY_OF_YEAR, 1);
            i++;
        }
    }
    
    private FechaPorcent[] crearFechas(int size) {
        FechaPorcent[] fp = new FechaPorcent[size];
        for(int i=0; i<fp.length; i++) {
            fp[i] = new FechaPorcent();
        }
        return fp;
    }
    
    private void ingresarUsuarios(List<Usuarios> usuarios) {
        trabUsuarios = new ArrayList<TrabajoUsuario>();
        for(Usuarios u : usuarios) {
            TrabajoUsuario tb = new TrabajoUsuario();
            tb.setUsuario(u.getUsuCodPk());
            tb.setEmpleado(u.getEmpleados().getEmplNombre1() + " " +
                    u.getEmpleados().getEmplApellido1());
            tb.setValores(crearFechas(fechas.size()));
            trabUsuarios.add(tb);
        }
    }
    
    private void ingresarFechas(FechaPorcent[] fechas, CronoProye cr, Proyectos proyecto, String actividad, Short porcentaje) {
        DateFormat date = new SimpleDateFormat("MM/dd");
        String d1 = date.format(cr.getCroproFeiPla());
        String d2 = date.format(cr.getCroproFefPla());
        int i = this.fechas.indexOf(d1);
        int n = this.fechas.indexOf(d2);
        for(; i<=n; i++) {
            fechas[i].addPorActividad(proyecto.getProDescrip(), actividad, porcentaje, cr.getCroproFeiPla(), cr.getCroproFefPla());
        }
    }
    
    private void ingresarResponsables(List<Responsables> responsables, List<CronoProye> cronoProyes) {
        for(Responsables r : responsables) {
            TrabajoUsuario tb = new TrabajoUsuario();
            tb.setUsuario(r.getResponsablesPK().getResUsuCodFk());
            int index = trabUsuarios.indexOf(tb);
            if(index != -1) {
                tb = trabUsuarios.get(index);
                ResponsablesPK rpk = r.getResponsablesPK();
                CronoProye cr = new CronoProye(rpk.getResProCodFk(), rpk.getResClsCodFk(),
                        rpk.getResEtpCodFk(), rpk.getResActCodFk(), rpk.getResCompPk(), rpk.getResTipCompPk());
                int ind = cronoProyes.indexOf(cr);
                if(ind == -1) {
                    tb.addActividad(r.getProyectos().getProDescrip(), r.getActividades().getActDescrip(), r.getResPorcent());
                } else {
                    ingresarFechas(tb.getValores(), cronoProyes.get(ind), r.getProyectos(), r.getActividades().getActDescrip(), r.getResPorcent());
                }
            }
        }
    }
    
    public List<ProyectoActividades> getProyectoActividades() {
        return proyectoActividades;
    }
    
    public List<TrabajoUsuario> getTrabUsuarios() {
        return trabUsuarios;
    }
    
    public void setTrabUsuarios(List<TrabajoUsuario> trabUsuarios) {
        this.trabUsuarios = trabUsuarios;
    }
    
    public List<String> getFechas() {
        return fechas;
    }
    
    public List<FechaAño> getFechaAños() {
        return fechaAños;
    }
    
    public void action(int index) {
        proyectoActividades = trabUsuarios.get(index).getProyectoActividades();
    }
    
    public void action(int ind, int index) {
        proyectoActividades = trabUsuarios.get(ind).getValores()[index].getProyectoActividades();
    }
}
