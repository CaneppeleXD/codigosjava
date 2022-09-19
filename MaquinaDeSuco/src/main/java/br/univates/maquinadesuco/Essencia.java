package br.univates.maquinadesuco;

import br.univates.source.Reservatorio;

public class Essencia extends Reservatorio{
    private String sabor;
    private double preco, saldo;
    private int aguaSuco, essenciaSuco, sucosServidos;

    public Essencia(int capacidade, String sabor){
        super(capacidade);
        this.sabor=sabor;
        aguaSuco=200;
        essenciaSuco=50;
        sucosServidos=0;
        preco=2.5;
        saldo=0;
    }

    public int getAguaSuco() {
        return aguaSuco;
    }

    public void setAguaSuco(int aguaSuco) {
        this.aguaSuco = aguaSuco;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    public int getSucosServidos() {
        return sucosServidos;
    }

    public void setSucosServidos(int sucosServidos) {
        this.sucosServidos = sucosServidos;
    }

    public int getEssenciaSuco() {
        return essenciaSuco;
    }

    public void setEssenciaSuco(int essenciaSuco) {
        this.essenciaSuco = essenciaSuco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}