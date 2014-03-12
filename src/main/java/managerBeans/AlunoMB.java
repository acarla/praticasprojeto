/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBeans;

import entidades.Aluno;
import interfaces.IAluno;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Ana
 */
@ManagedBean(name ="alunoMB1")
@ViewScoped
public class AlunoMB {
    private boolean cadastrar = false;
    private boolean listar = false;
    private boolean editar = false;
    
    private Aluno aluno = new Aluno();
    
    @EJB
    private IAluno alunos;
    
    public AlunoMB() {
    }
    
    public void telaCadastrar(){
        this.cadastrar = true;
        this.listar = false;
        this.editar = false;
    }
    
    public void telaListar(){
        this.cadastrar = false;
        this.listar = true;
        this.editar = false;
    }
    
    public void telaEditar(){
        this.cadastrar = false;
        this.listar = false;
        this.editar = true;
    }

    public boolean isCadastrar() {
        return cadastrar;
    }

    public boolean isListar() {
        return listar;
    }

    public boolean isEditar() {
        return editar;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void addAluno(){
        this.alunos.inserirAluno(aluno);
        this.telaListar();
    }
    
    public List<Aluno> listaAlunos(){
        return this.alunos.listarAluno();
    }
    
     public List<SelectItem> listarItensAlunos(){
         List<SelectItem> itensAlunos = new ArrayList<SelectItem>();
        for (Aluno a : this.aluno.listarAluno()) {
            SelectItem item = new SelectItem(a, a.getNome());
            itensAlunos.add(item); 
        }
        return itensAlunos;
    }

    
}
