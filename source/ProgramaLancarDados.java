/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source;

/**
 *
 * @author joao.caneppele
 */
public class ProgramaLancarDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dado[] dados = gerarDados(Entrada.leiaInt("Digite quantos dados deseja girar"));
        girarDados(dados, Entrada.leiaInt("Digite quantas vezes deseja girá-los"));
        imprimirDados(dados);
    }
    
    public static void girarDados(Dado[] dados,int vezes){
        for (Dado dado : dados) {
            dado.girarDado(vezes);
        } 
    }
    
    public static void imprimirDados(Dado[] dados){
        System.out.println("VALOR\t1\t2\t3\t4\t5\t6");
        for(int dado = 0;dado<dados.length;dado++){
            int dadoReal = dado+1;
            System.out.print("D"+dadoReal+":\t");
            for(int i = 1;i<=6;i++){
               System.out.print(dados[dado].getNumeroLancamentos(i)+"\t"); 
            }
            System.out.println("\n");
        }
    }
    
    public static Dado[] gerarDados(int quantidade){
        Dado[] dados = new Dado[quantidade];
        for(int i = 0;i<quantidade;i++){
            dados[i] = new Dado();
        }
        return(dados);
    }
}
