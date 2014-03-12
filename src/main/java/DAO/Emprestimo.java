/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.IEmprestimo;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ana
 */
@Stateless
@Remote(IEmprestimo.class)
public class Emprestimo implements IEmprestimo {
    
     @PersistenceContext(unitName="PRATICAS-PU")
    private EntityManager manager;

    @Override
    public entidades.Emprestimo retornarEmprestimo(Long id) {
       return manager.find(entidades.Emprestimo.class, id);
    }

    @Override
    public List<entidades.Emprestimo> listarEmprestimo() {
       Query query = manager.createQuery("SELECT e from Emprestimo e");
        return query.getResultList();
    }

    @Override
    public void inserirEmprestimo(entidades.Emprestimo emprestimo) {
         manager.persist(emprestimo);
    }

    @Override
    public void atualizarEmprestimo(entidades.Emprestimo emprestimo) {
       manager.merge(emprestimo);
    }

    @Override
    public void removerEmprestimo(entidades.Emprestimo emprestimo) {
        emprestimo = manager.find(entidades.Emprestimo.class, emprestimo.getId());
        manager.remove(emprestimo);
    }

   
}
