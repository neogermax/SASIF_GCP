/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jpa.valores.Componentes;
import jpa.valores.ProyActs;
import jpa.valores.Relaciones;
import jsf.controlador.PtdProyActs;

/**
 *
 * @author analista02
 */
public class CompPar {
    private PtdProyActs ptdProyActs;
    private List<CompAct> compActs = new ArrayList<CompAct>();
    
    private CompAct crear(ProyActs p) {
        CompAct c = new CompAct();
        Componentes comp = new Componentes(p.getProyActsPK().getPryProCodFk(),
                p.getProyActsPK().getPryComTipFk(), p.getProyActsPK().getPryComNomFk());
        c.setComponente(comp);
        return c;
    }
    
    public CompPar(List<ProyActs> proyActs, List<Relaciones> relaciones, PtdProyActs ptdProyActs) {
        this.ptdProyActs = ptdProyActs;
        for(ProyActs p : proyActs) {
            CompAct c = crear(p);
            int index = compActs.indexOf(c);
            if(index == -1) {
                c.setProyActs(new ArrayList<ProyActs>());
                compActs.add(c);
            } else {
                c = compActs.get(index);
            }
            c.getProyActs().add(p);
        }
        ordenar(relaciones);
    }
    
    private void ordenar(List<Relaciones> relaciones) {
        ComparaProyActs cmp = new ComparaProyActs(relaciones);
        for(CompAct c : compActs) {
            Collections.sort(c.getProyActs(), cmp);
        }
    }
    
    public void activar() {
        List<ProyActs> prys = new ArrayList<ProyActs>();
        for(int i=0; i<compActs.size();) {
            CompAct c = compActs.get(i);
            ProyActs p = c.getProyActs().get(0);
            p.setPryEstado("D");
            prys.add(p);
            c.getProyActs().remove(p);
            if(c.getProyActs().isEmpty()) {
                compActs.remove(c);
            } else {
                i++;
            }
        }
        ptdProyActs.actualizar(prys);
    }
    
    public void activar(ProyActs p) {
        CompAct c = crear(p);
        int index = compActs.indexOf(c);
        if(index != -1) {
            c = compActs.get(index);
            ProyActs pr = c.getProyActs().get(0);
            pr.setPryEstado("D");
            c.getProyActs().remove(pr);
            if(c.getProyActs().isEmpty()) {
                compActs.remove(c);
            }
            ptdProyActs.actualizar(pr);
        }
    }
}
