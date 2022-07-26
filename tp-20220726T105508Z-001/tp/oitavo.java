public class oitavo {

    public static void main(String[] args) {
        int[] vetor = preencherVetor(5);
        imprimirVetor(vetor);
        System.out.println("Moda: " + encontrarModa(vetor));
    }

    public static int[] preencherVetor(int x) {
        int[] vetor = new int[x];
        for (int i = 0; i < x; i++) {
            vetor[i] = (int) Math.round(5 * Math.random());
        }
        return (vetor);
    }

    public static int encontrarModa(int[] vetor) {
        int maior = 0;
        int moda = 0;
        for (int i = 0; i < vetor.length; i++) {
            int aux = 0;
            for (int x = i; x < vetor.length; x++) {
                if (vetor[i] == vetor[x]) {
                    aux++;
                }
            }
            if (aux > maior) {
                maior = aux;
                moda = i;
            }
        }
        return (vetor[moda]);
    }

    public static void imprimirVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

} // calcular a moda comparando um numero do vetor com os demais e salvando o
  // maior valor de repeticao, se o proximo valo de repeticao for menor nao
  // precisa salvar
