public class contarMatriz {
    public static void main(String[]args) {
        int[][] matriz = preencherMatriz();
        imprimirMatriz(matriz);
        analisarMatriz(matriz);
    }
    public static int[][] preencherMatriz(){
        int [][] matriz = new int[6][3];
        for(int linha = 0;linha<matriz.length;linha++){
            for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                matriz[linha][coluna] = (int)Math.round(Math.random()*100);
            }
        }
        return(matriz);
    }
    public static void analisarMatriz(int[][] matriz) {
        int menor = matriz[0][0];
        int[] posicao = new int[2];
        int quant = 0;
        int[] salvarColuna = new int[0];
        for(int linha = 0;linha<matriz.length;linha++){
            salvarColuna = new int[0];
            quant=0;
            for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                if(matriz[linha][coluna]>= 12 && matriz[linha][coluna]<=20){
                    salvarColuna = salvarColuna(salvarColuna, coluna);
                    quant++;
                }
                if(matriz[linha][coluna]<menor){
                    menor = matriz[linha][coluna];
                    posicao[0] = linha+1;
                    posicao[1] = coluna+1;
                }
            }
            if(quant > 0){
                int linhareal = linha+1;
                System.out.print("Na linha "+linhareal+" há "+quant+" número(s) entre 12 e 20\nColuna(s): ");
                for(int i = 0;i<salvarColuna.length;i++){
                    System.out.print(salvarColuna[i]+"|");
                }
                System.out.println("\n");
            }
        }
        System.out.println(menor+" é o MENOR número na matriz e está na posição: "+posicao[0]+"x"+posicao[1]);
        if(quant == 0){
            System.out.println("Não há números entre 12 e 20 na Matriz");

        }
    }
    public static int[] salvarColuna(int[] salvarColuna, int coluna) {
        int[] vetor = new int[salvarColuna.length+1];
        int i = 0;
        while(i<salvarColuna.length){
            vetor[i] = salvarColuna[i];
            i++;
        }
        vetor[i] = coluna+1;
        
        
        return(vetor);
    }
    public static void imprimirMatriz(int[][] matriz){
        System.out.println("---------------------------------------------------------------------------");
        for(int linha = 0;linha<matriz.length;linha++){
            for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                System.out.print(matriz[linha][coluna]+"\t");
            }
        System.out.println("");
        }
    }
}
