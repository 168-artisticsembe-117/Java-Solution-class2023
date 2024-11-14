import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static Comparator<Integer> ascSort =
            (a, b) -> {
                if (a % 2 == 0 && b % 2 != 0)
                    return -1;
                else if (b % 2 == 0 && a % 2 != 0)
                    return 1;
                return a.compareTo(b);
            };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.sort(ascSort);
        System.out.println(numbers.toString().replaceAll("[\\[\\],]+", ""));

    }
}
