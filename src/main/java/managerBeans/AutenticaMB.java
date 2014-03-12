/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBeans;

import entidades.Usuario;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ana
 */
@ManagedBean
@RequestScoped
public class AutenticaMB {

    private Usuario usuarioLogado = new Usuario();
    
    @EJB
    private Usuario usuarioManager;
    
    public String autenticar() {
        
        String paginaRetorno = "/index.jsf";
        
        Usuario usuario = usuarioManager.recuperarUsuario(usuarioLogado.getLogin(), usuarioLogado.getSenha());
        
        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Erro de autenticação", "Login ou senha inválidos"));
            paginaRetorno = "/login.jsf";
        } else {
            usuarioLogado = usuario;
            
        }
        
        return paginaRetorno;
        
    }
    
    public String encerrarSessao() {
        
        usuarioLogado = new Usuario();
        return "/login.jsf";
        
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }  
    

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
        
    }

    
    
    /**
     * Creates a new instance of AutenticacaoBean
     */
    public AutenticaMB() {
        
    
    
    }
}
