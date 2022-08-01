/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br.univates.source;

/**
 *
 * @author joao.caneppele
 */
public class NumeroInteiro {

    public int valor;

    public NumeroInteiro(int valor) {

        this.valor = valor;
    }

    public boolean verificarPrimo() {
        boolean retorno = true;
        for (int i = 2; retorno == true && i < valor; i++) {
            if (valor % i == 0) {
                retorno = false;
            }
        }

        return (retorno);
    }

    public int contarDivisores() {
        int divisores = 0;
        for (int i = 1; i <= valor; i++) {
            if (valor % i == 0) {
                divisores++;
            }
        }
        return (divisores);
    }
    
    public boolean verificarPrimo(int x) {
        boolean retorno = true;
        for (int i = 2; retorno == false && i <= Math.min(valor, x); i++) {
            if ((valor % i == 0) && (x % i == 0)) {
                retorno = false;
            }
        }
        return (retorno);
    }

}
