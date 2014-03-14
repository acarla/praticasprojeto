/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managerBeans.AutenticaMB;

/**
 *
 * @author Ana
 */
public class Autenticacao implements PhaseListener{
    @Override
    public void afterPhase(PhaseEvent event) {
        
        String paginaAtual = event.getFacesContext().getViewRoot().getViewId();
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();

        AutenticaMB autenticaMB = (AutenticaMB) session.getAttribute("autenticaMB");
        
        boolean usuarioLogado = false;
        
        if (autenticaMB != null) {
            usuarioLogado = (autenticaMB.getUsuarioLogado() != null);
        }
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        
        if (!paginaAtual.equals("/login.xhtml") && !usuarioLogado)  {
            try {
                response.sendRedirect("login.jsf");
            } catch (IOException ex) {
                Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (paginaAtual.equals("/login.xhtml") && usuarioLogado) {
            try {
                response.sendRedirect("index.jsf");
            } catch (IOException ex) {
                Logger.getLogger(Autenticacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    
    
}
