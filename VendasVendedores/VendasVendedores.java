package VendasVendedores;

public class VendasVendedores {
    public static void main(String[] aStrings) {
        int[][] vendas = gerarPreencherMatriz(5, 4);
        imprimirVendas(vendas);
        totalCadaVendedorMes(vendas);
        totalCadaSemana(vendas);
        totalNoMes(vendas);
    }

    public static void totalNoMes(int[][] matriz){
        int total = 0;
        System.out.println("--------TOTAL DO MÊS--------");
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                total += matriz[linha][coluna];
            }
        }
        System.out.println("TOTAL: "+total);
    }

    public static void totalCadaSemana(int[][] matriz) {
        System.out.println("--------TOTAL NA SEMANA--------");
        for (int coluna = 0; coluna < matriz[0].length; coluna++) {
            int total = 0;
            for (int linha = 0; linha < matriz.length; linha++) {
                total += matriz[linha][coluna];
            }
            int semana = coluna + 1;
            System.out.println("SEMANA " + semana + ": " + total);

        }

    }

    public static int[][] gerarPreencherMatriz(int linhas, int colunas) {
        int[][] matriz = new int[linhas][colunas];
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                matriz[linha][coluna] = (int) Math.round(Math.random() * 1000);
            }

        }

        return (matriz);
    }

    public static void totalCadaVendedorMes(int[][] matriz) {
        System.out.println("--------TOTAL NO MÊS--------");
        for (int linha = 0; linha < matriz.length; linha++) {
            int total = 0;
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                total += matriz[linha][coluna];
            }
            int vendedor = linha + 1;
            System.out.println("VENDEDOR " + vendedor + ": " + total);

        }
    }

    public static void imprimirVendas(int[][] matriz) {
        System.out.println("-------------------VENDAS-------------------");
        for (int linha = 0; linha < matriz.length; linha++) {
            int vendedor = linha + 1;
            System.out.print("VENDEDOR " + vendedor + ": \t");
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t");
            }
            System.out.print("\n");

        }
    }

}
