import java.util.*;
public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite quanto números deseja sortear");
        int[][] m = new int[10000][s.nextInt()];
        for (int i = 0; i < m.length; i++) {
            List<Integer> l = sortear(m[i].length);
            m[i] = toArray(l);
        }
        imprimirMatriz(m);
        s.close();
        System.out.println(getRandomVales(m).toString());
    }
    public static List<Integer> sortear(int quantidade){
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < quantidade; i++) {
            int n;
            while(l.contains(n = (int)Math.round(Math.random()*100))) {}
            l.add(n);
        }
        return l;
    }
    public static int[] toArray(List<Integer> list){
        int[] v = new int[list.size()];
        for (int i = 0; i < v.length; i++) {
            v[i]=list.get(i);
        }
        return v;
    }
    public static List<Integer> toList(int[] v){
        List<Integer> l = new ArrayList<Integer>();
        for (Integer integer : v) {
            l.add(integer);
        }
        return l;
    }
    public static void imprimirMatriz(int[][] m){
        for (int[] is : m) {
            String linha = "";
            for (int is2 : is) {
                linha+=is2+"|";
            }
            System.out.println(linha);
        }
    }
    public static List<Integer> getRandomVales(int[][] m){
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < m[0].length; i++) {
            int n = m[(int)Math.round(Math.random()*(m.length-1))][(int)Math.round(Math.random()*(m[0].length-1))];
            while(l.contains(l)){n = m[(int)Math.round(Math.random()*m.length)][(int)Math.round(Math.random()*m[0].length)];}
            l.add(n);
        }
        return l;
    }
}
