public class ProgramaData {
    public static void main(String[] args) {
        Data d = new Data(05, 02, 2000);
        Data d2 = new Data(28, 06, 2000);
        System.out.println(d2.formatarData("mm/yy/dd"));
    }
}
