package verificarString;

public class Verifica {
    public static void main(String[] args) {
        String senha = Entrada.leiaString("Digite a senha");
        while (!senha.equals("-=")) {
            verificarSenha(senha);
            senha = Entrada.leiaString("Digite a senha ou -= para parar");
        }
    }
    public static void verificarSenha(String senha) {
        boolean verificacao1 = false;
        boolean verificacao2 = false;
        boolean verificacao3 = false;
        verificacao1 = verificarCaracterInvalido(senha);
        if (!verificacao1) {
            System.out.println("Digite apenas números e/ou letras");
        }
        verificacao2 = verificarTamanho(senha);
        if (!verificacao2) {
            System.out.println("A senha deve ter pelo menos 10 caracteres");
        }
        verificacao3 = verificarNumeros(senha);
        if (!verificacao3) {
            System.out.println("A senha deve ter pelo menos dois números");
        }
        if (verificacao1 && verificacao2 && verificacao3) {
            System.out.println("Senha válida: "+senha);
        }
    }

    public static boolean verificarCaracterInvalido(String senha) {
        boolean invalida = false;
        String invalidos = "!@#$%^&*()_+-=/*-+;:?/.,><{}[]`~|'" + '"';
        for (int i = 0; i < senha.length() && invalida == false; i++) {
            for (int in = 0; in < invalidos.length() && invalida == false; in++) {
                if (senha.charAt(i) == invalidos.charAt(in)) {
                    invalida = true;
                }
            }
        }
        return (!(invalida));
    }

    public static boolean verificarTamanho(String senha) {
        return (senha.length() >= 10);
    }

    public static boolean verificarNumeros(String senha) {
        int quant = 0;
        String numeros = "1234567890";
        for (int i = 0; i < senha.length() && quant != 2; i++) {
            for (int in = 0; in < numeros.length() && quant != 2; in++) {
                if (senha.charAt(i) == numeros.charAt(in)) {
                    quant++;
                }
            }
        }
        return (quant == 2);
    }
}
