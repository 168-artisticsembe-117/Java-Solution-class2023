import java.util.Scanner;
import java.util.function.BiPredicate;

public class Main {
    static BiPredicate<String, Integer> check1 = (x, y) ->
            x.length() <= y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");
        for(String name : names)
            if(check1.test(name, n))
                System.out.println(name);
    }
}
