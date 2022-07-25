public class ProgramaCafeteira{
     public static void main(String[]args){
          Cafeteira c1 = criarCafeteira();
          boolean desligar = false;
          while(desligar == false){
               if(menuUsuario(c1)){
                    desligar = menuAdmin(c1); 
               }
          }
          
     }
     public static boolean menuUsuario(Cafeteira c1){
          String menu = "MENU CAFETEIRA\n\n"+
               "[1]CAF� CURTO R$"+c1.precoCafeCurto+
               "\n[2]CAF� LONGO R$"+c1.precoCafeLongo+
               "\n[3]Cappuccino R$"+c1.precoCappuccino+
               "\n[4]LateMacchiato R$"+c1.precoLateMacchiato+
               "\n[5]MODO ADMINISTRADOR";
          int comando = 0;
          while(comando != 5){
               comando = Entrada.leiaInt(menu);
               switch (comando){
                    case 1:
                         if(c1.servirCafeCurto()){
                         System.out.println("Caf� curto servido");
                    }
                         else{
                              System.out.println("Falta de insumos");   
                         }
                         break;
                    case 2:
                         if(c1.servirCafeLongo()){
                         System.out.println("CafeLongo servido");
                    }
                         else{
                              System.out.println("Falta de insumos");   
                         }
                         break;
                    case 3:
                         if(c1.servirCappuccino()){
                         System.out.println("Cappuccino servido");
                    }
                         else{
                              System.out.println("Falta de insumos");   
                         }
                         break;
                    case 4:
                         if(c1.servirLateMacchiato()){
                         System.out.println("LateMacchiato servido");
                    }
                         else{
                              System.out.println("Falta de insumos");   
                         }
                         break;
                    case 5:
                         if(!verificarSenha(Entrada.leiaInt("Digite a senha"))){
                         comando = 0;
                         System.out.println("Senha incorreta");
                    }
                         
                         break;
                         
               }
               
          }
          return(true);
     }
     public static boolean menuAdmin(Cafeteira c1){
          boolean desligar = false;
          String menu = "MENU ADMIN\n\n"+
               "[1]TROCAR PRECO CAF� CURTO"+
               "\n[2]TROCAR PRECO CAF� LONGO"+
               "\n[3]TROCAR PRECO Cappuccino"+
               "\n[4]TROCAR PRECO LateMacchiato"+
               "\n[5]RECARREGAR CAF�"+
               "\n[6]RECARREGAR LEITE"+
               "\n[7]RECARREGAR �GUA"+
               "\n[8]CONSULTAR"+
               "\n\n[9]SAIR"+
               "\n[10]DESLIGAR";
          int comando = 0;
          while(comando != 9 && comando != 10){
               comando = Entrada.leiaInt(menu);
               switch (comando){
                    case 1:
                         c1.trocarCafeCurto(Entrada.leiaInt("Digite o novo pre�o"));
                         System.out.println("Pre�o trocado");
                         break;
                    case 2:
                         c1.trocarCafeLongo(Entrada.leiaInt("Digite o novo pre�o"));
                         System.out.println("Pre�o trocado");
                         break;
                    case 3:
                         c1.trocarCappuccino(Entrada.leiaInt("Digite o novo pre�o"));
                         System.out.println("Pre�o trocado");
                         break;
                    case 4:
                         c1.trocarLateMacchiato(Entrada.leiaInt("Digite o novo pre�o"));
                         System.out.println("Pre�o trocado");
                         break;
                    case 5:
                         if(c1.abastecerCafe(Entrada.leiaInt("Digite a quantidade(g)"))){
                         System.out.println("RECARREGADO");
                    }
                         else{
                              System.out.println("QUANTIDADE MUITO GRANDE");   
                         }
                         break;
                    case 6:
                         if(c1.abastecerLeite(Entrada.leiaInt("Digite a quantidade(g)"))){
                         System.out.println("RECARREGADO");
                    }
                         else{
                              System.out.println("QUANTIDADE MUITO GRANDE");   
                         }
                         break;
                    case 7:
                         if(c1.abastecerAgua(Entrada.leiaInt("Digite a quantidade(ml)"))){
                         System.out.println("RECARREGADO");
                    }
                         else{
                              System.out.println("QUANTIDADE MUITO GRANDE");   
                         }
                         break;
                    case 8:
                         System.out.println("C O N S U L T A\n\n"+
                                            "ReservatorioAgua: "+c1.nivelReservatorioAgua+
                                            "\nReservatorioCafe: "+c1.nivelReservatorioCafe+
                                            "\nReservatorioLeite: "+c1.nivelReservatorioLeite+
                                            
                                            "\ncontadorCafeCurto: "+c1.contadorCafeCurto+
                                            "\ncontadorCafeLongo: "+c1.contadorCafeLongo+
                                            "\ncontadorCappuccino: "+c1.contadorCappuccino+
                                            "\ncontadorLateMacchiato:"+c1.contadorLateMacchiato+
                                            
                                            "\nprecoCafeCurto: "+c1.precoCafeCurto+
                                            "\nprecoCafeLongo: "+c1.precoCafeLongo+
                                            "\nprecoCappuccino: "+c1.precoCappuccino+
                                            "\nprecoLateMacchiato: "+c1.precoLateMacchiato+
                                            "\nvalorCaixa"+c1.valorCaixa);  
                         
                         break;
                    case 9: 
                         break;
                    case 10:
                         System.out.println("Sistema desligado");
                         desligar = true;
                         break;
               }    
               
          }
          return(desligar);  
     }
     
     
     public static boolean verificarSenha(int senha){
          boolean retorno = false;
          if(senha == 123){
               retorno = true;
          }
          return(retorno);
     }
     public static Cafeteira criarCafeteira(){
          Cafeteira c1 = new Cafeteira();
          return(c1);
     }
}