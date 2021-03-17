import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String askString(String msg) {
        System.out.println(msg + " ");
        return scanner.next();
    }

    public static int askInt(String message) {
        System.out.println(message + " ");
        return scanner.nextInt();


    }
    public static float askFloat(String message) {
        System.out.println(message + "");
        return scanner.nextFloat();


    }

}
