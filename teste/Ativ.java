import java.util.Vector;

public class Ativ {
    public static void main(String[] aStrings) {
        int[] vetor = gerarPreencherVetor(10);
        paresImpares(vetor);
    }

    public static int[] gerarPreencherVetor(int colunas) {
        int[] vetor = new int[colunas];
        for (int coluna = 0; coluna < vetor.length; coluna++) {
                vetor[coluna] = (int) Math.round(Math.random() * 1000);
        }

        return (vetor);
    }
    public static void paresImpares(int[] vetor) {
        int pares = 0;
        int impares = 0;
        for (int coluna = 0; coluna < vetor.length; coluna++) {
            if(vetor[coluna]%2==0){pares++;}
            else{impares++;}
            System.out.print(vetor[coluna]+";");
        }
        System.out.println("\nPARES: "+pares+"\nÍMPARES: "+impares);
    }
}