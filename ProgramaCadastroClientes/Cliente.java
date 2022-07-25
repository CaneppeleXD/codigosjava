public class Cliente{
    int id;
    String nome;
    double[] compra;
    public void comprar(double n){
         double[] aux = new double[compra.length];
         for(int i = 0;i<aux.length;i++){
              aux[i] = compra[i];
         }
         compra = new double[aux.length+1];
         for(int i = 0;i<aux.length;i++){
              compra[i] = aux[i]; 
         }
         compra[compra.length-1] = n;
    }
}
