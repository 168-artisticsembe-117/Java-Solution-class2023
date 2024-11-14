import java.util.*;
import java.util.function.IntPredicate;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(scanner.nextLine());
        IntPredicate check = x -> x % n != 0;

        List<Integer> list = new ArrayList<>();
        for(int number : numbers)
            if(check.test(number))
                list.add(number);
        Collections.reverse(list);
        System.out.println(list.toString().replaceAll("[\\[\\],]+", ""));
    }
}
