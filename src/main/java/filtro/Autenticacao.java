/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.io.IOException;
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
          try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();

            AutenticaMB autenBean = (AutenticaMB) session;
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

            if (!"/login.jsf".equals(event.getFacesContext().getViewRoot().getViewId()) && autenBean.getUsuarioLogado() == null) {
                try {
                    response.sendRedirect("/login.jsf");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                response.sendRedirect("/index.jsf");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    
    
}
