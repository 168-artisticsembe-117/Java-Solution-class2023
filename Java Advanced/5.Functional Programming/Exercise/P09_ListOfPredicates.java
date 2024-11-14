import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class Main {
    static BiPredicate<Integer, List<Integer>> check = (number, list) -> {
        for(Integer el : list) {
            if(number % el != 0)
                return  false;
        }
        return true;
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        for(int i = 1; i <= n; i ++) {
            if(check.test(i, numbers))
                System.out.print(i + " ");
        }
    }
}
