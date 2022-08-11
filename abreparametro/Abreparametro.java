import java.util.ArrayList;

public class Abreparametro {
    public static void main(String[] args) {
        Arquivo bruto = new Arquivo("semAtivo.txt");
        Arquivo arquivoComAtivo = new Arquivo("comAtivo.txt");
        Arquivo arquivoSemAtivo = new Arquivo("semAtivo2.txt");
        
        ArrayList<String> semAtivo = new ArrayList<String>();
        ArrayList<String> comAtivo = new ArrayList<String>();
        int i = contarLinhas(bruto);
        bruto.abrirLeitura();
        arquivoComAtivo.abrirEscrita();
        arquivoSemAtivo.abrirEscrita();
        for (int linha = 0; linha < i; linha++) {
            String a = bruto.lerLinha();
            if (a.contains("feito") || a.contains("FEITO")) {
                //arquivoComAtivo.escreverLinha(a);
                arquivoSemAtivo.escreverLinha(a);
                comAtivo.add(a);
            } else {
                
                semAtivo.add(a);
            }
        }
        arquivoComAtivo.fecharArquivo();
        arquivoSemAtivo.fecharArquivo();
        bruto.fecharArquivo();
    }

    public static int contarLinhas(Arquivo bruto) {
        bruto.abrirLeitura();
        int linha = 0;
        while (bruto.lerLinha() != null) {
            linha++;
        }
        bruto.fecharArquivo();
        return (linha);
    }
}
