/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tp;

/**
 *
 * @author joao.caneppele
 */
public class terceiro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(verificarPrimo(Entrada.leiaInt(""), Entrada.leiaInt("")));
    }
    
    public static boolean verificarPrimo(int x, int y){
        boolean retorno = true;
        for(int i = 2;retorno == false && i < Math.min(x, y);i++){
            if((x%i == 0)&&(y%i==0)){
                retorno=false;
            }
        }
        return(retorno);
    }
    
}
