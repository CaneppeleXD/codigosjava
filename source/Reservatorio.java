public class Reservatorio {
    
    private final int capacidade;
    private int conteudo; 

    public Reservatorio(int capacidade){
        this.capacidade = capacidade;
    }

    public boolean colocar(int n) {
        boolean retorno = false;
        if(conteudo+n<=capacidade){
            retorno = true;
            conteudo+=n;
        }
        return(retorno);
    }
    
    public boolean tirar(int n) {
        boolean retorno = false;
        if(conteudo-n>=0){
            retorno = true;
            conteudo-=n;
        }
        return(retorno);
    }

    public int obterCapacidade(){
        return(capacidade);
    }

    public int obterConteudo(){
        return(conteudo);
    }

    public double porcentagem(){
        return(100*(conteudo/(capacidade*1.0)));
    }

}
