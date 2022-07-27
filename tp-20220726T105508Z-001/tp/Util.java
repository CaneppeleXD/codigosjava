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
public class Util {

    /**
     * @param args the command line arguments
     */
    public static int contarDivisores(int x) {
        int divisores = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                divisores++;
            }
        }
        return (divisores);
    }

    public static boolean verificarPrimo(int x) {
        boolean retorno = true;
        for (int i = 2; retorno == true && i < x; i++) {
            if (x % i == 0) {
                retorno = false;
            }
        }

        return (retorno);
    }

    public static boolean verificarPrimo(int x, int y) {
        boolean retorno = true;
        for (int i = 2; retorno == false && i <= Math.min(x, y); i++) {
            if ((x % i == 0) && (y % i == 0)) {
                retorno = false;
            }
        }
        return (retorno);
    }

    public static double calcularMedia(int[] vetor) {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return (soma / vetor.length);

    }

    public static int[] preencherVetor(int x) {
        int[] vetor = new int[x];
        for (int i = 0; i < x; i++) {
            vetor[i] = (int) Math.round(100 * Math.random());
        }
        return (vetor);
    }

    public static double calcularVariancia(int[] vetor) {
        double media = calcularMedia(vetor);
        double soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += Math.pow(vetor[i] - media, 2);
        }
        return (soma / vetor.length);
    }

    public static double calcularDesvioPadrao(int[] vetor) {
        return (Math.sqrt(calcularVariancia(vetor)));
    }

    public static void ordenarVetor(int[] vetor) {
        int contador = 0;
        while (confereOrdem(vetor)) {
            for (int x = 0; x < vetor.length - 1; x++) {
                int aux = 0;
                contador++;
                if (vetor[x] > vetor[x + 1]) {
                    aux = vetor[x];
                    vetor[x] = vetor[x + 1];
                    vetor[x + 1] = aux;
                }
            }
        }
    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static int encontrarModa(int[] vetor) {
        int maior = 0;
        int moda = 0;
        for (int i = 0; i < vetor.length; i++) {
            int aux = 0;
            for (int x = i; x < vetor.length; x++) {
                if (vetor[i] == vetor[x]) {
                    aux++;
                }
            }
            if (aux > maior) {
                maior = aux;
                moda = i;
            }
        }
        return (vetor[moda]);
    }

    public static double calcularMediana(int[] vetor) {
        ordenarVetor(vetor);
        int noti = vetor.length - 1;
        int i = 0;
        while (i < noti) {
            noti--;
            i++;
        }
        return ((vetor[i] + vetor[noti]) / 2.0);
    }

    public static boolean confereOrdem(int[] vetor) {
        boolean retorno = false;
        for (int i = 0; i < vetor.length - 1 && retorno == false; i++) {
            if (vetor[i] > vetor[i + 1]) {
                retorno = true;
            }
        }
        return (retorno);
    }

}
