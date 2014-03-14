/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBeans;

import DAO.LivroBean;
import entidades.Livro;
import interfaces.ILivro;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ana
 */
@ManagedBean(name="livroMB")
@ViewScoped
public class LivroMB {
    private boolean cadastrar = false;
    private boolean listar = false;
    private boolean editar = false;
    
    private Livro livro = new Livro();
    
    private ILivro livros = new LivroBean();

    public LivroMB() {
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

    public void addLivro(){
        this.livros.inserirLivro(livro);
        this.telaListar();
    }
   
    public List<Livro> listaLivros(){
        return this.livros.listarLivros();
    }
    
    
    public void atualizaLivro(){
        this.livros.atualizarLivro(this.livro);
        this.telaListar();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
}
