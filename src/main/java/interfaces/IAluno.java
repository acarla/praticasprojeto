/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Aluno;
import java.util.List;

/**
 *
 * @author Ana
 */
public interface IAluno {
    public Aluno retornarAluno(Long id);
    
    public List<Aluno> listarAluno();
   
    public void inserirAluno(Aluno aluno);
    
    public void atualizarAluno(Aluno aluno);
    
    public void removerAluno(Aluno aluno);

    public Aluno retornarAluno(Aluno aluno);
    
}
    
