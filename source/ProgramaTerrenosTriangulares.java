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
public class ProgramaTerrenosTriangulares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Triangulo[] terrenos = gerarTerrenos(2);
        System.out.println(areaTotal(terrenos));
    }
    
    public static double areaTotal(Triangulo[] terrenos){
    
    double areaTotal = 0;
    for(int i = 0;i<terrenos.length;i++){
        areaTotal+=terrenos[i].getArea();
    }
    return(areaTotal);
    }
    
    public static Triangulo[] gerarTerrenos(int quantidade){
        Triangulo[] terrenos = new Triangulo[quantidade];
        for(int i = 0;i<terrenos.length;i++){
            int terreno = i+1;
            terrenos[i] = new Triangulo(Entrada.leiaDouble("Digite o lado A do terreno "+terreno),Entrada.leiaDouble("Digite o lado B"+terreno),Entrada.leiaDouble("Digite o lado C"+terreno));
        }
        return(terrenos);
    }
}
