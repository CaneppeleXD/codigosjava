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
public class Data {
    private int dia;
    
    private int mes;
    
    private int ano;
    
    public Data (int dia, int mes, int ano){
        trocarDia(dia);
        trocarMes(mes);
        trocarAno(ano);
    }
    
    //verificar uma maneira de verificar se o dia naquele mes é possivel, talvez pegar o mes antes do dia, e o ano antes de tudo
    public boolean trocarDia (int dia) {
        boolean retorno = false;
        if(dia > 0 && dia <= 32){
            this.dia = dia;
            retorno = true;
        }
        return(retorno);
    }
    
    public boolean trocarMes (int mes) {
        boolean retorno = false;
        if(mes > 0 && mes <= 12){
            this.mes = mes;
            retorno = true;
        }
        return(retorno);
    }
    
    public boolean trocarAno (int ano) {
        boolean retorno = false;
        if(ano > 0){
            this.ano= ano;
            retorno = true;
        }
        return(retorno);
    }
    
    public int obterDia (){
        return(dia);
    }
    
    public int obterMes (){
        return(mes);
    }
    
    public int obterAno (){
        return(ano);
    }
    
    public boolean ehBissexto (){
        boolean retorno = false;

        return(retorno);
    }
}
