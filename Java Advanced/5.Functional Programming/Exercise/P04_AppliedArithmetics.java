import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    static Function<int[], int[]> add = arr -> Arrays.stream(arr)
            .map(x -> x + 1).toArray();
    static Function<int[], int[]> multiply = arr -> Arrays.stream(arr)
            .map(x -> x * 2).toArray();
    static Function<int[], int[]> subtract = arr -> Arrays.stream(arr)
            .map(x -> x - 1).toArray();
    static Consumer<int[]> print = arr -> {
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
        System.out.println();
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!"end".equals(command)) {
            switch (command) {
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
