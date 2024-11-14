import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<int[], Integer> getMin =
                arr -> Arrays.stream(arr).min().getAsInt();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(getMin.apply(numbers));
    }
}
