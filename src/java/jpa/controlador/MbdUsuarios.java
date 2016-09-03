/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controlador;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.valores.Areas;
import jpa.valores.Empresas;
import jpa.valores.HistoricoClaves;
import jpa.valores.Usuarios;


@Stateless
public class MbdUsuarios implements MbdUsuariosLocal {
    @PersistenceContext(unitName = "CGPLUISPU")
    private EntityManager em;

    @Override
    public Usuarios validarUsuario(String usuario) {
        return em.find(Usuarios.class, usuario);
    }

    @Override
    public void actualizarUsuario(Usuarios usuario) {
        em.merge(usuario);
    }

    @Override
    public List<HistoricoClaves> encontrarHistoricos(String usuario) {
        return em.createNamedQuery("HistoricoClaves.findAll", HistoricoClaves.class)
                .setParameter("usuario", usuario)
                .getResultList();
    }

    @Override
    public void cambiarContraseña(Usuarios usuario) {
        Date d = new Date();
        usuario.setUsuFechaClave(d);
        em.merge(usuario);
        HistoricoClaves h = new HistoricoClaves();
        h.setHisClave(usuario.getUsuClaveEncrip());
        h.setHisFechaHora(d);
        h.setHisModif(d);
        h.setHisUsuCod(usuario.getUsuCodPk());
        h.setHisUsuarioFk(usuario.getUsuCodPk());
        em.persist(h);
    }

    @Override
    public List<Usuarios> encontrarTodos() {
        return em.createNamedQuery("Usuarios.findAll", Usuarios.class).getResultList();
    }

    @Override
    public void insertar(Usuarios usuarios) throws Exception {
        Usuarios u = em.find(Usuarios.class, usuarios.getUsuCodPk());
        if(u != null)
            throw new Exception();
        em.persist(usuarios);
    }

    @Override
    public void eliminar(String usuCodPk) {
        Usuarios u = em.find(Usuarios.class, usuCodPk);
        em.remove(u);
    }

    @Override
    public List<Usuarios> encontrarPorEmpresa(Empresas empresa) {
        return em.createNamedQuery("Usuarios.findByEmp", Usuarios.class)
                .setParameter("empresa", empresa).getResultList();
    }

    @Override
    public List<Usuarios> encontrarPorArea(Areas area) {
        return em.createNamedQuery("Usuarios.findByArea", Usuarios.class)
                .setParameter("area", area).getResultList();
    }
    
    @Override
    public Usuarios encontrarPorCod(String cod) {
        return em.createNamedQuery("Usuarios.findByCod", Usuarios.class)
                .setParameter("cod", cod).getSingleResult();
    }
}
