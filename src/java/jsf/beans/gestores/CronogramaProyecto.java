/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Actividades;
import jpa.valores.Clases;
import jpa.valores.Etapas;
import jpa.valores.Festivos;
import jpa.valores.Paises;
import jpa.valores.Proyectos;
import jpa.valores.ValorHora;
import jsf.controlador.PtdPaises;
import jsf.beans.generales.CalculoTime;
import jsf.beans.generales.CalculoTime2;
import jsf.controlador.PtdValorHora;

/**
 *
 * @author analista03
 */
@ManagedBean(name = "cronogramaProyecto")
@SessionScoped
public class CronogramaProyecto implements Serializable {

    private Date croproFeiPla;
    private Date croproFefPla;
    private Long croproTiePla;
    private Date croproFeiRea;
    private Date croproFefRea;
    private Long croproTieRea;
    private Date croproFeiRep;
    private Date croproFefRep;
    private BigDecimal croproPorRea;
    private Integer croproProCodFk;
    private Integer croproClsCodFk;
    private Integer croproEtpCodFk;
    private Integer croproActCodFk;
    private String croproComNomFk;
    private Integer croproTipCodFk;
    private Proyectos proyectos;
    private Etapas etapas;
    private Clases clases;
    private Actividades actividades;
    private Long modulo;
    private String union;
    private int cronoVal = 0;
    private Calendar cronoValfe = Calendar.getInstance();
    private PtdValorHora ptdValorHora = new PtdValorHora();
    private List<ValorHora> valorHoras;
    private int i=0; 
    
      
    private Paises pais;
    private Long croproVahPla;
    private Long croproCosPla;
    private Long croproCosRea;
    
    public CronogramaProyecto(Paises pais) {
        this.pais = pais;
        
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }
    
  
    

    public int getCroproProCodFk() {
        
        return croproProCodFk;
        
    }

    public void setCroproProCodFk(Integer croproProCodFk) {
        this.croproProCodFk = croproProCodFk;
    }

    public Integer getCroproClsCodFk() {
        return croproClsCodFk;
    }

    public void setCroproClsCodFk(Integer croproClsCodFk) {
        this.croproClsCodFk = croproClsCodFk;
    }

    public Integer getCroproEtpCodFk() {
        return croproEtpCodFk;
    }

    public void setCroproEtpCodFk(Integer croproEtpCodFk) {

        this.croproEtpCodFk = croproEtpCodFk;
    }

    public Integer getCroproActCodFk() {
        return croproActCodFk;
    }

    public void setCroproActCodFk(Integer croproActCodFk) {
        this.croproActCodFk = croproActCodFk;
    }

    public String getCroproComNomFk() {
        return croproComNomFk;
    }

    public void setCroproComNomFk(String croproComNomFk) {
        this.croproComNomFk = croproComNomFk;
    }

    public Integer getCroproTipCodFk() {
        return croproTipCodFk;
    }

    public void setCroproTipCodFk(Integer croproTipCodFk) {
        this.croproTipCodFk = croproTipCodFk;
    }

    public Date getCroproFeiPla() {
        return croproFeiPla;
    }

    public void setCroproFeiPla(Date croproFeiPla) {
        this.croproFeiPla = croproFeiPla;
    }

    public Date getCroproFefPla() {
        
        return croproFefPla;
    }
    
        

    public void setCroproFefPla(Date croproFefPla) {
        modulo= ((CalculoTime.getTimeMinutos(pais,croproFeiPla,croproFefPla, actividades.getActFes().equals("S")))%60);
        if( modulo == 0){
            union = Long.toString((CalculoTime.getTimeMinutos(pais,croproFeiPla,croproFefPla, actividades.getActFes().equals("S")))/60)+ ":0" +  Long.toString(modulo);
        }else{
                union = Long.toString((CalculoTime.getTimeMinutos(pais,croproFeiPla,croproFefPla, actividades.getActFes().equals("S")))/60)+ ":" +  Long.toString(modulo);
         }
        croproTiePla = CalculoTime.getTimeMinutos(pais,croproFeiPla,croproFefPla, actividades.getActFes().equals("S"));
        this.croproFefPla = croproFefPla;
        croproFeiRep = croproFeiPla;
        croproFefRep = croproFefPla;
        
        
        
        
        
        
    }

    public Long getCroproTiePla() {
                
        return croproTiePla;
    }

    public void setCroproTiePla(Long croproTiePla) {
       modulo= ((CalculoTime.getTimeMinutos(pais,croproFeiPla,croproFefPla, actividades.getActFes().equals("S")))%60);
        if( modulo == 0){
            union = Long.toString((CalculoTime.getTimeMinutos(pais,croproFeiPla,croproFefPla, actividades.getActFes().equals("S")))/60)+ ":0" +  Long.toString(modulo);
        }else{
                union = Long.toString((CalculoTime.getTimeMinutos(pais,croproFeiPla,croproFefPla, actividades.getActFes().equals("S")))/60)+ ":" +  Long.toString(modulo);
         } 
       croproFefPla = CalculoTime2.getTimeFechas(actividades.getActFes(),pais,croproFeiPla,croproTiePla);
        
        this.croproTiePla = croproTiePla;
    }

    public Date getCroproFeiRea() {
        return croproFeiRea;
    }

    public void setCroproFeiRea(Date croproFeiRea) {
        this.croproFeiRea = croproFeiRea;
    }

    public Date getCroproFefRea() {
        return croproFefRea;
    }

    public void setCroproFefRea(Date croproFefRea) {
        this.croproFefRea = croproFefRea;
    }

    public Long getCroproTieRea() {
        return croproTieRea;
    }

    public void setCroproTieRea(Long croproTieRea) {
        this.croproTieRea = croproTieRea;
    }

    public Date getCroproFeiRep() {
        return croproFeiRep;
    }

    public void setCroproFeiRep(Date croproFeiRep) {
        this.croproFeiRep = croproFeiRep;
    }

    public Date getCroproFefRep() {
        return croproFefRep;
    }

    public void setCroproFefRep(Date croproFefRep) {
        this.croproFefRep = croproFefRep;
    }

    public BigDecimal getCroproPorRea() {
        
        return croproPorRea;
    }

    public void setCroproPorRea(BigDecimal croproPorRea) {
        this.croproPorRea = croproPorRea;
    }
    
    public Long getCroproVahPla() {
        return croproVahPla;
    }

    public void setCroproVahPla(Long croproVahPla) {
        this.croproVahPla = croproVahPla;
    }

    public Long getCroproCosPla() {
        return croproCosPla;
    }

    public void setCroproCosPla(Long croproCosPla) {
        this.croproCosPla = croproCosPla;
    }

    public Long getCroproCosRea() {
        return croproCosRea;
    }

    public void setCroproCosRea(Long croproCosRea) {
        this.croproCosRea = croproCosRea;
    }

    public Proyectos getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyectos proyectos) {
        this.proyectos = proyectos;
    }

    public Etapas getEtapas() {
        return etapas;
    }

    public void setEtapas(Etapas etapas) {
        this.etapas = etapas;
    }

    public Clases getClases() {
        return clases;
    }

    public void setClases(Clases clases) {
        this.clases = clases;
    }

    public Actividades getActividades() {
        if(croproTiePla!=null){
            buscarAct(actividades.getActCodPk());
        }
        
        if(croproVahPla!=null){
            valorTot(croproVahPla, croproTiePla);
        }
        
        return actividades;
        
    }
    
    private void valorTot(Long actVal, Long tieppla){
        croproCosPla = (actVal/60)*tieppla; 
               
    }
    
    private void buscarAct(Integer actVal){
                
	       valorHoras = ptdValorHora.encontrarTodos();
               
               long valHorAct =0;
               Calendar fechaHoy = Calendar.getInstance();
               Calendar fechaini = Calendar.getInstance(); 
               fechaini.set(1970, 0, 1,0,0,0);
               cronoValfe.set(1970, 0, 1,0,0,0);
                             
               for(ValorHora vh : valorHoras) {
                   Calendar cal = Calendar.getInstance();
                   cal.setTime(vh.getValorHoraPK().getValhoFecha());
                   
                   
                   if(actVal == vh.getValorHoraPK().getValhoActCodFk() && cal.after(cronoValfe) && cal.before(fechaHoy)  ){
                     
                     cronoVal = vh.getValorHoraPK().getValhoActCodFk();
                     cronoValfe = cal;
                     valHorAct = vh.getValhoValor();
                   }
                   
               }
               
               if(cronoValfe.after(fechaini)){
                   croproVahPla = valHorAct;
               }else{
                   croproVahPla = null;
               }
               
               
                
                          
        
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }
    
    public Long getModulo() {
        
        return modulo;
    }

    public void setModulo(Long modulo) {
        this.modulo = modulo;
    }
    
    
    public String getUnion() {
        
        return union;
    }

    public void setUnion(String union) {
        
        this.union = union;
    }
    
    
        
}
        

 

