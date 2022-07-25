public class Cafeteira
{
     int nivelReservatorioAgua;
     int nivelReservatorioCafe;
     int nivelReservatorioLeite;
     
     int contadorCafeCurto;
     int contadorCafeLongo;
     int contadorCappuccino;
     int contadorLateMacchiato;
     
     double precoCafeCurto;
     double precoCafeLongo;
     double precoCappuccino;
     double precoLateMacchiato;
     double valorCaixa;
     
     public boolean servirCafeCurto()
     {
          boolean retorno = false;
          if(nivelReservatorioAgua >= 100 && nivelReservatorioCafe >= 10){
               nivelReservatorioAgua -= 100;
               nivelReservatorioCafe -= 10;
               contadorCafeCurto++;
               retorno = true;
               valorCaixa += precoCafeCurto;
          }
          return(retorno);
     }
     
     public boolean servirCafeLongo()
     {
          boolean retorno = false;
          if(nivelReservatorioAgua >= 300 && nivelReservatorioCafe >= 30){
               nivelReservatorioAgua -= 300;
               nivelReservatorioCafe -= 30;
               contadorCafeLongo++;
               valorCaixa += precoCafeLongo;
               retorno = true;
          }
          return(retorno);   
     }
     
     public boolean servirCappuccino()
     {
          boolean retorno = false;
          if(nivelReservatorioAgua >= 300 && nivelReservatorioCafe >= 15 && nivelReservatorioLeite > 15){
               nivelReservatorioAgua -= 300;
               nivelReservatorioCafe -= 15;
               nivelReservatorioLeite -= 15;
               contadorCappuccino++;
               valorCaixa += precoCappuccino;
               retorno = true;
          }
          return(retorno);
     }
     
     public boolean servirLateMacchiato()
     {
          boolean retorno = false;
          if(nivelReservatorioAgua >= 300 && nivelReservatorioCafe >= 20 && nivelReservatorioLeite > 10){
               nivelReservatorioAgua -= 300;
               nivelReservatorioCafe -= 20;
               nivelReservatorioLeite -= 10;
               contadorLateMacchiato++;
               valorCaixa += precoLateMacchiato;
               retorno = true;
          }
          return(retorno);
     }
     
     public boolean abastecerLeite( int quant )
     {
          boolean retorno = false;
          if(nivelReservatorioLeite + quant <= 2000){
               nivelReservatorioLeite += quant;
               retorno = true;
          }
          return(retorno);
     }
     
     public boolean abastecerCafe( int quant )
     {
          boolean retorno = false;
          if(nivelReservatorioCafe + quant <= 2000){
               nivelReservatorioCafe += quant;
               retorno = true;
          }
          return(retorno);  
     }
     
     public boolean abastecerAgua( int quant )
     {
          boolean retorno = false;
          if(nivelReservatorioAgua + quant <= 20000){
               nivelReservatorioAgua += quant;
               retorno = true;
          }
          return(retorno);  
     }
     public void trocarCafeCurto(int quant){
          precoCafeCurto = quant;
     }
     public void trocarCafeLongo(int quant){
          precoCafeLongo = quant;
     }
     public void trocarCappuccino(int quant){
          precoCappuccino = quant;
     }
     public void trocarLateMacchiato(int quant){
          precoLateMacchiato = quant;
     }
     
}