import java.io.File; 

public class edi {
    public static void main(String[] args) {
        String nomePasta = "/home/flexabus-java-3/Downloads/Arquivos";
        File pasta = new File(nomePasta);
        String[] nomeArquivos = pasta.list();
        File arquivo = new File(nomePasta+"/"+nomeArquivos[0]);
        //Arquivo inicial = new Arquivo()
        for (int i = 0; i < nomeArquivos.length; i++) {
            System.out.println(nomeArquivos[i]);
        }
        System.out.println(arquivo.length());
    }
}
