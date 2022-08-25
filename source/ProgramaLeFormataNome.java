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
public class ProgramaLeFormataNome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NomeProprio[] nomes = lerGerarNomes("H:\\codigosjava\\segundosemestre\\Source\\src\\main\\java\\br\\univates\\source\\nomes.txt");
        imprimirFormatado(nomes);
    }
    public static NomeProprio[] lerGerarNomes(String arquivo){
        Arquivo nomes = new Arquivo(arquivo);
        int linhas = 0;
        nomes.abrirLeitura();
        while(nomes.lerLinha() != null){
            linhas++;
        }
        nomes.fecharArquivo();
        NomeProprio[] vetorNomes = new NomeProprio[linhas];
        nomes.abrirLeitura();
        for (NomeProprio vetorNome : vetorNomes) {
            vetorNome = new NomeProprio(nomes.lerLinha());
        }
        nomes.fecharArquivo();
        return(vetorNomes);
    }
    
    public static void imprimirFormatado(NomeProprio[] nomes){
        for(NomeProprio nome : nomes){
            System.out.println(nome.getNomeFormatado(2));
        }
    }
}
