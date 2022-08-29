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
public class ProgramaData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo t = new Triangulo(15, 1, 18);
        System.out.println(t.getA());
        Data d = new Data(19,8,2022);
        System.out.println(d.obterFaseDaLua());
    }
    
}
