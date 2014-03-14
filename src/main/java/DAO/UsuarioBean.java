/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import entidades.Usuario;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ana
 */
@LocalBean
@Stateless
public class UsuarioBean {
    
    @PersistenceContext(unitName = "PRATICAS-PU")
    private EntityManager entityManager;

    public void cadastrarUsuario(UsuarioBean usuario) {
        entityManager.persist(usuario);
    }

    public Usuario recuperarUsuario(String login) {

        Usuario usuarioRecuperado = null;

        try {
            Query query = entityManager.createNamedQuery("usuario.recuperaPeloLogin");
            query.setParameter("login", login);

            usuarioRecuperado = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usuarioRecuperado;

    }

    public Usuario recuperarUsuario(String login, String senha) {

        Usuario usuarioRecuperado = new Usuario();
        
        try {
            usuarioRecuperado = (Usuario) entityManager.createNamedQuery("usuario.recuperarPelasCredenciais")
                    .setParameter("login", login).setParameter("senha", senha).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuarioRecuperado;
    }

}

