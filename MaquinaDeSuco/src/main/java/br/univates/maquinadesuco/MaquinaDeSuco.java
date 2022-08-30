package br.univates.maquinadesuco;

public class MaquinaDeSuco {
    private double agua, capacidadeAgua, aguaSuco, essenciaSuco;
    private double[] essencias, capacidadeEssencias;
    private int sucosServidos;
    public MaquinaDeSuco(int quantidadeDeEssencias){
        sucosServidos = 0;
        agua = 0;
        capacidadeAgua = 20000;
        essencias = new double[quantidadeDeEssencias];
        capacidadeEssencias = new double[quantidadeDeEssencias];
        for(int i = 0;i<capacidadeEssencias.length;i++){
            capacidadeEssencias[i]=5000;
        }
        aguaSuco = 200;
        essenciaSuco = 50;
    }

    public double getAguaNoSuco(){
        return(aguaSuco);
    }

    public boolean setAguaNoSuco(double quantia){
        boolean retorno = quantia<=capacidadeAgua;
        if(retorno){
            aguaSuco=quantia;
        }
        return(retorno);
    }

    public double getEssenciaNoSuco(){
        return(essenciaSuco);
    }

    public boolean setEssenciaNoSuco(double quantia){
        boolean retorno = quantia<=capacidadeAgua;
        if(retorno){
            essenciaSuco=quantia;
        }
        return(retorno);
    }

    public double getQuantidadeAgua(){
        return(agua);
    }
    
    public boolean colocarAgua(double agua){
        if(this.agua+agua<=capacidadeAgua){
            this.agua+=agua;
        }
        return(this.agua+agua<=capacidadeAgua);
    }

    public boolean tirarAgua(double agua){
        if(this.agua-agua>=0){
            this.agua-=agua;
        }
        return(this.agua-agua>=0);
    }

    public boolean setcapacidadeAgua(int capacidadeAgua){
        boolean retorno = (capacidadeAgua>=agua);
        if(retorno){
            this.capacidadeAgua=capacidadeAgua;
        }
        return(retorno);
    }

    public double getQuantidadeEssencia(int essencia){
        return(essencias[essencia]);
    }

    public boolean colocarEssencia(int essencia, double quantidade){
        boolean retorno = essencias[essencia]+quantidade<=capacidadeEssencias[essencia];
        if(retorno){
            essencias[essencia]+=quantidade;
        }
        return(retorno);
    }

    public boolean tirarEssencia(int essencia, double quantidade){
        boolean retorno = essencias[essencia]-quantidade>=0;
        if(retorno){
            essencias[essencia]-=quantidade;
        }
        return(retorno);
    }

    public boolean servirSuco(int essencia){
        boolean retorno = capacidadeAgua>=aguaSuco && capacidadeEssencias[essencia]>=essenciaSuco;
        if(retorno){
            tirarAgua(aguaSuco);
            tirarEssencia(essencia, essenciaSuco);
            sucosServidos++;
        }
        return(retorno);
    }

    public int getQuantidadeDeEssencias(){
        return(essencias.length);
    }

    public int getSucosServidos(){
        return(sucosServidos);
    }

    /*public void adicionarEssencia(){
        essencias = Arrays.copyOf(essencias, essencias.length+1);
    }*/
    // continuar a fazer metodo para adicionar novas essencias no vetor e colocar nome nelas
}
