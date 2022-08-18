package br.univates.source;

public class Dado {
    private int[] historico;

    public Dado(){
        historico = new int[0];
    }

    private static int[] adicionaEvento(int[] historico, int evento) {
        int[] memoria = new int[historico.length];
        for (int i = 0; i < memoria.length; i++) {
            memoria[i] = historico[i];
        }
        historico = new int[memoria.length + 1];
        for (int i = 0; i < memoria.length; i++) {
            historico[i] = memoria[i];
        }
        historico[memoria.length] = evento;
        return(historico);
    }

    public int girarDado() {
        int evento = (int) Math.round(Math.random() * 6);
        historico = Dado.adicionaEvento(historico,evento);
        return (evento);
    }

    public String getHistorico() {
        String retorno = "";
        for (int i = 0; i < historico.length; i++) {
            retorno += historico[i] + "";
        }
        return (retorno);
    }

    public int getMedia(){
        return (int) Util.calcularMedia(historico);
    }

    public int getModa(){
        return(int) Util.encontrarModa(historico);
    }

    public int getUltimo(){
        return(historico[historico.length-1]);
    }

    public int getDesvioPadrao(){
        return (int) Util.calcularDesvioPadrao(historico);
    }

    
}
