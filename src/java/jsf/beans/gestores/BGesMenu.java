/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.gestores;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jpa.valores.Links;
import jpa.valores.OpcionRoles;
import jpa.valores.Roles;
import jsf.beans.generales.UtileriaHTTP;
import jsf.controlador.PtdRoles;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean(name = "bgesMenu")
@SessionScoped
public class BGesMenu implements Serializable {
    private BGesNavegacion bgesNavegacion = ((BGesNavegacion)UtileriaHTTP.getBean("bgesNavegacion"));
    private BGesTodoReporte bgesTodoReporte = (BGesTodoReporte)UtileriaHTTP.getBean("bgesTodoReporte");
    private BGesReportes bgesReportes = (BGesReportes)UtileriaHTTP.getBean("bgesReportes");
    private PtdRoles ptdRoles = new PtdRoles();
    private TreeNode root;
    private Links link;
    private OpcionRoles opcionRoles;
    private String rolRolPk;
    
    public BGesMenu() {
        rolRolPk = ((BGesLogin)UtileriaHTTP.getBean("bgesLogin")).getUsuarios().getUsuRolFk().getRolRolPk();
        init();
    }
    
    public void init() {
        root = new DefaultTreeNode("Root", null);
        Roles role = ptdRoles.encontrar(rolRolPk);
        if(role != null && role.getRolEstado().equals("A")) {
            addNodes(role, root);
        }
    }
    
    private void addNodes(Roles role, TreeNode parent) {
        TreeNode node = new DefaultTreeNode("folder", role, parent);
        for(OpcionRoles opRol: role.getOpcionRolesList()) {
            Roles rol = opRol.getOpcSubrol();
            if(rol != null) {
                addNodes(rol, node);
            } else {
                TreeNode n = new DefaultTreeNode("document", opRol, node);
            }
        }
    }
    
    public TreeNode getRoot() {
        return root;
    }
    
    public Links getLink() {
        return link;
    }

    public void setLink(Links link) {
        this.link = link;
    }
    
    public OpcionRoles getOpcionRoles() {
        return opcionRoles;
    }
    
    public void setOpcionRoles(OpcionRoles opcionRoles) {
        this.opcionRoles = opcionRoles;
    }
    
    public void onNodeSelect(NodeSelectEvent event) {
        Object data = event.getTreeNode().getData();
        if(data instanceof OpcionRoles) {
            opcionRoles = (OpcionRoles)data;
            Links l = opcionRoles.getOpcNombre();
            if(link != null) {
                if(link.equals(l))
                    return;
                UtileriaHTTP.addMessage(null, "No se puede abrir " + l.getLinkDescrip()
                        + " hasta que no cierre " + link.getLinkDescrip(),
                    FacesMessage.SEVERITY_ERROR);
                return;
            }
            link = l;
        }
    }
    
    public void onNodeExpand(NodeExpandEvent event) {
        event.getTreeNode().setExpanded(true);
    }
    
    public void onNodeCollapse(NodeCollapseEvent event) {
        event.getTreeNode().setExpanded(false);
    }
    
    public void handleClose(CloseEvent event) {
        bgesNavegacion.close();
        limpiar();
        link = null;
    }
    
    public void limpiar() {
        bgesTodoReporte.setOpcion("1");
        bgesReportes.setOpcion("1");
    }
}
