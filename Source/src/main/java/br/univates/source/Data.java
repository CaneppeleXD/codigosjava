/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univates.source;

/**
 *
 * @author joao.caneppele
 */
public class Data {

    private int dia;

    private int mes;

    private int ano;

    public Data() {
        dia = 1;
        mes = 1;
        ano = 1902;
    }

    public Data(int dia, int mes, int ano) {
        
        this.dia = 1;
        this.mes = 1;
        this.ano = 1902;
        
        setData(dia, mes, ano);
        
    }

    public boolean setDia(int dia) {
        boolean retorno = false;
        Data aux = new Data(dia, mes, ano);
        if (Data.ehCorreta(dia, mes, ano)) {
            this.dia = dia;
            retorno = true;
        }
        return (retorno);
    }

    public boolean setMes(int mes) {
        boolean retorno = false;
        if (Data.ehCorreta(dia, mes, ano)) {
            this.mes = mes;
            retorno = true;
        }
        return (retorno);
    }

    public boolean setAno(int ano) {
        boolean retorno = false;
        if (Data.ehCorreta(dia, mes, ano)) {
            this.ano = ano;
            retorno = true;
        }
        return (retorno);
    }
    
    public boolean setData(int dia, int mes, int ano){
        boolean retorno = false;
        if(Data.ehCorreta(dia, mes, ano)){
            this.dia=dia;
            this.mes=mes;
            this.ano=ano;
            retorno = true;
        }
        return(retorno);
    }

    public int getDia() {
        return (dia);
    }

    public int getMes() {
        return (mes);
    }

    public int getAno() {
        return (ano);
    }

    public boolean ehBissexto() { // pode ser um metodo static
        boolean retorno = false;
        if (ano >= 1582) {
            if (ano % 4 == 0 && ano % 100 != 0) {
                retorno = true;
            } else if (ano % 400 == 0) {
                retorno = true;
            }
        }
        return (retorno);
    }

    public int getUltimoDiaMes() {
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (ehBissexto()) {
            dias[1]++;
        }
        return (dias[mes - 1]);
    }

    public static boolean ehCorreta(int dia, int mes, int ano) {
        return ((dia > 0 && dia <= getUltimoDiaMes(mes, ano)) && (mes > 0 && mes <= 12) && (ano > 1900));
    }

    public static int getUltimoDiaMes(int mes, int ano) {
        int[] dias = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0) {
            dias[1]++;
        }
        return (dias[mes - 1]);
    }

    public String getEstacaoDoAno() { // pode ser um metodo static
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

    public int getDiaAno() {
        int retorno = 0;
        Data aux = new Data(1, 1, ano);
        for (int i = 0; i < mes - 1; i++) {
            retorno += aux.getUltimoDiaMes();
            aux.mes++;
        }

        return (retorno + dia);

    }

    public int getSegundosAno() {
        return (getDiaAno() * 24 * 60 * 60);
    }

    private static Data[] preencherSignos(int ano) {
        Data[] signosData = new Data[12];
        int[] signosBruto = {2103, 2104, 2105, 2106, 2207, 2308, 2309, 2310, 2211, 2212, 2101, 2002};
        for (int i = 0; i < 12; i++) {
            signosData[i] = new Data(1, 1, ano);
            signosData[i].setMes(signosBruto[i] % 100);
            signosData[i].setDia((signosBruto[i] - signosData[i].mes) / 100);
            System.out.println(signosData[i].dia + "/" + signosData[i].mes);
        }
        return (signosData);
    }

    public String getSigno() {
        String[] signos = {"Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário",
            "Capricórnio", "Aquário", "Peixes"};
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
            formatada = dia + " de " + getExtensoMes() + " de " + ano;
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

    public String getExtensoMes() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro"};
        return (meses[mes - 1]);
    }

    public void avancarDias(int dia) {
        while (this.dia + dia > getUltimoDiaMes()) {
            dia -= getUltimoDiaMes();
            mes++;
            if (mes == 13) {
                ano++;
                mes = 1;
            }
        }
        this.dia += dia;
    }

    // metodo de retrocder pode influenciar nagativamente na integridade da classe
    // da maneira que está
    public void retrocederDias(int dia) {
        while (this.dia - dia <= 0) {
            mes--;
            if (mes == 0) {
                ano--;
                mes = 12;
            }
            dia -= getUltimoDiaMes();
        }
        this.dia -= dia;
    }

    public void avancarUmDia() {
        avancarDias(1);
    }

    public void retrocederUmDia() {
        avancarDias(1);
    }

    public int getDiaDoSeculo() {
        int diaDoSeculo = (ano - 1901) * 365 + (ano - 1901) / 4 + dia + (mes - 1)
                * 31 - ((mes * 4 + 23) / 10)
                * ((mes + 12) / 15)
                + ((4 - ano % 4) / 4)
                * ((mes + 12) / 15);
        return diaDoSeculo;
    }

    public int getDiferenca(Data d) {
        return (getDiaDoSeculo() - d.getDiaDoSeculo());
    }

    public boolean ehPalindromo() {
        String invertida = "";
        String data = formatarData("ddmmyy");
        for (int i = data.length() - 1; i >= 0; i--) {
            invertida += data.charAt(i);
        }
        return (invertida.equals(data));
    }

    public Data getDataFutura(int dias) {
        Data retorno = new Data(dia, mes, ano);
        retorno.avancarDias(dias);
        return (retorno);

    }

    public String getFaseDaLua() {
        String[] fases = {"Cheia", "Minguante", "Nova", "Crescente"};
        Data luacheia = new Data(11, 8, 2022);
        int diferenca = Math.abs(getDiferenca(luacheia));
        return (fases[(diferenca / 7) % 4]);

    }

    public boolean ehFeriado() {
        Arquivo feriados = new Arquivo("feriados");
        feriados.abrirLeitura();
        String linha = "";
        String data = formatarData("dd/mm/yyyy");
        boolean retorno = false;
        while (linha != null && retorno == false) {
            if (data.equals(linha)) {
                retorno = true;
            }
            linha = feriados.lerLinha();
        }
        feriados.fecharArquivo();
        return (retorno);
    }

    public String getDiaSemana() {
        String[] semana = {"Segunda-feira", "Terça-feira", "Quarta-feira",
            "Quinta-feira", "Sexta-feira", "Sábado", "Domingo"};

        return semana[getDiaDoSeculo() % 7];
    }

}
