/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Livro;
import java.util.List;

/**
 *
 * @author Ana
 */
public interface ILivro {
    
    public Livro retornarLivro(Long id);
    
    public List<Livro> listarLivros();
   
    public void inserirLivro(Livro livro);
    
    public void atualizarLivro(Livro livro);
    
    public void removerLivro(Livro livro);

    public Livro retornarlivro(Livro livro);
    
    
}
