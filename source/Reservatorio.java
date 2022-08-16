public class Reservatorio {
    
    private final int capacidade;
    private int nivel; 

    public Reservatorio(int capacidade){
        this.nivel = 0;
        this.capacidade = capacidade;
    }

    public boolean adicionar(int n) {
        boolean retorno = false;
        if(nivel+n<=capacidade){
            retorno = true;
            nivel+=n;
        }
        return(retorno);
    }
    
    public boolean retirar(int n) {
        boolean retorno = false;
        if(nivel-n>=0){
            retorno = true;
            nivel-=n;
        }
        return(retorno);
    }

    public int obterCapacidade(){
        return(capacidade);
    }

    public int obterConteudo(){
        return(nivel);
    }

    public double porcentagem(){
        return(100*(nivel/(capacidade*1.0)));
    }

}
