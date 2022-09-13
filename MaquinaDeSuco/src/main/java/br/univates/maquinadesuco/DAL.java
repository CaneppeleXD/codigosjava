package br.univates.maquinadesuco;

import br.univates.source.Arquivo;

public class DAL {

    Arquivo repo;
    MaquinaDeSuco m;

    public DAL(String caminho, MaquinaDeSuco m) {
        repo = new Arquivo(caminho);
        this.m = m;
    }

    public boolean salvar() {
        boolean retorno = false;

        if (retorno = repo.abrirEscrita()) {
            repo.escreverLinha(formatarSabores());
            repo.escreverLinha(formatarAguaNoSuco());
            repo.escreverLinha(formatarEssenciaNoSuco());
            repo.escreverLinha(formatarReservatorio());
            repo.escreverLinha(formatarPreco());
            repo.escreverLinha(formatarSaldo());
            repo.escreverLinha(formatarSucosServidos());
            repo.fecharArquivo();
        }

        return retorno;
    }

    public MaquinaDeSuco recuperar() {
        if (repo.abrirLeitura()) {
            recuperarSabores();
            recuperarAguaNoSuco();
            recuperarEssenciaNoSuco();
            recuperarReservatorios();
            recuperarPrecos();
            recuperarSaldos();
            recuperarSucosServidos();
            repo.fecharArquivo();
        }
        return m;
    }

    private void recuperarAguaNoSuco() {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setAguaNoSuco(i, (int)Math.round(Double.parseDouble(linha.substring(0, linha.indexOf(";")))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarEssenciaNoSuco() {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setEssenciaNoSuco(i, (int)Math.round(Double.parseDouble(linha.substring(0, linha.indexOf(";")))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarSucosServidos() {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setSucosServidos(i, Integer.parseInt(linha.substring(0, linha.indexOf(";"))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarSaldos() {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setSaldo(i, Double.parseDouble(linha.substring(0, linha.indexOf(";"))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarPrecos() {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setPreco(i, Double.parseDouble(linha.substring(0, linha.indexOf(";"))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarReservatorios() {
        String linha = repo.lerLinha();
        m.setcapacidadeAgua(Integer.parseInt(linha.substring(0, linha.indexOf(";"))));
        linha = linha.substring(linha.indexOf(";") + 1);
        m.colocarAgua((int) Math.round(Double.parseDouble(linha.substring(0, linha.indexOf(";")))));
        linha = linha.substring(linha.indexOf(";") + 1);
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            // m.setcapacidadeEssencia(Integer.parseInt(linha.substring(0,
            // linha.indexOf(";"))));
            linha = linha.substring(linha.indexOf(";") + 1);
            m.colocarEssencia(i, (int) Math.round(Double.parseDouble(linha.substring(0, linha.indexOf(";")))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarSabores() {
        String linha = repo.lerLinha();
        int quantidade = 0;
        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == ';')
                quantidade++;
        }
        String[] sabores = new String[quantidade];
        for (int i = 0; i < sabores.length; i++) {
            sabores[i] = linha.substring(0, linha.indexOf(";"));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
        m = new MaquinaDeSuco(sabores);
    }

    private String formatarSabores() {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getSabor(i) + ";";
        }
        return (linha);
    }

    private String formatarReservatorio() {
        String linha = m.getCapacidade(0) + ";" + m.getQuantidadeAgua() + ";";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getCapacidade(i) + ";" + m.getQuantidadeEssencia(i) + ";";
        }
        return (linha);
    }

    private String formatarPreco() {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getPreco(i) + ";";
        }
        return (linha);
    }

    private String formatarSaldo() {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getSaldo(i) + ";";
        }
        return (linha);
    }

    private String formatarSucosServidos() {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getSucosServidos(i) + ";";
        }
        return (linha);
    }


    private String formatarAguaNoSuco() {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getAguaNoSuco(i) + ";";
        }
        return (linha);
    }

    private String formatarEssenciaNoSuco() {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getEssenciaNoSuco(i) + ";";
        }
        return (linha);
    }
}
