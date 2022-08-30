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
public class ProgramaData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dado d = new Dado();
        d.girarDado(5);
        System.out.println(d.getHistorico());
    }

}
