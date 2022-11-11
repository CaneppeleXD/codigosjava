public class Pi {
    public static void main(String[] args) {
        //encontrar numero palindromo primo nas casas decimais de pi
        double x = Math.pow(10, 15);
        double pireal = x*Math.sin(Math.PI/x); 
        System.out.println(pireal);
        System.out.println(Math.PI);
        //suponha que tenha que calcular as casas decimais de pi manualmente uma por uma e ir conferindo...
    }    
}
