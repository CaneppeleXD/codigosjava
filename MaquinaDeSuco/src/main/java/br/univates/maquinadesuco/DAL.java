package br.univates.maquinadesuco;

import br.univates.source.Arquivo;

public class DAL {

    Arquivo repo;
    MaquinaDeSuco m;

    public DAL(String caminho) {
        repo = new Arquivo(caminho);
    }

    public boolean salvar(MaquinaDeSuco m) {
        boolean retorno = false;

        if (retorno = repo.abrirEscrita()) {
            repo.escreverLinha(formatarSabores(m));
            repo.escreverLinha(formatarAguaNoSuco(m));
            repo.escreverLinha(formatarEssenciaNoSuco(m));
            repo.escreverLinha(formatarReservatorio(m));
            repo.escreverLinha(formatarPreco(m));
            repo.escreverLinha(formatarSaldo(m));
            repo.escreverLinha(formatarSucosServidos(m));
            repo.fecharArquivo();
        }

        return retorno;
    }

    public MaquinaDeSuco recuperar() {
        MaquinaDeSuco m = null;
        if (repo.abrirLeitura()) {
            m = recuperarSabores();
            recuperarAguaNoSuco(m);
            recuperarEssenciaNoSuco(m);
            recuperarReservatorios(m);
            recuperarPrecos(m);
            recuperarSaldos(m);
            recuperarSucosServidos(m);
            repo.fecharArquivo();
        }
        return m;
    }

    private void recuperarAguaNoSuco(MaquinaDeSuco m) {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setAguaNoSuco(i, (int)Math.round(Double.parseDouble(linha.substring(0, linha.indexOf(";")))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarEssenciaNoSuco(MaquinaDeSuco m) {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setEssenciaNoSuco(i, (int)Math.round(Double.parseDouble(linha.substring(0, linha.indexOf(";")))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarSucosServidos(MaquinaDeSuco m) {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setSucosServidos(i, Integer.parseInt(linha.substring(0, linha.indexOf(";"))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarSaldos(MaquinaDeSuco m) {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setSaldo(i, Double.parseDouble(linha.substring(0, linha.indexOf(";"))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarPrecos(MaquinaDeSuco m) {
        String linha = repo.lerLinha();
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            m.setPreco(i, Double.parseDouble(linha.substring(0, linha.indexOf(";"))));
            linha = linha.substring(linha.indexOf(";") + 1);
        }
    }

    private void recuperarReservatorios(MaquinaDeSuco m) {
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

    private MaquinaDeSuco recuperarSabores() {
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
        return new MaquinaDeSuco(sabores);
    }

    private String formatarSabores(MaquinaDeSuco m) {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getSabor(i) + ";";
        }
        return (linha);
    }

    private String formatarReservatorio(MaquinaDeSuco m) {
        String linha = m.getCapacidade(0) + ";" + m.getQuantidadeAgua() + ";";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getCapacidade(i) + ";" + m.getQuantidadeEssencia(i) + ";";
        }
        return (linha);
    }

    private String formatarPreco(MaquinaDeSuco m) {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getPreco(i) + ";";
        }
        return (linha);
    }

    private String formatarSaldo(MaquinaDeSuco m) {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getSaldo(i) + ";";
        }
        return (linha);
    }

    private String formatarSucosServidos(MaquinaDeSuco m) {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getSucosServidos(i) + ";";
        }
        return (linha);
    }


    private String formatarAguaNoSuco(MaquinaDeSuco m) {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getAguaNoSuco(i) + ";";
        }
        return (linha);
    }

    private String formatarEssenciaNoSuco(MaquinaDeSuco m) {
        String linha = "";
        for (int i = 1; i <= m.getQuantidadeDeEssencias(); i++) {
            linha += m.getEssenciaNoSuco(i) + ";";
        }
        return (linha);
    }
}
