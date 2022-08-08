/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br.univates.source;
import java.util.Arrays;
/**
 *
 * @author joao.caneppele
 */
public class VetorInteiro {

    public int[] vetor;

    public VetorInteiro(){
        vetor = new int[0];
    }

    public VetorInteiro(int[] vetor){
        this.vetor = vetor;
    }
    
    public VetorInteiro(int tamanho){
        preencherVetor(tamanho);
    }

    public void preencherVetor(int x) {
        vetor = new int[x];
        for (int i = 0; i < x; i++) {
            vetor[i] = (int) Math.round(100 * Math.random());
        }
    }

    public double calcularMedia() {
        int soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += vetor[i];
        }
        return (soma / vetor.length);

    }

    public double calcularVariancia() {
        double media = calcularMedia();
        double soma = 0;
        for (int i = 0; i < vetor.length; i++) {
            soma += Math.pow(vetor[i] - media, 2);
        }
        return (soma / vetor.length);
    }

    public double calcularDesvioPadrao(int[] vetor) {
        return (Math.sqrt(calcularVariancia()));
    }

    public void ordenarVetor(){
        boolean ordenado = false;
        int passadas = 0;
        while(!ordenado){
            passadas++; //a cada passada ele coloca o maior que faltava
            ordenado = true;
            for(int i = 0;i<vetor.length-passadas;i++){
                if(vetor[i] > vetor[i+1]){
                int aux = vetor[i];
                vetor[i] = vetor[i+1];
                vetor[i+1] = aux;
                ordenado = false;
                }
            }
        }
    }

    public void imprimirVetor() {
        for (int i: vetor) {
            System.out.println(i);
        }
    }

    public int encontrarModa() {
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

    public double calcularMediana() {
        int[] vetor = Arrays.copyOf(this.vetor, this.vetor.length);
        double mediana = 0;
        ordenarVetor();
        int meio = vetor.length/2;
        if(vetor.length%2!=0){
            mediana = vetor[meio];
        }
        else{
            mediana = (vetor[meio-1]+vetor[meio])/2D;
        }
        return (mediana);
    }
}
