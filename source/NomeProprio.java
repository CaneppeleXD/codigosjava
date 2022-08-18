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
        return (nome.substring(nome.lastIndexOf(" ") + 1, nome.length()));
    }

    public String getPreNome() {
        return (nome.substring(0, nome.indexOf(" ")));
    }

    public String getIniciais() {
        String iniciais = nome.charAt(0) + "";
        for (int i = 0; i < nome.length(); i++) {
            if (nome.charAt(i) == ' ') {
                iniciais += nome.charAt(i + 1);
            }
        }
        return (iniciais);
    }

    public String getNomeSemCharEspeciais() {
        String especiais = "äàáâãåèéêëìíîïòóôöõùúûüñýÿç";
        String nome = this.nome;
        for (int i = 0; i < nome.length(); i++) {
            for (int iespecial = 0; iespecial < especiais.length(); iespecial++) {
                if (nome.charAt(i) == especiais.charAt(iespecial)) {
                    if (iespecial < 6) {
                        nome = nome.replace(nome.charAt(i), 'a');
                    } else if (iespecial < 10) {
                        nome = nome.replace(nome.charAt(i), 'e');
                    } else if (iespecial < 14) {
                        nome = nome.replace(nome.charAt(i), 'i');
                    } else if (iespecial < 19) {
                        nome = nome.replace(nome.charAt(i), 'o');
                    } else if (iespecial < 23) {
                        nome = nome.replace(nome.charAt(i), 'u');
                    } else if (iespecial < 24) {
                        nome = nome.replace(nome.charAt(i), 'n');
                    } else if (iespecial < 26) {
                        nome = nome.replace(nome.charAt(i), 'y');
                    } else {
                        nome = nome.replace(nome.charAt(i), 'c');
                    }
                }
            }
        }
        return (nome);
    }

}
