import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConsoleParser parser = new ConsoleParser();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (true) {
            try {
                parser.parse(input);
            } catch (RuntimeException e) {
                // handle it somehow
            }
            input = sc.nextLine();
        }
    }
}
