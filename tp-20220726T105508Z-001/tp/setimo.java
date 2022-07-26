public class setimo {
    public static void main(String[] args) {
        int[] vetor = preencherVetor(10);
        ordenarVetor(vetor);
        imprimirVetor(vetor);
    }

    public static int[] preencherVetor(int x) {
        int[] vetor = new int[x];
        for (int i = 0; i < x; i++) {
            vetor[i] = (int) Math.round(100 * Math.random());
        }
        return (vetor);
    }

    public static void ordenarVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int x = 0; x < vetor.length - 1; x++) {
                int aux = 0;
                if (vetor[x] > vetor[x+1]) {
                    aux = vetor[x];
                    vetor[x] = vetor[x+1];
                    vetor[x+1] = aux;
                }
            }
        }
    }
    public static void imprimirVetor(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
}
