public class ProgramaCadastroClienteV2 {
     public static void main(String[] args) {
          String menu = "MENU\n\n" +
                    "[1] Adicionar cliente\n" +
                    "[2] Consultar clientes\n" +
                    "[3] Adicionar compra\n" +
                    "[4] Excluir cliente\n\n" +
                    "[0] Finalizar";
          int comando = 5;
          Cliente[] memoria = recuperar();
          while (comando != 0) {

               if (comando == 1) {
                    memoria = cadastrar(memoria);
               }
               if (comando == 2) {
                    consultar(memoria);
               }
               if (comando == 3) {
                    comprar(memoria);

               }
               if (comando == 4) {
                    memoria = excluir(memoria);
               }
               salvar(memoria);
               comando = Entrada.leiaInt(menu);

          }

     }

     public static void comprar(Cliente[] memoria) {
          int id = Entrada.leiaInt("Digite o ID do cliente");
          int cliente = 0;
          while (cliente < memoria.length && memoria[cliente].id != id) {
               cliente++;
          }
          if (cliente == memoria.length) {
               System.out.println("\nCliente não encontrado");

          } else { // ver se ta adicionando no cliente certo
               memoria[cliente].comprar(Entrada.leiaDouble("Digite o preço da compra do cliente"));
               System.out.println("\nCompra Cadastrada com Sucesso");
          }

     }

     public static Cliente[] excluir(Cliente[] memoria) {
          if (memoria.length > 0) {
               int id = Entrada.leiaInt("Digite o ID do cliente que deseja excluir");
               int cliente = 0;
               while (cliente < memoria.length && memoria[cliente].id != id) {
                    cliente++;
               }
               if (cliente == memoria.length) {
                    System.out.println("\nCliente não encontrado");

               } else if (memoria.length > 1) {
                    boolean flag = false;
                    Cliente[] aux = new Cliente[memoria.length - 1];
                    for (int i = 0; i < aux.length; i++) {

                         if (i == cliente) {
                              flag = true;
                         }
                         if (flag) {
                              aux[i] = memoria[i+1];
                         } else {
                              aux[i] = memoria[i];
                         }
                    }
                    memoria = aux;
               } else {
                    memoria = new Cliente[0];
               }
               System.out.println("\nCliente Excluído com Sucesso");
          } else {
               System.out.println("\nNão há clientes para excluir");
          }
          return (memoria);
     }

     public static void consultar(Cliente[] memoria) {
          System.out.println("\n-------CONSULTA-------");
          for (int i = 0; i < memoria.length; i++) {
               String compras = "";
               for (int compra = 0; compra < memoria[i].compra.length; compra++) {
                    compras += ";" + memoria[i].compra[compra];
               }
               System.out.println(memoria[i].id + ";" + memoria[i].nome + compras);
          }
     }

     public static Cliente[] cadastrar(Cliente[] memoria) {
          Cliente a = new Cliente();
          if (memoria.length == 0) {
               a.id = 1;
          } else {
               a.id = (memoria[memoria.length - 1].id) + 1;
          }
          a.nome = Entrada.leiaString("Digite o nome do cliente");
          a.compra = new double[0];
          a.comprar(Entrada.leiaDouble("Digite o preço da compra do cliente"));
          Cliente[] aux = new Cliente[memoria.length + 1];
          for (int i = 0; i < memoria.length; i++) {
               aux[i] = memoria[i];
          }
          aux[aux.length - 1] = a;
          System.out.println("\nCliente Cadastrado com Sucesso");
          return (aux);
     }

     public static void salvar(Cliente[] memoria) {
          Arquivo bancoClientes = new Arquivo("clientespanze.txt");
          if (bancoClientes.abrirEscrita()) {
               for (int i = 0; i < memoria.length; i++) {
                    String compras = "";
                    for (int compra = 0; compra < memoria[i].compra.length; compra++) {
                         compras += ";" + memoria[i].compra[compra];
                    }
                    bancoClientes.escreverLinha(memoria[i].id + ";" + memoria[i].nome + compras);
               }
               bancoClientes.fecharArquivo();
          }
     }

     public static Cliente[] recuperar() {
          Arquivo bancoClientes = new Arquivo("clientespanze.txt");
          int quantidade = 0;
          if (bancoClientes.abrirLeitura()) {
               while (bancoClientes.lerLinha() != null) {
                    quantidade++;
               }
               bancoClientes.fecharArquivo();
          }
          Cliente[] memoria = new Cliente[quantidade];
          for (int i = 0; i < quantidade; i++) {
               memoria[i] = new Cliente();
          }
          if (quantidade > 0) {
               if (bancoClientes.abrirLeitura()) {
                    for (int cliente = 0; cliente < memoria.length; cliente++) {
                         String registro = bancoClientes.lerLinha();
                         int posicao = 0;
                         for (int i = 0; i < 3; i++) {
                              int inicio = posicao;
                              posicao = percorrerString(posicao + 1, registro);
                              if (i == 0) {
                                   memoria[cliente].id = Integer.parseInt(registro.substring(inicio, posicao));
                              }
                              if (i == 1) {
                                   memoria[cliente].nome = registro.substring(inicio + 1, posicao);
                              }
                              if (i == 2) {
                                   int tamanho = 0;
                                   for (int i1 = inicio; i1 < registro.length() - 1; i1 = percorrerString(i1 + 1,
                                             registro)) {
                                        tamanho++;
                                   }
                                   memoria[cliente].compra = new double[tamanho];
                                   for (int compra = 0; compra < memoria[cliente].compra.length; compra++) {
                                        // erro, tem que dar um jeito de inicializar o vetor do objeto cliente
                                        memoria[cliente].compra[compra] = Double
                                                  .parseDouble(registro.substring(inicio + 1, posicao));// continuar a
                                                                                                        // recuperar as
                                                                                                        // compras
                                                                                                        // (achar a
                                                                                                        // proxima
                                                                                                        // compra))
                                        inicio = posicao;
                                        posicao = percorrerString(posicao + 1, registro);
                                   }
                              }
                         }

                    }
                    bancoClientes.fecharArquivo();
               }
          }
          return (memoria);
     }

     public static int percorrerString(int posicao, String a) {
          while (posicao < a.length() - 1 && a.charAt(posicao) != ';') {
               posicao++;
          }
          return (posicao);
     }
}
