package br.univates.source;

public class Dado {

    private int[] historico;

    public Dado() {
        historico = new int[0];
    }

    private static int[] adicionaEvento(int[] historico, int evento) {
        int[] memoria = new int[historico.length];
        System.arraycopy(historico, 0, memoria, 0, memoria.length);
        historico = new int[memoria.length + 1];
        System.arraycopy(memoria, 0, historico, 0, memoria.length);
        historico[memoria.length] = evento;
        return (historico);
    }

    public int girarDado(){
        return girarDado(1);
    }
    
    public double getPorcentagem(int valor){
        return(this.getNumeroLancamentos(valor)/(this.getNumeroLancamentos()+0.0))*100;
    }
    
    public void zerar(){
        historico = new int[0];
    }
    
    public int girarDado(int vezes) {
        for (int i = 0; i<vezes;i++) {
            int evento = (int) Math.round(Math.random() * 6);
            historico = Dado.adicionaEvento(historico, evento);
        }
        return (historico[historico.length-1]);
    }
    
    public int getNumeroLancamentos(){
        return(historico.length);
    }
    
    public int getNumeroLancamentos(int valor){
        int vezes = 0;
        for(int i = 0;i<historico.length;i++){
            if(historico[i]==valor){
                vezes++;
            }
        }
        return(vezes);
    }
    
    public String getHistorico() {
        String retorno = "";
        for (int i = 0; i < historico.length; i++) {
            retorno += historico[i] + "";
        }
        return (retorno);
    }

    public int getMedia() {
        return (int) Util.calcularMedia(historico);
    }

    public int getModa() {
        return (int) Util.encontrarModa(historico);
    }

    public int getUltimo() {
        return (historico[historico.length - 1]);
    }

    public int getDesvioPadrao() {
        return (int) Util.calcularDesvioPadrao(historico);
    }

}
