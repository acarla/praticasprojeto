/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.ILivro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ana
 */
public class Livro implements ILivro{
    @PersistenceContext(unitName="PRATICAS-PU")
    private EntityManager manager;

    @Override
    public entidades.Livro retornarLivro(Long id) {
        return manager.find(entidades.Livro.class, id);
    }

    @Override
    public List<entidades.Livro> listarLivros() {
       Query query = manager.createQuery("SELECT l from Livro l");
        return query.getResultList();
    }

    @Override
    public void inserirLivro(entidades.Livro livro) {
         manager.persist(livro);
    }

    @Override
    public void atualizarLivro(entidades.Livro livro) {
        manager.merge(livro);
    }

    @Override
    public void removerLivro(entidades.Livro livro) {
        livro = manager.find(entidades.Livro.class, livro.getId());
        manager.remove(livro);
    }

    @Override
    public entidades.Livro retornarlivro(entidades.Livro livro) {
        return manager.find(entidades.Livro.class, livro.getId());
    }
    
}
