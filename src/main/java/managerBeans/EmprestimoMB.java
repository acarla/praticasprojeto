/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBeans;

import entidades.Aluno;
import entidades.Emprestimo;
import entidades.Livro;
import interfaces.IAluno;
import interfaces.IEmprestimo;
import interfaces.ILivro;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ana
 */
@ManagedBean(name="emprestimoMB1")
@ViewScoped
public class EmprestimoMB {
    
    Emprestimo emprestimo = new Emprestimo();
    Livro livro = new Livro();
    Aluno aluno = new Aluno();
   
    @EJB
    IEmprestimo emprestimos;
    
    @EJB
    ILivro livros;
    
    @EJB
    IAluno alunos;

   
}
