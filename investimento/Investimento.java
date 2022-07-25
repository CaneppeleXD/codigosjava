public class Investimento {
    public static void main(String[] aStrings) {
	if(Entrada.leiaInt("1 para calcular investimento\n2 para calcular juros mensal")==1){
       		 System.out.println(
                calcularMontante(Entrada.leiaDouble("Digite o valor inicial"), Entrada.leiaDouble("Digite o acrescimo"),
                        Entrada.leiaDouble("Digite o juros"), Entrada.leiaInt("Digite o tempo")));
   		
       	}
	else{
	
		System.out.println(calcularJurosMensal(Entrada.leiaDouble("Digite o juros anual"))+"%");
	}
    }

    public static double calcularMontante(double inicial, double acrescimo, double juros, int tempo) {
        double montante = inicial;
        for (int i = 0; i < tempo; i++) {
            montante = montante * (1 + juros / 100);
            if (i > 0) {
                montante += acrescimo;
            }
        }
        return (montante);
    }
    public static double calcularJurosMensal(double juros){
    	return((Math.pow(1+juros/100,1/12.0)-1)*100);
    }
}
