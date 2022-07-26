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
public class quarto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Média do vetor: "+calcularMedia(preencherVetor(10)));
    }

    public static int[] preencherVetor(int x) {
        int[] vetor = new int[x];
        for(int i = 0;i<x;i++){
            vetor[i] = (int)Math.round(100*Math.random());
        }
        return(vetor);
    }
    
    public static double calcularMedia(int[] vetor){
        int soma = 0;
        for(int i=0;i<vetor.length;i++){
            soma+=vetor[i];
        }
        return(soma/vetor.length);
    
    }

}
