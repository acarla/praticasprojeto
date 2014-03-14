/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Livro;
import interfaces.IAluno;
import interfaces.ILivro;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
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
@Remote(ILivro.class)
public class LivroBean implements ILivro{
    
    @PersistenceContext(unitName = "PRATICAS-PU")
    private EntityManager entityManager;

    @Override
    public entidades.Livro retornarLivro(Long id) {
        return entityManager.find(entidades.Livro.class, id);
    }

    @Override
    public List<entidades.Livro> listarLivros() {
        Query query = entityManager.createQuery("SELECT l from Livro l");
        return query.getResultList();
    }

    @Override
    public void inserirLivro(Livro livro) {
        System.out.println(livro);
        System.out.println(entityManager);
         entityManager.persist(livro);
    }

    @Override
    public void atualizarLivro(entidades.Livro livro) {
        entityManager.merge(livro);
    }

    @Override
    public void removerLivro(entidades.Livro livro) {
        livro = entityManager.find(entidades.Livro.class, livro.getId());
        entityManager.remove(livro);
    }

    @Override
    public entidades.Livro retornarlivro(entidades.Livro livro) {
        return entityManager.find(entidades.Livro.class, livro.getId());
    }
    
}
