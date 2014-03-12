/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

import DAO.Aluno;
import entidades.Livro;
import interfaces.IAluno;

import javax.faces.convert.Converter;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ana
 */
@FacesConverter("converteAluno")
public class ConverteMatriculaAluno implements Converter{

    @Override
    public Object getAsObject(FacesContext contex, UIComponent component, String value) {
        StringBuilder Bmatricula = new StringBuilder(value);

        boolean valido = true;

      
        char traco = '-';

        int i = 0;
        while(i < Bmatricula.length() && valido){
            char c = Bmatricula.charAt(i);
            if(Character.isDigit(c)){
                i++;
            
            } else if(c == traco){
                Bmatricula.deleteCharAt(i);
            } else{
                valido = false;
            }
        }

        if(i > 10){
            FacesMessage facesMessage = new FacesMessage("Erro na conversao da matricula!", "Tamanho invalido!");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(facesMessage);
        
        }

        return Bmatricula.toString();
    }

    @Override
    public String getAsString(FacesContext contex, UIComponent component, Object value) {
         String matricula = value.toString();
        String matriculaConvertida = matricula.substring(0,8)+"-"+matricula.substring(8);
        return matriculaConvertida;
    }
   


    
}
