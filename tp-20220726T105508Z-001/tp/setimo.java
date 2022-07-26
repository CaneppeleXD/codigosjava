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
public class setimo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vetor = preencherVetor(10);
        ordenarVetor(vetor);
        imprimirVetor(vetor);
    }

    public static int[] preencherVetor(int x) {
        int[] vetor = new int[x];
        for (int i = 0; i < x; i++) {
            vetor[i] = (int) Math.round(100 * Math.random());
        }
        return (vetor);
    }

    public static void ordenarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int x = 0; x < vetor.length - 1; x++) {
                int aux = 0;
                if (vetor[i] < vetor[x]) {
                    aux = vetor[i];
                    vetor[i] = vetor[x];
                    vetor[x] = aux;
                }
            }
        }
    }
    public static void imprimirVetor(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
