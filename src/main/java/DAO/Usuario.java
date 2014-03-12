/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 *
 * @author Ana
 */
@LocalBean
@Stateless
public class Usuario {
        @PersistenceContext(unitName = "PRATICAS-PU")
    private EntityManager entityManager;

    public void cadastrarUsuario(Usuario usuario) {
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

        Usuario usuarioRecuperado = null;
        
        try {
            Query query = entityManager.createNamedQuery("usuario.recuperarPelasCredenciais");
            query.setParameter("login", login);
            query.setParameter("senha", senha);

            usuarioRecuperado = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuarioRecuperado;
    }

}

