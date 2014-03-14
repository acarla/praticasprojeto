/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managerBeans;

import DAO.UsuarioBean;
import entidades.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ana
 */
@ManagedBean(name = "autenticaMB")
@SessionScoped
public class AutenticaMB {

    private Usuario usuarioLogado = new Usuario();
    
    private UsuarioBean usuarioManager = new UsuarioBean();
    
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
        this.usuarioLogado = null;
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().invalidate();
        return "login.jsf";
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
