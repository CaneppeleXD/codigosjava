package br.univates.source.lerArquivo;

public class LerArquivo {
    public static void main(String[] args) {
        Arquivo arquivoBruto = new Arquivo("/home/flexabus-java-3/pasta do jao/javaas/Source/src/main/java/br/univates/source/lerArquivo/arquivo.txt");
        Arquivo arquivoFiltrado = new Arquivo("/home/flexabus-java-3/pasta do jao/javaas/Source/src/main/java/br/univates/source/lerArquivo/filtrado.txt");
        if(arquivoBruto.abrirLeitura() && arquivoFiltrado.abrirEscrita()){
            String linha = arquivoBruto.lerLinha();
            while(linha!=null) {
                if(verificaLinha(linha)){
                    arquivoFiltrado.escreverLinha(linha);
                } 
                linha = arquivoBruto.lerLinha();
            }
        }
        arquivoBruto.fecharArquivo();
        arquivoFiltrado.fecharArquivo();
    }

    public static boolean verificaLinha(String linha){
        linha=linha.toLowerCase().trim();
        return linha!=null && linha.contains(" mercadoria ") && linha.contains("select") && (linha.contains("e.*") || linha.contains("m.*")) && !linha.contains("abremercadoria");
    }
}
