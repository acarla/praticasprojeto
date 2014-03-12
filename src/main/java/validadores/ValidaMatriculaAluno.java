/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Ana
 */
@FacesValidator(value="valMatAluno")
public class ValidaMatriculaAluno implements Validator{
    
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String matricula = (String) value;
        boolean valido = somaMatricula(matricula);


          if(!valido){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Matricula invalida!", "Matricula digitada nao é valido!");
            throw new ValidatorException(facesMessage);
        }
    }
    
    public boolean somaMatricula(String NumMatricula) {
         int[] matricula = new int[NumMatricula.length()]; //define o valor com o tamanho da string
         int resultP = 0;
         int resultS = 0;

         
         for (int i = 0; i < matricula.length; i++) {
             matricula[i] = Integer.parseInt(NumMatricula.substring(i, i + 1));
         }

        
         for (int i = 0; i < 8; i++) {
             resultP += matricula[i] * (i + 1);
         }
         int divP = resultP % 10;

       
         if (divP != matricula[8]) {
             return false;
         } else {
            
             for (int i = 0; i < 9; i++) {
                 resultS += matricula[i] * (i);
             }
            int divS = resultS % 10;

             //se o resultado for diferente ao 10 digito do cpf retorna falso
             if (divS != matricula[10]) {
                 return false;
             }
         }

         //se tudo estiver ok retorna verdadeiro
         return true;
     } 
    
}
