import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    static Function<String, Integer> parse = Integer::parseInt;
    static Predicate<Integer> isEven = x -> x % 2 == 0;
    static Comparator<Integer> check = Integer::compareTo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(parse)
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(numbers.toString().replaceAll("[\\[\\]]+", ""));
        numbers = numbers.stream().sorted(check).collect(Collectors.toList());
        System.out.println(numbers.toString().replaceAll("[\\[\\]]+", ""));
    }
}
