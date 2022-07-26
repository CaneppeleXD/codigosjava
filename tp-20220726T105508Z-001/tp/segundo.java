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
public class segundo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(verificarPrimo(Entrada.leiaInt("Digite um número"))){System.out.println("O número é primo");}
        else{System.out.println("O número não é primo");}
    }
    
    public static boolean verificarPrimo(int x){
    boolean retorno = true;
    for(int i = 2;retorno == true && i<x;i++){
        if(x%i==0){
            retorno = false;
        }
    }
    
    return(retorno);
    }
    
}
