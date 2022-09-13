/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.maquinadesuco;

import br.univates.source.Entrada;

/**
 *
 * @author joao.caneppele
 */
public class TelaPrincipal {
    private MaquinaDeSuco maquina1;
    private DAL dal;

    public TelaPrincipal(MaquinaDeSuco maquina1, DAL dal) {
        this.maquina1 = maquina1;
        this.dal = dal;
    }

    public void exibir() {
        while (true) {
            while (menuUsu() != 2) {
                dal.salvar();
            }
            while (menuAdmin() != 13) {
                dal.salvar();
            }
        }
    }

    public int menuUsu() {
        String menuUsu = "M E N U\n\n" +
                "[1] SERVIR SUCO\n" +
                "[2] ADMINISTRADOR";
        int comando = Entrada.leiaInt(menuUsu);
        switch (comando) {
            case 1:
                if (maquina1.servirSuco(perguntarEssencia()))
                    System.out.println("\nSUCO SERVIDO");
                else
                    System.out.println("\nNÃO HÁ INSUMOS SUFICIENTES");
                break;
            case 2:
                System.out.println("MODO ADMINISTRADOR");
                break;
        }
        return (comando);
    }

    public int menuAdmin() {
        String menuAdmin = "MENU ADMINISTRADOR\n\n" +
                "[1] CONSULTAR GERAL\n" +
                "[2] REGARREGAR ÁGUA\n" +
                "[3] RETIRAR ÁGUA\n" +
                "[4] REGARREGAR ESSÊNCIA\n" +
                "[5] RETIRAR ESSÊNCIA\n" +
                "[6] SALDO TOTAL\n" +
                "[7] SALDO POR ESSÊNCIA\n" +
                "[8] TROCAR PREÇOS\n" +
                "[9] VERIFICAR PREÇOS\n" +
                "[10] MUDAR QUANT. ÁGUA NO SUCO\n" +
                "[11] MUDAR QUANT. ESSÊNCIA NO SUCO\n" +
                "[12] VIZUALIZAR RECEITAS\n\n"+
                "[13] TROCAR MODO\n" +
                "[0] DESLIGAR";
        int comando = Entrada.leiaInt(menuAdmin);
        try {
            switch (comando) {
                case 1:
                    imprimirConsulta();
                    break;
                case 2:
                    if (maquina1.colocarAgua(Entrada.leiaInt("Digite a quantidade de água")))
                        System.out.println("Regarregado com Sucesso");
                    else
                        System.out.println("Quantidade de Água maior do que a capacidade do Reservatório");
                    break;
                case 3:
                    if (maquina1.tirarAgua(Entrada.leiaInt("Digite a quantidade de água")))
                        System.out.println("Retirado com Sucesso");
                    else
                        System.out.println("ERRO: A quantidade de Água no recipiente deve ser maior que ZERO");
                    break;
                case 4:
                    if (maquina1.colocarEssencia(perguntarEssencia(),
                            Entrada.leiaInt("Digite a quantidade")))
                        System.out.println("Recarregado com Sucesso");
                    else
                        System.out.println("Quantidade de Essência maior do que a capacidade do Reservatório");
                    break;
                case 5:
                    if (maquina1.tirarEssencia(perguntarEssencia(),
                            Entrada.leiaInt("Digite a quantidade")))
                        System.out.println("Retirado com Sucesso");
                    else
                        System.out.println("ERRO: A quantidade de Essência no recipiente deve ser maior que ZERO");
                    break;
                case 6:
                    System.out.println("Saldo Total: " + maquina1.getTotalSaldo());
                    break;
                case 7:
                    imprimirSaldos();
                    break;
                case 8:
                    maquina1.setPreco(perguntarEssencia(), Entrada.leiaDouble("Digite o novo preço"));
                    System.out.println("Preço Trocado");
                    break;
                case 9:
                    imprimirPrecos();
                    break;
                case 10:
                    maquina1.setAguaNoSuco(perguntarEssencia(), Entrada.leiaInt("Digite a nova quantidade"));
                    System.out.println("Quantidade trocada");
                    break;
                case 11:
                    maquina1.setEssenciaNoSuco(perguntarEssencia(), Entrada.leiaInt("Digite a nova quantidade"));
                    System.out.println("Quantidade Trocada");
                    break;
                case 12:
                    imprimirReceita();
                    break;
                case 0:
                    System.out.println("DESLIGADO");
                    dal.salvar();
                    System.exit(0);
                    break;
            }
        } catch (Exception x) {
            System.out.println(x);
        }
        return (comando);
    }

    public int perguntarEssencia() {
        String menuEssencia = "Escolha o sabor:";
        for (int i = 1; i <= maquina1.getQuantidadeDeEssencias(); i++) {
            menuEssencia += "\n[" + i + "]: " + maquina1.getSabor(i);
        }
        return (Entrada.leiaInt(menuEssencia));
    }

    public void imprimirSaldos() {
        System.out.println("\nSALDO POR ESSÊNCIA\n");
        for (int i = 1; i <= maquina1.getQuantidadeDeEssencias(); i++) {
            System.out.print(maquina1.getSabor(i) + ": " + maquina1.getSaldo(i) + "\n");
        }
    }

    public void imprimirConsulta() {
        String consulta = "\nCONSULTA\n\n" +
                "Sucos Servidos: " + maquina1.getTotalSucosServidos() +
                "\nSaldo: " + maquina1.getTotalSaldo() +
                "\nQuantidade Água: " + maquina1.getQuantidadeAgua() + "ml";
        for (int i = 1; i <= maquina1.getQuantidadeDeEssencias(); i++) {
            consulta += "\nQuant. Essência de " + maquina1.getSabor(i) + ": " + maquina1.getQuantidadeEssencia(i)
                    + "ml";
        }
        System.out.println(consulta);
    }

    public void imprimirPrecos() {
        String impressao = "\nPREÇOS\n";
        for (int i = 1; i <= maquina1.getQuantidadeDeEssencias(); i++) {
            impressao += "\nPreço suco de " + maquina1.getSabor(i) + ": R$" + maquina1.getPreco(i);
        }
        System.out.println(impressao);
    }

    public void imprimirReceita(){
        String receita = "\nRECEITAS\n";
        for (int i = 1; i <= maquina1.getQuantidadeDeEssencias(); i++) {
            receita += maquina1.getSabor(i)+":\n"+maquina1.getAguaNoSuco(i)+"ml de água\n"+maquina1.getEssenciaNoSuco(i)+"ml de essência\n";
        }
        System.out.println(receita);
    }
}