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
import jpa.valores.AccesoRepUsu;
import jpa.valores.AccesoRepUsuPK;
import jpa.valores.Parametrias;
import jpa.valores.Proyectos;
import jpa.valores.Usuarios;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdAccesoRepUsu;
import jsf.controlador.PtdParametrias;

@ManagedBean(name = "bgesSelectReporte")
@SessionScoped
public class BGesSelectReporte implements Serializable {
    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    private BGesTodoReporte bgesTodoReporte = (BGesTodoReporte)UtileriaHTTP.getBean("bgesTodoReporte");
    private Usuarios usuario = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuarios();
    private PtdParametrias ptdParametrias = new PtdParametrias();
    private PtdAccesoRepUsu ptdAccesoRepUsu = new PtdAccesoRepUsu();
    private List<Parametrias> parametrias;
    private Parametrias parametria;
    private Proyectos proyecto;
    private String valor= "0";
    private String extension;
    private String tipoReporte;
    
    public void init(Proyectos proyecto) {
        this.proyecto = proyecto;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
      
    private List<Parametrias> accesos(String tipo) {
        List<Integer> reportes = new ArrayList<Integer>();
        List<Integer> grupos = new ArrayList<Integer>();
        List<AccesoRepUsu> accesos = ptdAccesoRepUsu.encontrarPorUsuario(usuario.getUsuCodPk());
        for(AccesoRepUsu a : accesos) {
            AccesoRepUsuPK ac = a.getAccesoRepUsuPK();
            if(ac.getAruCodRepFk() != 0) {
                reportes.add(ac.getAruCodRepFk());
            }
            if(ac.getAruGrpCodFk() != 0) {
                grupos.add(ac.getAruCodRepFk());
            }
        }
        return ptdParametrias.encontrarPorAcceso(tipo, reportes, grupos);
    }
    
    private List<Parametrias> obtenerParametrias(String tipo) {
        char c = usuario.getUsuAccRep().charAt(0);
        switch(c) {
            case 'T': return ptdParametrias.encontrarPorTipo(tipo);
            case 'G': return ptdParametrias.encontrarPorGrupo(tipo, usuario.getUsuGrupRep());
            case 'N': return accesos(tipo);
            default: return null;
        }
    }

    public String valores() {
        valor = UtileriaHTTP.getParameter("valor");
        return null;
    }

    
    public List<Parametrias> getPresupuesto() {
         parametrias = obtenerParametrias(valor);
        if(!parametrias.isEmpty()) {
            selectParametria();
        }
        return parametrias;
    }
    
    private void selectParametria() {
        if(parametria == null) {
            setParametria(parametrias.get(0));
        } else {
            int index = parametrias.indexOf(parametria);
            if(index == -1) {
                setParametria(parametrias.get(0));
            } else {
                setParametria(parametrias.get(index));
            }
        }
    }
    
    public Parametrias getParametria() {
        return parametria;
    }
    
    public void setParametria(Parametrias parametria) {
        this.parametria = parametria;
    }
    
    public String action() {
         extension = parametria.getParProgLlam();
        tipoReporte = parametria.getParTipoRep();
        if (parametria != null && extension != null) {
            
            switch(tipoReporte.charAt(0)){
                case 'T' : bgesTodoReporte.setOpcion("3");
                           break;
                default :  bgesTodoReporte.setOpcion("2");    
                           break;
            }
                bgesReportes.setOpcion("2");
                bgesReportes.setParametro(0);
                bgesReportes.setParametro2(2);
                bgesReportes.setFila("T");
                bgesReportes.setColumna("T");
                bgesReportes.vari = (int) parametria.getParCodRepPk();

                bgesTodoReporte.actionReporte("jsf.beans.gestores." + extension);
                bgesTodoReporte.setCodcronoproy(proyecto.getProCodPk());
                bgesTodoReporte.cargarDatos();
            
        }
        return null;
    }
}
