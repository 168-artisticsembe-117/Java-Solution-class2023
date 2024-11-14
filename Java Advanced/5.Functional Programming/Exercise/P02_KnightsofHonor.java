import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> print = data -> System.out.println("Sir " + data);
        for (String name:  scanner.nextLine().split("\\s+")) {
            print.accept(name);
        }
    }
}
