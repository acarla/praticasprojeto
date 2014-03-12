/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Emprestimo;
import java.util.List;

/**
 *
 * @author Ana
 */
public interface IEmprestimo {
     public Emprestimo retornarEmprestimo(Long id);
    
    public List<Emprestimo> listarEmprestimo();
   
    public void inserirEmprestimo(Emprestimo emprestimo);
    
    public void atualizarEmprestimo(Emprestimo emprestimo);
    
    public void removerEmprestimo(Emprestimo emprestimo);

    
    
}
