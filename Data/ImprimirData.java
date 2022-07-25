package Data;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ImprimirData {
    public static void main(String[] args) {
        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(LocalDateTime.now()));
    }
}
