import java.util.Scanner;
import java.util.function.BiPredicate;

public class Main {

    static  BiPredicate<Integer, String> checkType = (number, type) -> {
        if(type.equals("even"))
            return number % 2 == 0;
        else
            return number % 2 != 0;
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int min = Integer.parseInt(input[0]);
        int max = Integer.parseInt(input[1]);
        String type = scanner.nextLine();
        for(int i = min; i <= max; i ++) {
            if(checkType.test(i, type)) {
                System.out.print(i + " ");
            }
        }
    }
}
