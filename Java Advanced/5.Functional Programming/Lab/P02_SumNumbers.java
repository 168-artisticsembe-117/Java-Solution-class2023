import java.util.Scanner;
import java.util.function.Function;

public class Main {
    static Function<String, Integer> parse = Integer::parseInt;
    static Function<String[], Integer> getSum = list -> {
        int sum = 0;
        for(String element : list)
            sum += parse.apply(element);
        return sum;
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(", ");
        System.out.println("Count = " + array.length);
        System.out.println("Sum = " + getSum.apply(array));
    }
}
