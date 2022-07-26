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
public class sexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("O desvio padrão é: "+calcularDesvioPadrao(preencherVetor(10)));
    }

    public static int[] preencherVetor(int x) {
        int[] vetor = new int[x];
        for (int i = 0; i < x; i++) {
            vetor[i] = (int) Math.round(100 * Math.random());
        }
        return (vetor);
    }

    public static double calcularMedia(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return (soma / vetor.length);

    }

    public static double calcularVariancia(int[] vetor) {
        double media = calcularMedia(vetor);
        double soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma+=Math.pow(vetor[i]-media, 2);
        }
        return(soma/vetor.length);
    }
    
    public static double calcularDesvioPadrao(int[] vetor){
        return(Math.sqrt(calcularVariancia(vetor)));
    }

}
