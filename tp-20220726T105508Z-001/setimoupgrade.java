public class setimoupgrade {
    public static void main(String[] args) {
        int[] vetor = preencherVetor(10000);
        ordenarVetor(vetor);
        
    }

    public static int[] preencherVetor(int x) {
        int[] vetor = new int[x];
        for (int i = 0; i < x; i++) {
            vetor[i] = (int) Math.round(100 * Math.random());
        }
        return (vetor);
    }

    public static void ordenarVetor(int[] vetor) {
        int contador = 0;
        while(confereOrdem(vetor)){
            for (int x = 0; x < vetor.length - 1; x++) {
                int aux = 0;
                contador++;
                if (vetor[x] > vetor[x+1]) {
                    aux = vetor[x];
                    vetor[x] = vetor[x+1];
                    vetor[x+1] = aux;
                }
            }
        }
        imprimirVetor(vetor);
        System.out.println("repeticoes: "+contador);
    }
    public static void imprimirVetor(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }
    public static boolean confereOrdem(int[] vetor){
        boolean retorno = false;
        for(int i=0;i<vetor.length-1 && retorno == false;i++){
            if(vetor[i]>vetor[i+1]){
                retorno = true;
            }
        }
        return(retorno);
    }
}
