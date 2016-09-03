/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.Comparator;
import java.util.List;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.ProyActs;
import jpa.valores.Relaciones;

/**
 *
 * @author analista02
 */
class ComparaProyActs implements Comparator {
    private List<Relaciones> relaciones;
    
    public ComparaProyActs(List<Relaciones> relaciones) {
        this.relaciones = relaciones;
    }
    
    private Relaciones relacion(Clases clase, Etapas etapa, Actividades actividad) {
        Relaciones r = new Relaciones();
        r.setClases(clase);
        r.setRelEtpCodFk(etapa);
        r.setRelActCodFk(actividad);
        return r;
    }
    
    @Override
    public int compare(Object o1, Object o2) {
        ProyActs p1 = (ProyActs)o1;
        ProyActs p2 = (ProyActs)o2;
        int i1 = relaciones.indexOf(relacion(p1.getClases(), p1.getEtapas(), p1.getActividades()));
        int i2 = relaciones.indexOf(relacion(p2.getClases(), p2.getEtapas(), p2.getActividades()));
        return i1-i2;
    }
    
}
