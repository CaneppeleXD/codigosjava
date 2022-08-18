package br.univates.source;

public class Dado {
    private int[] historico;

    public Dado(){
        historico = new int[0];
    }

    private void adicionaEvento(int evento) {
        int[] memoria = new int[historico.length];
        for (int i = 0; i < memoria.length; i++) {
            memoria[i] = historico[i];
        }
        historico = new int[memoria.length + 1];
        for (int i = 0; i < memoria.length; i++) {
            historico[i] = memoria[i];
        }
        historico[memoria.length] = evento;
    }

    public int girarDado() {
        int evento = (int) Math.round(Math.random() * 6);
        adicionaEvento(evento);
        return (evento);
    }

    public String getHistorico() {
        String retorno = "";
        for (int i = 0; i < historico.length; i++) {
            retorno += historico[i] + "";
        }
        return (retorno);
    }
}
