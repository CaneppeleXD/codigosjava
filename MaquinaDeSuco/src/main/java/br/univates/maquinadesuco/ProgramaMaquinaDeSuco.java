package br.univates.maquinadesuco;

import br.univates.source.Entrada;

public class ProgramaMaquinaDeSuco {
    public static void main(String[] args) {
        String menu = "M E N U\n\n"+
                    "[1] SERVIR SUCO\n"+
                    "[2] REGARREGAR ÁGUA\n"+
                    "[3] RETIRAR ÁGUA\n"+
                    "[4] REGARREGAR ESSÊNCIA\n"+
                    "[5] RETIRAR ESSÊNCIA\n"+
                    "[6] CONSULTAR\n\n"+
                    "[0] DESLIGAR";
        MaquinaDeSuco maquina1 = new MaquinaDeSuco(3);
        int comando = 10;
        while (comando != 0) {
            comando = Entrada.leiaInt(menu);
            switch (comando) {
                case 1:
                    if (maquina1.servirSuco(Entrada.leiaInt("Escolha o sabor:\n[1]: Maça\n[2]: Manga\n[3]: Uva") - 1))
                        System.out.println("\nSUCO SERVIDO");
                    else
                        System.out.println("\nNÃO HÁ INSUMOS SUFICIENTES");
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
                    if (maquina1.colocarEssencia(Entrada.leiaInt("Escolha o sabor:\n[1]: Maça\n[2]: Manga\n[3]: Uva") - 1,
                            Entrada.leiaDouble("Digite a quantidade")))
                            System.out.println("Recarregado com Sucesso");
                    else
                        System.out.println("Quantidade de Essência maior do que a capacidade do Reservatório");
                    break;
                case 5:
                    if (maquina1.tirarEssencia(Entrada.leiaInt("Escolha o sabor:\n[1]: Maça\n[2]: Manga\n[3]: Uva") - 1,
                            Entrada.leiaDouble("Digite a quantidade")))
                        System.out.println("Retirado com Sucesso");
                    else
                        System.out.println("ERRO: A quantidade de Essência no recipiente deve ser maior que ZERO");
                    break;
                case 6:
                    System.out.println("\nCONSULTA\n\n"+
                        "Sucos Servidos: "+maquina1.getSucosServidos()+
                        "\nQuantidade Água: "+maquina1.getQuantidadeAgua()+
                        "\nQuantidade Essencia 1: "+maquina1.getQuantidadeEssencia(0)+
                        "\nQuantidade Essencia 2: "+maquina1.getQuantidadeEssencia(1)+
                        "\nQuantidade Essencia 3: "+maquina1.getQuantidadeEssencia(2));
                    break;
                case 0:
                    System.out.println("DESLIGADO");
                    break;

            }
        }
    }
}
