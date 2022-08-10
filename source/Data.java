/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br.univates.source;

/**
 *
 * @author joao.caneppele
 */
public class Data {
    private int dia;

    private int mes;

    private int ano;

    public Data() {
        trocarDia(1);
        trocarMes(1);
        trocarAno(1);
    }

    public Data(int dia, int mes, int ano) {
        trocarDia(dia);
        trocarMes(mes);
        trocarAno(ano);
    }

    // verificar uma maneira de verificar se o dia naquele mes é possivel, talvez
    // pegar o mes antes do dia, e o ano antes de tudo ou utilizar um metodo para
    // verifica se a data é correta
    public boolean trocarDia(int dia) {
        boolean retorno = false;
        if (dia > 0 && dia <= 32) {
            this.dia = dia;
            retorno = true;
        }
        return (retorno);
    }

    public boolean trocarMes(int mes) {
        boolean retorno = false;
        if (mes > 0 && mes <= 12) {
            this.mes = mes;
            retorno = true;
        }
        return (retorno);
    }

    public boolean trocarAno(int ano) {
        boolean retorno = false;
        if (ano > 0) {
            this.ano = ano;
            retorno = true;
        }
        return (retorno);
    }

    public int obterDia() {
        return (dia);
    }

    public int obterMes() {
        return (mes);
    }

    public int obterAno() {
        return (ano);
    }

    public boolean ehBissexto() { // pode ser um metodo static
        boolean retorno = false;
        if (ano % 4 == 0 && ano % 100 != 0) {
            retorno = true;
        } else if (ano % 400 == 0) {
            retorno = true;
        }
        return (retorno);
    }

    public String obterEstacaoDoAno() { // pode ser um metodo static
        final Data inicioOutono = new Data(21, 03, ano);
        final Data inicioInverno = new Data(21, 06, ano);
        final Data inicioPrimavera = new Data(23, 9, ano);
        final Data inicioVerao = new Data(21, 12, ano);
        String estacao = "";
        if (ehMaiorQue(inicioOutono) && ehMenorQue(inicioInverno)) {
            estacao = "outono";
        } else if (ehMaiorQue(inicioInverno) && ehMenorQue(inicioPrimavera)) {
            estacao = "inverno";
        } else if (ehMaiorQue(inicioPrimavera) && ehMenorQue(inicioVerao)) {
            estacao = "primavera";
        } else {
            estacao = "verão";
        }
        return (estacao);
    }

    private static Data[] preencherSignos(int ano) {
        Data[] signosData = new Data[12];
        int[] signosBruto = { 2103, 2104, 2105, 2106, 2207, 2308, 2309, 2310, 2211, 2212, 2101, 2002 };
        for (int i = 0; i < 12; i++) {
            signosData[i] = new Data(1, 1, ano);
            signosData[i].trocarMes(signosBruto[i] % 100);
            signosData[i].trocarDia((signosBruto[i] - signosData[i].mes) / 100);
            System.out.println(signosData[i].dia + "/" + signosData[i].mes);
        }
        return (signosData);
    }

    public String obterSigno() {
        String[] signos = { "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário",
                "Capricórnio", "Aquário", "Peixes" };
        Data[] inicioSignos = preencherSignos(ano);
        boolean flag = false;
        int i;
        for (i = 0; i < 12 && flag == false; i++) {
            inicioSignos[i].ano = ano;
            if (i == 11) {
                if (ehMaiorQue(inicioSignos[i]) && ehMenorQue(inicioSignos[1])) {
                    flag = true;
                }
            } else if (i == 9) {
                if (ehMaiorQue(inicioSignos[i]) || ehMenorQue(inicioSignos[i + 1])) {
                    flag = true;
                }
            } else {
                if (ehMaiorQue(inicioSignos[i]) && ehMenorQue(inicioSignos[i + 1])) {
                    flag = true;
                }
            }
        }
        return (signos[i - 1]);
    }

    public boolean ehMenorQue(Data d) {
        boolean retorno = false;
        if (ano < d.ano) {
            retorno = true;
        } else if (ano == d.ano && mes < d.mes) {
            retorno = true;
        } else if (ano == d.ano && mes == d.mes && dia < d.dia) {
            retorno = true;
        }
        return (retorno);
    }

    public boolean ehMaiorQue(Data d) {
        return (!ehMenorQue(d));
    }

    public String formatarData(String formato) {
        String formatada = formato.toLowerCase();
        if (formato.equals("extenso")) {
            formatada = dia + " de " + obterExtensoMes() + " de " + ano;
        } else {
            if (dia < 10) {
                formatada = formatada.replaceAll("dd", "0" + dia);
            } else {
                formatada = formatada.replaceAll("dd", dia + "");
            }

            if (mes < 10) {
                formatada = formatada.replaceAll("mm", "0" + mes);
            } else {
                formatada = formatada.replaceAll("mm", mes + "");
            }

            if (contarY(formatada) > 2) {
                formatada = formatada.replaceAll("yyyy", ano + "");
            } else {
                int anomenor = ano % 100;
                if (anomenor < 10) {
                    formatada = formatada.replaceAll("yy", "0" + anomenor);
                } else {
                    formatada = formatada.replaceAll("yy", anomenor + "");
                }
            }
        }
        return (formatada);
    }

    public static int contarY(String a) {
        int contador = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'y') {
                contador++;
            }
        }
        return (contador);
    }

    public String obterExtensoMes() {
        String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
                "Outubro", "Novembro", "Dezembro" };
        return (meses[mes - 1]);
    }
}
