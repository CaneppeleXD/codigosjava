package br.univates.maquinadesuco;

import br.univates.source.Reservatorio;

public class MaquinaDeSuco {
    private Reservatorio reservatorioAgua;
    private Essencia[] essencias;

    public MaquinaDeSuco(String[] sabores) {
        reservatorioAgua = new Reservatorio(20000);
        essencias = new Essencia[sabores.length];
        for (int i = 0; i < sabores.length; i++) {
            essencias[i] = new Essencia(5000, sabores[i]);
        }

    }

    }

    public int getCapacidade(int reservatorio) {
        int retorno = 0;
        if(reservatorio == 0){retorno=reservatorioAgua.obterCapacidade();}
        else{retorno=essencias[reservatorio-1].obterCapacidade();}
        return retorno;
    }

    public String getSabor(int essencia) {
        return essencias[essencia-1].getSabor();
    }

    public void setSabor(int essencia, String nome) {
        essencias[essencia-1].setSabor(nome);
    }

    public double getAguaNoSuco(int essencia) {
        return (essencias[essencia-1].getAguaSuco());
    }

    public void setAguaNoSuco(int essencia, int quantia) {
        essencias[essencia-1].setAguaSuco(quantia);
    }

    public double getEssenciaNoSuco(int essencia) {
        return (essencias[essencia-1].getEssenciaSuco());
    }

    public void setEssenciaNoSuco(int essencia, int quantia) {
        essencias[essencia-1].setEssenciaSuco(quantia);
    }

    public double getQuantidadeAgua() {
        return (reservatorioAgua.obterConteudo());
    }

    public boolean colocarAgua(int agua) {
        return (reservatorioAgua.adicionar(agua));
    }

    public boolean tirarAgua(int agua) {
        return (reservatorioAgua.retirar(agua));
    }

    public boolean setcapacidadeAgua(int capacidadeAgua) {
        return (reservatorioAgua.setCapacidade(capacidadeAgua));
    }

    public double getQuantidadeEssencia(int essencia) {
        return (essencias[essencia-1].obterConteudo());
    }

    public boolean colocarEssencia(int essencia, int quantidade) {
        return (essencias[essencia-1].adicionar(quantidade));
    }

    public boolean tirarEssencia(int essencia, int quantidade) {
        return (essencias[essencia-1].retirar(quantidade));
    }

    public boolean servirSuco(int essencia) {
        boolean retorno = reservatorios[0].obterConteudo() >= aguaSuco[essencia - 1]
                && reservatorios[essencia].obterConteudo() >= essenciaSuco[essencia - 1];
        if (retorno) {
            tirarAgua(aguaSuco[essencia - 1]);
            tirarEssencia(essencia, essenciaSuco[essencia - 1]);
            sucosServidos[essencia - 1]++;
            saldos[essencia - 1] += precos[essencia - 1];
        }
        return (retorno);
    }

    public int getQuantidadeDeEssencias() {
        return (reservatorios.length - 1);
    }

    public int getTotalSucosServidos() {
        int total = 0;
        for (int i = 0; i < sucosServidos.length; i++) {
            total += sucosServidos[i];
        }
        return (total);
    }

    public int getSucosServidos(int essencia) {
        return (sucosServidos[essencia - 1]);
    }

    public void setPreco(int essencia, double preco) {
        precos[essencia - 1] = preco;
    }

    public double getPreco(int essencia) {
        return (precos[essencia - 1]);
    }

    public double getSaldo(int essencia) {
        return (saldos[essencia - 1]);
    }

    public double getTotalSaldo() {
        double total = 0;
        for (int i = 0; i < saldos.length; i++) {
            total += getSaldo(i + 1);
        }
        return (total);
    }

    public void setSaldo(int essencia, double saldo) {
        saldos[essencia - 1] = saldo;
    }

    public void setSucosServidos(int essencia, int sucosServidos) {
        this.sucosServidos[essencia - 1] = sucosServidos;
    }

    /*
     * public void adicionarEssencia(){
     * essencias = Arrays.copyOf(essencias, essencias.length+1);
     * }
     */
    // continuar a fazer metodo para adicionar novas essencias no vetor e colocar
    // nome nelas

}
