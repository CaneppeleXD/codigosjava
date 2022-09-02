package br.univates.maquinadesuco;

import br.univates.source.Reservatorio;

public class MaquinaDeSuco {
    private String[] sabores;
    private int aguaSuco, essenciaSuco;
    private Reservatorio[] reservatorios;
    private double[] precos, saldos;
    private int[] sucosServidos;
    public MaquinaDeSuco(String[] quantidadeDeEssencias) {
        aguaSuco = 200;
        essenciaSuco = 50;
        reservatorios = new Reservatorio[quantidadeDeEssencias.length + 1];
        precos = new double[quantidadeDeEssencias.length];
        sucosServidos = new int[quantidadeDeEssencias.length];
        sabores = new String[quantidadeDeEssencias.length];
        saldos = new double[quantidadeDeEssencias.length];
        for (int i = 0; i < reservatorios.length; i++) {
            if (i == 0)
                reservatorios[i] = new Reservatorio(20000);
            else {
                reservatorios[i] = new Reservatorio(5000);
                setPreco(i, 2.5);
                setSabor(i, quantidadeDeEssencias[i - 1]);
            }

        }
    }

    public String getSabor(int essencia) {
        return sabores[essencia - 1];
    }

    public void setSabor(int essencia, String nome) {
        sabores[essencia - 1] = nome;
    }

    public double getAguaNoSuco() {
        return (aguaSuco);
    }

    public boolean setAguaNoSuco(int quantia) {
        boolean retorno = quantia <= reservatorios[0].obterCapacidade();
        if (retorno) {
            aguaSuco = quantia;
        }
        return (retorno);
    }

    public double getEssenciaNoSuco() {
        return (essenciaSuco);
    }

    public boolean setEssenciaNoSuco(int quantia) {
        boolean retorno = quantia <= reservatorios[reservatorios.length].obterCapacidade();
        if (retorno) {
            essenciaSuco = quantia;
        }
        return (retorno);
    }

    public double getQuantidadeAgua() {
        return (reservatorios[0].obterConteudo());
    }

    public boolean colocarAgua(int agua) {
        return (reservatorios[0].adicionar(agua));
    }

    public boolean tirarAgua(int agua) {
        return (reservatorios[0].retirar(agua));
    }

    public boolean setcapacidadeAgua(int capacidadeAgua) {
        return (reservatorios[0].setCapacidade(capacidadeAgua));
    }

    public double getQuantidadeEssencia(int essencia) {
        return (reservatorios[essencia].obterConteudo());
    }

    public boolean colocarEssencia(int essencia, int quantidade) {
        return (reservatorios[essencia].adicionar(quantidade));
    }

    public boolean tirarEssencia(int essencia, int quantidade) {
        return (reservatorios[essencia].adicionar(quantidade));
    }

    public boolean servirSuco(int essencia) {
        boolean retorno = reservatorios[0].obterConteudo() >= aguaSuco
                && reservatorios[essencia].obterConteudo() >= essenciaSuco;
        if (retorno) {
            tirarAgua(aguaSuco);
            tirarEssencia(essencia, essenciaSuco);
            sucosServidos[essencia - 1]++;
            saldos[essencia - 1]+=precos[essencia-1];
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
        int total = 0;
        for (int i = 0; i < saldos.length; i++) {
            total += getSaldo(i+1);
        }
        return (total);
    }

    // adaptar a classe telaprincipal à nova classe maquinadesuco
    /*
     * public void adicionarEssencia(){
     * essencias = Arrays.copyOf(essencias, essencias.length+1);
     * }
     */
    // continuar a fazer metodo para adicionar novas essencias no vetor e colocar
    // nome nelas

}
