import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> print = System.out::println;
        for (String name:  scanner.nextLine().split("\\s+")) {
            print.accept(name);
        }
    }
}
