/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Aluno;
import interfaces.IAluno;
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
@Remote(IAluno.class)
public class AlunoBean implements IAluno{
    
    @PersistenceContext(unitName="PRATICAS-PU")
    private EntityManager manager;

    @Override
    public entidades.Aluno retornarAluno(Long id) {
         return manager.find(entidades.Aluno.class, id);
    }

    @Override
    public List<entidades.Aluno> listarAluno() {
        Query query = manager.createQuery("SELECT a from Aluno a");
        return query.getResultList();
    }
    
    @Override
    public Aluno retornarAlunoPorEmail(String email) {
        return (Aluno) manager.createQuery("SELECT a from Aluno a Where a.email = :email").setParameter("email", email).getResultList();
    }

    @Override
    public void inserirAluno(entidades.Aluno aluno) {
         manager.persist(aluno);
    }

    @Override
    public void atualizarAluno(entidades.Aluno aluno) {
        manager.merge(aluno);
    }

    @Override
    public void removerAluno(entidades.Aluno aluno) {
            aluno = manager.find(entidades.Aluno.class, aluno.getId());
        manager.remove(aluno);
    }

    @Override
        public entidades.Aluno retornarAluno(entidades.Aluno aluno) {
         return manager.find(entidades.Aluno.class, aluno.getId());
    }

}
