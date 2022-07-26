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
public class primeiro {
    public static void main(String[] args) {
        System.out.println("O número digitado tem "+contarDivisores(Entrada.leiaInt("Digite um número"))+" divisores");
    }
    
    public static int contarDivisores(int x) {
        int divisores = 0;
        for(int i = 1;i<=x;i++){
            if(x%i==0){divisores++;}
        }
        return(divisores);
    }
}
