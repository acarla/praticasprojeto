package teste;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ana
 */
public class testeNumeros {
    private int n;

    public testeNumeros(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public String VerificaN(int numero){
        if (numero== 0){
            return "Zero";
        } if(numero <0){
            return "Negativo";     
    }if(numero ==2){
        return "dois";
    }
    
    return null; 
}
}