public class ordenarMatriz {
    public static void main(String[]args){
        int[][] matriz = preencherMatriz();
        imprimirMatriz(matriz);
        int[] vetor = preencherVetor(matriz);
        ordenarVetor(vetor);
        vetorParaMatriz(vetor, matriz);
        imprimirMatriz(matriz);
   }

   public static void ordenarVetor(int[] vetor){
      for(int y = 0; y < vetor.length; y++){
          for(int i = 0; i < vetor.length-1; i++){
              int aux = 0;
              if(vetor[i] > vetor[i+1]){
                  aux = vetor[i];
                  vetor[i] = vetor[i+1];
                  vetor[i+1] = aux;
              }
          }
          
          
      }
  }
   public static void vetorParaMatriz(int[] vetor, int[][] matriz){
        int i = 0;
        for(int linha = 0;linha<matriz.length;linha++){
            for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                matriz[linha][coluna] = vetor[i];
                i++;
            }
        }
   }
   public static int[] preencherVetor(int[][] matriz){
        int i = 0; 
        int[] vetor = new int[matriz.length*matriz[0].length];
        for(int linha = 0;linha<matriz.length;linha++){
             for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                vetor[i] = matriz[linha][coluna];
                i++;
            }
        }
        return(vetor);
   }
   public static int[][] preencherMatriz(){
        int[][] matriz = new int[5][10];
        for(int linha = 0;linha<matriz.length;linha++){
             for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                  int n = (int)Math.round(Math.random()*100);
                    while(coluna%2 != n%2){
                        n = (int)Math.round(Math.random()*100);
                    }
                    matriz[linha][coluna] = n;
                }
            }
        return(matriz);
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


    

