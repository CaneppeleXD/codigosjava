package br.univates.source;

public class Triangulo {
    private double a;
    private double b;
    private double c;

    public Triangulo(double a, double b, double c) {
        this.a = 1;
        this.b = 1;
        this.c = 1;
        setLados(a, b, c);
    }

    public boolean setA(double a) {
        boolean retorno = Triangulo.ehValido(a, b, c);
        if (retorno)
            this.a = a;
        return (retorno);
    }

    public boolean setB(double b) {
        boolean retorno = Triangulo.ehValido(a, b, c);
        if (retorno)
            this.b = b;
        return (retorno);
    }

    public boolean setC(double c) {
        boolean retorno = Triangulo.ehValido(a, b, c);
        if (retorno)
            this.c = c;
        return (retorno);
    }

    public boolean setLados(double a, double b, double c){
        boolean retorno = false;
        if(Triangulo.ehValido(a,b,c)){
            this.a = a;
            this.b = b;
            this.c = c;
            retorno = true;
        }
        return(retorno);
    }
    
    public static boolean ehValido(double a, double b, double c) {
        return (Math.abs(a - b) < c && c < Math.abs(a + b));
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getPerimetro() {
        return (a + b + c);
    }

    public double getArea() {
        double p = getPerimetro() / 2;
        return (Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }

    public double getAltura(double base) {
        return (2 * getArea() / base);
    }

    public void ampliarArestas(double aux) {
        this.a = this.a * aux;
        this.b = this.b * aux;
        this.c = this.c * aux;
    }

    public void reduzirArestas(double aux) {
        this.a = this.a / aux;
        this.b = this.b / aux;
        this.c = this.c / aux;
    }
}
