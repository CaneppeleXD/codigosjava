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
public class NomeProprio {

    String nome;

    public NomeProprio(String nome) {
        this.nome = "O nome não pode ser vazio";
        setNome(nome);
    }

    public String toString() {
        return (nome);
    }

    public boolean setNome(String nome) {
        boolean retorno = false;
        if (!nome.isEmpty()) {
            this.nome = nome;
            retorno = true;
        }
        return (retorno);
    }

    public String getSobrenome() {
        return (nome.substring(nome.lastIndexOf(" ") + 1, nome.length())); //se nao tiver sobrenome vai retornar nada
    }

    public String getPreNome() {
        return (nome.substring(0, nome.indexOf(" ")));
    }

    public String getIniciais() {
        return getIniciais(false);
    }

    public String getIniciais(boolean comPonto) {
        String iniciais = nome.charAt(0) + (comPonto ? ". " : "");
        String salva = this.nome;
        this.nome = this.getNomeSemCharEspeciais();
        String nome = getNomeSemLigacoes();
        this.nome = salva;
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) == ' ') {
                iniciais += nome.charAt(i + 1) + (comPonto ? ". " : "");
            }
        }
        return (iniciais);
    }

    private String getNomeSemLigacoes() {
        String[] ligacoes = {" de ", " do ", " da ", " dos ", " das "};
        String nomeAux = nome;
        for (String ligacao : ligacoes) {
            if (nomeAux.contains(ligacao)) {
                nomeAux = nomeAux.replace(ligacao, " ");
            }
        }
        return nomeAux;
    }

    public String getNomeSemCharEspeciais() {
        String especiais = "äàáâãåèéêëìíîïòóôöõùúûüñýÿç";
        String limpos = "aaaaaaeeeeiiiiooooouuuunyyc";
        String nome = this.nome;
        for (int i = 0; i < nome.length(); i++) {
            nome = nome.replace(especiais.charAt(i), limpos.charAt(i));
        }
        return (nome);
    }
        
    
    public String getNomeFormatado(int formato){
        String retorno = "";
        switch (formato){
            case 1: retorno = this.getSobrenome().toUpperCase()+", "+this.getPreNome();
            case 2: retorno = this.getSobrenome().toUpperCase()+", "+this.getIniciais(true).substring(0, this.getIniciais(true).trim().lastIndexOf(" "));
        }
        return(retorno);
    }
}
