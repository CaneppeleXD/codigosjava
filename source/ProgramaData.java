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
        Data d = new Data(05, 02, 2000);
        Data d2 = new Data(11, 8, 2022);
        System.out.println(d2.obterDiaSemana());
        
    }
    
}
