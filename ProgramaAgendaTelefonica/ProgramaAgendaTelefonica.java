public class ProgramaAgendaTelefonica {
     public static void main(String[] args) {
          String menu = "MENU\n\n" +
                    "[1] Incluir\n" +
                    "[2] Alterar\n" +
                    "[3] Excluir\n" +
                    "[4] Consultar\n" +
                    "[5] Listar\n\n" +
                    "[0] Desligar";
          String[][] agenda = recuperar();
          int comando = 6;
          while (comando != 0) {
               if (comando == 1) {
                    agenda = incluir(agenda);
               }
               if (comando == 2) {
                    alterar(agenda);
               }
               if (comando == 3) {
                    agenda = excluir(agenda);
               }
               if (comando == 4) {
                    consultar(agenda);
               }
               if (comando == 5) {
                    listar(agenda);
               }
               salvar(agenda);
               comando = Entrada.leiaInt(menu);

          }
     }

     public static String[][ incluir(String[][] memoria) {
          int tamanho = 0;
          for (int linha = 0; linha < memoria.length; linha++) {
               tamanho++;
          }
          String matrizAux[][] = new String[tamanho + 1][4];
          for (int linha = 0; linha < memoria.length; linha++) {
               for (int coluna = 0; coluna < memoria[0].length; coluna++) {
                    matrizAux[linha][coluna] = memoria[linha][coluna];
               }
          }
          matrizAux[tamanho][0] = Entrada.leiaString("Digite o nome");
          matrizAux[tamanho][1] = Entrada.leiaString("Digite o endereço");
          matrizAux[tamanho][2] = Entrada.leiaString("Digite a cidade");
          matrizAux[tamanho][3] = Entrada.leiaString("Digite o telefone");
          System.out.println("Cliente adicionado");
          return (matrizAux);
     }

     public static void listar(String[][] memoria) {
          System.out.println("\nLISTAGEM DE CLIENTES***************************************************************");
          for (int linha = 0; linha < memoria.length; linha++) {
               for (int coluna = 0; coluna < memoria[0].length; coluna++) {
                    System.out.print(memoria[linha][coluna] + "; ");
               }
               System.out.println("\n---------------------------------------------------------------------------");
          }
     }

     public static void alterar(String[][] memoria) {
          String menu = "MENU ALTERAR\n\n" +
                    "[1]Nome\n" +
                    "[2]Endereço\n" +
                    "[3]Cidade\n" +
                    "[4]Telefone\n\n" +
                    "[0]CANCELAR";
          String nome = Entrada.leiaString("Digite o nome do cliente que deseja ALTERAR").toLowerCase();
          int indice = 0;
          while (indice < memoria.length && !nome.equals(memoria[indice][0].toLowerCase())) {
               indice++;
          }
          if (indice < memoria.length) {
               int comando = Entrada.leiaInt(menu);
               if (comando == 1) {
                    memoria[indice][comando - 1] = Entrada.leiaString("Digite o novo NOME");
                    System.out.println("\nCLIENTE ALTERADO COM SUSCESSO");
               }
               if (comando == 2) {
                    memoria[indice][comando - 1] = Entrada.leiaString("Digite o novo ENDEREÇO");
                    System.out.println("\nCLIENTE ALTERADO COM SUSCESSO");
               }
               if (comando == 3) {
                    memoria[indice][comando - 1] = Entrada.leiaString("Digite a nova CIDADE");
                    System.out.println("\nCLIENTE ALTERADO COM SUSCESSO");
               }
               if (comando == 4) {
                    memoria[indice][comando - 1] = Entrada.leiaString("Digite o novo TELEFONE");
                    System.out.println("\nCLIENTE ALTERADO COM SUSCESSO");
               }
               if (comando == 0) {
                    System.out.println("\nOPERAÇÃO CANCELADA");
               }
          } else {
               System.out.println("\nCLIENTE NÃO ENCONTRADO");

          }
     }

     public static String[][] excluir(String[][] memoria) {
          String[][] menor = new String[memoria.length - 1][4];
          String[][] retorno = memoria;
          String nome = Entrada.leiaString("Digite o nome do cliente que deseja EXCLUIR").toLowerCase();
          int indice = 0;
          boolean flag = false;
          while (indice < memoria.length && !nome.equals(memoria[indice][0].toLowerCase())) {
               indice++;
          }
          if (indice < memoria.length) {
               // memoria[indice]= new String("","","","");
               for (int linha = 0; linha < memoria.length; linha++) {
                    for (int coluna = 0; coluna < memoria[0].length; coluna++) {
                         if (linha == indice) {
                              linha++;
                              flag = true;
                         }
                         if (flag) {
                              menor[linha - 1][coluna] = memoria[linha][coluna];
                         } 
                         else {
                              menor[linha][coluna] = memoria[linha][coluna];

                         }
                    }
               }
               retorno = menor;
               System.out.println("\nCLIENTE " + nome + " EXCLUÍDO COM SUSCESSO");
          } 
          else {
               System.out.println("\nCLIENTE NÃO ENCONTRADO");

          }
          return (retorno);

     }
     public static void consultar(String[][] memoria){
          String nome = Entrada.leiaString("Digite o nome do cliente que deseja CONSULTAR").toLowerCase();
          int indice = 0;
          while (indice < memoria.length && !nome.equals(memoria[indice][0].toLowerCase())) {
               indice++;
          }
          if (indice < memoria.length) {
               System.out.println("\nCONSULTA DE CLIENTE***************************************************************");
               for(int coluna = 0;coluna<memoria[indice].length;coluna++){
                    System.out.print(memoria[indice][coluna]+"; ");
               }
               System.out.println("\n---------------------------------------------------------------------------"); 
          }
          else {
               System.out.println("\nCLIENTE NÃO ENCONTRADO");

          }

     }

     public static void salvar(String[][] memoria) {
          Arquivo bancoAgenda = new Arquivo("agenda.txt");
          if (bancoAgenda.abrirEscrita()) {
               for (int linha = 0; linha < memoria.length; linha++) {
                    String a = "";
                    for (int coluna = 0; coluna < memoria[0].length; coluna++) {
                         a = a + memoria[linha][coluna] + ";";
                    }
                    bancoAgenda.escreverLinha(a);
               }
               bancoAgenda.fecharArquivo();
          }
     }

     public static String[][] recuperar() {
          int tamanho = 0;
          String[][] memoria = new String[0][0];
          Arquivo bancoAgenda = new Arquivo("agenda.txt");
          if (bancoAgenda.abrirLeitura()) {
               while (bancoAgenda.lerLinha() != null) {
                    tamanho++;
               }
               bancoAgenda.fecharArquivo();
          }
          if (bancoAgenda.abrirLeitura()) {
               memoria = new String[tamanho][4];
               for (int linha = 0; linha < memoria.length; linha++) {
                    int indice = 0;
                    String a = bancoAgenda.lerLinha();
                    for (int coluna = 0; coluna < memoria[0].length; coluna++) {
                         int preindice = indice;// continuar daqui (fazer a substring de "a" que ele deve salvar no
                                                // vetor)
                         while (indice < a.length()) {
                              if (a.charAt(indice) == ';') {
                                   memoria[linha][coluna] = a.substring(preindice, indice);
                                   indice++;
                                   break;
                              }
                              indice++;
                         }
                    }
               }
               bancoAgenda.fecharArquivo();
          }
          return (memoria);
     }
}
