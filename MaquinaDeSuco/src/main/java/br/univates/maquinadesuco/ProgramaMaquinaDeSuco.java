package br.univates.maquinadesuco;

public class ProgramaMaquinaDeSuco {
    public static void main(String[] args) {
        String[] nomes = { "manga", "uva", "maça", "maracujá" };
        MaquinaDeSuco m1 = new MaquinaDeSuco(nomes);
        DAL dal = new DAL(
                        "/home/flexabus-java-3/pasta do jao/javaas/MaquinaDeSuco/src/main/java/br/univates/maquinadesuco/maquinadesuco.txt",
                        m1);
        m1 = dal.recuperar();
        TelaPrincipal t = new TelaPrincipal(m1, dal);
        t.exibir();
    }
}