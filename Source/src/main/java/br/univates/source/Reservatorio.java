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
public class Reservatorio {
    
    private final int capacidade;
    private int nivel; 

    public Reservatorio(int capacidade){
        this.nivel = 0;
        this.capacidade = capacidade;
    }

    public boolean adicionar(int n) {
        boolean retorno = false;
        if(n>0 && nivel+n<=capacidade){
            retorno = true;
            nivel+=n;
        }
        return(retorno);
    }
    
    public boolean retirar(int n) {
        boolean retorno = false;
        if(nivel>0 && nivel-n>=0){
            retorno = true;
            nivel-=n;
        }
        return(retorno);
    }

    public int obterCapacidade(){
        return(capacidade);
    }

    public int obterConteudo(){
        return(nivel);
    }

    public double porcentagem(){
        return(100*(nivel/(capacidade*1.0)));
    }

}
