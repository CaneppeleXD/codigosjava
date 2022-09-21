package br.univates.maquinadesuco;

public class ProgramaMaquinaDeSuco {
    public static void main(String[] args) {
        String[] nomes = { "manga", "uva", "maça", "maracujá" };
        MaquinaDeSuco m1 = new MaquinaDeSuco(nomes);
        DAL dal = new DAL(
                "/home/flexabus-java-3/pasta do jao/javaas/MaquinaDeSuco/src/main/java/br/univates/maquinadesuco/maquinadesuco.txt");
        try {
            m1 = dal.recuperar();
        } catch (Exception x) {
            System.out.println("Erro ao recuperar máquina --->" + x);
            dal.repo.fecharArquivo();
        }
        TelaPrincipal t = new TelaPrincipal(m1, dal);
        t.exibir();
    }
}