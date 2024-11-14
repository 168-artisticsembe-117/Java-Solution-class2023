import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static Function<List<Integer>, Integer> getMinIndex =
            arr -> {
                Integer min = arr.stream()
                        .min(Comparator.naturalOrder())
                        .get();
                return arr.lastIndexOf(min);
            };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(getMinIndex.apply(numbers));
    }
}
