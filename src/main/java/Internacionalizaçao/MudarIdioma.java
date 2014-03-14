/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Internacionalizaçao;

import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ana
 */

@ManagedBean(name="MudarIdioma")
@SessionScoped
public class MudarIdioma {
    
      public String portugueseAction() {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        viewRoot.setLocale(new Locale("pt"));
        return null;
    }


    public String englishAction() {
         UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        viewRoot.setLocale(new Locale("en"));
        return null;
    }
    
}
