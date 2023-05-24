import java.io.InputStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        String asd = "haha";
        int i = 45;
        var res = asd + i;

        System.out.println(res);
        String input = read();
        System.out.println(res + input);
    }

    private static String read() {
        return read(System.in);
    }

    public static String read(InputStream is) {
        Scanner scanner = new Scanner(is);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

}
