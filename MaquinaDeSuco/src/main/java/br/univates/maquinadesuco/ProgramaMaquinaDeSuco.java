package br.univates.maquinadesuco;

public class ProgramaMaquinaDeSuco {
    public static void main(String[] args) {
        String[] nomes = {"manga","uva","maça","maracujá"};
        MaquinaDeSuco m1 = new MaquinaDeSuco(nomes);
        
        TelaPrincipal t = new TelaPrincipal(m1);
        t.exibir();
    }
}