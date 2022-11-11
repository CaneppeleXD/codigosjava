

public class teste {
    Arquivo mdfebruto = new Arquivo("/home/flexabus-java-3/pasta do jao/javaas/mdfe/mdfe.xml");
    Arquivo mdferetirada = new Arquivo("/home/flexabus-java-3/pasta do jao/javaas/mdfe/mdferetirada.xml");
    String[] lmdfebruto = new String[1814];
    String[] lmdferetirada = new String[1814];
    mdfebruto.abrirLeitura();
    mdferetirada.abrirLeitura();
    lmdfebruto[0]=mdfebruto.lerLinha();
    lmdferetirada[0]=mdferetirada.lerLinha();
    for(int i = 1; lmdfebruto[i]!=null; i++){
        lmdfebruto[0]=mdfebruto.lerLinha();
        lmdferetirada[0]=mdferetirada.lerLinha();
    }   
}
