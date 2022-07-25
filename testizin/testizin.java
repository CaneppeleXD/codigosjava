public class testizin {
    public static void main(String[]args) throws InterruptedException{
        int tempo = 100;
        while(true) {
            System.out.print("\b|");
            Thread.sleep(tempo);
            System.out.print("\b/");
            Thread.sleep(tempo);
            System.out.print("\b-");
            Thread.sleep(tempo);
            System.out.print("\b\\");
            Thread.sleep(tempo);
        }
    }
    public static void esqueca(){
        double n = 500;
        double x = 0;
        for(int i = 0;i<10000000;i++){
            System.out.println(x);
            x = x+n/(Math.pow(2, i));
            
        }
        System.out.println(x);
    }
}