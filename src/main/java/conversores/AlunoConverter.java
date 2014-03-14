/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import entidades.Aluno;
import interfaces.IAluno;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Zé Roberto
 */
@FacesConverter(value="alunoConverter")
public class AlunoConverter implements Converter {

    private IAluno alunoBean;
    
    public AlunoConverter(IAluno alunoBean) {
        this.alunoBean = alunoBean;
    }
    
    //Retorna o objeto e retorna o email
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return alunoBean.retornarAlunoPorEmail(value);    
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Aluno) value).getEmail();
    }
    
}
