public class InverterMatriz{
    public static void main(String[]args){
         int[][] matriz = new int[6][4];
         preencherMatriz(matriz);
         imprimirMatriz(matriz);
         System.out.println("--------------------------------------------------------");
         matriz = transporMatriz(matriz);
         imprimirMatriz(matriz);
    }
    
    public static void preencherMatriz(int[][] matriz){
         for(int linha = 0;linha<matriz.length;linha++){
              for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                   matriz[linha][coluna] = (int)Math.round(Math.random()*1000);
              }
         }
    }
    public static int[][] transporMatriz(int[][] base){
         int[][] matriz = new int[base[0].length][base.length];
         for(int linha = 0;linha<matriz.length;linha++){
              for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                   matriz[linha][coluna] = base[coluna][linha];
              }
         }
         return(matriz);
         
    }
    public static void imprimirMatriz(int[][] matriz){
         for(int linha = 0;linha<matriz.length;linha++){
              for(int coluna = 0;coluna<matriz[linha].length;coluna++){
                   System.out.print(matriz[linha][coluna]+"\t");
              }
              System.out.println("\n");
         }
    }
    
}

